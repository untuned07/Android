package com.example.activitylifecycle;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {
String TAG="Activity Lifecycle program";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d(TAG, "Hello to android on Create Method");
    }
    @Override
    public void onStart(){
        super.onStart();
        Log.d(TAG, "Hello to android on Start Method");
    }
    @Override
    public void onStop(){
        super.onStop();
        Log.d(TAG, "Hello to android on Stop Method");
    }
    @Override
    public void onPause(){
        super.onPause();
        Log.d(TAG, "Hello to android on Pause Method");
    }
    @Override
    public void onResume(){
        super.onResume();
        Log.d(TAG, "Hello to android on Resume Method");
    }
    @Override
    public void onDestroy(){
        super.onDestroy();
        Log.d(TAG, "Hello to android on Destroy Method");
    }
}