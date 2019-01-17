package com.example.rickb.week2day3;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.concurrent.ExecutionException;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    RecyclerViewAdapter rvAdapter;
    ListView listView;
    double randomNumber;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        MySqlDatabaseHelper mySqlDatabaseHelper = new MySqlDatabaseHelper(this);
        if(mySqlDatabaseHelper.getAllanimals().isEmpty()){
            Animal human = new Animal("Mammal", "Human", "Blaaaah!",
                    "https://images.freeimages.com/images/large-previews/25d/eagle-1523807.jpg");
            mySqlDatabaseHelper.insertanimal(human);
            Animal frog = new Animal("Amphibian", "Frog", "Hribbit!",
                    "https://img.purch.com/h/1000/aHR0cDovL3d3dy5saXZlc2NpZW5jZS5jb20vaW1hZ2VzL2kvMDAwLzA5Ni8yODEvb3JpZ2luYWwvd2hpdGUtdHJlZS1mcm9nLmpwZw==");
            mySqlDatabaseHelper.insertanimal(frog);
            Animal snake = new Animal("Reptile", "Snake", "Hssss!",
                    "https://gq-images.condecdn.net/image/2M3KEjwkqpg/crop/1620/f/Snake-GQ-31Mar17_istock_b.jpg");
            mySqlDatabaseHelper.insertanimal(snake);
            Animal clownfish = new Animal("Fish", "Clownfish", "Glup!",
                    "https://m.liveaquaria.com/images/categories/large/lg80188OcellarisClownfish.jpg");
            mySqlDatabaseHelper.insertanimal(clownfish);
            Animal seagull = new Animal("Bird", "Seagull", "Mine!",
                    "https://thenypost.files.wordpress.com/2018/07/drunk-seaguls-england.jpg?quality=90&strip=all&w=618&h=410&crop=1");
            mySqlDatabaseHelper.insertanimal(seagull);
        }

        sampleThreading();

        recyclerView = findViewById(R.id.rvMainRecyclerView);
        rvAdapter = new RecyclerViewAdapter(this, listOfAnimals());
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(rvAdapter);
        listView = findViewById(R.id.listView);


        recyclerView.addOnItemTouchListener(new View.OnClickListener());
//        String[] list={"sam", "dam", "ram", "bam"};
//        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, android.R.id.text1, list);
//        listView.setAdapter(adapter);

        System.out.println(randomNumber);
    }

    public void onClick(View view){
        Intent intent = new Intent(this, Main2Activity.class);
        startActivity(intent);

    }

    private ArrayList<Animal> listOfAnimals() {
        MySqlDatabaseHelper mySqlDatabaseHelper = new MySqlDatabaseHelper(this);
        ArrayList<Animal> animalsArrayList = new ArrayList<>();
        animalsArrayList = mySqlDatabaseHelper.getAllanimals();
        return animalsArrayList;
    }

    public void sampleThreading(){

        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                try {
                    System.out.println("Running");
                    randomNumber = Math.random();

                    System.out.println("stop");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        };
        Thread thread = new Thread(runnable);
        System.out.println("Starting");
        thread.start();
    }
}
