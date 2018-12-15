package com.example.fidenz.tabview;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;

public class MyView extends ViewModel {

    private MutableLiveData<ArrayList> txt = new MutableLiveData<>();

    public void saveData(ArrayList a) {
        txt.setValue(a);
    }

    public LiveData<ArrayList> getData() {
        return txt;
    }

}
