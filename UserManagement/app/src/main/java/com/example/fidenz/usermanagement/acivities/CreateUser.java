package com.example.fidenz.usermanagement.acivities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.fidenz.usermanagement.R;
import com.example.fidenz.usermanagement.database.DaoMaster;
import com.example.fidenz.usermanagement.database.DaoSession;
import com.example.fidenz.usermanagement.database.User;
import com.example.fidenz.usermanagement.database.UserDao;

import org.greenrobot.greendao.database.Database;

public class CreateUser extends AppCompatActivity {

    private EditText edt_user_name;
    private EditText edt_mobile_no;
    private EditText edt_pw;
    private Button btnSave;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_user);

        edt_user_name = findViewById(R.id.edt_user_name);
        edt_mobile_no = findViewById(R.id.edt_mobile);
        edt_pw = findViewById(R.id.edt_password);
        btnSave = findViewById(R.id.btn_save_user);

        DaoMaster.DevOpenHelper helper = new DaoMaster.DevOpenHelper(this, "user-db");
        Database db = helper.getWritableDb();
        DaoSession daoSession = new DaoMaster(db).newSession();
        final UserDao userDao = daoSession.getUserDao();

//        DaoSession daoSession = ((DbSession) getApplication()).getDaoSession();
//        final UserDao userDao = daoSession.getUserDao();

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (edt_user_name.getText().toString().isEmpty() || edt_pw.getText().toString().isEmpty() || edt_mobile_no.getText().toString().isEmpty()) {
                    Toast.makeText(CreateUser.this, "Please fill these form", Toast.LENGTH_SHORT).show();
                } else {
                    User us = new User();
                    us.setUsername(edt_user_name.getText().toString());
                    us.setMobile(Integer.parseInt(edt_mobile_no.getText().toString()));
                    us.setPassword(edt_pw.getText().toString());
                    userDao.insert(us);
                    Toast.makeText(CreateUser.this, "Saved", Toast.LENGTH_SHORT).show();

                    Intent intent = new Intent(CreateUser.this, LogIn.class);
                    startActivity(intent);
                    finish();
                }

            }
        });
    }
}
