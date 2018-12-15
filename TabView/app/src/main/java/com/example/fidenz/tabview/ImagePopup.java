package com.example.fidenz.tabview;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Gravity;
import android.view.WindowManager;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

public class ImagePopup extends Activity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_popup);

        getActionBar().hide();

        DisplayMetrics dis = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dis);

        int width = (int) (dis.widthPixels * 0.75);

        getWindow().setLayout(width, width);

        WindowManager.LayoutParams p = getWindow().getAttributes();
        p.gravity = Gravity.CENTER;

        ImageView img = findViewById(R.id.img_profile);

        Intent intent = getIntent();

        String s = intent.getStringExtra("img_url");

        Log.i("logger", s);
        Glide.with(this)
                .load(s)
                .apply(RequestOptions.placeholderOf(R.drawable.ic_person_black_60dp))
                .apply(RequestOptions.centerCropTransform())
                .into(img);
    }
}
