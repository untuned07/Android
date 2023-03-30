package com.example.practical12;

import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText num, message;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        num = findViewById(R.id.editTextNumber);
        message = findViewById(R.id.editText);
    }

    public void textMyNumber(){
        String s, numberPh;
        numberPh = num.getText().toString();
        s= message.getText().toString();
        SmsManager smsManager = SmsManager.getDefault();
        smsManager.sendTextMessage(numberPh, null, s, null, null);
        Toast.makeText(getApplicationContext(), "Message sent", Toast.LENGTH_LONG).show();
    }

    public void textMe(View view){
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.M){
            if(checkSelfPermission(Manifest.permission.SEND_SMS) == PackageManager.PERMISSION_GRANTED){
                textMyNumber();
            }
        }
    }
}