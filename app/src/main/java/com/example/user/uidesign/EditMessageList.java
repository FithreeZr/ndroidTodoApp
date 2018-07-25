package com.example.user.uidesign;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

public class EditMessageList extends AppCompatActivity {

    String messageText;
    int position;

    private static final String TAG = "EditMessageList";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.listlist);
        Log.d(TAG, "onCreate: starting");

        Intent intent = getIntent();
        messageText = intent.getStringExtra(Intent_Constant.INTENT_MESSAGE_DATA);
        position = intent.getIntExtra(Intent_Constant.INTENT_ITEM_POSITION, -1);
        EditText messageData = (EditText) findViewById(R.id.editTextList);
        messageData.setText(messageText);

    }

    public void saveButtonClicked(View v){
        String changeMessageText = ((EditText)findViewById(R.id.editTextList)).getText().toString();

            Intent intent = new Intent();
            intent.putExtra(Intent_Constant.INTENT_CHANGE_MESSAGE, changeMessageText);
            intent.putExtra(Intent_Constant.INTENT_ITEM_POSITION, position);
            setResult(Intent_Constant.INTENT_RESULT_CODE_TWO,intent);
            finish();


    }

}
