package com.example.fidenz.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ArrayList img = new ArrayList();
    private ArrayList display_name = new ArrayList();
    private ArrayList descriptions = new ArrayList();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        loadData();

        LinearLayoutManager linear = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        RecyclerView recycler = findViewById(R.id.view_MyRecyclerView);
        recycler.setLayoutManager(linear);
        recycler.setAdapter(new MyViewAdapter(this, img, display_name, descriptions));
    }

    private void loadData() {

        img.add("https://c1.staticflickr.com/5/4636/25316407448_de5fbf183d_o.jpg");
        display_name.add("The Dark Knight");
        descriptions.add("In Poland during World war II, Oskar Sanchindler gradually becomes..");

        img.add("https://i.redd.it/tpsnoz5bzo501.jpg");
        display_name.add("Schindler's List");
        descriptions.add("The masterful concoction features a delicious core of mandarin oranges");

        img.add("https://i.redd.it/qn7f9oqu7o501.jpg");
        display_name.add("Inspection");
        descriptions.add("An insomniac office worker, looking for a wya to change his life, crosses path..");

        img.add("https://i.redd.it/j6myfqglup501.jpg");
        display_name.add("The Matrix");
        descriptions.add("In Poland during World war II, Oskar Sanchindler gradually becomes..");


        img.add("https://i.redd.it/0h2gm1ix6p501.jpg");
        display_name.add("The Silence of the Lambs");
        descriptions.add("In Poland during World war II, Oskar Sanchindler gradually becomes..");

        img.add("https://c1.staticflickr.com/5/4636/25316407448_de5fbf183d_o.jpg");
        display_name.add("The Dark Knight");
        descriptions.add("In Poland during World war II, Oskar Sanchindler gradually becomes..");

        img.add("https://i.redd.it/tpsnoz5bzo501.jpg");
        display_name.add("Schindler's List");
        descriptions.add("The masterful concoction features a delicious core of mandarin oranges");

        img.add("https://i.redd.it/qn7f9oqu7o501.jpg");
        display_name.add("Inspection");
        descriptions.add("An insomniac office worker, looking for a wya to change his life, crosses path..");

        img.add("https://i.redd.it/j6myfqglup501.jpg");
        display_name.add("The Matrix");
        descriptions.add("In Poland during World war II, Oskar Sanchindler gradually becomes..");


        img.add("https://i.redd.it/0h2gm1ix6p501.jpg");
        display_name.add("The Silence of the Lambs");
        descriptions.add("In Poland during World war II, Oskar Sanchindler gradually becomes..");

        img.add("https://c1.staticflickr.com/5/4636/25316407448_de5fbf183d_o.jpg");
        display_name.add("The Dark Knight");
        descriptions.add("In Poland during World war II, Oskar Sanchindler gradually becomes..");

        img.add("https://i.redd.it/tpsnoz5bzo501.jpg");
        display_name.add("Schindler's List");
        descriptions.add("The masterful concoction features a delicious core of mandarin oranges");

        img.add("https://i.redd.it/qn7f9oqu7o501.jpg");
        display_name.add("Inspection");
        descriptions.add("An insomniac office worker, looking for a wya to change his life, crosses path..");

        img.add("https://i.redd.it/j6myfqglup501.jpg");
        display_name.add("The Matrix");
        descriptions.add("In Poland during World war II, Oskar Sanchindler gradually becomes..");


        img.add("https://i.redd.it/0h2gm1ix6p501.jpg");
        display_name.add("The Silence of the Lambs");
        descriptions.add("In Poland during World war II, Oskar Sanchindler gradually becomes..");

        img.add("https://c1.staticflickr.com/5/4636/25316407448_de5fbf183d_o.jpg");
        display_name.add("The Dark Knight");
        descriptions.add("In Poland during World war II, Oskar Sanchindler gradually becomes..");

        img.add("https://i.redd.it/tpsnoz5bzo501.jpg");
        display_name.add("Schindler's List");
        descriptions.add("The masterful concoction features a delicious core of mandarin oranges");

        img.add("https://i.redd.it/qn7f9oqu7o501.jpg");
        display_name.add("Inspection");
        descriptions.add("An insomniac office worker, looking for a wya to change his life, crosses path..");

        img.add("https://i.redd.it/j6myfqglup501.jpg");
        display_name.add("The Matrix");
        descriptions.add("In Poland during World war II, Oskar Sanchindler gradually becomes..");


        img.add("https://i.redd.it/0h2gm1ix6p501.jpg");
        display_name.add("The Silence of the Lambs");
        descriptions.add("In Poland during World war II, Oskar Sanchindler gradually becomes..");

        img.add("https://c1.staticflickr.com/5/4636/25316407448_de5fbf183d_o.jpg");
        display_name.add("The Dark Knight");
        descriptions.add("In Poland during World war II, Oskar Sanchindler gradually becomes..");

        img.add("https://i.redd.it/tpsnoz5bzo501.jpg");
        display_name.add("Schindler's List");
        descriptions.add("The masterful concoction features a delicious core of mandarin oranges");

        img.add("https://i.redd.it/qn7f9oqu7o501.jpg");
        display_name.add("Inspection");
        descriptions.add("An insomniac office worker, looking for a wya to change his life, crosses path..");

        img.add("https://i.redd.it/j6myfqglup501.jpg");
        display_name.add("The Matrix");
        descriptions.add("In Poland during World war II, Oskar Sanchindler gradually becomes..");


        img.add("https://i.redd.it/0h2gm1ix6p501.jpg");
        display_name.add("The Silence of the Lambs");
        descriptions.add("In Poland during World war II, Oskar Sanchindler gradually becomes..");

        img.add("https://c1.staticflickr.com/5/4636/25316407448_de5fbf183d_o.jpg");
        display_name.add("The Dark Knight");
        descriptions.add("In Poland during World war II, Oskar Sanchindler gradually becomes..");

        img.add("https://i.redd.it/tpsnoz5bzo501.jpg");
        display_name.add("Schindler's List");
        descriptions.add("The masterful concoction features a delicious core of mandarin oranges");

        img.add("https://i.redd.it/qn7f9oqu7o501.jpg");
        display_name.add("Inspection");
        descriptions.add("An insomniac office worker, looking for a wya to change his life, crosses path..");

        img.add("https://i.redd.it/j6myfqglup501.jpg");
        display_name.add("The Matrix");
        descriptions.add("In Poland during World war II, Oskar Sanchindler gradually becomes..");


        img.add("https://i.redd.it/0h2gm1ix6p501.jpg");
        display_name.add("The Silence of the Lambs");
        descriptions.add("In Poland during World war II, Oskar Sanchindler gradually becomes..");
    }
}
