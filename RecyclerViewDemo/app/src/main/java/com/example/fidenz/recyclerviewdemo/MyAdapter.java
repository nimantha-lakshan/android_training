package com.example.fidenz.recyclerviewdemo;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {

    private ArrayList user_data;
    private Context contxt;

    public MyAdapter(Context contxt, ArrayList dataPack) {
        this.contxt = contxt;
        this.user_data = dataPack;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View myview = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.widget_myview, viewGroup, false);
        return new MyViewHolder(myview);
    }

    @Override
    public void onBindViewHolder(final MyViewHolder myViewHolder, int position) {
        final MyDataPack dataPak = (MyDataPack) user_data.get(position);

        Glide
                .with(contxt)
                .load(dataPak.getDisplayImages())
                .apply(RequestOptions.placeholderOf(R.drawable.ic_person_black_60dp))
                .into(myViewHolder.imgs);

        if (dataPak.getDisplayNames() == null) {
            myViewHolder.txt_userName.setText("Not Available");
        } else {
            myViewHolder.txt_userName.setText(dataPak.getDisplayNames());
        }
        if (dataPak.getDescriptions() == null) {
            myViewHolder.txtDes.setText("Not Found");
        } else {
            myViewHolder.txtDes.setText(dataPak.getDescriptions());
        }

        myViewHolder.imgs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(contxt, MyPopupActivity.class);

                in.putExtra("img_url", dataPak.getDisplayImages());
                in.putExtra("user_name", dataPak.getDisplayNames());
                contxt.startActivity(in);
            }
        });
    }

    @Override
    public int getItemCount() {
        return user_data.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        CircleImageView imgs;
        TextView txt_userName;
        TextView txtDes;

        public MyViewHolder(final View itemView) {
            super(itemView);
            imgs = itemView.findViewById(R.id.img_profile);
            txt_userName = itemView.findViewById(R.id.txt_contactName);
            txtDes = itemView.findViewById(R.id.txt_descriptions);

        }
    }
}
