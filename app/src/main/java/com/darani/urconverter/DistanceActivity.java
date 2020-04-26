package com.darani.urconverter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class DistanceActivity extends AppCompatActivity {

    RadioGroup rgInp, rgOut;
    RadioButton rbInp, rbOut;
    LinearLayout distCalc, line2;
    EditText etinputDist;
    TextView tvoutputDist;
    private TextWatcher text;
    public String input = "none", output = "none";
    public    double inp = 0;
    public double out;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_distance);

        line2 = findViewById(R.id.line2);
        etinputDist = findViewById(R.id.etinputDist);
        tvoutputDist = findViewById(R.id.tvoutputDist);
        distCalc = findViewById(R.id.distCalc);
        distCalc.setVisibility(View.GONE);
        line2.setVisibility(View.GONE);
        rgInp = findViewById(R.id.rgInp);
        rgOut = findViewById(R.id.rgOut);

        text=new TextWatcher() {
            @Override

            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

             // out = 0;
                try {
                    inp = Double.parseDouble(etinputDist.getText().toString());
                } catch (NumberFormatException e) {
                    tvoutputDist.setText("0.00");
                }
                calculate(inp);

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        };
                etinputDist.addTextChangedListener(text);

    }



    public void checkInp(View v){
        Toast.makeText(this,"Input got..",Toast.LENGTH_SHORT).show();
        int radioId= rgInp.getCheckedRadioButtonId();
        rbInp=findViewById(radioId);
        input=rbInp.getText().toString().trim();
        if (!output.equals("none")) {
            Toast.makeText(this, "From " + input + " to " + output, Toast.LENGTH_SHORT).show();
            distCalc.setVisibility(View.VISIBLE);
            etinputDist.setHint(input);
            tvoutputDist.setHint(output);
            line2.setVisibility(View.VISIBLE);
            calculate(inp);
        }
    }

    public void checkOut(View v) {
        int radioId = rgOut.getCheckedRadioButtonId();
        rbOut = findViewById(radioId);
        output = rbOut.getText().toString().trim();
        if (!input.equals("none")) {
            Toast.makeText(this, "From " + input + " to " + output, Toast.LENGTH_SHORT).show();
            distCalc.setVisibility(View.VISIBLE);
            etinputDist.setHint(input);
            tvoutputDist.setHint(output);
            line2.setVisibility(View.VISIBLE);
            calculate(inp);
        }

    }
    void calculate( double inp){
        if (input.equals("Metre")){
            if (output.equals("Metre")){
                out=inp;
            }
            else if(output.equals("Kilometre")){
                out=inp/1000;
            }
            else if(output.equals("Centimetre")){
                out=inp*100.0;
            }
            else if(output.equals("Mile")){
                out=inp*0.000621371;
            }
            else if(output.equals("Foot")){
                out=inp*3.28084;
            }
            else if(output.equals("Inch")){
                out=inp*39.3701;
            }

        }
        else if(input.equals("Kilometre")){
            if(output.equals("Metre")){
                out=inp*1000;
            }
            else if(output.equals("Kilometre")){
                out=inp;
            }
            else if(output.equals("Centimetre")){
                out=inp*100000;
            }
            else if(output.equals("Mile")){
                out=inp*0.621371;
            }
            else if(output.equals("Foot")){
                out=inp*3280.84;
            }
            else if(output.equals("Inch")){
                out=inp*39370.1;
            }

        }

        else if(input.equals("Centimetre")){
            if(output.equals("Metre")){
                out=inp/100;
            }
            else if(output.equals("Kilometre")){
                out=inp/100000;
            }
            else if(output.equals("Centimetre")){
                out=inp;
            }
            else if(output.equals("Mile")){
                out=inp*6.2137*Math.pow(10,-6);
            }
            else if(output.equals("Foot")){
                out=inp*0.0328084;
            }
            else if(output.equals("Inch")){
                out=inp*0.393701;
            }

        }

        else if(input.equals("Mile")){
            if(output.equals("Metre")){
                out=inp*1609.34;
            }
            else if(output.equals("Kilometre")){
                out=inp*1.60934;
            }
            else if(output.equals("Centimetre")){
                out=inp*160934;
            }
            else if(output.equals("Mile")){
                out=inp;
            }
            else if(output.equals("Foot")){
                out=inp*5280;
            }
            else if(output.equals("Inch")){
                out=inp*63360;
            }

        }

        else if(input.equals("Foot")){
            if(output.equals("Metre")){
                out=inp*0.3048;
            }
            else if(output.equals("Kilometre")){
                out=inp*0.0003048;
            }
            else if(output.equals("Centimetre")){
                out=inp*30.48;
            }
            else if(output.equals("Mile")){
                out=inp*0.000189394;
            }
            else if(output.equals("Foot")){
                out=inp;
            }
            else if(output.equals("Inch")){
                out=inp*12;
            }

        }

        else if(input.equals("Inch")){
            if(output.equals("Metre")){
                out=inp*0.0254;
            }
            else if(output.equals("Kilometre")){
                out=inp*2.54*Math.pow(10,-5);
            }
            else if(output.equals("Centimetre")){
                out=inp*2.54;
            }
            else if(output.equals("Mile")){
                out=inp/63360;
            }
            else if(output.equals("Foot")){
                out=inp/12;
            }
            else if(output.equals("Inch")){
                out=inp;
            }

        }

        tvoutputDist.setText(out+"");

    }

}
