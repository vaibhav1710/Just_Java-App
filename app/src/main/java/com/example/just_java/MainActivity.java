package com.example.just_java;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import com.example.just_java.R;

import java.text.NumberFormat;
import java.util.Locale;
import java.util.Scanner;

/**
 This app displays an order form to order coffee.
 */
public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * This method is called when the order button is clicked.
     */
    public int number = 0;
    public void submitOrder(View view) {
      //  int price = calculatePrice();
       // String pricemessage = "Grand Total - "+"$"+ price+ "\n Thank You!";
       // displayMessage(orderSummary());
        //display(number);
        //displayprice(number*5);
        String message = orderSummary();
        EditText ed = findViewById(R.id.enter_name);
        String name = ed.getText().toString();

        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("*/*");

        intent.putExtra(Intent.EXTRA_SUBJECT, "Just Java For "+name);
        intent.putExtra(Intent.EXTRA_TEXT, message);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }


    }
    private String orderSummary(){
        CheckBox cb = findViewById(R.id.Topp_ing);
        CheckBox cb1 = findViewById(R.id.Topp_ing_choc);
        boolean f=false;
        if(cb.isChecked()){
           f = true;
        }
        EditText ed = findViewById(R.id.enter_name);
        String name = ed.getText().toString();

        if(cb.isChecked()){
            number = number+2;
        }
        if(cb1.isChecked()){
            number += 1;
        }


       String  message = " Add Whiped Creame ? "+cb.isChecked() +"\n ";
        message += "Add Chocolate ? "+cb1.isChecked()+"\n";
          message += "Total: $"+ number*5;

        return message;
    }



    public void increment(View view){
        number++;
        display(number);
    }

    public void decrement(View view){
       if(number>0) {
           number--;
       }
        display(number);
    }
    /**
     * This method displays the given quantity value on the screen.
     */
    private void display(int number) {
        TextView quantityTextView = (TextView) findViewById(
                R.id.quantityTextview);
        quantityTextView.setText("" + number);
    }


}