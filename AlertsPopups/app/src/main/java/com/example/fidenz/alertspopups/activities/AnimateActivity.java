package com.example.fidenz.alertspopups.activities;


import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.fidenz.alertspopups.R;

public class AnimateActivity extends AppCompatActivity {

    private Button btnFromTop;
    private Button btnFromBottom;
    private Button btnFromRight;
    private Button btnFromLeft;
    private Button btnShare;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animate);
        overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
        setTitle("Animations");

        btnFromTop = findViewById(R.id.btn_viewFromTop);
        btnFromBottom = findViewById(R.id.btn_viewFromBottom);
        btnFromRight = findViewById(R.id.btn_viewFromRight);
        btnFromLeft = findViewById(R.id.btn_viewFromLeft);
        btnShare = findViewById(R.id.btn_share);

        btnShare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_SEND);
                Intent chooser = Intent.createChooser(intent, "share via");

                if (intent.resolveActivity(getPackageManager()) != null) {
                    startActivity(chooser);
                }
            }
        });


        btnFromTop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AnimateActivity.this, TestThreeActivity.class);
                startActivity(intent);

            }
        });

        btnFromBottom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AnimateActivity.this, TestFourActivity.class);
                startActivity(intent);

            }
        });

        btnFromRight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(AnimateActivity.this, TestOneActivity.class);
                startActivity(intent);

            }
        });

        btnFromLeft.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AnimateActivity.this, TestTwoActivity.class);
                startActivity(intent);

            }
        });
    }

    @Override
    public void finish() {
        super.finish();
        overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
    }
}
