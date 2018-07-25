package com.example.user.uidesign;

import android.content.Context;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;

import com.example.user.uidesign.Utils.BottomNavHelper;
import com.ittianyu.bottomnavigationviewex.BottomNavigationViewEx;

import java.util.ArrayList;
import java.util.List;

public class CheckActivity extends AppCompatActivity {

    private static final String TAG = "CheckActivity";
    private Context mContext =  CheckActivity.this;
    private static final int ACTIVITY_NUM = 1;

//    RecyclerView recyclerView;
//    ArrayList<String> arrayList;
//    ArrayAdapter<String> arrayAdapter;

    private RecyclerView recycleviewcheck;
    private RecyclerView.Adapter adapter;
    private List<checklist> checklists;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check);
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

    public void onBackPressed(){
        super.onBackPressed();
        overridePendingTransition(R.anim.animation_enter, R.anim.animation_leave);
    }

    private void setupRecycleView(){
        Log.d(TAG, "setupRecycleView");

        recycleviewcheck = (RecyclerView) findViewById(R.id.recycleviewcheck);
        recycleviewcheck.setHasFixedSize(true);
        recycleviewcheck.setLayoutManager(new LinearLayoutManager(this));

        checklists = new ArrayList<>();
        for (int i = 1; i<=1; i++){
            checklist checklist = new checklist(
                    ""
            );

            checklists.add(checklist);
        }

        adapter = new adaptercheck(checklists, this);
        recycleviewcheck.setAdapter(adapter);

    }

}
