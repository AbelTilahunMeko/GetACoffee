package com.example.android.getacoffee.view.sampledata.sampledata.View;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.android.getacoffee.R;
import com.example.android.getacoffee.view.sampledata.sampledata.Contract.MainActivityContract;
import com.example.android.getacoffee.view.sampledata.sampledata.model.MainActivityModel;
import com.example.android.getacoffee.view.sampledata.sampledata.presenter.MainActivityPresenter;


public class MainActivity extends AppCompatActivity implements MainActivityContract.View {

    private TextView mTextView;
    private TextView mTextView2;
    private Button mButton;
    private MainActivityContract.Presenter mPresenter;
    private EditText coffeeNameInput;
    private EditText coffeePriceInput;
    private Button addButton;
    private Button showDataButton;
    private ImageView coffeeOne;
    private ImageView coffeeTwo;
    private ImageView coffeeThree;
    private ImageView coffeeFour;
    private ImageView coffeeFive;
    private ImageView coffeeSix;

    public MainActivityModel mData;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mPresenter = new MainActivityPresenter(this);
        mData = new MainActivityModel(this);
        //getInputData();
        //viewData();
        DatabaseOnCreate();
        handlingCoffeeOne();
        handlingCoffeeTwo();
        handlingCoffeeThree();
        handlingCoffeeFour();
        handlingCoffeeFive();
        handlingCoffeeSix();



    }
    public void handlingCoffeeOne(){
        coffeeOne = findViewById(R.id.coffeeOne);
        coffeeOne.setOnClickListener(
                new View.OnClickListener(){
                    @Override
                    public void onClick(android.view.View v){
//                        Toast.makeText(MainActivity.this, "One", Toast.LENGTH_SHORT).show();
                        //mPresenter.onClick(v);
                        mPresenter.ViewDatabase(MainActivity.this,1);
//                        mPresenter.getData("Espresso", "35 ETB", " Coffee, Espresso, Two Spoon Sugar");
                    }
                }
        );
    }
    public void handlingCoffeeTwo(){
        coffeeTwo = findViewById(R.id.coffeeTwo);
        coffeeTwo.setOnClickListener(
                new View.OnClickListener(){
                    @Override
                    public void onClick(View v){
//                        Toast.makeText(MainActivity.this, "Two", Toast.LENGTH_SHORT).show();
                        mPresenter.ViewDatabase(MainActivity.this,2);

                    }
                }
        );
    }
    public void handlingCoffeeThree(){
        coffeeThree = findViewById(R.id.coffeeThree);
        coffeeThree.setOnClickListener(
                new View.OnClickListener(){
                    @Override
                    public void onClick(View v){
//                        Toast.makeText(MainActivity.this, "Three", Toast.LENGTH_SHORT).show();
                        mPresenter.ViewDatabase(MainActivity.this,3);

                    }
                }
        );
    }
    public void handlingCoffeeFour(){
        coffeeFour = findViewById(R.id.coffeefour);
        coffeeFour.setOnClickListener(
                new View.OnClickListener(){
                    @Override
                    public void onClick(View v){
//                        Toast.makeText(MainActivity.this, "Four", Toast.LENGTH_SHORT).show();
                        mPresenter.ViewDatabase(MainActivity.this,4);

                    }
                }
        );
    }
    public void handlingCoffeeFive(){
        coffeeFive = findViewById(R.id.coffeefive);
        coffeeFive.setOnClickListener(
                new View.OnClickListener(){
                    @Override
                    public void onClick(View v){
//                        Toast.makeText(MainActivity.this, "5", Toast.LENGTH_SHORT).show();
                        mPresenter.ViewDatabase(MainActivity.this,5);

                    }
                }
        );
    }
    public void handlingCoffeeSix(){
        coffeeSix = findViewById(R.id.coffeesix);
        coffeeSix.setOnClickListener(
                new View.OnClickListener(){
                    @Override
                    public void onClick(View v){
//                        Toast.makeText(MainActivity.this, "Six", Toast.LENGTH_SHORT).show();
                        mPresenter.ViewDatabase(MainActivity.this,6);
                    }
                }
        );
    }

    @Override
    public void DatabaseOnCreate(){
        mPresenter.getData("Cappuccino", "35 ETB", " Coffee, Espresso, Two Spoon Sugar");
        mPresenter.getData("Espresso", "15 ETB", " Hot Water, Ceffa Coffee, Two Spoon Sugar");
        mPresenter.getData("Ethiopian Coffee", "15 ETB", " Hot Water, Ceffa Coffee, Two Spoon Sugar");
        mPresenter.getData("Macchiatoo", "25 ETB", " Hot Water, Milk, Coffee, Two Spoon Sugar, Foam On Top");
        mPresenter.getData("Americano", "40 ETB", " Hot Water, Milk, Espresso, Two Spoon Sugar, Foam On Top");
        mPresenter.getData("Latte", "42 ETB", " Hot Water, Warm Milk, Espresso, Two Spoon Sugar, Foam On Top");

    }
    @Override
    public void initView(){
//        mTextView = findViewById(R.id.typeDisplay);
//        mTextView2 =  findViewById(R.id.coffeePrice);
//        mButton =  findViewById(R.id.viewButton);
//        mButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(android.view.View view) {
//                mPresenter.onClick(view);
//
//            }
//        });

    }






}
