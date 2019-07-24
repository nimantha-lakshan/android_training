package com.example.fidenz.objectbox.model;

import android.arch.lifecycle.ViewModel;

import com.example.fidenz.objectbox.database.User;
import com.example.fidenz.objectbox.database.User_;

import io.objectbox.Box;
import io.objectbox.android.ObjectBoxLiveData;

public class UserViewModel extends ViewModel {

    private ObjectBoxLiveData<User> objectBoxLiveData;

    public ObjectBoxLiveData<User> getObjectBoxLiveData(Box<User> userBox) {
        if (objectBoxLiveData == null) {
            objectBoxLiveData = new ObjectBoxLiveData<>(userBox.query().order(User_.__ID_PROPERTY).build());
        }
        return objectBoxLiveData;
    }
}
