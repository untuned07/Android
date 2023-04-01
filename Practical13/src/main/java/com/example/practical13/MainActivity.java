package com.example.practical13;

import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    EditText num;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        num = findViewById(R.id.editTextPhone);
    }

    public void callMyNumber(){
        String str;
        str = num.getText().toString();
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
}