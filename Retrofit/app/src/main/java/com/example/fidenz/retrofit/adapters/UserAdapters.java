package com.example.fidenz.retrofit.adapters;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.FragmentManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.fidenz.retrofit.R;
import com.example.fidenz.retrofit.alerts.UpdateUserDialog;
import com.example.fidenz.retrofit.database.User;
import com.example.fidenz.retrofit.model.UserViewModel;

import java.util.ArrayList;
import java.util.List;

public class UserAdapters extends RecyclerView.Adapter<UserAdapters.UserViewHolder> {

    private List<User> usersData = new ArrayList<>();
    private UserViewModel userViewModel;
    private Context context;
    private FragmentManager fragmentManager;

    public UserAdapters(Context context, UserViewModel userViewModel, FragmentManager supportFragmentManager) {
        this.userViewModel = userViewModel;
        this.context = context;
        this.fragmentManager = supportFragmentManager;
    }

    public void setUserData(List<User> usersData) {
        this.usersData = usersData;
    }

    public User getUserAt(int position) {
        return usersData.get(position);
    }

    @NonNull
    @Override
    public UserViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.widget_user_data, viewGroup, false);
        return new UserViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull UserViewHolder myViewHolder, int i) {
        User user = usersData.get(i);

        myViewHolder.txt_id.setText(String.valueOf(user.getUser_id()));
        myViewHolder.txt_username.setText(user.getUser_name());

        myViewHolder.itemView.setOnLongClickListener(v -> {

            Bundle data = new Bundle();
            data.putInt("id", user.getUser_id());
            data.putString("name", user.getUser_name());

            UpdateUserDialog updateUserDialog = new UpdateUserDialog();
            updateUserDialog.setArguments(data);
            updateUserDialog.show(fragmentManager, "");

            return false;
        });

    }

    @Override
    public int getItemCount() {
        return usersData.size();
    }

    public class UserViewHolder extends RecyclerView.ViewHolder {

        TextView txt_id;
        TextView txt_username;

        public UserViewHolder(@NonNull View itemView) {
            super(itemView);
            txt_id = itemView.findViewById(R.id.txt_userId);
            txt_username = itemView.findViewById(R.id.txt_username);
        }
    }
}
