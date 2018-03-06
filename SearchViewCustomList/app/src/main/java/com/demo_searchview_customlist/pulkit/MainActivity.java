package com.demo_searchview_customlist.pulkit;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;

import com.miguelcatalan.materialsearchview.MaterialSearchView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    MaterialSearchView searchView;
    ListView lstView;
    Toolbar toolbar;
    List<String> lstFound;

    String[] lstSource = {
            "Harry",
            "Ron",
            "Hermione",
            "Snape",
            "Malfoy",
            "One",
            "Two",
            "Three",
            "Four",
            "Five",
            "Six",
            "Seven",
            "Eight",
            "Nine",
            "Ten"
    };

    private CustomAdapter eventsAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Material Search");
        toolbar.setTitleTextColor(Color.parseColor("#FFFFFF"));

        lstView = (ListView) findViewById(R.id.lstView);

        eventsAdapter = new CustomAdapter(getApplicationContext(), Arrays.asList(lstSource));
        lstView.setAdapter(eventsAdapter);

        searchView = (MaterialSearchView) findViewById(R.id.search_view);
        searchView.setOnSearchViewListener(new MaterialSearchView.SearchViewListener() {
            @Override
            public void onSearchViewShown() {

            }

            @Override
            public void onSearchViewClosed() {

                //If closed Search View , lstView will return default
                lstView = (ListView) findViewById(R.id.lstView);

                eventsAdapter = new CustomAdapter(getApplicationContext(), Arrays.asList(lstSource));
                lstView.setAdapter(eventsAdapter);

            }
        });

        searchView.setOnQueryTextListener(new MaterialSearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                if (newText != null && !newText.isEmpty()) {
                    lstFound = new ArrayList<String>();
                    for (String item : lstSource) {
                        if (item.contains(newText))
                            lstFound.add(item);
                    }

                    eventsAdapter = new CustomAdapter(getApplicationContext(), lstFound);
                    lstView.setAdapter(eventsAdapter);

                } else {
                    //if search text is null
                    //return default
                    eventsAdapter = new CustomAdapter(getApplicationContext(), Arrays.asList(lstSource));
                    lstView.setAdapter(eventsAdapter);

                }
                return true;
            }

        });


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_item, menu);
        MenuItem item = menu.findItem(R.id.action_search);
        searchView.setMenuItem(item);
        return true;
    }
}
