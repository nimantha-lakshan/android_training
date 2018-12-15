package com.example.fidenz.tabview;


import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;


public class TabTwo extends Fragment {

    private TabTwoActionListener tabTwoListener;
    private TextView txtView;
    private EditText edtTxt;
    private Button btn;

    public TabTwo() {
        // Required empty public constructor
    }

    public static TabTwo newInstance() {
        return new TabTwo();
    }

    public interface TabTwoActionListener {
        void sendDataTabTwo(String data);
    }

    @Override
    public void onStart() {
        super.onStart();

        MyView myView = ViewModelProviders.of(getActivity()).get(MyView.class);
        myView.getData().observe(getViewLifecycleOwner(), new Observer<ArrayList>() {
            @Override
            public void onChanged(@Nullable ArrayList arrayList) {
                Integer index = (Integer) arrayList.get(0);
                if (index == 1) {
                    txtView.setText(arrayList.get(1).toString());
                }
            }
        });
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_tab_two, container, false);
        txtView = view.findViewById(R.id.txt_two);
        edtTxt = view.findViewById(R.id.edtTxt_two);
        btn = view.findViewById(R.id.btn_two);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tabTwoListener.sendDataTabTwo(edtTxt.getText().toString());
            }
        });
        return view;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        if (context instanceof TabTwo.TabTwoActionListener) {
            tabTwoListener = (TabTwo.TabTwoActionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        tabTwoListener = null;
    }
}
