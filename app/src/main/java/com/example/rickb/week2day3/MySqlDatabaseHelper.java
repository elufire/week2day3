package com.example.rickb.week2day3;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.annotation.Nullable;

import java.util.ArrayList;


import static com.example.rickb.week2day3.DatabaseConstraints.DATABASE_NAME;
import static com.example.rickb.week2day3.DatabaseConstraints.DATABASE_VERSION;
import static com.example.rickb.week2day3.DatabaseConstraints.FIELD_IMAGE;
import static com.example.rickb.week2day3.DatabaseConstraints.FIELD_NAME;
import static com.example.rickb.week2day3.DatabaseConstraints.FIELD_SOUND;
import static com.example.rickb.week2day3.DatabaseConstraints.FIELD_TYPE;
import static com.example.rickb.week2day3.DatabaseConstraints.TABLE_NAME;


public class MySqlDatabaseHelper extends SQLiteOpenHelper {

    public MySqlDatabaseHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String createQuery = "Create Table " + TABLE_NAME + "("
                + FIELD_NAME + " TEXT PRIMARY KEY, "
                + FIELD_TYPE + " TEXT, "
                + FIELD_SOUND + " TEXT, "
                + FIELD_IMAGE + " TEXT)";

        db.execSQL(createQuery);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        onCreate(db);
    }

    public void insertanimal(Animal animal){
        SQLiteDatabase database = getReadableDatabase();
        ContentValues contentValues = new ContentValues();

        if( animal != null){
            contentValues.put(FIELD_TYPE, animal.getType());
            contentValues.put(FIELD_NAME, animal.getName());
            contentValues.put(FIELD_SOUND, animal.getSound());
            contentValues.put(FIELD_IMAGE, animal.getImage());


            database.insert(TABLE_NAME, null, contentValues);
        }

    }

    public ArrayList<Animal> getAllanimals(){
        SQLiteDatabase sqLiteDatabase = getReadableDatabase();
        String query = "SELECT * FROM " + TABLE_NAME ;
        Cursor cursor = sqLiteDatabase.rawQuery(query, null);

        if(cursor.moveToFirst()){
            ArrayList<Animal> arrayList = new ArrayList<>();
            do{
                String type = cursor.getString(cursor.getColumnIndex(FIELD_TYPE));
                String name = cursor.getString(cursor.getColumnIndex(FIELD_NAME));
                String sound = cursor.getString(cursor.getColumnIndex(FIELD_SOUND));
                String image = cursor.getString(cursor.getColumnIndex(FIELD_IMAGE));
                arrayList.add(new Animal(type, name, sound, image));
            }while(cursor.moveToNext());
            return arrayList;
        }else{
            return null;
        }

    }

    public Animal getanimal(String passedName){
        Animal returnanimal = null;
        if(passedName != null && !passedName.isEmpty()){
            SQLiteDatabase sqLiteDatabase = getReadableDatabase();
            String query = "SELECT * FROM " + TABLE_NAME + " WHERE " +
                    FIELD_NAME + " = \"" +passedName + "\"";
            Cursor cursor = sqLiteDatabase.rawQuery(query, null);
            if(cursor.moveToFirst()){
                String type = cursor.getString(cursor.getColumnIndex(FIELD_TYPE));
                String name = cursor.getString(cursor.getColumnIndex(FIELD_NAME));
                String sound = cursor.getString(cursor.getColumnIndex(FIELD_SOUND));
                String image = cursor.getString(cursor.getColumnIndex(FIELD_IMAGE));
                returnanimal = new Animal(type, name, sound, image);
            }
            cursor.close();
        }

        return returnanimal;
    }

    public int deleteanimal(String passedName){
        String whereClause = FIELD_NAME + "=" + "\"" +  passedName +"\"";
        SQLiteDatabase sqLiteDatabase = getWritableDatabase();
        return sqLiteDatabase.delete(TABLE_NAME, whereClause , null);
    }

    public int updateanimal(Animal animal){
        if(animal != null){
            String whereClause = FIELD_NAME + " = \"" + animal.getName() + "\"";
            SQLiteDatabase sqLiteDatabase = getWritableDatabase();
            ContentValues contentValues = new ContentValues();
            contentValues.put(FIELD_TYPE, animal.getType());
            contentValues.put(FIELD_NAME, animal.getName());
            contentValues.put(FIELD_SOUND, animal.getSound());
            contentValues.put(FIELD_IMAGE, animal.getImage());
            return sqLiteDatabase.update(TABLE_NAME, contentValues, whereClause , null);
        }
        return 0;
    }

}