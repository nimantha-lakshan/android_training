package com.example.fidenz.tabview;

import android.arch.lifecycle.ViewModelProviders;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity implements TabOne.TabOneActionListener, TabTwo.TabTwoActionListener, TabThree.TabThreeActionListener {

    private ViewPager viewPger;
    private MyAdapter myAdapter;
    private TabLayout tabLay;
    private MyView myView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        viewPger = findViewById(R.id.myViewPager);
        tabLay = findViewById(R.id.tab_layout);

        myAdapter = new MyAdapter(getSupportFragmentManager());
        viewPger.setAdapter(myAdapter);

        viewPger.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLay));
        tabLay.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                if (tab.getPosition() == 0) {
                    viewPger.setCurrentItem(0);
                } else if (tab.getPosition() == 1) {
                    viewPger.setCurrentItem(1);
                } else if (tab.getPosition() == 2) {
                    viewPger.setCurrentItem(2);
                } else if (tab.getPosition() == 3) {
                    viewPger.setCurrentItem(3);
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {
            }
        });
    }

    @Override
    public void sendDataTabOne(String data) {
        myView = ViewModelProviders.of(this).get(MyView.class);
        ArrayList al = new ArrayList();
        al.add(1);
        al.add(data);

        myView.saveData(al);
        viewPger.setCurrentItem(1);
    }

    @Override
    public void sendDataTabTwo(String data) {
        myView = ViewModelProviders.of(this).get(MyView.class);
        ArrayList al = new ArrayList();
        al.add(2);
        al.add(data);

        myView.saveData(al);
        viewPger.setCurrentItem(2);
    }

    @Override
    public void sendDataTabThree(String data) {
        myView = ViewModelProviders.of(this).get(MyView.class);
        ArrayList al = new ArrayList();
        al.add(0);
        al.add(data);

        myView.saveData(al);
        viewPger.setCurrentItem(0);
    }
}
