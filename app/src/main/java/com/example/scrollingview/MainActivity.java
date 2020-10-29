package com.example.scrollingview;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.graphics.Typeface;
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

            listView=findViewById(android.R.id.list);
            listView.addHeaderView(textView);

            // For populating list data
            item Friends = new item(this, friendsNames, catchPhrases, imageid);
            listView.setAdapter(Friends);

            listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                    Toast.makeText(getApplicationContext(),"You Selected "+friendsNames[position-1]+ " as friends",Toast.LENGTH_SHORT).show();
                }
            });
        }
    }
class item extends ArrayAdapter {
    private String[] friendsNames;
    private String[] catchPhrases;
    private Integer[] imageid;
    private Context context;

    public item(Context context, String[] friendsNames, String[] catchPhrases, Integer[] imageid) {
        super(context, R.layout.item, friendsNames);
        this.context = context;
        this.friendsNames = friendsNames;
        this.catchPhrases = catchPhrases;
        this.imageid = imageid;

    }
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @Nullable ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context.getApplicationContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View row=inflater.inflate(R.layout.item,parent,false);
        TextView textViewFriends = (TextView) row.findViewById(R.id.textViewFriends);
        TextView textViewPhrases = (TextView) row.findViewById(R.id.textViewPhrases);
        ImageView imageFlag = (ImageView) row.findViewById(R.id.imageViewFlag);

        textViewFriends.setText(friendsNames[position]);
        textViewPhrases.setText(catchPhrases[position]);
        imageFlag.setImageResource(imageid[position]);
        return  row;
    }
}

