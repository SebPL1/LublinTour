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

public class HistoricalPlaces extends Fragment {

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            View rootView = inflater.inflate(R.layout.word_list, container, false);

            final ArrayList<Word> words = new ArrayList<Word>();
            words.add(new Word(R.string.zamek_name, R.string.zamek_adres, getString(R.string.zamek_location), R.drawable.lublin_zamek));
            words.add(new Word(R.string.litewski_name, R.string.litewski_adres, getString(R.string.litewski_location), R.drawable.litewski_photo));
            words.add(new Word(R.string.katedra_name, R.string.katedra_adres, getString(R.string.katedra_location), R.drawable.katedra_photo));
            words.add(new Word(R.string.fara_name, R.string.fara_adres, getString(R.string.fara_location), R.drawable.fara_photo));
            words.add(new Word(R.string.krakowska_name, R.string.krakowska_adres, getString(R.string.krakowska_location), R.drawable.krakowska_photo));
            words.add(new Word(R.string.majdanek_name, R.string.majdanek_adres, getString(R.string.majdanek_location), R.drawable.majdanek_photo));
            words.add(new Word(R.string.kaplica_name, R.string.kaplica_adres, getString(R.string.kaplica_location), R.drawable.kaplica_photo));
            words.add(new Word(R.string.baszta_name, R.string.baszta_adres, getString(R.string.baszta_location), R.drawable.baszta_photo));
            words.add(new Word(R.string.cerkiew_name, R.string.cerkiew_adres, getString(R.string.cerkiew_location), R.drawable.cerkiew_photo));

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