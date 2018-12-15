package com.example.fidenz.recyclerviewdemo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Gravity;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

public class MyPopupActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_popup);

        getActionBar().hide();
        DisplayMetrics display = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(display);

        getWindow().setLayout((int) (display.widthPixels * 0.7), (int) (display.heightPixels * .4));

        WindowManager.LayoutParams p = getWindow().getAttributes();
        p.gravity = Gravity.CENTER;
        p.x = 0;
        p.y = -20;


        ImageView img = findViewById(R.id.imgView_displayImage);
        TextView txt_uName = findViewById(R.id.txt_userName);

        Intent inten = getIntent();

        txt_uName.setText(inten.getStringExtra("user_name"));
        Glide
                .with(this)
                .load(inten.getStringExtra("img_url"))
                .apply(RequestOptions.placeholderOf(R.drawable.ic_person_black_60dp))
                .apply(RequestOptions.centerCropTransform())
                .into(img);
    }
}
