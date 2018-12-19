package com.example.fidenz.usermanagement.alerts;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.fidenz.usermanagement.R;
import com.example.fidenz.usermanagement.acivities.UserList;
import com.example.fidenz.usermanagement.database.DaoMaster;
import com.example.fidenz.usermanagement.database.DaoSession;
import com.example.fidenz.usermanagement.database.User;
import com.example.fidenz.usermanagement.database.UserDao;

import org.greenrobot.greendao.database.Database;


public class UpdateUser extends DialogFragment {

    private EditText update_username;
    private EditText update_mobile;
    private EditText update_password;
    private Button btn_update;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.alert_dialog_update_user, container, false);
        update_username = view.findViewById(R.id.edt_update_username);
        update_mobile = view.findViewById(R.id.edt_update_mobile);
        update_password = view.findViewById(R.id.edt_update_password);
        btn_update = view.findViewById(R.id.btn_update_user);

        Bundle bundle_data = getArguments();
        final long u_id = bundle_data.getLong("u_id");
        update_username.setText(bundle_data.getString("u_name"));
        update_mobile.setText(String.valueOf(bundle_data.getInt("u_mobile")));
        update_password.setText(bundle_data.getString("u_password"));

        DaoMaster.DevOpenHelper helper = new DaoMaster.DevOpenHelper(getContext(), "user-db");
        Database db = helper.getWritableDb();
        DaoSession daoSession = new DaoMaster(db).newSession();
        final UserDao userDao = daoSession.getUserDao();

        btn_update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (update_username.getText().toString().isEmpty() || update_mobile.getText().toString().isEmpty() || update_password.getText().toString().isEmpty()) {
                    Toast.makeText(getContext(), "Fill all fields", Toast.LENGTH_SHORT).show();
                } else {
                    User us = new User();
                    us.setUser_id(u_id);
                    us.setUsername(update_username.getText().toString());
                    us.setMobile(Integer.parseInt(update_mobile.getText().toString()));
                    us.setPassword(update_password.getText().toString());

                    userDao.update(us);
                    Toast.makeText(getContext(), "Updated", Toast.LENGTH_SHORT).show();
                    getDialog().dismiss();
                    startActivity(new Intent(getActivity(), UserList.class));
                }
            }
        });
        return view;
    }
}
