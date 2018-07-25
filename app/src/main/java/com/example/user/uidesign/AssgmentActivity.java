package com.example.user.uidesign;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import com.example.user.uidesign.Utils.BottomNavHelper;
import com.ittianyu.bottomnavigationviewex.BottomNavigationViewEx;

public class AssgmentActivity extends AppCompatActivity {

    private static final String TAG = "AssgmentActivity";
    private Context mContext =  AssgmentActivity.this;
    private static final int ACTIVITY_NUM = 4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_assgment);
        Log.d(TAG, "onCreate: starting");

        setupBottomNavigationView();
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
}
