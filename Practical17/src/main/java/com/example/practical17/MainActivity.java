package com.example.practical17;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView myListView = findViewById(R.id.listView);
        ArrayList<String> elements = new ArrayList<>();
        elements.add("First Element");
        elements.add("Second Element");
        elements.add("Third Element");
        elements.add("Fourth Element");
        elements.add("Fifth Element");

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, elements);
        myListView.setAdapter(arrayAdapter);
    }
}