package com.example.bitmapdemo.adapter;


import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.example.bitmapdemo.R;
import com.example.bitmapdemo.bean.ColorBean;
import com.example.bitmapdemo.bean.MainEvent;

import java.util.List;

public class ColorAdapter extends RecyclerView.Adapter<ColorAdapter.ViewHolder> {


    private final List<ColorBean> list;
    private final Context context;
    private String TAG = "MainAdapter";

    public ColorAdapter(List<ColorBean> list, Context context) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.color_adapter_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        ColorBean colorBean = list.get(position);
        holder.color_item_des.setText(colorBean.getDes());
        holder.color_item_im.setBackgroundColor(colorBean.getColor());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private final ImageView color_item_im;
        private final TextView color_item_des;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            color_item_im = itemView.findViewById(R.id.color_adapter_item_im);
            color_item_des = itemView.findViewById(R.id.color_adapter_item_des);
            //color_item_des.setVisibility(View.GONE);
        }
    }
}
