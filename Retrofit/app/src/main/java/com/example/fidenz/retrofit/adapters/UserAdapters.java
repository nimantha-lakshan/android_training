package com.example.fidenz.retrofit.adapters;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.example.fidenz.retrofit.R;
import com.example.fidenz.retrofit.database.User;
import com.example.fidenz.retrofit.model.UserViewModel;

import java.util.ArrayList;
import java.util.List;

public class UserAdapters extends RecyclerView.Adapter<UserAdapters.UserViewHolder> {

    private List<User> usersData = new ArrayList<>();
    private UserViewModel userViewModel;
    private Context context;

    public UserAdapters(Context context, UserViewModel userViewModel) {
        this.userViewModel = userViewModel;
        this.context = context;
    }

    public void setUserData(List<User> usersData) {
        this.usersData = usersData;
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

        myViewHolder.btn_delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                new AlertDialog.Builder(context)
                        .setTitle("Delete")
                        .setMessage("Are you sure?")
                        .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                userViewModel.delete(user);
                                dialog.dismiss();
                            }
                        })
                        .setNegativeButton("No", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.dismiss();
                            }
                        }).create().show();
            }
        });

        myViewHolder.btn_edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                userViewModel.deleteAll();
                Log.i("mylogs", "on edit");
            }
        });
    }

    @Override
    public int getItemCount() {
        return usersData.size();
    }

    public class UserViewHolder extends RecyclerView.ViewHolder {

        TextView txt_id;
        TextView txt_username;
        ImageButton btn_edit;
        ImageButton btn_delete;

        public UserViewHolder(@NonNull View itemView) {
            super(itemView);
            txt_id = itemView.findViewById(R.id.txt_userId);
            txt_username = itemView.findViewById(R.id.txt_username);
            btn_edit = itemView.findViewById(R.id.btn_edit);
            btn_delete = itemView.findViewById(R.id.btn_delete);
        }
    }
}
