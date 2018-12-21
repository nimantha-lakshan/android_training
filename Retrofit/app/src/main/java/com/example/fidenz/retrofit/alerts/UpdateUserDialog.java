package com.example.fidenz.retrofit.alerts;

import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;

import com.example.fidenz.retrofit.R;
import com.example.fidenz.retrofit.database.User;
import com.example.fidenz.retrofit.model.UserViewModel;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class UpdateUserDialog extends DialogFragment {

    @BindView(R.id.edt_add_user)
    EditText userName;

    private int uid;
    private UserViewModel userViewModel;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.dialog_add_new_user, container, false);
        ButterKnife.bind(this, view);

        userViewModel = ViewModelProviders.of(getActivity()).get(UserViewModel.class);

        Bundle arguments = getArguments();
        userName.setText(arguments.getString("name"));
        uid = arguments.getInt("id");
        return view;
    }

    @OnClick(R.id.btn_save)
    public void save() {
        User user = new User(userName.getText().toString());
        user.setUser_id(uid);

        userViewModel.update(user);
        Toast.makeText(getContext(), "Updated", Toast.LENGTH_SHORT).show();
        getDialog().dismiss();
    }

}
