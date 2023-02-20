package com.example.labexternalstorage;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class MainActivity extends AppCompatActivity {
    EditText et;
    TextView tv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        et = findViewById(R.id.editTextTextPersonName);
        tv = findViewById(R.id.textView);
    }

    public void saveData(View view){
        ActivityCompat.requestPermissions(MainActivity.this, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, 23);
        File dir = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS);
        String fileName = "myFile.txt";
        File myFile = new File(dir, fileName);
        String str = et.getText().toString();

        try{
            FileOutputStream myOutput = new FileOutputStream(myFile,true);
            myOutput.write(str.getBytes());
            myOutput.close();
        }catch(FileNotFoundException e){
            Toast.makeText(getApplicationContext(), "File Not Found", Toast.LENGTH_LONG).show();
        }catch(Exception e){
            Toast.makeText(getApplicationContext(), "Exception " + e, Toast.LENGTH_LONG).show();
        }
        try {
            FileInputStream myFileInput = new FileInputStream(myFile);
            StringBuffer myStringBuffer = new StringBuffer();
            int read = -1;
            while((read = myFileInput.read())!= -1){
                myStringBuffer.append((char)read);
            }
            String data = myStringBuffer.substring(0, myStringBuffer.length());
            tv.setText(data);
        }catch (FileNotFoundException e){
            Toast.makeText(getApplicationContext(), "File Not Found", Toast.LENGTH_LONG).show();
        }catch (IOException e){
            Toast.makeText(getApplicationContext(), "IO Exception", Toast.LENGTH_LONG).show();
        }catch (Exception e){
            Toast.makeText(getApplicationContext(), "Error", Toast.LENGTH_LONG).show();
        }
    }
}