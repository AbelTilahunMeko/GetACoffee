package com.example.android.getacoffee.view.sampledata.sampledata.model;

import android.app.Dialog;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import com.example.android.getacoffee.view.sampledata.sampledata.Contract.MainActivityContract;
import com.example.android.getacoffee.view.sampledata.sampledata.View.MainActivity;
import com.example.android.getacoffee.view.sampledata.sampledata.presenter.MainActivityPresenter;

import java.security.KeyPair;

/**
 * Created by littELGOsht on 3/19/2018.
 */

public class MainActivityModel  extends SQLiteOpenHelper  implements MainActivityContract.Model{
    public static final String DATABASE_NAME = "getacoffee.dp";
    public static  final String DATABASE_TABLE = "coffee_Table";
    public static final String Col_1 = "ID";
    public static final String COL_2 = "COFFEE_NAME";
    public static final String COL_3 = "COFFEE_PRICE";
    public static final String COL_4 = "COFFEE_DESC";

    public  MainActivityModel(Context context) {
        super(context, DATABASE_NAME, null, 1);
//        SQLiteDatabase db = this.getWritableDatabase();
    }
    @Override
    public String getData() {
        return "Hello World";
    }
    @Override
    public String priceOfCoffee(){ return "The price of the coffee is 10 bux";}




    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table " + DATABASE_TABLE + "(ID INTEGER PRIMARY KEY AUTOINCREMENT, COFFEE_NAME TEXT, COFFEE_PRICE TEXT, COFFEE_DESC TEXT  )" );
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + DATABASE_TABLE);
        onCreate(db);
    }
    @Override
    public boolean insertData( String coffeeName, String coffeePrice, String coffeeDescription){
//        System.out.println("Data Insert\nCoffeeName " + coffeeName + " \nCoffeePrice " + CoffeePrice);
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(COL_2, coffeeName);
        cv.put(COL_3, coffeePrice);
        cv.put(COL_4, coffeeDescription);

        long result = db.insert(DATABASE_TABLE, null, cv);

        if(result == -1){
            return false;
        }else{
            return true;
        }

    }
    @Override
    public Cursor showAllData(){
        //Done when all the data from the database is wanted to be showed.
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor databaseResult = db.rawQuery("SELECT * FROM "+ DATABASE_TABLE, null);
        return  databaseResult;
    }
    public Cursor getAllData(int ROWID){
        //What does the Cursor class,
        //Its an interface that have the ability to read and write data
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor result = db.rawQuery("SELECT * FROM "+DATABASE_TABLE + " WHERE ID ="+ ROWID, null);
        return result;
    }
    public boolean getDataFromPresenter(String coffeeName, String coffeePrice, String coffeeDescription){
//        System.out.println("Yooo am here too");
//        System.out.println("Model\nCoffeeName " + coffeeName + " \nCoffeePrice " + coffeePrice);
        boolean successful = insertData(coffeeName,coffeePrice,coffeeDescription);
        if(successful){
            System.out.println("Go and do it");
            return true;
        }else{
            System.out.println("Oh shit");
            return false;
        }
    }
}
