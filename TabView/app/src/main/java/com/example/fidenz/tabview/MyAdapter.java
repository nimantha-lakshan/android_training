package com.example.fidenz.tabview;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class MyAdapter extends FragmentPagerAdapter {

    public MyAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int i) {
        switch (i) {
            case 0:
                return TabOne.newInstance();
            case 1:
                return TabTwo.newInstance();
            case 2:
                return TabThree.newInstance();
            case 3:
                return new Gallery();
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return 4;
    }
}
