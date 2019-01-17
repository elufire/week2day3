package com.example.rickb.week1weekend;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.BitSet;
import java.util.List;


public class MainActivity extends AppCompatActivity {


    String lang;
    String operation;
    String numbersStringArray [];
    float tvValue;
    Boolean unary = false;
    TextView output;
    TextView input;
    List<Float> numbers = new ArrayList<>();
    String specialChars = "/!";
    String excla = "!";
    String digits = "0123456789";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        output = findViewById(R.id.calculatorOutput);
        input = findViewById(R.id.calculatorInput);

    }

    public void onClick(View view) {
        String temp;
        float tempVal;
        temp = input.getText().toString();
        //switch handles all the different cases for each of the five words
        switch (view.getId()) {

            case R.id.one:
                if (temp.isEmpty() || excla.indexOf(temp.charAt(temp.length() - 1)) == -1) {
                    input.append("1");
                    break;
                } else
                    break;
            case R.id.two:
                if (temp.isEmpty() || excla.indexOf(temp.charAt(temp.length() - 1)) == -1) {
                    input.append("2");
                    break;
                } else
                    break;
            case R.id.three:
                if (temp.isEmpty() || excla.indexOf(temp.charAt(temp.length() - 1)) == -1) {
                    input.append("3");
                    break;
                } else
                    break;
            case R.id.four:
                if (temp.isEmpty() || excla.indexOf(temp.charAt(temp.length() - 1)) == -1) {
                    input.append("4");
                    break;
                } else
                    break;
            case R.id.five:
                if (temp.isEmpty() || excla.indexOf(temp.charAt(temp.length() - 1)) == -1) {
      