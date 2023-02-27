package com.example.labstorage;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

public class MainActivity extends AppCompatActivity {
    EditText myText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        myText = findViewById(R.id.editXML);
    }

    public void saveInternalData(View view){
        String data = myText.getText().toString().trim();
        File myFile = getFilesDir();

        try{
            FileOutputStream myFileOutput = openFileOutput("myfile.txt", MODE_PRIVATE);
            myFileOutput.write(data.getBytes());
            myFileOutput.close();
            Toast.makeText(getApplicationContext(), "File Saved at " + myFile , Toast.LENGTH_LONG).show();
        }catch (FileNotFoundException e){
            Toast.makeText(getApplicationContext(), "File not found", Toast.LENGTH_LONG).show();
        }catch (Exception e){
            Toast.makeText(getApplicationContext(), "Error", Toast.LENGTH_LONG).show();
        }
    }
}