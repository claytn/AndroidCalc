package edu.purdue.marsha88.cs180calc;


import android.os.Bundle;


import android.support.v7.app.AppCompatActivity;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {



        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        TextView textView = (TextView) findViewById(R.id.answer);
        CalculatorView view = new CalculatorView(textView);

        final Calculator c = new Calculator(view);
        Button zero = (Button) findViewById(R.id.button0);
        Button one = (Button) findViewById(R.id.button1);
        Button two = (Button) findViewById(R.id.button2);
        Button three = (Button) findViewById(R.id.button3);
        Button four = (Button) findViewById(R.id.button4);
        Button five = (Button) findViewById(R.id.button5);
        Button six = (Button) findViewById(R.id.button6);
        Button seven = (Button) findViewById(R.id.button7);
        Button eight = (Button) findViewById(R.id.button8);
        Button nine = (Button) findViewById(R.id.button9);
        Button del = (Button) findViewById(R.id.buttonDEL);
        Button div = (Button) findViewById(R.id.buttonDiv);
        Button dot = (Button) findViewById(R.id.buttonDot);
        Button mul = (Button) findViewById(R.id.buttonx);
        Button plus = (Button) findViewById(R.id.buttonPlus);
        Button eq = (Button) findViewById(R.id.buttonEq);
        Button min = (Button) findViewById(R.id.buttonMinus);
        Button cl = (Button) findViewById(R.id.clear);


        zero.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                c.inputDigit('0');
            }
        });
        one.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                c.inputDigit('1');
            }
        });
        two.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                c.inputDigit('2');
            }
        });
        three.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                c.inputDigit('3');
            }
        });
        four.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                c.inputDigit('4');
            }
        });
        five.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                c.inputDigit('5');
            }
        });
        six.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                c.inputDigit('6');
            }
        });
        seven.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                c.inputDigit('7');
            }
        });
        eight.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                c.inputDigit('8');
            }
        });
        nine.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                c.inputDigit('9');
            }
        });
        dot.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                c.dot();
            }
        });
        eq.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                c.equal();
            }
        });
        plus.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                c.operator('+');
            }
        });
        min.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                c.operator('-');
            }
        });
        mul.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                c.operator('x');
            }
        });
        div.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                c.operator('/');
            }
        });
        del.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                c.delete();
            }
        });
        cl.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                c.clear();
            }
        });


    }

}
