package com.example.zakatapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.EditTextPreference;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class CalculatorActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);


        EditText w=findViewById(R.id.etWeight);
        EditText v=findViewById(R.id.etValue);
        EditText x=findViewById(R.id.etX);

        Button c=findViewById(R.id.btCalc);
        Button rc=findViewById(R.id.btReCalc);


        TextView ot1=findViewById(R.id.tvOutput1);
        TextView ot2=findViewById(R.id.tvOutput2);
        TextView ot3=findViewById(R.id.tvOutput3);

        c.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                try {

                    //to call value but in string
                    String getW = w.getText().toString();
                    String getV = v.getText().toString();
                    String getX = x.getText().toString();


                    //to convert value from string to double
                    double dW = Double.parseDouble(getW);
                    double dV = Double.parseDouble(getV);
                    double dX = Double.parseDouble(getX);


                    //formula for total value of the gold
                    double tvg = dW * dV;

                    //formula for total gold value that is Zakat payable
                    double tgzp = (dW - dX) * dV;

                    //formula for total zakat
                    double tz = 0.025 * tgzp;

                //for output
                ot1.setText(String.valueOf(tvg));
                ot2.setText(String.valueOf(tgzp));
                ot3.setText(String.valueOf(tz));

                }
                catch (Exception e){
                    Toast.makeText(CalculatorActivity.this,"Please enter a number",Toast.LENGTH_SHORT).show();
                }

            }
        });

        //Recalculate button
        rc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //reset edit text
                w.setText(null);
                w.dispatchDisplayHint(View.VISIBLE);
                v.setText(null);
                v.dispatchDisplayHint(view.VISIBLE);
                x.setText(null);
                x.dispatchDisplayHint(view.VISIBLE);

                //reset output
                ot1.setText("0");
                ot2.setText("0");
                ot3.setText("0");
            }
        });
    }

    public boolean onCreateOptionsMenu(Menu menu){
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);

        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item){
        switch(item.getItemId()){
            case R.id.home:
                Toast.makeText(this, "This is home page",Toast.LENGTH_LONG).show();
                Intent intent = new Intent(this, MainActivity.class);
                startActivity(intent);
                break;

            case R.id.about:
                Toast.makeText(this, "This is about page",Toast.LENGTH_LONG).show();
                Intent intent1 = new Intent(this, AboutActivity.class);
                startActivity(intent1);
                break;

            case R.id.calculator:
                Toast.makeText(this, "This is calculator page",Toast.LENGTH_LONG).show();
                Intent intent2 = new Intent(this, CalculatorActivity.class);
                startActivity(intent2);
                break;


        }

        return super.onOptionsItemSelected(item);
    }




}