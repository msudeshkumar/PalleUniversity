package com.tech.msudesh_kumar.palleuniversity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

public class ThirdActivity extends AppCompatActivity {

    TextView TextView1, TextView2;
    EditText EditText1, EditText2, EditText3, EditText4;
    //CheckBox CheckBox1, CheckBox2;
    RadioButton RadioButton1, RadioButton2;
    Button Button1, Button2;

    String BankName = "", CardNo, Cvv, PaymentOp = "";
    int[] CoursesArray;
    String[] CoursesChosen = {"Java", "Android", "SQL", ".Net"};
    int[] Prices = {9991, 15991, 7991, 15991};
    String FinalCourses = "";
    int FinalPrice = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);

        TextView1 = findViewById(R.id.textView1);
        TextView2 = findViewById(R.id.textView2);
        EditText1 = findViewById(R.id.editText1);
        EditText4 = findViewById(R.id.editText4);
        RadioButton1 = findViewById(R.id.radiobutton1);
        RadioButton2 = findViewById(R.id.radiobutton2);

        Intent previn = getIntent();
        Bundle b = previn.getExtras();

        CoursesArray = b.getIntArray("coursesarray");

        for(int i = 0; i<CoursesArray.length;i++)
        {
            if(CoursesArray[i]==1)
            {
                FinalCourses = FinalCourses + CoursesChosen[i] + ", ";
            }
        }

        for(int j=0; j<CoursesArray.length;j++)
        {
            if(CoursesArray[j]==1)
            {
                FinalPrice = FinalPrice + Prices[j];
            }
        }

        TextView1.setText(FinalCourses);
        TextView2.setText(String.valueOf(FinalPrice));

    }

    public void pay(View view) {

        Intent in = new Intent();

        BankName = EditText1.getText().toString();

        if(RadioButton1.isChecked())
        {
            PaymentOp = RadioButton1.getText().toString();
        }
        else if(RadioButton2.isChecked())
        {
            PaymentOp = RadioButton2.getText().toString();
        }
        /*else
        {
            PaymentOp = "None";
        }*/

        in.putExtra("courses", FinalCourses);
        in.putExtra("fees", FinalPrice);
        in.putExtra("bankname", BankName);
        in.putExtra("paymentop",PaymentOp);

        setResult(RESULT_OK, in);
        finish();
    }


    public void cancel(View view) {

        Intent in = new Intent();

        String reason = EditText4.getText().toString();

        in.putExtra("reason", reason);

        setResult(RESULT_CANCELED, in);
        finish();
    }
}
