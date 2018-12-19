package com.example.fidenz.alertspopups.activities;



import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.animation.Animation;
import android.view.animation.LinearInterpolator;
import android.widget.Toast;

import com.example.fidenz.alertspopups.R;
import com.example.fidenz.alertspopups.adapters.ProfileRecyclerViewAdapter;
import com.example.fidenz.alertspopups.alerts.Dialog;
import com.example.fidenz.alertspopups.sampledata.Profile;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements Dialog.DialogActionEvent {

    private ArrayList profile;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        Animation anim = android.view.animation.AnimationUtils.loadAnimation(this, R.anim.splash);
//        anim.setInterpolator(new LinearInterpolator());
//        anim.setRepeatCount(Animation.INFINITE);
//        anim.setDuration(700);



        profile = new ArrayList();
        loadData();

        LinearLayoutManager linear = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        recyclerView = findViewById(R.id.recyclerView_profile);
        recyclerView.setLayoutManager(linear);
        recyclerView.setAdapter(new ProfileRecyclerViewAdapter(this, profile, getSupportFragmentManager()));

    }

    private void loadData() {
        String img1 = "http://i.annihil.us/u/prod/marvel/i/mg/3/40/4bb4680432f73/portrait_xlarge.jpg";
        String img2 = "https://i.redd.it/tpsnoz5bzo501.jpg";
        String img3 = "https://i.redd.it/qn7f9oqu7o501.jpg";
        String img4 = "https://i.redd.it/j6myfqglup501.jpg";
        String img5 = "https://i.redd.it/0h2gm1ix6p501.jpg";

        String name1 = "The Dark Knight";
        String name2 = "Schindler's List";
        String name3 = "Inspection";
        String name4 = "Dead Island";
        String name5 = "The Silence of the Lambs";

        String des1 = "In Poland during World war II, Oskar Sanchindler gradually becomes..";
        String des2 = "The masterful concoction features a delicious core of mandarin oranges";
        String des3 = "An insomniac office worker, looking for a wya to change his life, crosses path..";

        for (int x = 0; x < 2; x++) {
            profile.add(new Profile(img1, name1, des1));
            profile.add(new Profile(img2, name2, des2));
            profile.add(new Profile(img3, name3, des3));
            profile.add(new Profile(img4, name4, des1));
            profile.add(new Profile(img5, name5, des2));
        }
    }

    @Override
    public void callToast() {
        Toast.makeText(this, "Action close, In Main Activity", Toast.LENGTH_SHORT).show();
        Snackbar.make(recyclerView, "Popup Window Closed", Snackbar.LENGTH_SHORT).show();
    }
}
