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
import java.lang.Math;

public class TimeActivity extends AppCompatActivity {

    RadioGroup rgInp, rgOut;
    RadioButton rbInp, rbOut;
    LinearLayout timeCalc, line3;
    EditText etinputTime;
    TextView tvoutputTime;
    double inp=0;
    private TextWatcher text;


    public String input = "none", output = "none";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_time);

        line3 = findViewById(R.id.line3);
        etinputTime = findViewById(R.id.etinputTime);
        tvoutputTime = findViewById(R.id.etoutputTime);
        timeCalc = findViewById(R.id.timeCalc);
        timeCalc.setVisibility(View.GONE);
        line3.setVisibility(View.GONE);
        rgInp = findViewById(R.id.rgInp);
        rgOut = findViewById(R.id.rgOut);

        text=new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {


                try {
                    inp = Double.parseDouble(etinputTime.getText().toString());
                }
                catch (NumberFormatException e)
                {
                    tvoutputTime.setText("0.00");

                }
                calculate(inp);

            }


            @Override
            public void afterTextChanged(Editable s) {

            }
        };

        etinputTime.addTextChangedListener(text);

    }

    public void checkInp(View v){
        Toast.makeText(this,"Input got..",Toast.LENGTH_SHORT).show();
        int radioId= rgInp.getCheckedRadioButtonId();
        rbInp=findViewById(radioId);
        input=rbInp.getText().toString().trim();
        if (!output.equals("none")) {
            Toast.makeText(this, "From " + input + " to " + output, Toast.LENGTH_SHORT).show();
            timeCalc.setVisibility(View.VISIBLE);
            etinputTime.setHint(input);
            tvoutputTime.setHint(output);
            line3.setVisibility(View.VISIBLE);
            calculate(inp);
        }
    }

    public void checkOut(View v) {
        int radioId = rgOut.getCheckedRadioButtonId();
        rbOut = findViewById(radioId);
        output = rbOut.getText().toString().trim();
        if (!input.equals("none")) {
            Toast.makeText(this, "From " + input + " to " + output, Toast.LENGTH_SHORT).show();
            timeCalc.setVisibility(View.VISIBLE);
            etinputTime.setHint(input);
            tvoutputTime.setHint(output);
            line3.setVisibility(View.VISIBLE);
            calculate(inp);
        }

    }

    public  void calculate(Double inp){
        double out;
        if (input.equals("Hour")) {
            if(output.equals("Hour")){
                tvoutputTime.setText(inp + "");
            }
            else if (output.equals("Minute")) {
                out = inp*60;
                tvoutputTime.setText(out + "");}
            else if (output.equals("Day")) {
                    out = inp/24;
                    tvoutputTime.setText(out + "");  }
                 else if (output.equals("Month")) {
                    out = inp*0.00136986;
                    tvoutputTime.setText(out + "");  }
            else if (output.equals("Year")) {
                out = inp/8760;
                tvoutputTime.setText(out + "");
            } else {
                out = (inp * 3600);
                tvoutputTime.setText(out + "");
            }
        }if (input.equals("Minute")) {
            if (output.equals("Minute")){
                tvoutputTime.setText(inp + "");
            }
            else if (output.equals("Hour")) {
                out = inp/60;
                tvoutputTime.setText(out + "");

            } else if (output.equals("Day")) {
                out = inp/1440;
                tvoutputTime.setText(out + "");  }
            else if (output.equals("Month")) {
                out = inp/43800;
                tvoutputTime.setText(out + "");  }
            else if (output.equals("Year")) {
                out = inp/525600;
                tvoutputTime.setText(out + "");
            }
            else {
                out = inp*60;
                tvoutputTime.setText(out + "");
            }
        }if (input.equals("Second")) {
            if (output.equals("Second")){
                tvoutputTime.setText(inp + "");
            }
            else if (output.equals("Hour")) {
                out = inp/3600;
                tvoutputTime.setText(out+"");
            }
            else if (output.equals("Day")) {
                out = inp/86400;
                tvoutputTime.setText(out + "");  }
            else if (output.equals("Month")) {
                out = inp*3.8052*Math.pow(10,-7);
                tvoutputTime.setText(out + "");  }
            else if (output.equals("Year")) {
                out = inp/3.154/Math.pow(10,7);
                tvoutputTime.setText(out + "");
            } else {
                out = inp/60;
                tvoutputTime.setText(out + "");
            }
        }
        if (input.equals("Day")) {
            if (output.equals("Day")){
                tvoutputTime.setText(inp + "");
            }
            else if (output.equals("Hour")) {
                out = inp*24;
                tvoutputTime.setText(out+"");
            }
            else if (output.equals("Second")) {
                out = inp*86400;
                tvoutputTime.setText(out + "");  }
            else if (output.equals("Month")) {
                out = inp/30.417;
                tvoutputTime.setText(out + "");  }
            else if (output.equals("Year")) {
                out = inp/365;
                tvoutputTime.setText(out + "");
            } else {
                out = inp*1440;
                tvoutputTime.setText(out + "");
            }}

        if (input.equals("Month")) {
            if (output.equals("Month")){
                tvoutputTime.setText(inp + "");
            }
            else if (output.equals("Hour")) {
                out = inp*730;
                tvoutputTime.setText(out+"");
            }
            else if (output.equals("Day")) {
                out = inp*30.417;
                tvoutputTime.setText(out + "");  }
            else if (output.equals("Second")) {
                out = inp* 2.628*Math.pow(10,6);
                tvoutputTime.setText(out + "");  }
            else if (output.equals("Year")) {
                out = inp/12;
                tvoutputTime.setText(out + "");
            } else {
                out = inp*43800;
                tvoutputTime.setText(out + "");
            }}

        if (input.equals("Year")) {
            if (output.equals("Year")){
                tvoutputTime.setText(inp + "");
            }
            else if (output.equals("Hour")) {
                out = inp*8760;
                tvoutputTime.setText(out+"");
            }
            else if (output.equals("Day")) {
                out = inp*365;
                tvoutputTime.setText(out + "");  }
            else if (output.equals("Second")) {
                out = inp*3.154*Math.pow(10,7);
                tvoutputTime.setText(out + "");  }
            else if (output.equals("Month")) {
                out = inp*12;
                tvoutputTime.setText(out + "");
            } else {
                out = inp*525600;
                tvoutputTime.setText(out + "");
            }}

    }
}
