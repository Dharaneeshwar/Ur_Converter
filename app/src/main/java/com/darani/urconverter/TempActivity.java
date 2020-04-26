package com.darani.urconverter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.text.method.KeyListener;
import android.view.KeyEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class TempActivity extends AppCompatActivity {

    RadioGroup rgInp, rgOut;
    RadioButton rbInp, rbOut;
    LinearLayout tempCalc, line1;
    EditText etinputTemp;
     TextView etoutputtemp;
    private TextWatcher text;
    public double inp;

    public String input = "none", output = "none";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_temp);
        line1 = findViewById(R.id.line1);
        etinputTemp = findViewById(R.id.etinputTemp);
        etoutputtemp = findViewById(R.id.etoutputTemp);
        tempCalc = findViewById(R.id.tempCalc);
        tempCalc.setVisibility(View.GONE);
        line1.setVisibility(View.GONE);
        rgInp = findViewById(R.id.rgInp);
        rgOut = findViewById(R.id.rgOut);

        text = new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
               // double inp=0,out;
                try {
                     inp = Double.parseDouble(etinputTemp.getText().toString());
                }
                catch (NumberFormatException e)
                {
                    etoutputtemp.setText("0.00");

                }calculate(inp);

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        };


        etinputTemp.addTextChangedListener(text);
     //   etoutputtemp.addTextChangedListener(text2);



    };

    public void checkInp(View v){
        Toast.makeText(this,"Input got..",Toast.LENGTH_SHORT).show();
        int radioId= rgInp.getCheckedRadioButtonId();
        rbInp=findViewById(radioId);
        input=rbInp.getText().toString().trim();
        if (!output.equals("none")) {
            Toast.makeText(this, "From " + input + " to " + output, Toast.LENGTH_SHORT).show();
            tempCalc.setVisibility(View.VISIBLE);
            etinputTemp.setHint(input);
            etoutputtemp.setHint(output);
            line1.setVisibility(View.VISIBLE);
            calculate(inp);
        }
    }

    public void checkOut(View v) {
            int radioId = rgOut.getCheckedRadioButtonId();
            rbOut = findViewById(radioId);
            output = rbOut.getText().toString().trim();
            if (!input.equals("none")) {
                Toast.makeText(this, "From " + input + " to " + output, Toast.LENGTH_SHORT).show();
                tempCalc.setVisibility(View.VISIBLE);
                etinputTemp.setHint(input);
                etoutputtemp.setHint(output);
                line1.setVisibility(View.VISIBLE);
                calculate(inp);
            }

    }

    public void calculate(double inp){
        double out;
        if (input.equals("Celsius")) {
            if(output.equals("Celsius")){
                etoutputtemp.setText(inp + " C");
            }
            else if (output.equals("Kelvin")) {
                out = inp+ 273.15;
                etoutputtemp.setText(out + " K");
            } else {
                out = (inp * 9 / 5) + 32;
                etoutputtemp.setText(out + " F");
            }
        } else if (input.equals("Fahrenheit")) {
            if (output.equals("Fahrenheit")){
                etoutputtemp.setText(inp + " F");
            }
            else if (output.equals("Celsius")) {
                out = (inp - 32) * 5 / 9;
                etoutputtemp.setText(out + " C");
            } else {
                out = ((inp - 32) * 5 / 9) + 273.15;
                etoutputtemp.setText(out + " K");
            }
        } else if (input.equals("Kelvin")) {
            if (output.equals("Kelvin")){
                etoutputtemp.setText(inp + " K");
            }
            else if (output.equals("Fahrenheit")) {
                out = ((inp - 273.15) * 9 / 5) + 32;
                etoutputtemp.setText(out + " F");
            } else {
                out = inp - 273.15;
                etoutputtemp.setText(out + " C");
            }
        } else
            etoutputtemp.setText(inp + "");

    }

}
