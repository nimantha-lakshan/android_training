package com.example.fidenz.alertspopups.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.fidenz.alertspopups.R;

public class TestFourActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_four);
        setTitle("From Bottom to Top");
    }

    @Override
    protected void onResume() {
        super.onResume();
        overridePendingTransition(R.anim.slide_in_bottom, R.anim.stay);
    }

    @Override
    public void finish() {
        super.finish();
        overridePendingTransition(R.anim.stay, R.anim.slide_out_bottom);
}
}
