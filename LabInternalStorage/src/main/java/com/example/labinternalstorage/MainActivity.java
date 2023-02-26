package com.example.labinternalstorage;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class MainActivity extends AppCompatActivity {
    EditText myEditText;
    TextView tv;
    Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        myEditText = findViewById(R.id.editTextTextPersonName);
        tv = findViewById(R.id.textView);
        btn = findViewById(R.id.button);
        String fileName = "myFile.txt";

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String str = myEditText.getText().toString();

                try{
                    FileOutputStream myOutput = openFileOutput(fileName, MODE_PRIVATE);
                    myOutput.write(str.getBytes());
                    myOutput.close();
                }catch(FileNotFoundException e){
                    Toast.makeText(getApplicationContext(), "File Not Found", Toast.LENGTH_LONG).show();
                }catch(Exception e){
                    Toast.makeText(getApplicationContext(), "Exception " + e, Toast.LENGTH_LONG).show();
                }

                try {
                    FileInputStream myFileInput = openFileInput(fileName);
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
        });
    }
}