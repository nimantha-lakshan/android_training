package com.example.fidenz.test;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ViewData extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_data);

        TextView txtView = findViewById(R.id.txt_view);
        final TextView edtView = findViewById(R.id.edtxt_data2);
        Button btnSend = findViewById(R.id.btn_submit);

//        Student std = getIntent().getParcelableExtra("obj");
        Car car = (Car) getIntent().getSerializableExtra("car");
        edtView.setText(car.getCarModel());
        txtView.setText(car.getCarColor() + "" + car.getMfd());

        btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent inte = new Intent();
                inte.putExtra("back", edtView.getText().toString());
                setResult(RESULT_OK, inte);
                finish();
            }
        });


    }
}
