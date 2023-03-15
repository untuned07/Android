package com.example.practical03;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    int[] colors={
            Color.GREEN, Color.GRAY, Color.RED, Color.MAGENTA, Color.CYAN, Color.BLUE, Color.YELLOW
    };
    Button btn;
    int i=0;
    View view;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn = findViewById(R.id.buttonXML);
        view = this.getWindow().getDecorView();
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                view.setBackgroundColor(colors[i]);
                i++;
                if(i ==7){
                    i = 0;
                }
            }
        });
    }
}