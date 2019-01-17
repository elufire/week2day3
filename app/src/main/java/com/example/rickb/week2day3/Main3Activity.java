package com.example.rickb.week2day3;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Main3Activity extends AppCompatActivity {
    TextView tvDisplay;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        tvDisplay = findViewById(R.id.tvDisplay);
        Intent intent = new Intent();
        //double doub = intent.getDoubleExtra("rand_number", 0);
        String animalName = intent.getStringExtra("animal_data");
        //tvDisplay.setText(String.valueOf(doub));
        tvDisplay.setText(animalName);
    }
}
