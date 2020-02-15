package com.example.a2ezy;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Facilities extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_facilities);
    }

    public void btn_ordernow(View v){

        startActivity(new Intent(getApplicationContext(),OrderNow.class));
    }

    public void btn_yourorder(View v){

        startActivity(new Intent(getApplicationContext(),YourOrder.class));
    }


    public void btn_offer1(View v){

        startActivity(new Intent(getApplicationContext(),Offer.class));

    }


    public void btn_contact(View v){

        startActivity(new Intent(getApplicationContext(),ContactUs.class));
    }


}

