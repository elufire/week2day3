package com.example.rickb.week2day3;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

public class Main2Activity extends AppCompatActivity {
    ListView listView;
    EditText edName;
    EditText edSound;
    EditText edImage;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        final MySqlDatabaseHelper mySqlDatabaseHelper = new MySqlDatabaseHelper(this);
        listView = findViewById(R.id.listView);
        edName = findViewById(R.id.edName);
        edSound = findViewById(R.id.edSound);
        edImage = findViewById(R.id.edImage);
        String[] list = {"Mammal", "Reptile", "Bird", "Amphibian", "Fish"};
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, android.R.id.text1, list);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener(){

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                int itemPosition = position;
                String value = listView.getItemAtPosition(position).toString();
                String name = edName.getText().toString();
                String sound = edSound.getText().toString();
                String image = edImage.getText().toString();
                if(!name.isEmpty() && !sound.isEmpty() && !image.isEmpty()){
                    Animal animal = new Animal("", name, sound, image);
                    switch (value){
                        case "Mammal":
                            animal.setType("Mammal");
                            mySqlDatabaseHelper.insertanimal(animal);
                            break;
                        case "Amphibian":
                            animal.setType("Amphibian");
                            mySqlDatabaseHelper.insertanimal(animal);
                            break;
                        case "Fish":
                            animal.setType("Fish");
                            mySqlDatabaseHelper.insertanimal(animal);
                            break;
                        case "Reptile":
                            animal.setType("Reptile");
                            mySqlDatabaseHelper.insertanimal(animal);
                            break;
                        case "Bird":
                            animal.setType("Bird");
                            mySqlDatabaseHelper.insertanimal(animal);
                            break;
                    }
                }

            }
        });
    }

    public void onClick(View view){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}
