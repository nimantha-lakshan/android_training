package com.example.fidenz.retrofit.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.Toast;

import com.example.fidenz.retrofit.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class AddUserActivity extends AppCompatActivity {

    @BindView(R.id.edt_add_field)
    EditText user_name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_user);
        ButterKnife.bind(this);

        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_back);
        setTitle("Add User");
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu_add_user, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case R.id.btn_save_menu:
                saveUser();
                return true;
            default:
                return super.onContextItemSelected(item);
        }
    }

    private void saveUser() {
        String name = user_name.getText().toString().trim();
        if (name.isEmpty()) {
            Toast.makeText(AddUserActivity.this, "Please enter a name", Toast.LENGTH_SHORT).show();
        } else {
            Intent intent = new Intent();
            intent.putExtra("u_name", name);

            setResult(1, intent);
            finish();
        }
    }
}
