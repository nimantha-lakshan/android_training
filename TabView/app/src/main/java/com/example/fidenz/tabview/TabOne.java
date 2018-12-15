package com.example.fidenz.tabview;


import android.Manifest;
import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class TabOne extends Fragment {


    private TabOneActionListener tabOneListener;
    private TextView txtView;
    private EditText edtTxt;
    private Button btn;

    public TabOne() {
        // Required empty public constructor
    }

    public static TabOne newInstance() {
        return new TabOne();
    }

    public interface TabOneActionListener {
        void sendDataTabOne(String data);
    }

    @Override
    public void onStart() {
        super.onStart();

        MyView myView = ViewModelProviders.of(getActivity()).get(MyView.class);
        myView.getData().observe(getViewLifecycleOwner(), new Observer<ArrayList>() {
            @Override
            public void onChanged(@Nullable ArrayList arrayList) {
                Integer index = (Integer) arrayList.get(0);
                if (index == 0) {
                    txtView.setText(arrayList.get(1).toString());
                }
            }
        });
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        final View view = inflater.inflate(R.layout.fragment_tab_one, container, false);
        txtView = view.findViewById(R.id.txt_one);
        edtTxt = view.findViewById(R.id.edtTxt_one);
        btn = view.findViewById(R.id.btn_one);


        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tabOneListener.sendDataTabOne(edtTxt.getText().toString());
            }
        });

//        btnOpenCam.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                if (ContextCompat.checkSelfPermission(view.getContext(), Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED) {
//                    ActivityCompat.requestPermissions(getActivity(),
//                            new String[]{Manifest.permission.CAMERA}, 0);
//                }
//            }
//        });

        return view;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        if (context instanceof TabOneActionListener) {
            tabOneListener = (TabOneActionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        tabOneListener = null;
    }

}



