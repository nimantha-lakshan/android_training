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


public class TabThree extends Fragment {

    private TextView txtView;
    private EditText edtText;
    private Button btnSubmit;
    private MyFragThreeActionListener myListener;

    public static TabThree newInstance() {
        return new TabThree();
    }

    public interface MyFragThreeActionListener {
        void getDataF3(String data);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_tab_three, container, false);
        txtView = view.findViewById(R.id.txt_Message_frag3);
        edtText = view.findViewById(R.id.edTxt_frag3);
        btnSubmit = view.findViewById(R.id.btn_submit_frag3);

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        return view;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof MyFragThreeActionListener) {
            myListener = (MyFragThreeActionListener) context;
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

    public void setDataF3(String txt) {
        
    }

}
