package com.example.practical04;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText et1, et2;
    Button btn;
    TextView tv;
    double num1, num2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        et1 = findViewById(R.id.num1);
        et2 = findViewById(R.id.num2);
        btn = findViewById(R.id.buttonXML);
        tv = findViewById(R.id.textView);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                num1 = Double.parseDouble(et1.getText().toString());
                num2 = Double.parseDouble(et2.getText().toString());
                double sum = num1 + num2;
                tv.setText("" + sum);
            }
        });
    }
}