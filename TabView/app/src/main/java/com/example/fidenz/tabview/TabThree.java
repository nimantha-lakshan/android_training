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

public class TabThree extends Fragment {

    private TabThreeActionListener tabThreeListener;
    private TextView txtView;
    private EditText edtTxt;
    private Button btn;

    public TabThree() {
        // Required empty public constructor
    }

    public static TabThree newInstance() {
        return new TabThree();
    }

    public interface TabThreeActionListener {
        void sendDataTabThree(String data);
    }

    @Override
    public void onStart() {
        super.onStart();

        MyView myView = ViewModelProviders.of(getActivity()).get(MyView.class);
        myView.getData().observe(getViewLifecycleOwner(), new Observer<ArrayList>() {
            @Override
            public void onChanged(@Nullable ArrayList arrayList) {
                Integer index = (Integer) arrayList.get(0);
                Log.i("logger", "" + arrayList.size());
                if (index == 2) {
                    txtView.setText(arrayList.get(1).toString());
                }
            }
        });
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_tab_three, container, false);
        txtView = view.findViewById(R.id.txt_three);
        edtTxt = view.findViewById(R.id.edtTxt_three);
        btn = view.findViewById(R.id.btn_three);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tabThreeListener.sendDataTabThree(edtTxt.getText().toString());
            }
        });
        return view;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        if (context instanceof TabThree.TabThreeActionListener) {
            tabThreeListener = (TabThree.TabThreeActionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        tabThreeListener = null;
    }

}
