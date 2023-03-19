package com.example.practical08;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {
    String title = "New Project";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d(title, "onCreate method");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(title, "onStart method");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(title, "onStop method");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(title, "onDestroy method");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(title, "onPause method");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(title, "onResume method");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d(title, "onRestart method");
    }
}