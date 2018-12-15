package com.example.fidenz.ui;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

public class MyReclyclerAdapter extends RecyclerView.Adapter<MyReclyclerAdapter.MyViewHolder> {

    private ArrayList profileImages;
    private ArrayList senderName;
    private ArrayList description;
    private Context context;

    public MyReclyclerAdapter(Context conte, ArrayList profileImages, ArrayList senderName, ArrayList description) {
        this.profileImages = profileImages;
        this.senderName = senderName;
        this.description = description;
        this.context = conte;
    }

    @Override
    public MyReclyclerAdapter.MyViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.widget_gmail, viewGroup, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyReclyclerAdapter.MyViewHolder viewHolder, int i) {
        Glide.with(context).asBitmap().load(profileImages.get(i)).into(viewHolder.dp);
        viewHolder.userName.setText(senderName.get(i).toString());
        viewHolder.des.setText(description.get(i).toString());
    }

    @Override
    public int getItemCount() {
        return senderName.size();
    }


    public class MyViewHolder extends RecyclerView.ViewHolder {

        CircleImageView dp;
        TextView userName;
        TextView des;

        public MyViewHolder(View itemView) {
            super(itemView);
            dp = itemView.findViewById(R.id.img_profile);
            userName = itemView.findViewById(R.id.senders_name);
            des = itemView.findViewById(R.id.description);
        }
    }
}
