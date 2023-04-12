package com.example.practical18;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.view.View;
import android.widget.TextView;

import com.example.practical18.MyService;

public class MainActivity extends AppCompatActivity {

    MyService myService = new MyService();
    boolean isConnected = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Intent intent = new Intent(this, MyService.class);
        bindService(intent, serviceConnection, Context.BIND_AUTO_CREATE);
    }

    public void getTimePressed(View v){
        TextView textView = findViewById(R.id.textView);
        textView.setText(myService.getSystemTime());
    }

    private ServiceConnection serviceConnection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            MyService.MyLocalBinder binder = (MyService.MyLocalBinder) service;
            myService = binder.getBoundService();
            isConnected = true;
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {

        }
    };
}