package com.example.fidenz.usermanagement.acivities;

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;


public class MainActivity extends AppCompatActivity {

    private Button btn_newUser;
    private Button btnLogIn;
    private Button btnNew;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        SharedPreferences sharedPrefe = PreferenceManager.getDefaultSharedPreferences(this);
        boolean login_state = sharedPrefe.getBoolean("isLogged", false);

        if (login_state) {
            Intent intent = new Intent(this, UserList.class);
            startActivity(intent);
            finish();
        } else {
            Intent intent = new Intent(this, LogIn.class);
            startActivity(intent);
            finish();
        }
    }
}
