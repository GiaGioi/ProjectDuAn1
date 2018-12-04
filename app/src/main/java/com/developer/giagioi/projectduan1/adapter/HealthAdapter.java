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
import com.developer.giagioi.projectduan1.model.Health;
import com.developer.giagioi.projectduan1.sqlitedao.AddDogDAO;
import com.developer.giagioi.projectduan1.sqlitedao.HealthDAO;

import java.util.List;

public class HealthAdapter extends BaseAdapter {
    List<Health> health;
    public Activity context;
    public LayoutInflater inflater;
    HealthDAO healthDAO;

    public HealthAdapter(Activity context, List<Health> health) {
        this.health = health;
        this.context = context;
        this.inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        healthDAO = new HealthDAO(context);
    }

    @Override
    public int getCount() {
        return health.size();
    }

    @Override
    public Object getItem(int position) {
        return health.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        HealthAdapter.ViewHolder holder;
        if (convertView == null) {
            holder = new HealthAdapter.ViewHolder();
            convertView = inflater.inflate(R.layout.item_dog, null);
            holder.img = (ImageView) convertView.findViewById(R.id.imgAnh);
            holder.tvIDPet = (TextView) convertView.findViewById(R.id.tvUser);
            holder.tvNamePet = (TextView) convertView.findViewById(R.id.tvHoTen);
            holder.imgDelete = (ImageView) convertView.findViewById(R.id.clear);
            holder.imgDelete.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    healthDAO.deleteHealthByID(health.get(position).getIdPet());
                    health.remove(position);
                    notifyDataSetChanged();
                }
            });
            convertView.setTag(holder);

        } else
            holder = (HealthAdapter.ViewHolder) convertView.getTag();
        Health _entry = (Health) health.get(position);
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

    public void changeDataset(List<Health> items){
        this.health = items;
        notifyDataSetChanged();
    }
}
