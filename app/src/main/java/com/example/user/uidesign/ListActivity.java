package com.example.user.uidesign;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.user.uidesign.Utils.BottomNavHelper;
import com.ittianyu.bottomnavigationviewex.BottomNavigationViewEx;

import java.util.ArrayList;

public class ListActivity extends AppCompatActivity {

    private static final String TAG = "ListActivity";
    private Context mContext =  ListActivity.this;
    private static final int ACTIVITY_NUM = 3;

    ListView listView;
    ArrayList<String> arrayList;
    ArrayAdapter<String> arrayAdapter;
    String messageText;
    int position;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
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

    private void setupRecycleView() {
        Log.d(TAG, "setupRecycleView");

        listView = (ListView) findViewById(R.id.listView);
        arrayList = new ArrayList<>();
        arrayAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,arrayList);
        listView.setAdapter(arrayAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent();
                intent.setClass(ListActivity.this, EditMessageList.class);
                intent.putExtra(Intent_Constant.INTENT_MESSAGE_DATA, arrayList.get(position).toString());
                intent.putExtra(Intent_Constant.INTENT_ITEM_POSITION, position);
                startActivityForResult(intent, Intent_Constant.INTENT_REQUEST_CODE_TWO);
            }
        });

    }

    public void onClick(View v){
        Intent intent = new Intent();
        intent.setClass(ListActivity.this, EditTextList.class);
        startActivityForResult(intent, Intent_Constant.INTENT_REQUEST_CODE);
//        startActivity(new Intent(ListActivity.this, EditTextList.class));
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        if(resultCode == Intent_Constant.INTENT_REQUEST_CODE){
            messageText = data.getStringExtra(Intent_Constant.INTENT_MESSAGE_FIELD);
            arrayList.add(messageText);
            arrayAdapter.notifyDataSetChanged();

        }else if (resultCode == Intent_Constant.INTENT_REQUEST_CODE_TWO){
            messageText = data.getStringExtra(Intent_Constant.INTENT_CHANGE_MESSAGE);
            position = data.getIntExtra(Intent_Constant.INTENT_ITEM_POSITION, -1);
            arrayList.remove(position);
            arrayList.add(position, messageText);
            arrayAdapter.notifyDataSetChanged();

        }
    }
}
