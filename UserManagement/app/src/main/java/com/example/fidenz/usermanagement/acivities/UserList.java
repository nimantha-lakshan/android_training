package com.example.fidenz.usermanagement.acivities;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageButton;

import com.example.fidenz.usermanagement.R;
import com.example.fidenz.usermanagement.adapters.UserAdapter;
import com.example.fidenz.usermanagement.database.DaoMaster;
import com.example.fidenz.usermanagement.database.DaoSession;
import com.example.fidenz.usermanagement.database.DbSession;
import com.example.fidenz.usermanagement.database.UserDao;

import org.greenrobot.greendao.database.Database;

import java.util.ArrayList;

public class UserList extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_list);

        DaoMaster.DevOpenHelper helper = new DaoMaster.DevOpenHelper(this, "user-db");
        Database db = helper.getWritableDb();
        DaoSession daoSession = new DaoMaster(db).newSession();
        UserDao userDao = daoSession.getUserDao();

        LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        RecyclerView review = findViewById(R.id.recycler_userlist);
        review.setLayoutManager(layoutManager);
        UserAdapter userAdapter = new UserAdapter(this, userDao.loadAll(), getSupportFragmentManager());
        userAdapter.notifyDataSetChanged();
        review.setAdapter(userAdapter);
        userAdapter.notifyDataSetChanged();

        ImageButton btn_logout = findViewById(R.id.btn_logout);
        btn_logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new AlertDialog.Builder(UserList.this)
                        .setTitle("Logout")
                        .setMessage("Are you sure?")
                        .setNegativeButton("No", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.dismiss();
                            }
                        })
                        .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                SharedPreferences sharedPrefe = PreferenceManager.getDefaultSharedPreferences(UserList.this);
                                SharedPreferences.Editor editor = sharedPrefe.edit();
                                editor.putBoolean("isLogged", false);
                                editor.apply();

                                Intent intent = new Intent(UserList.this, LogIn.class);
                                startActivity(intent);
                                finish();
                            }
                        }).create().show();
            }
        });

    }
}
