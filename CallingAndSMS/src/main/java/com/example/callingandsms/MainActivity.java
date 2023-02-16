package com.example.callingandsms;

import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText et, msg;
    Button call, message;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        et = findViewById(R.id.editTextPhone);
        msg = findViewById(R.id.editTextTextPersonName);
        call = findViewById(R.id.button);
        message = findViewById(R.id.button2);
    }

    public void callMyNumber(){
        String str;
        str = et.getText().toString();
        Intent i = new Intent(Intent.ACTION_CALL);
        i.setData(Uri.parse("tel:" + str));
        startActivity(i);
    }

    public void callMe(View view){
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.M){
            if(checkSelfPermission(Manifest.permission.CALL_PHONE) == PackageManager.PERMISSION_GRANTED){
                callMyNumber();
            }
        }
    }

    public void textMyNumber(){
        String s, num;
        num = et.getText().toString();
        s= msg.getText().toString();
        SmsManager smsManager = SmsManager.getDefault();
        smsManager.sendTextMessage(num, null, s, null, null);
    }

    public void textMe(View view){
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.M){
            if(checkSelfPermission(Manifest.permission.SEND_SMS) == PackageManager.PERMISSION_GRANTED){
                textMyNumber();
            }
        }
    }
}