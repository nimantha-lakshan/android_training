package com.example.fidenz.retrofit;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.fidenz.retrofit.adapters.MyAdapters;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView view = findViewById(R.id.view_recycler);
        LinearLayoutManager liner = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        view.setLayoutManager(liner);
        view.setAdapter(new MyAdapters());
    }
}
