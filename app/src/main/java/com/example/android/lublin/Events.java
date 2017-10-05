package com.example.android.lublin;


import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class Events extends Fragment {
        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            View rootView = inflater.inflate(R.layout.word_list, container, false);

            final ArrayList<Word> words = new ArrayList<Word>();
            words.add(new Word(R.string.sztuk_name, R.string.sztuk_date, getString(R.string.sztuk_web), R.drawable.sztuk_photo));
            words.add(new Word(R.string.juw_name, R.string.juw_date, getString(R.string.juw_web), R.drawable.juw_photo));
            words.add(new Word(R.string.mov_name, R.string.mov_date, getString(R.string.mov_web), R.drawable.mov_photo));
            words.add(new Word(R.string.stud_name, R.string.stud_date, getString(R.string.stud_web), R.drawable.stud_photo));

            WordAdapter adapter = new WordAdapter(getActivity(), words, R.color.category_historical_places);
            ListView listView = (ListView) rootView.findViewById(R.id.list);
            listView.setAdapter(adapter);
            listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                    Word word = words.get(position);

                    Uri gmmIntentUri = Uri.parse(word.getLoc());
                    Intent wIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
                    startActivity(wIntent);
                }

            });
            return rootView;
            }
}




