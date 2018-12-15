package com.example.fidenz.tabview;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;


public class Gallery extends Fragment {

    private ArrayList dataPacket;

    public Gallery() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_gallery, container, false);

        dataPacket = new ArrayList();
        loadData();

        LinearLayoutManager linear = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
        RecyclerView re = view.findViewById(R.id.myRecycler);
        re.setLayoutManager(linear);
        re.setAdapter(new MyRecyclerViewAdapter(getContext(), dataPacket));

        return view;

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
        String name4 = "Dead Island";
        String name5 = "The Silence of the Lambs";

        String des1 = "In Poland during World war II, Oskar Sanchindler gradually becomes..";
        String des2 = "The masterful concoction features a delicious core of mandarin oranges";
        String des3 = "An insomniac office worker, looking for a wya to change his life, crosses path..";

        for (int x = 0; x < 2; x++) {
            dataPacket.add(new MyDataPack(img1, name1, des1));
            dataPacket.add(new MyDataPack(img2, name2, des2));
            dataPacket.add(new MyDataPack(img3, name3, des3));
            dataPacket.add(new MyDataPack(img4, name4, des1));
            dataPacket.add(new MyDataPack(img5, name5, des2));
        }
    }
}
