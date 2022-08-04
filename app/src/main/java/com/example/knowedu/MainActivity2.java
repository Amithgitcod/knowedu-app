package com.example.knowedu;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.knowedu.data.MyDBhandler;

public class MainActivity2 extends AppCompatActivity {

    EditText name,email,marks;
    Button submit;
    MyDBhandler myDBhandler ;
    TextView textView8;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        myDBhandler = new MyDBhandler(MainActivity2.this) ;

        name = findViewById(R.id.name);
        email = findViewById(R.id.email);
        marks = findViewById(R.id.marks);
        submit = findViewById(R.id.submit);
        textView8 = findViewById(R.id.textView8);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nameTXT = name.getText().toString();
                String emailTXT = email.getText().toString();
                String marksTXT = marks.getText().toString();
                int checkmarks =0;
                if(marksTXT.length() != 0) {
                     checkmarks = Integer.parseInt(marksTXT);
                }
                if (nameTXT.length() == 0 || emailTXT.length() == 0 || marksTXT.length() == 0) {
                    Toast.makeText(MainActivity2.this, "please enter all details", Toast.LENGTH_SHORT).show();
                } else {

                    if (checkmarks > 600 || checkmarks < 0) {
                        Toast.makeText(MainActivity2.this, "please enter marks correctly", Toast.LENGTH_SHORT).show();
                    } else {

                        long checkinfo = myDBhandler.addinfo(nameTXT, emailTXT, marksTXT);
                        if (checkinfo == -1) {
                            Toast.makeText(MainActivity2.this, "please try again", Toast.LENGTH_SHORT).show();
                        } else {
                            textView8.setText("Please remember your student id is : " + checkinfo);
                        }
                    }
                }
            }
        });


    }
}