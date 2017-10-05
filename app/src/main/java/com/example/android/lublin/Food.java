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
public class Food extends Fragment {
        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            View rootView = inflater.inflate(R.layout.word_list, container, false);

            final ArrayList<Word> words = new ArrayList<Word>();
            words.add(new Word(R.string.stol_name, R.string.stol_adres, getString(R.string.stol_location), R.drawable.stol_photo));
            words.add(new Word(R.string.sielsko_name, R.string.sielsko_adres, getString(R.string.sielsko_location), R.drawable.sielsko_photo));
            words.add(new Word(R.string.sexy_name, R.string.sexy_adres, getString(R.string.sexy_location), R.drawable.sexy_photo));
            words.add(new Word(R.string.magia_name, R.string.magia_adres, getString(R.string.magia_location), R.drawable.magia_photo));
            words.add(new Word(R.string.czarcia_name, R.string.czarcia_adres, getString(R.string.czarcia_location), R.drawable.czarcia_photo));

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




