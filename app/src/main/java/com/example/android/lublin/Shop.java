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

public class Shop extends Fragment {



        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            View rootView = inflater.inflate(R.layout.word_list, container, false);

            final ArrayList<Word> words = new ArrayList<Word>();
            words.add(new Word(R.string.tarasy_name, R.string.tarasy_adres, getString(R.string.tarasy_location), R.drawable.tarasy_photo));
            words.add(new Word(R.string.plaza_name, R.string.plaza_adres, getString(R.string.plaza_location), R.drawable.plaza_photo));
            words.add(new Word(R.string.olimp_name, R.string.olimp_adres, getString(R.string.olimp_location), R.drawable.olimp_photo));

            WordAdapter adapter = new WordAdapter(getActivity(), words, R.color.category_historical_places);

            ListView listView = (ListView) rootView.findViewById(R.id.list);

            listView.setAdapter(adapter);

            listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                    Word word = words.get(position);
                    Uri gmmIntentUri = Uri.parse(word.getLoc());
                    Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
                    mapIntent.setPackage("com.google.android.apps.maps");
                    startActivity(mapIntent);
                }

            });
            return rootView;
            }
}




