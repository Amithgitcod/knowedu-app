package com.example.knowedu;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.example.knowedu.data.MyDBhandler;
import com.example.knowedu.model.Info;

import java.text.BreakIterator;
import java.util.ArrayList;
import java.util.List;

public class MainActivity5 extends AppCompatActivity {
    ListView listView;
    EditText editfetch;
    Button fetch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main5);

        MyDBhandler db = new MyDBhandler(MainActivity5.this);

        listView = findViewById(R.id.mylistview2);
        editfetch = findViewById(R.id.editfetch);
        fetch = findViewById(R.id.button6);
        List<Info> allinfo;
        ArrayList<String> infod = new ArrayList<>();

        fetch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String id_get = editfetch.getText().toString();

                if (id_get.length() == 0) {
                    Toast.makeText(MainActivity5.this, "please enter student id", Toast.LENGTH_SHORT).show();
                } else {
                    //get all info
                    List<Info> allinfo = db.getidinfo((id_get));
                    for (Info info : allinfo) {
                        int marksp = Integer.parseInt(info.getMarks());
                        double percentage = Math.round(Double.parseDouble(info.getMarks()) / 6);
                        infod.add(Integer.toString(info.getId()) + " : " + info.getName() + " : " + info.getEmail() + " : " + info.getMarks()
                                + " \n " + String.valueOf(percentage) + " %");
                    }

                }
            }
        });

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,infod);
        listView.setAdapter(arrayAdapter);

    }
}