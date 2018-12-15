package com.example.fidenz.alertspopups.adapters;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.FragmentManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.fidenz.alertspopups.R;
import com.example.fidenz.alertspopups.activities.AnimateActivity;
import com.example.fidenz.alertspopups.alerts.Dialog;
import com.example.fidenz.alertspopups.sampledata.Profile;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;


public class ProfileRecyclerViewAdapter extends RecyclerView.Adapter<ProfileRecyclerViewAdapter.ProfileViewHolder> {

    private ArrayList profileData;
    private Context context;
    private FragmentManager supportFragmentManager;

    public ProfileRecyclerViewAdapter(Context context, ArrayList profileData, FragmentManager supportFragmentManager) {
        this.profileData = profileData;
        this.context = context;
        this.supportFragmentManager = supportFragmentManager;
    }


    @NonNull
    @Override
    public ProfileViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.widget_profile, viewGroup, false);
        return new ProfileViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final ProfileViewHolder profileViewHolder, int i) {

        final Profile profile = (Profile) profileData.get(i);

        Glide.with(context).load(profile.getImgUrl()).apply(RequestOptions.placeholderOf(R.drawable.ic_profile_img_placeholder)).into(profileViewHolder.profile_img);
        profileViewHolder.profile_name.setText(profile.getProfileName());
        profileViewHolder.profile_detail.setText(profile.getProfileDetail());

        profileViewHolder.profile_img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                new AlertDialog.Builder(context)
                        .setTitle("Alert")
                        .setMessage(profile.getProfileName())
                        .setNegativeButton("Close", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.dismiss();
                            }
                        }).create().show();
            }
        });

        profileViewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Bundle bundle = new Bundle();
                bundle.putString("img_url", profile.getImgUrl());
                bundle.putString("profile_name", profile.getProfileName());
                bundle.putString("profile_detail", profile.getProfileDetail());

                Dialog dialog = new Dialog();
                dialog.setArguments(bundle);
                dialog.show(supportFragmentManager, "show");
            }
        });

        profileViewHolder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                Intent intent = new Intent(context, AnimateActivity.class);
                context.startActivity(intent);
                return false;
            }
        });
    }

    @Override
    public int getItemCount() {
        return profileData.size();
    }

    public class ProfileViewHolder extends RecyclerView.ViewHolder {

        CircleImageView profile_img;
        TextView profile_name;
        TextView profile_detail;

        public ProfileViewHolder(@NonNull View itemView) {
            super(itemView);
            profile_img = itemView.findViewById(R.id.img_profile);
            profile_name = itemView.findViewById(R.id.txt_profile_name);
            profile_detail = itemView.findViewById(R.id.txt_profile_details);
        }
    }
}
