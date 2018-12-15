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


public class TabTwo extends Fragment {

    private MyFragTwoActionListener myListener;
    private TextView txtView;
    private EditText edtTxt;
    private Button btn_submit;
    private MyViewModel myViewModel;


    public static TabTwo newInstance() {
        return new TabTwo();
    }

    public interface MyFragTwoActionListener {
        void getDataF2(String data);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_tab_two, container, false);
        txtView = view.findViewById(R.id.txt_Message_frag2);
        edtTxt = view.findViewById(R.id.edTxt_frag2);
        btn_submit = view.findViewById(R.id.btn_submit_frag2);

        btn_submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        return view;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof MyFragTwoActionListener) {
            myListener = (MyFragTwoActionListener) context;
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

    public void setDataF2(String txt) {


    }
}
