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
import com.developer.giagioi.projectduan1.sqlitedao.AddDogDAO;

import java.util.List;


public class AddDogAdapter extends BaseAdapter {
    List<AddDog> addDogs;
    public Activity context;
    public LayoutInflater inflater;
    AddDogDAO addDogDAO;

    public AddDogAdapter(Activity context, List<AddDog> addDogs) {
        this.addDogs = addDogs;
        this.context = context;
        this.inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        addDogDAO = new AddDogDAO(context);
    }


    @Override
    public int getCount() {
        return addDogs.size();
    }

    @Override
    public Object getItem(int position) {
        return addDogs.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if (convertView == null) {
            holder = new ViewHolder();
            convertView = inflater.inflate(R.layout.item_dog, null);
            holder.img = (ImageView) convertView.findViewById(R.id.imgAnh);
            holder.tvIDPet = (TextView) convertView.findViewById(R.id.tvUser);
            holder.tvNamePet = (TextView) convertView.findViewById(R.id.tvHoTen);
            holder.imgDelete = (ImageView) convertView.findViewById(R.id.clear);
            holder.imgDelete.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    addDogDAO.deleteAddDogByID(addDogs.get(position).getNamePet());
                    addDogs.remove(position);
                    notifyDataSetChanged();
                }
            });
            convertView.setTag(holder);

        } else
            holder = (ViewHolder) convertView.getTag();
        AddDog _entry = (AddDog) addDogs.get(position);
        holder.img.setImageResource(R.drawable.images);
        holder.tvIDPet.setText(_entry.getNamePet());
        holder.tvNamePet.setText(_entry.getTinhTrang());
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

    public void changeDataset(List<AddDog> items){
        this.addDogs = items;
        notifyDataSetChanged();
    }
}
