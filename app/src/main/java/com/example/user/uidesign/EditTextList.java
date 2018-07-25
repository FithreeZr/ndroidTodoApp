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

public class EditTextList extends AppCompatActivity {

    private static final String TAG = "EditTextList";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.listlist);
        Log.d(TAG, "onCreate: starting");

    }

    public void saveButtonClicked(View v){
        String messageText = ((EditText)findViewById(R.id.editTextList)).getText().toString();

        if(messageText.equals("")){

        }else{
            Intent intent = new Intent();
            intent.putExtra(Intent_Constant.INTENT_MESSAGE_FIELD,messageText);
            setResult(Intent_Constant.INTENT_RESULT_CODE,intent);
            finish();

        }
    }
}
