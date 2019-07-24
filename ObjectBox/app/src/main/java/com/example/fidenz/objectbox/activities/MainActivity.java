package com.example.fidenz.objectbox.activities;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProviders;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.fidenz.objectbox.R;
import com.example.fidenz.objectbox.adapters.UserAdapter;
import com.example.fidenz.objectbox.database.MyObjectBox;
import com.example.fidenz.objectbox.database.User;
import com.example.fidenz.objectbox.model.UserViewModel;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.objectbox.Box;
import io.objectbox.BoxStore;

public class MainActivity extends AppCompatActivity {

//    @BindView(R.id.view_user)
//    RecyclerView recyclerView;
//
//    private Box<User> userBox;
//    private UserAdapter userAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

//        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
//        userAdapter = new UserAdapter();
//        recyclerView.setLayoutManager(linearLayoutManager);
//        recyclerView.setAdapter(userAdapter);
//
//        BoxStore build = MyObjectBox.builder().androidContext(this).build();
//        userBox = build.boxFor(User.class);
//
//        UserViewModel model = ViewModelProviders.of(this).get(UserViewModel.class);
//        model.getObjectBoxLiveData(userBox).observe(this, new Observer<List<User>>() {
//            @Override
//            public void onChanged(@Nullable List<User> users) {
//                userAdapter.setUsersList(users);
//                userAdapter.notifyDataSetChanged();
//            }
//        });
    }
}
