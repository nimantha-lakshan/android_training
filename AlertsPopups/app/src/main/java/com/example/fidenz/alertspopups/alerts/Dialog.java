package com.example.fidenz.alertspopups.alerts;


import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.fidenz.alertspopups.R;


public class Dialog extends DialogFragment {

    private ImageView img_profile;
    private ImageButton btn_exit;
    private TextView txt_name;
    private TextView txt_details;
    private Button btn_close;
    private Dialog.DialogActionEvent dialogActionEvent;

    public Dialog() {
    }


    public interface DialogActionEvent {
        void callToast();
    }


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.dialog_profile, container, false);

        img_profile = view.findViewById(R.id.dialog_img_profile);
        btn_exit = view.findViewById(R.id.dialog_btn_exit);
        txt_name = view.findViewById(R.id.dialog_txt_profile_name);
        txt_details = view.findViewById(R.id.dialog_txt_profile_detail);
        btn_close = view.findViewById(R.id._dialog_btn_close);

        getDialog().getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        /* create bundle and get data from main activity */
        Bundle bundle = getArguments();

        Glide.with(getContext())
                .load(bundle.getString("img_url"))
                .apply(RequestOptions.placeholderOf(R.drawable.ic_profile_img_placeholder))
                .apply(RequestOptions.centerCropTransform())
                .into(img_profile);
        txt_name.setText(bundle.getString("profile_name"));
        txt_details.setText(bundle.getString("profile_detail"));


        btn_exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(), "Action Close", Toast.LENGTH_SHORT).show();
                getDialog().dismiss();
            }
        });


        btn_close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialogActionEvent.callToast();
                getDialog().dismiss();
            }
        });
        return view;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        if (context instanceof Dialog.DialogActionEvent) {
            dialogActionEvent = (Dialog.DialogActionEvent) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }
}
