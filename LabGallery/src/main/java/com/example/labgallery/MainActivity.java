package com.example.labgallery;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    int[] images={
            R.drawable.one,
            R.drawable.two,
            R.drawable.three,
            R.drawable.four,
            R.drawable.five
    };
    int count = 0;
    Button btn12, btn23;
    ImageView imageview;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn12 = findViewById(R.id.btn1);
        btn23 = findViewById(R.id.btn2);
        imageview = findViewById(R.id.imageView);

        btn23.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(count == images.length-1){
                    Toast.makeText(MainActivity.this, "No Next Image", Toast.LENGTH_SHORT).show();
                }else {
                    ++count;
                    imageview.setImageResource(images[count]);
                }
            }
        });

        btn12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (count == 0){
                    Toast.makeText(MainActivity.this, "No Previous Image", Toast.LENGTH_SHORT).show();
                }else{
                    --count;
                    imageview.setImageResource(images[count]);
                }
            }
        });
    }
}