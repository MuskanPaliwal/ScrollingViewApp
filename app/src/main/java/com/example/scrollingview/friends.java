package com.example.scrollingview;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;

public class friends extends ArrayAdapter {
    private String[] friendsNames;
    private String[] catchPhrases;
    private Integer[] imageid;
    private Activity context;

    public friends(Activity context, String[] friendsNames, String[] catchPhrases, Integer[] imageid) {
        super(context, R.layout.row_item, friendsNames);
        this.context = context;
        this.friendsNames = friendsNames;
        this.catchPhrases = catchPhrases;
        this.imageid = imageid;

    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View row=convertView;
        LayoutInflater inflater = context.getLayoutInflater();
        if(convertView==null)
            row = inflater.inflate(R.layout.row_item, null, true);
        TextView textViewCountry = (TextView) row.findViewById(R.id.textViewCountry);
        TextView textViewCapital = (TextView) row.findViewById(R.id.textViewCapital);
        ImageView imageFlag = (ImageView) row.findViewById(R.id.imageViewFlag);

        textViewCountry.setText(friendsNames[position]);
        textViewCapital.setText(catchPhrases[position]);
        imageFlag.setImageResource(imageid[position]);
        return  row;
    }
}

