package com.example.knowedu;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.knowedu.data.MyDBhandler;
import com.example.knowedu.model.Info;

import java.util.ArrayList;
import java.util.List;

public class MainActivity3 extends AppCompatActivity {
        ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);


        MyDBhandler db = new MyDBhandler(MainActivity3.this);

        listView = findViewById(R.id.mylistview);
        ArrayList<String> infos = new ArrayList<>();

        //get all info
        List<Info> allinfo = db.getinfo();
        for(Info info : allinfo){
            infos.add(Integer.toString(info.getId()) + " : " + info.getName() + " : " + info.getMarks());
        }
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,infos);
        listView.setAdapter(arrayAdapter);
    }
}