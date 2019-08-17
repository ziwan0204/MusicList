package com.example.musiclist;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

//list view
public class MainActivity extends AppCompatActivity {

    ListView list;
    String titles[] = {"Chasing Wonder", "Enjoyable", "Healing Piano"};
    String descriptions[] = {"1", "2", "3"};
    int imgs[] = {R.drawable.chasingwonder, R.drawable.enjoyable, R.drawable.healingpiano};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        list = findViewById(R.id.list1);

        //creating instance of class MyAdapter
        MyAdapter adapter = new MyAdapter(this, titles, imgs, descriptions);

        //set adapter to list
        list.setAdapter(adapter);

        //handle item clicks
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                if (position == 0) {
                    Toast.makeText(MainActivity.this, "Chasing Wonder", Toast.LENGTH_SHORT).show();
                    Intent myintent = new Intent(view.getContext(), ChasingWonderActivity.class);
                    startActivityForResult(myintent, 0);

                }
                if (position == 1) {
                    Toast.makeText(MainActivity.this, "Enjoyable", Toast.LENGTH_SHORT).show();
                    Intent myintent = new Intent(view.getContext(), EnjoyableActivity.class);
                    startActivityForResult(myintent, 1);
                }
                if (position == 2) {
                    Toast.makeText(MainActivity.this, "Healing Piano", Toast.LENGTH_SHORT).show();
                    Intent myintent = new Intent(view.getContext(), HealingPianoActivity.class);
                    startActivityForResult(myintent, 2);
                }
            }
        });
    }


    class MyAdapter extends ArrayAdapter<String> {
        Context context;
        String myTitles[];
        String myDescriptions[];
        int[] imgs;

        MyAdapter(Context c, String[] titles, int[] imgs, String[] descriptions) {
            super(c, R.layout.row, R.id.text1, titles);
            this.context = c;
            this.imgs = imgs;
            this.myTitles = titles;
            this.myDescriptions = descriptions;
        }

        @NonNull
        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            LayoutInflater layoutInflater = (LayoutInflater) getApplicationContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View row = layoutInflater.inflate(R.layout.row, parent, false);
            ImageView images = row.findViewById(R.id.logo);
            TextView myTitle = row.findViewById(R.id.text1);
            TextView myDescription = row.findViewById(R.id.text2);
            images.setImageResource(imgs[position]);
            myTitle.setText(titles[position]);
            myDescription.setText(descriptions[position]);
            return row;
        }
    }
}