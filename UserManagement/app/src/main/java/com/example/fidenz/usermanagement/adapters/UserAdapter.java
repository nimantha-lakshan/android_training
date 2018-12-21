package com.example.fidenz.usermanagement.adapters;

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
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.example.fidenz.usermanagement.R;
import com.example.fidenz.usermanagement.acivities.UserList;
import com.example.fidenz.usermanagement.alerts.UpdateUser;
import com.example.fidenz.usermanagement.database.DaoMaster;
import com.example.fidenz.usermanagement.database.DaoSession;
import com.example.fidenz.usermanagement.database.User;
import com.example.fidenz.usermanagement.database.UserDao;

import org.greenrobot.greendao.database.Database;

import java.util.List;

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.UserHolder> {

    private Context context;
    private List<User> user;
    private FragmentManager supportFragmentManager;


    public UserAdapter(Context context, List<User> user, FragmentManager supportFragmentManager) {
        this.context = context;
        this.user = user;
        this.supportFragmentManager = supportFragmentManager;
    }

    @NonNull
    @Override
    public UserHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.widget_user_profile, viewGroup, false);
        return new UserHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull UserHolder userHolder, int i) {
        final User user_data = this.user.get(i);

        userHolder.user_id.setText(String.valueOf(user_data.getUser_id()));
        userHolder.user_name.setText(user_data.getUsername());
        userHolder.user_mobile.setText(String.valueOf(user_data.getMobile()));

        DaoMaster.DevOpenHelper helper = new DaoMaster.DevOpenHelper(context, "user-db");
        Database db = helper.getWritableDb();
        DaoSession daoSession = new DaoMaster(db).newSession();
        final UserDao userDao = daoSession.getUserDao();

        userHolder.edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle bundle = new Bundle();
                bundle.putLong("u_id", user_data.getUser_id());
                bundle.putString("u_name", user_data.getUsername());
                bundle.putInt("u_mobile", user_data.getMobile());
                bundle.putString("u_password", user_data.getPassword());

                UpdateUser dialog = new UpdateUser();
                dialog.setArguments(bundle);
                dialog.show(supportFragmentManager, "show");
                notifyDataSetChanged();
            }
        });

        userHolder.delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                AlertDialog.Builder builder = new AlertDialog.Builder(context);
                builder.setTitle("Delete User")
                        .setMessage("Do you want delete this user")
                        .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                userDao.deleteByKey(user_data.getUser_id());
                                Toast.makeText(context, "user delete", Toast.LENGTH_SHORT).show();
                                notifyDataSetChanged();
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
    }

    @Override
    public int getItemCount() {
        return user.size();
    }

    public class UserHolder extends RecyclerView.ViewHolder {
        TextView user_id;
        TextView user_name;
        TextView user_mobile;
        ImageButton edit;
        ImageButton delete;

        public UserHolder(final View itemView) {
            super(itemView);
            user_id = itemView.findViewById(R.id.widget_txt_user_id);
            user_name = itemView.findViewById(R.id.widget_txt_user_name);
            user_mobile = itemView.findViewById(R.id.widget_txt_user_mobile);
            edit = itemView.findViewById(R.id.btn_edit_user);
            delete = itemView.findViewById(R.id.btn_delete_user);
        }
    }
}
