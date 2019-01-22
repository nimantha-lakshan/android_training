package com.example.fidenz.objectbox.adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.fidenz.objectbox.R;
import com.example.fidenz.objectbox.database.User;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.UserViewHolder> {

    private List<User> usesData = new ArrayList<>();

    public void setUsersList(List<User> users) {
        this.usesData = users;
    }

    @NonNull
    @Override
    public UserViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.widget_user_profile, viewGroup, false);
        return new UserViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull UserViewHolder userViewHolder, int i) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class UserViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.txt_userId)
        TextView userId;
        @BindView(R.id.txt_userFullName)
        TextView userName;
        @BindView(R.id.txt_userMobile)
        TextView userMobile;
        @BindView(R.id.txt_userEmail)
        TextView userEmail;

        public UserViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(itemView);
        }
    }
}
