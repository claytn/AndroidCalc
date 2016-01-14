package edu.purdue.marsha88.cs180calc;

import android.content.Context;
import android.os.Vibrator;
import android.widget.TextView;

/**
 * Created by clayt_000 on 11/30/2015.
 */
public class CalculatorView implements CalculatorViewInterface {
    TextView textView;
    MainActivity m = new MainActivity();

    public CalculatorView(TextView textView) {
        this.textView = textView;

    }

    public void display(String val){
        textView.setText(val);
    }

    public void invalid(){
    }
}
