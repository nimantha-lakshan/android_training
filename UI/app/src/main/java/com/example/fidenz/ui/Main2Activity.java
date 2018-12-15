package com.example.fidenz.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.LinearLayout;

import java.util.ArrayList;

public class Main2Activity extends AppCompatActivity {

    private ArrayList images = new ArrayList();
    private ArrayList senderName = new ArrayList();
    private ArrayList des = new ArrayList();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        loadData();

        LinearLayoutManager linear = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);

        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(linear);
        recyclerView.setAdapter(new MyReclyclerAdapter(this, images, senderName, des));
    }

    private void loadData() {

        images.add("https://c1.staticflickr.com/5/4636/25316407448_de5fbf183d_o.jpg");
        senderName.add("Havasu Falls");
        des.add("This is a sample description");

        images.add("https://i.redd.it/tpsnoz5bzo501.jpg");
        senderName.add("Trondheim");
        des.add("This is a sample description");

        images.add("https://i.redd.it/qn7f9oqu7o501.jpg");
        senderName.add("Portugal");
        des.add("This is a sample description");

        images.add("https://i.redd.it/j6myfqglup501.jpg");
        senderName.add("Rocky Mountain National Park");
        des.add("This is a sample description");


        images.add("https://i.redd.it/0h2gm1ix6p501.jpg");
        senderName.add("Mahahual");
        des.add("This is a sample description");

        images.add("https://i.redd.it/k98uzl68eh501.jpg");
        senderName.add("Frozen Lake");
        des.add("This is a sample description");


        images.add("https://i.redd.it/glin0nwndo501.jpg");
        senderName.add("White Sands Desert");
        des.add("This is a sample description");

        images.add("https://i.redd.it/obx4zydshg601.jpg");
        senderName.add("Australia");
        des.add("This is a sample description");

        images.add("https://i.imgur.com/ZcLLrkY.jpg");
        senderName.add("Washington");
        des.add("This is a sample description");

        images.add("https://c1.staticflickr.com/5/4636/25316407448_de5fbf183d_o.jpg");
        senderName.add("Havasu Falls");
        des.add("This is a sample description");

        images.add("https://i.redd.it/tpsnoz5bzo501.jpg");
        senderName.add("Trondheim");
        des.add("This is a sample description");

        images.add("https://i.redd.it/qn7f9oqu7o501.jpg");
        senderName.add("Portugal");
        des.add("This is a sample description");

        images.add("https://i.redd.it/j6myfqglup501.jpg");
        senderName.add("Rocky Mountain National Park");
        des.add("This is a sample description");


        images.add("https://i.redd.it/0h2gm1ix6p501.jpg");
        senderName.add("Mahahual");
        des.add("This is a sample description");

        images.add("https://i.redd.it/k98uzl68eh501.jpg");
        senderName.add("Frozen Lake");
        des.add("This is a sample description");


        images.add("https://i.redd.it/glin0nwndo501.jpg");
        senderName.add("White Sands Desert");
        des.add("This is a sample description");

        images.add("https://i.redd.it/obx4zydshg601.jpg");
        senderName.add("Australia");
        des.add("This is a sample description");

        images.add("https://i.imgur.com/ZcLLrkY.jpg");
        senderName.add("Washington");
        des.add("This is a sample description");

        images.add("https://c1.staticflickr.com/5/4636/25316407448_de5fbf183d_o.jpg");
        senderName.add("Havasu Falls");
        des.add("This is a sample description");

        images.add("https://i.redd.it/tpsnoz5bzo501.jpg");
        senderName.add("Trondheim");
        des.add("This is a sample description");

        images.add("https://i.redd.it/qn7f9oqu7o501.jpg");
        senderName.add("Portugal");
        des.add("This is a sample description");

        images.add("https://i.redd.it/j6myfqglup501.jpg");
        senderName.add("Rocky Mountain National Park");
        des.add("This is a sample description");


        images.add("https://i.redd.it/0h2gm1ix6p501.jpg");
        senderName.add("Mahahual");
        des.add("This is a sample description");

        images.add("https://i.redd.it/k98uzl68eh501.jpg");
        senderName.add("Frozen Lake");
        des.add("This is a sample description");


        images.add("https://i.redd.it/glin0nwndo501.jpg");
        senderName.add("White Sands Desert");
        des.add("This is a sample description");

        images.add("https://i.redd.it/obx4zydshg601.jpg");
        senderName.add("Australia");
        des.add("This is a sample description");

        images.add("https://i.imgur.com/ZcLLrkY.jpg");
        senderName.add("Washington");
        des.add("This is a sample description");

    }
}
