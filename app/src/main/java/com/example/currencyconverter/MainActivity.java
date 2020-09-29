package com.example.currencyconverter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;


import com.squareup.okhttp.Callback;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

public class MainActivity extends AppCompatActivity
{
    public void convert(View v)
    {
        EditText amountInString = (EditText) findViewById(R.id.amountNumber);

        double amount = Double.parseDouble(amountInString.getText().toString());
        double dollar = amount * 0.15;
        String dollarInString = String.format("%.2f", dollar);

         Toast.makeText( this,    amountInString.getText() + "tl is $" + dollarInString, Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public static boolean isInteger(String s)
    {
        return isInteger(s, 10);
    }

    public static boolean isInteger(String s, int radix)
    {
        if (s.isEmpty()) return false;
        for (int i = 0; i < s.length(); i++)
        {
            if (i == 0 && s.charAt(i) == '-')
            {
                if (s.length() == 1) return false;
                else continue;
            }
            if (Character.digit(s.charAt(i), radix) < 0) return false;
        }
        return true;
    }
}