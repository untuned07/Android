package com.example.practical02;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    int[] colors= {
            Color.BLACK, Color.BLUE, Color.CYAN, Color.GREEN, Color.RED, Color.MAGENTA, Color.GRAY
    };
    TextView textView;
    Button btn;
    int i=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = findViewById(R.id.textView);
        btn = findViewById(R.id.buttonXML);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textView.setTextColor(Color.WHITE);
                textView.setBackgroundColor(colors[i]);
                i++;
                if(i == 7){
                    i=0;
                }
            }
        });
    }
}