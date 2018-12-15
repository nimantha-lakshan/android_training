package com.example.fidenz.fragments;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;

public class MyViewModel extends ViewModel {
    private MutableLiveData<String> text = new MutableLiveData<>();

    public void setData(String txt){
        text.setValue(txt);
    }

    public LiveData<String> getData(){
        return text;
    }
}
