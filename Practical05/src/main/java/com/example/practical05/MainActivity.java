package com.example.practical05;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.button.MaterialButton;

import org.mozilla.javascript.Context;
import org.mozilla.javascript.Scriptable;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    TextView resultTV, solutionTV;
    MaterialButton buttonC, buttonAC, buttonDot, buttonOpenBracket, buttonClosedBracket, buttonDivide, buttonMultiply, buttonMinus, buttonAdd, buttonEquals, button1, button2, button3, button4, button5, button6, button7, button8, button9, button0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        resultTV = findViewById(R.id.result);
        solutionTV = findViewById(R.id.solution);
        assignID(buttonC, R.id.button_c);
        assignID(buttonAC, R.id.button_ac);
        assignID(buttonDot, R.id.button_dot);
        assignID(buttonOpenBracket, R.id.button_open_bracket);
        assignID(buttonClosedBracket, R.id.button_closed_bracket);
        assignID(buttonDivide, R.id.button_divide);
        assignID(buttonMultiply, R.id.button_multiply);
        assignID(buttonMinus, R.id.button_minus);
        assignID(buttonAdd, R.id.button_add);
        assignID(buttonEquals, R.id.button_equals);
        assignID(button0, R.id.button_0);
        assignID(button1, R.id.button_1);
        assignID(button2, R.id.button_2);
        assignID(button3, R.id.button_3);
        assignID(button4, R.id.button_4);
        assignID(button5, R.id.button_5);
        assignID(button6, R.id.button_6);
        assignID(button7, R.id.button_7);
        assignID(button8, R.id.button_8);
        assignID(button9, R.id.button_9);
    }

    void assignID(MaterialButton btn, int id){
        btn = findViewById(id);
        btn.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        MaterialButton button = (MaterialButton) view;
        String buttonText = button.getText().toString();
        String dataToCalculate = solutionTV.getText().toString();

        if(buttonText.equals("AC")){
            solutionTV.setText("");
            resultTV.setText("0");
            return;
        }else if(buttonText.equals("C")){
            if(solutionTV.length() == 1 || solutionTV.length()==0){
                solutionTV.setText("");
                dataToCalculate = "0";
            }else{
                dataToCalculate = dataToCalculate.substring(0, dataToCalculate.length()-1);
            }
        }else if(buttonText.equals("=")){
            solutionTV.setText(resultTV.getText());
            return;
        }else{
            dataToCalculate = dataToCalculate + buttonText;
        }

        solutionTV.setText(dataToCalculate);

        String finalResult = getResult(dataToCalculate);
        if(!finalResult.equals("Error")){
            resultTV.setText(finalResult);
        }
    }

    String getResult(String data){
        try {
            Context context = Context.enter();
            context.setOptimizationLevel(-1);
            Scriptable scriptable = context.initStandardObjects();
            String finalResult = context.evaluateString(scriptable, data, "Javascript", 1, null).toString();
            return finalResult;
        }catch (Exception e){
            return "Error";
        }
    }
}