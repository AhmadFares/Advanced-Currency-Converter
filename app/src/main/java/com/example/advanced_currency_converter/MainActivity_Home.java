package com.example.advanced_currency_converter;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity_Home extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_home);
    }
    public void nextpage (View view)
    {
        Intent obj = new Intent(getApplicationContext() , MainActivity.class);
        startActivity(obj);
    }
}