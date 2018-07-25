package com.example.user.uidesign.Utils;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.util.Log;
import android.view.MenuItem;

import com.example.user.uidesign.AlarmActivity;
import com.example.user.uidesign.AssgmentActivity;
import com.example.user.uidesign.CheckActivity;
import com.example.user.uidesign.ListActivity;
import com.example.user.uidesign.MainActivity;
import com.example.user.uidesign.R;
import com.ittianyu.bottomnavigationviewex.BottomNavigationViewEx;

public class BottomNavHelper {

    private static final String TAG = "BottomNavHelper";

    public static void setupBottomNavigationView(BottomNavigationViewEx bottomNavigationViewEx){
        Log.d(TAG, "setupBottomNavigationView");
        bottomNavigationViewEx.enableAnimation(false);
        bottomNavigationViewEx.enableItemShiftingMode(false);
        bottomNavigationViewEx.enableShiftingMode(false);
        bottomNavigationViewEx.setTextVisibility(false);
    }

    public static void enableNavigation(final Context context, BottomNavigationViewEx view){
        view.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){

                    case R.id.ic_home:
                        Intent intent1 = new Intent(context, MainActivity.class);
                        intent1.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP | Intent.FLAG_ACTIVITY_CLEAR_TASK );
                        context.startActivity(intent1);
                        break;

                    case R.id.ic_check:
                        Intent intent2 = new Intent(context, CheckActivity.class);
                        intent2.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                        context.startActivity(intent2);
                        break;

                    case R.id.ic_alarm:
                        Intent intent3 = new Intent(context, AlarmActivity.class);
                        intent3.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                        context.startActivity(intent3);
                        break;

                    case R.id.ic_list:
                        Intent intent4 = new Intent(context, ListActivity.class);
                        intent4.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                        context.startActivity(intent4);
                        break;

                    case R.id.ic_assignment:
                        Intent intent5 = new Intent(context, AssgmentActivity.class);
                        intent5.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                        context.startActivity(intent5);
                        break;

                }

                return false;
            }
        });
    }
}
