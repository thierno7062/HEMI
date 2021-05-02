package com.example.stopcovid19.Model;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DBHelper extends SQLiteOpenHelper {
    public DBHelper( Context context) {
        super(context, "DBCovid.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL( "CREATE TABLE test(  nom TEXT primary key,prenom TEXT,mail TEXT,age int,Address TEXT,phone number)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS test");
        onCreate(db);
    }

    public void insertProduct (info_personnelles p)
    {
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues cv=new ContentValues();
        cv.put("nom",p.getNom());
        cv.put("prix",p.getPrenom());
        cv.put("mail",p.getMail());
        cv.put("age",p.getAge());
        cv.put("address",p.getAddress());
        cv.put("phone",p.getPhone());

        db.insert("test",null,cv);
        db.close();
    }

}
