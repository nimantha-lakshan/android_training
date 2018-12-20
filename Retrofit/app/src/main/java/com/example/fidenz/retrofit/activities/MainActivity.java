package com.example.fidenz.retrofit.activities;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.fidenz.retrofit.R;
import com.example.fidenz.retrofit.adapters.UserAdapters;
import com.example.fidenz.retrofit.alerts.AddUserDialog;
import com.example.fidenz.retrofit.database.User;
import com.example.fidenz.retrofit.model.UserViewModel;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    private UserViewModel userViewModel;

    @BindView(R.id.view_recycler)
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTheme(R.style.AppTheme_Launch);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        userViewModel = ViewModelProviders.of(this).get(UserViewModel.class);

        LinearLayoutManager liner = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(liner);
        final UserAdapters userAdapters = new UserAdapters(this, userViewModel);
        recyclerView.setAdapter(userAdapters);

        userViewModel.getAllUsers().observe(this, new Observer<List<User>>() {
            @Override
            public void onChanged(@Nullable List<User> users) {
                userAdapters.setUserData(users);
            }
        });

    }

    @OnClick(R.id.btn_addnew)
    public void btn_addNew() {
        AddUserDialog addUserDialog = new AddUserDialog();
        addUserDialog.setUserRepository(userViewModel);
        addUserDialog.show(getSupportFragmentManager(), "show");
    }

}
