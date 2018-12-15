package com.example.fidenz.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar tool_bar = findViewById(R.id.top_bar);
        setSupportActionBar(tool_bar);


        ImageView img4 = findViewById(R.id.img4);
        ImageView img5 = findViewById(R.id.img5);
        ImageView img6 = findViewById(R.id.img6);
        ImageView img7 = findViewById(R.id.img7);


        Glide.with(this).load(R.drawable.img_dish_4).apply(RequestOptions.centerCropTransform()).into(img4);
        Glide.with(this).load(R.drawable.img_dish1).apply(RequestOptions.centerCropTransform()).into(img5);
        Glide.with(this).load(R.drawable.img_dish2).apply(RequestOptions.centerCropTransform()).into(img6);
        Glide.with(this).load(R.drawable.img_dish3).apply(RequestOptions.centerCropTransform()).into(img7);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater me = getMenuInflater();
        me.inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);
    }


}
