package com.example.knowedu;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.knowedu.data.MyDBhandler;
import com.example.knowedu.model.Info;
import com.example.knowedu.params.params;

public class MainActivity4 extends AppCompatActivity {

    Button button4, button5;
    EditText editget, editdelete;
    MyDBhandler myDBhandler;
    TextView textView11;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);

        button4 = findViewById(R.id.button4);
        button5 = findViewById(R.id.button5);

        editdelete = findViewById(R.id.editdelete);
        myDBhandler = new MyDBhandler(MainActivity4.this);


        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String iddel = editdelete.getText().toString();

                if (iddel.length() == 0) {
                    Toast.makeText(MainActivity4.this, "Enter a valid student id ", Toast.LENGTH_SHORT).show();
                } else {
                    int id_delete = Integer.parseInt(iddel);

                    boolean confirm = myDBhandler.deleteinfo(id_delete);
                    if (confirm == false) {
                        Toast.makeText(MainActivity4.this, "Failed to delete,try again", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(MainActivity4.this, "Student successfully deleted", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });


    }

    public void openactivity5(View v){
        Toast.makeText(this, "getting info...", Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(this,MainActivity5.class);
        startActivity(intent);
    }
}


//        button4.setOnClickListener(new View.OnClickListener() {
//            @SuppressLint("Range")
//            @Override
//            public void onClick(View view) {
//
//
//                int id_get = Integer.parseInt(editget.getText().toString());
//                Info res = myDBhandler.getidinfo(id_get);
////                if (res.getCount() == 0) {
////                    Toast.makeText(MainActivity4.this, "No entry exists", Toast.LENGTH_SHORT).show();
////                    return;
////                }
////                StringBuffer buffer = new StringBuffer();
////                buffer.append("Student id : " + res.getString(1) + "\n");
////                buffer.append("Student name : " + res.getString(2) + "\n");
////                buffer.append("Student email : " + res.getString(3) + "\n");
////                buffer.append("Student marks : " + res.getString(4) + "\n");
////
////                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity4.this);
////                builder.setCancelable(true);
////                builder.setTitle("Student information");
////                builder.setMessage(buffer.toString());
////                builder.show();
//
//                    Toast.makeText(MainActivity4.this, "it is working", Toast.LENGTH_SHORT).show();
//                   // textView11.setText("column index " + res.getColumnIndex(params.KEY_ID));
////                    textView11.setText("id is " + res.getInt(res.getColumnIndex(params.KEY_ID)));
////                    textView11.setText("Student id : " + res.getInt(0) + " Student name : " + res.getString(1) +
////                            " Student email : " + res.getString(2) + " Student marks : " + res.getString(3));
//
//                    textView11.setText("id is " + res.getId());
//
//            }
//        });
//    }
