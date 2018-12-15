package com.example.fidenz.myapplication;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

public class MyViewAdapter extends RecyclerView.Adapter<MyViewAdapter.MyViewHolder> {

    private ArrayList img;
    private ArrayList display_name;
    private ArrayList descriptions;
    private Context contxt;

    public MyViewAdapter( Context contxt, ArrayList img, ArrayList display_name, ArrayList descriptions) {
        this.img = img;
        this.display_name = display_name;
        this.descriptions = descriptions;
        this.contxt = contxt;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View myview = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.widget_myview, viewGroup, false);
        return new MyViewHolder(myview);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int i) {
        Glide.with(contxt).asBitmap().load(img.get(i)).into(myViewHolder.imgs);
        myViewHolder.txt_userName.setText(display_name.get(i).toString());
        myViewHolder.txtDes.setText(descriptions.get(i).toString());
    }

    @Override
    public int getItemCount() {
        return display_name.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        CircleImageView imgs;
        TextView txt_userName;
        TextView txtDes;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            imgs = itemView.findViewById(R.id.img_profile);
            txt_userName = itemView.findViewById(R.id.txt_contactName);
            txtDes = itemView.findViewById(R.id.txt_descriptions);
        }
    }
}
