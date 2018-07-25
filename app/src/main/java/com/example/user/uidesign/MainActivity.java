package com.example.user.uidesign;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import com.example.user.uidesign.Utils.BottomNavHelper;
import com.ittianyu.bottomnavigationviewex.BottomNavigationViewEx;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";
    private Context mContext =  MainActivity.this;
    private static final int ACTIVITY_NUM = 0;

    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private List<homelist> homelists;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d(TAG, "onCreate: starting");

        setupBottomNavigationView();
        setupRecycleView();



    }

    private void setupBottomNavigationView(){
        Log.d(TAG, "setupBottomNavigationView");

        BottomNavigationViewEx bottomNavigationViewEx = (BottomNavigationViewEx)findViewById(R.id.topNavView_Bar);
        BottomNavHelper.setupBottomNavigationView(bottomNavigationViewEx);
        BottomNavHelper.enableNavigation(mContext, bottomNavigationViewEx);
        overridePendingTransition(R.anim.slide_in_right,R.anim.slide_out_right);
        Menu menu = bottomNavigationViewEx.getMenu();
        MenuItem menuItem = menu.getItem(ACTIVITY_NUM);
        menuItem.setChecked(true);


    }

    private void setupRecycleView(){
        Log.d(TAG, "setupRecycleView");

        recyclerView = (RecyclerView) findViewById(R.id.recycleview);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        homelists = new ArrayList<>();
        for (int i = 0; i<=9; i++){
            homelist homelist = new homelist(
                    "heading" + (i+1),
                    "Description"
            );

            homelists.add(homelist);
        }

        adapter = new adapter(homelists, this);
        recyclerView.setAdapter(adapter);

    }




}
