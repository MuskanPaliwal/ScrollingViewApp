package com.example.scrollingview;
import com.example.scrollingview.friends;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
        ListView listView;
        String friendsNames[] = {
                "Hema",
                "Amit",
                "Ruchi",
                "Divya",
                "Dipisha"
        };

        String catchPhrases[] = {
                "Everything will work",
                "I can do this!",
                "Don't worry Yarr!",
                "I am very stressed!",
                "Smiling always!"
        };


        Integer imageid[] = {
                R.drawable.friend,
                R.drawable.friend,
                R.drawable.friend,
                R.drawable.friend,
                R.drawable.friend,

        };


        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);

            // Setting header
            TextView textView = new TextView(this);
            textView.setTypeface(Typeface.DEFAULT_BOLD);
            textView.setText("List of friends");

            ListView listView=(ListView)findViewById(android.R.id.list);
            listView.addHeaderView(textView);

            // For populating list data
            friends Friends = new friends(this, friendsNames, catchPhrases, imageid);
            listView.setAdapter(Friends);

            listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                    Toast.makeText(getApplicationContext(),"You Selected "+friendsNames[position-1]+ " as friends",Toast.LENGTH_SHORT).show();        }
            });
        }
    }