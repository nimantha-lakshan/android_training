package com.example.fidenz.fragments;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;


public class MyAdapter extends FragmentStatePagerAdapter {

    private MainActivity mainAc;

    MyAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int i) {

        switch (i) {
            case 0:
                TabOne tabOne = TabOne.newInstance();
//                mainAc.myFr1 = tabOne;
                return tabOne;
            case 1:
                TabTwo tabTwo = TabTwo.newInstance();
//                mainAc.myFr2 = tabTwo;
                return tabTwo;
            case 2:
                TabThree tabThree = TabThree.newInstance();
                return tabThree;
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return 1;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return super.getPageTitle(position);
    }
}
