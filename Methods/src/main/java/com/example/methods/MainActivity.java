package com.example.methods;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    String title = "New Project";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(title, "Hello to Android on Start method");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(title, "Hello to Android on Stop method");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(title, "Hello to Android on Destroy method");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(title, "Hello to Android on Pause method");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(title, "Hello to Android on Resume method");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d(title, "Hello to Android on Restart method");
    }
}