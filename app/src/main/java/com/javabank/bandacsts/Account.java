package com.javabank.bandacsts;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class Account extends AppCompatActivity {

    public int User,Pin,Ip;

    /*TextView Bag;*/
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account);
        User = getIntent().getIntExtra("user",0);
        Pin = getIntent().getIntExtra("pin",0);
        Ip = getIntent().getIntExtra("ip",0);


    }

    public void  onStart(){
        super.onStart();

    }

/*
    public void actualizarBag(){
        int bag = 1000000;
        Bag = findViewById(R.id.idBag);
        Bag.setText(bag);

    }
    */

}