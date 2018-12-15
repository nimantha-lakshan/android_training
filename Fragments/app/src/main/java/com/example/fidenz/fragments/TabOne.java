package com.example.fidenz.fragments;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class TabOne extends Fragment {


    private TextView txtView;
    private EditText edtTxt;
    private Button btnSubmit;
    private MyFragOneActionListener myListener;

    public static TabOne newInstance() {
        return new TabOne();
    }

    public interface MyFragOneActionListener {
        void getDataF1(String data);
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {


        final View view = inflater.inflate(R.layout.fragment_tab_one, container, false);
        txtView = view.findViewById(R.id.txt_Message);
        edtTxt = view.findViewById(R.id.edTxt);
        btnSubmit = view.findViewById(R.id.btn_submit);


        return view;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof MyFragOneActionListener) {
            myListener = (MyFragOneActionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        myListener = null;
    }


    public void setDataF1(String txt) {

    }
}
