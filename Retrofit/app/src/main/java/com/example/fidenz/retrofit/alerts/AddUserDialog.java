package com.example.fidenz.retrofit.alerts;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.fidenz.retrofit.R;
import com.example.fidenz.retrofit.database.User;
import com.example.fidenz.retrofit.model.UserViewModel;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class AddUserDialog extends DialogFragment {

    private UserViewModel userViewModel;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.dialog_add_new_user, container, false);

        Button btnSave = view.findViewById(R.id.btn_save);
        EditText edt_user = view.findViewById(R.id.edt_add_user);

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String username = edt_user.getText().toString().trim();
                if (username.isEmpty()) {
                    Toast.makeText(getContext(), "Please enter a user name", Toast.LENGTH_SHORT).show();
                } else {
                    User user = new User(username);
                    userViewModel.insert(user);
                    Toast.makeText(getContext(), "Done", Toast.LENGTH_SHORT).show();
                    getDialog().dismiss();
                }
            }
        });

        return view;
    }

    public void setUserRepository(UserViewModel userViewModel) {
        this.userViewModel = userViewModel;
    }
}
