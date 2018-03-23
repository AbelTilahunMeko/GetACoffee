package com.example.android.getacoffee.view.sampledata.sampledata.presenter;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.database.Cursor;
import android.support.v7.app.AlertDialog;
import android.view.View;
import android.widget.Toast;

import com.example.android.getacoffee.view.sampledata.sampledata.Contract.MainActivityContract;
import com.example.android.getacoffee.view.sampledata.sampledata.View.MainActivity;
import com.example.android.getacoffee.view.sampledata.sampledata.model.MainActivityModel;

/**
 * Created by littELGOsht on 3/19/2018.
 */

public class MainActivityPresenter extends MainActivity implements MainActivityContract.Presenter{
    private MainActivityContract.View mView;
    private MainActivityContract.Model mModel;

    public  MainActivityPresenter(MainActivity view){
        mView = view;
        Context xn = view.getApplicationContext();
        initPresenter(xn);
    }
    private void initPresenter(Context context){
        mModel = new MainActivityModel(context);
        mView.initView();
    }
    @Override
    public void onClick(android.view.View view){
        String data = mModel.getData();
        String coffeePrice = mModel.priceOfCoffee();
        //mView.setViewData(data, coffeePrice);
    }

    public void showMessage(String tittle, String message, Context cont){
        AlertDialog.Builder builder = new AlertDialog.Builder(cont);
        builder.setCancelable(true);
        builder.setPositiveButton("Order", new DialogInterface.OnClickListener(){
            @Override
            public void onClick(DialogInterface dm, int which){
                System.out.println("Your order is processed");
            }
        });
        builder.setNegativeButton("Cancel",null);
        builder.setTitle(tittle);
        builder.setMessage(message);
        builder.show();
    }
    @Override
    public void ViewDatabase(Context context, int ROWID){
        Cursor res = mModel.getAllData(ROWID);
        if(res.getCount() ==0){
                            //Toast.makeText(MainActivity.this,"Sorry but there is nothing in your database", Toast.LENGTH_SHORT).show();
            showMessage("Error", "There is no data in the database", context);
        }else {
            System.out.println("Am in the presenter after getting course data");
            StringBuffer buffer = new StringBuffer();
            while (res.moveToNext()) {
                buffer.append("\nID:- " + res.getString(0)
                        + "\nCoffee Name:- " + res.getString(1)
                        + "\nCoffee Price:- " + res.getString(2)
                        +"\nCoffee Description:- "+ res.getString(3));
            }
            System.out.println("I am here, After reading data from the buffer");

            if(ROWID==1){
                showMessage("Cappuccino", buffer.toString(), context);
            }else if(ROWID==2){
                showMessage("Espresso", buffer.toString(), context);
            }else if(ROWID==3){
                showMessage("Ethiopian Coffee", buffer.toString(), context);
            }else if(ROWID==4){
                showMessage("Macchiato", buffer.toString(), context);
            }else if(ROWID==5){
                showMessage("Americano", buffer.toString(), context);
            }else if(ROWID==6){
                showMessage("Latte", buffer.toString(), context);
            }


        }
    }
    @Override
    public void getData(String coffeeName, String coffeePrice, String coffeeDescription){


//        mModel = new MainActivityModel(this);
        boolean success = mModel.getDataFromPresenter(coffeeName,coffeePrice,coffeeDescription );
        if(success){
            System.out.print("Works");
        }else{
            System.out.print("Doesn't work");
        }
    }


}
