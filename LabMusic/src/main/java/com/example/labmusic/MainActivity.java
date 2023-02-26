package com.example.labmusic;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    Intent myIntent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        myIntent = new Intent(getApplicationContext(), MyService.class);
    }

    public  void startMe(View view){
        startService(myIntent);
    }

    public void stopMe(View view){
        stopService(myIntent);
    }
}