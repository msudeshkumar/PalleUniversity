package com.tech.msudesh_kumar.palleuniversity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;

public class MainActivity extends AppCompatActivity {

    CheckBox CheckBox1, CheckBox2, CheckBox3, CheckBox4;
    Button Button1;

    int[] CoursesArray = new int[4];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        CheckBox1 = findViewById(R.id.checkbox1);
        CheckBox2 = findViewById(R.id.checkbox2);
        CheckBox3 = findViewById(R.id.checkbox3);
        CheckBox4 = findViewById(R.id.checkbox4);
        Button1 = findViewById(R.id.button1);

    }

    public void proceed(View view) {

        Intent in = new Intent(MainActivity.this, SecondActivity.class);

        if(CheckBox1.isChecked())
        {
            CoursesArray[0] = 1;
        }

        if(CheckBox2.isChecked())
        {
            CoursesArray[1] = 1;
        }

        if(CheckBox3.isChecked())
        {
            CoursesArray[2] = 1;
        }

        if(CheckBox4.isChecked())
        {
            CoursesArray[3] = 1;
        }

        in.putExtra("coursesarray", CoursesArray);

        startActivity(in);

    }
}
