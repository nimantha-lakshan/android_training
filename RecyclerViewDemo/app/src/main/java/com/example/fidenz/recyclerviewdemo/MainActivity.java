package com.example.fidenz.recyclerviewdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

import java.util.AbstractList;
import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

public class MainActivity extends AppCompatActivity {


    private ArrayList dataPacket = new ArrayList();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        loadData();

        LinearLayoutManager linear = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        RecyclerView re = findViewById(R.id.view_myView);
        re.setLayoutManager(linear);
        re.setAdapter(new MyAdapter(this, dataPacket));

    }

    private void loadData() {
        String img1 = "http://i.annihil.us/u/prod/marvel/i/mg/3/40/4bb4680432f73/portrait_xlarge.jpg";
        String img2 = "https://i.redd.it/tpsnoz5bzo501.jpg";
        String img3 = "https://i.redd.it/qn7f9oqu7o501.jpg";
        String img4 = "https://i.redd.it/j6myfqglup501.jpg";
        String img5 = "https://i.redd.it/0h2gm1ix6p501.jpg";

        String name1 = "The Dark Knight";
        String name2 = "Schindler's List";
        String name3 = "Inspection";
        String name4 = null;
        String name5 = "The Silence of the Lambs";

        String des1 = "In Poland during World war II, Oskar Sanchindler gradually becomes..";
        String des2 = "The masterful concoction features a delicious core of mandarin oranges";
        String des3 = "An insomniac office worker, looking for a wya to change his life, crosses path..";

        for (int x = 0; x < 5; x++) {
            dataPacket.add(new MyDataPack("", name1, des1));
            dataPacket.add(new MyDataPack(img2, name2, des2));
            dataPacket.add(new MyDataPack(img3, name3, des3));
            dataPacket.add(new MyDataPack(img4, name4, des1));
            dataPacket.add(new MyDataPack(img5, name5, null));
        }
    }
}
