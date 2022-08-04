package com.example.knowedu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void openactivity2(View v){
        Toast.makeText(this, "opening...", Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(this,MainActivity2.class);
        startActivity(intent);
    }

    public void openactivity3(View v){
        //Toast.makeText(this, "getting list...", Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(this,MainActivity3.class);
        startActivity(intent);
    }

    public void openactivity4(View v){
        Toast.makeText(this, "getting info....", Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(this,MainActivity4.class);
        startActivity(intent);
    }
}