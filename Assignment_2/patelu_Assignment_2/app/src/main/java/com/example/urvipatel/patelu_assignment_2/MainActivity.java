package com.example.urvipatel.patelu_assignment_2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;



public class MainActivity extends AppCompatActivity {

    private int firstOperandInt = 0;
    private int secondOperandInt = 0;
    private String numberText = "";
    private String secondOperandStr = "";
    private String operandStr = "";
    private boolean isTyping = false;
    private int runningTotal = 0;
    private boolean isFirstOp = true;
    private String lastOp = "+";
    private boolean equalPressed = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final TextView tv = (TextView) findViewById(R.id.text1);

        Button b1 = (Button) findViewById(R.id.button1);
        Button b2 = (Button) findViewById(R.id.button2);
        Button b3 = (Button) findViewById(R.id.button3);
        Button b4 = (Button) findViewById(R.id.button4);
        Button b5 = (Button) findViewById(R.id.button5);
        Button b6 = (Button) findViewById(R.id.button6);
        Button b7 = (Button) findViewById(R.id.button7);
        Button b8 = (Button) findViewById(R.id.button8);
        Button b9 = (Button) findViewById(R.id.button9);
        Button b0 = (Button) findViewById(R.id.button0);
        Button plus = (Button) findViewById(R.id.buttonPlus);
        Button equals = (Button) findViewById(R.id.buttonEquals);
        Button clear = (Button) findViewById(R.id.buttonClear);

        View.OnClickListener numberListener = new View.OnClickListener() {
            public void onClick(View v) {

                //tv.setText(((Button) v).getText());
                //firstOperand = Integer.parseInt( ((Button) v).getText().toString());

                String buttonText = ((Button) v).getText().toString();

                if(lastOp.equals("="))
                {
                    tv.setText("0");
                    numberText = "";
                    isTyping = false;
                    firstOperandInt = 0;
                    secondOperandInt = 0;
                    runningTotal = 0;
                    lastOp = "+";
                }

                if (isTyping)
                {
                    numberText += buttonText;
                }
                else
                {
                    numberText = buttonText;
                    isTyping = true;
                }
                tv.setText(numberText);
            }
        };

        View.OnClickListener plusListener = new View.OnClickListener() {
            public void onClick(View v) {
                //tv.setText(((Button) v).getText() + " pressed");

                String currentLabelText = tv.getText().toString();
                isTyping = false;
                numberText = "";
                firstOperandInt = Integer.parseInt(currentLabelText);

                if(lastOp.equals("+"))
                {
                    runningTotal += firstOperandInt;
                    String resStr = String.valueOf(runningTotal);
                    tv.setText(resStr);
                }
                lastOp = "+";
            }
        };

        View.OnClickListener equalListener = new View.OnClickListener() {
            public void onClick(View v) {
                if(lastOp.equals("="))
                {
                    return;
                }
                secondOperandInt =  Integer.parseInt(tv.getText().toString());
                runningTotal += secondOperandInt;
                String resStr = String.valueOf(runningTotal);
                tv.setText(resStr);
                lastOp = "=";
            }
        };

        View.OnClickListener clearListener = new View.OnClickListener() {
            public void onClick(View v) {

                tv.setText("0");
                numberText = "";
                isTyping = false;
                firstOperandInt = 0;
                secondOperandInt = 0;
                runningTotal = 0;
                lastOp = "+";

            }
        };

        b1.setOnClickListener(numberListener);
        b2.setOnClickListener(numberListener);
        b3.setOnClickListener(numberListener);
        b4.setOnClickListener(numberListener);
        b5.setOnClickListener(numberListener);
        b6.setOnClickListener(numberListener);
        b7.setOnClickListener(numberListener);
        b8.setOnClickListener(numberListener);
        b9.setOnClickListener(numberListener);
        b0.setOnClickListener(numberListener);
        plus.setOnClickListener(plusListener);
        equals.setOnClickListener(equalListener);
        clear.setOnClickListener(clearListener);
    }
}
