package com.example.android.getacoffee.view.sampledata.sampledata.Contract;

import android.content.Context;
import android.database.Cursor;

/**
 * Created by littELGOsht on 3/19/2018.
 */

public interface MainActivityContract {
    //This is where all the interface is created
    interface View{
        //THis are the rules that will be implement by the view class
        void initView();
        void DatabaseOnCreate();

    }
    interface Model{
        //This are the rules that are going to be implemented by model
        String getData();
        String priceOfCoffee();
        boolean getDataFromPresenter(String coffeeName, String coffeePrice,String coffeeDescription );
        boolean insertData(String coffeeName, String coffeePrice, String coffeeDescription);
        Cursor getAllData(int ROWID);
        Cursor showAllData();

    }

    interface Presenter{
        void onClick(android.view.View view);
        void getData(String coffeeName, String coffeePrice, String coffeeDescription);
        void ViewDatabase(Context context,int ROWID);
    }
}















