package com.developer.giagioi.projectduan1.holder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.developer.giagioi.projectduan1.R;


public class UserHolder extends RecyclerView.ViewHolder {
    public  final TextView tvUser,tvhoten;
    public UserHolder(View itemView) {
        super(itemView);
        tvUser = itemView.findViewById(R.id.tvUser);
        tvhoten=itemView.findViewById(R.id.tvHoTen);
    }
}
