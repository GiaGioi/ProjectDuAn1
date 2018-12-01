package com.developer.giagioi.projectduan1.adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.developer.giagioi.projectduan1.R;
import com.developer.giagioi.projectduan1.model.AddDog;
import com.developer.giagioi.projectduan1.model.Vaccin;
import com.developer.giagioi.projectduan1.sqlitedao.AddDogDAO;
import com.developer.giagioi.projectduan1.sqlitedao.VaccinDAO;

import java.util.List;

public class VaccinAdapter extends BaseAdapter {
    List<Vaccin> vaccins;
    public Activity context;
    public LayoutInflater inflater;
    VaccinDAO vaccinDAO;

    public VaccinAdapter(Activity context, List<Vaccin> vaccins) {
        this.vaccins = vaccins;
        this.context = context;
        this.inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        vaccinDAO = new VaccinDAO(context);
    }

    @Override
    public int getCount() {
        return vaccins.size();
    }

    @Override
    public Object getItem(int position) {
        return vaccins.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
       AddDogAdapter.ViewHolder holder;
        if (convertView == null) {
            holder = new AddDogAdapter.ViewHolder();
            convertView = inflater.inflate(R.layout.item_dog, null);
            holder.img = (ImageView) convertView.findViewById(R.id.imgAnh);
            holder.tvIDPet = (TextView) convertView.findViewById(R.id.tvUser);
            holder.tvNamePet = (TextView) convertView.findViewById(R.id.tvHoTen);
            holder.imgDelete = (ImageView) convertView.findViewById(R.id.clear);
            holder.imgDelete.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    vaccinDAO.deleteVaccin(String.valueOf((vaccins.get(position))));
                    vaccins.remove(position);
                    notifyDataSetChanged();
                }
            });
            convertView.setTag(holder);

        } else
            holder = (AddDogAdapter.ViewHolder) convertView.getTag();
        Vaccin _entry = (Vaccin) vaccins.get(position);
        holder.img.setImageResource(R.drawable.images);
        holder.tvIDPet.setText(_entry.getTenVatNuoi());
        holder.tvNamePet.setText(_entry.getLoaiThucAn());
        return convertView;
    }
    public static class ViewHolder {
        ImageView img;
        TextView tvIDPet;
        TextView tvNamePet;
        ImageView imgDelete;
    }
    @Override
    public void notifyDataSetChanged() {
        super.notifyDataSetChanged();
    }

    public void changeDataset(List<Vaccin> items){
        this.vaccins = items;
        notifyDataSetChanged();
    }
}
