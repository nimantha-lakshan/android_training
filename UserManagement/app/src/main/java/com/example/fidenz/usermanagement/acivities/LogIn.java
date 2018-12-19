package com.example.fidenz.usermanagement.acivities;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.fidenz.usermanagement.R;
import com.example.fidenz.usermanagement.database.DaoMaster;
import com.example.fidenz.usermanagement.database.DaoSession;
import com.example.fidenz.usermanagement.database.User;
import com.example.fidenz.usermanagement.database.UserDao;

import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.query.QueryBuilder;

import java.util.List;

public class LogIn extends AppCompatActivity {

    private List<User> users;
    private EditText userName;
    private EditText pw;
    private Button btn_login;
    private TextView txt_CreateNew;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in);

        userName = findViewById(R.id.edt_username_login);
        pw = findViewById(R.id.edt_password_login);
        btn_login = findViewById(R.id.btn_login);
        txt_CreateNew = findViewById(R.id.txt_create_new_user);

        DaoMaster.DevOpenHelper helper = new DaoMaster.DevOpenHelper(this, "user-db");
        Database db = helper.getWritableDb();
        DaoSession daoSession = new DaoMaster(db).newSession();
        final UserDao userDao = daoSession.getUserDao();


        users = userDao.loadAll();

        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                QueryBuilder<User> userQueryBuilder = userDao.queryBuilder();

                if (userName.getText().toString().isEmpty() || pw.getText().toString().isEmpty()) {
                    Toast.makeText(LogIn.this, "Fill all the login details", Toast.LENGTH_SHORT).show();
                } else {
                    List<User> user_data = userQueryBuilder.where(UserDao.Properties.Username.eq(userName.getText().toString())).list();
                    if (user_data.size() == 0) {
                        Toast.makeText(LogIn.this, "user name incorrect, please check again", Toast.LENGTH_SHORT).show();
                    } else {
                        User user = user_data.get(0);
                        if (pw.getText().toString().equals(user.getPassword().toString())) {

                            SharedPreferences sharedPrefe = PreferenceManager.getDefaultSharedPreferences(LogIn.this);
                            SharedPreferences.Editor editor = sharedPrefe.edit();
                            editor.putBoolean("isLogged", true);
                            editor.apply();

                            Intent intent = new Intent(LogIn.this, UserList.class);
                            startActivity(intent);
                            finish();
                        } else {
                            Toast.makeText(LogIn.this, "Password wrong, please try again", Toast.LENGTH_SHORT).show();
                        }
                    }
                }
            }
        });


        txt_CreateNew.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LogIn.this, CreateUser.class);
                startActivity(intent);
            }
        });
    }

}
