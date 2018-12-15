package com.example.fidenz.alertspopups.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.example.fidenz.alertspopups.R;

public class AnimateActivity extends AppCompatActivity {

    private Button btnFromTop;
    private Button btnFromBottom;
    private Button btnFromRight;
    private Button btnFromLeft;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animate);
        btnFromTop = findViewById(R.id.btn_viewFromTop);
        btnFromBottom = findViewById(R.id.btn_viewFromBottom);
        btnFromRight = findViewById(R.id.btn_viewFromRight);
        btnFromLeft = findViewById(R.id.btn_viewFromLeft);

        btnFromTop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Log.i("logger", "top");
                Intent intent = new Intent(AnimateActivity.this, TestOneActivity.class);
                startActivity(intent);
                overridePendingTransition(R.anim.anim_right_to_left, R.anim.anim_left_to_right);
            }
        });

        btnFromBottom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i("logger", "bottom");
            }
        });

        btnFromRight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i("logger", "right");
            }
        });

        btnFromLeft.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i("logger", "left");
            }
        });
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
//        overridePendingTransition(R.anim.anim_right_to_left, R.anim.anim_left_to_right);
    }
}
