package com.example.android.lublin;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;




public class WordAdapter extends ArrayAdapter<Word> {

    private int mColorResourceId;


    public WordAdapter(Context context, ArrayList<Word> words, int colorResourceId){

        super(context, 0, words);
        mColorResourceId = colorResourceId;
    }
    private static final String LOG_TAG = WordAdapter.class.getSimpleName();
    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View listItemView = convertView;
        if(listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);
        }

        Word currentWord = getItem(position);
        TextView miwokTextView = (TextView) listItemView.findViewById(R.id.attraction_name);
        miwokTextView.setText(currentWord.getAttLocation());



        TextView defaultTextView = (TextView) listItemView.findViewById(R.id.attraction_description);
        defaultTextView.setText(currentWord.getAttAddress());
        ImageView imageView = (ImageView) listItemView.findViewById(R.id.icon);




        if (currentWord.hasImage()) {
            imageView.setImageResource(currentWord.getImageResourceId());
            imageView.setVisibility(View.VISIBLE);
        }else {
            imageView.setVisibility(View.GONE);
        }

        View textContainer = listItemView.findViewById(R.id.text_container);
        int color = ContextCompat.getColor(getContext(), mColorResourceId);
        textContainer.setBackgroundColor(color);

        return listItemView;
    }

}

