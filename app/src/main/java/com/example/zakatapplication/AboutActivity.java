package com.example.zakatapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

public class AboutActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);
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