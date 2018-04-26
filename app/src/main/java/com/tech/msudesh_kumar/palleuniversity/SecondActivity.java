package com.tech.msudesh_kumar.palleuniversity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    public static final int REQ_CD1 = 1;

    EditText EditText1, EditText2, EditText3;
    TextView TextView1, TextView2, TextView3, TextView4;

    String name, email, address, courses, fees, bankname, paymentop, reason;
    int[] CoursesArray;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        EditText1 = findViewById(R.id.editText1);
        EditText2 = findViewById(R.id.editText2);
        EditText3 = findViewById(R.id.editText3);

        TextView1 = findViewById(R.id.textView2);
        TextView2 = findViewById(R.id.textView3);
        TextView3 = findViewById(R.id.textView4);
        TextView4 = findViewById(R.id.textView5);


    }

    public void checkout(View view) {

        Intent previn = getIntent();
        Intent in = new Intent(SecondActivity.this, ThirdActivity.class);

        name = EditText1.getText().toString();
        email = EditText2.getText().toString();
        address = EditText3.getText().toString();

        Bundle b = previn.getExtras();

        CoursesArray = b.getIntArray("coursesarray");

        in.putExtra("name", name);
        in.putExtra("email", email);
        in.putExtra("address", address);
        in.putExtra("coursesarray", CoursesArray);

        startActivityForResult(in, REQ_CD1);


    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        Intent in = data;
        Bundle b = in.getExtras();

        /*in.putExtra("courses", FinalCourses);
        in.putExtra("fees", FinalPrice);
        in.putExtra("bankname", BankName);
        in.putExtra("paymentop",PaymentOp);

        in.putExtra("reason", reason);*/


        if(requestCode==REQ_CD1)
        {
            if(resultCode==RESULT_OK)
            {
                courses = b.getString("courses");
                fees = b.getString("fees");
                bankname = b.getString("bankname");
                paymentop = b.getString("paymentop");

                TextView1.setText("Courses: "+courses);
                TextView2.setText("Total Fees: "+fees);
                TextView3.setText("Bank name: "+bankname);
                TextView4.setText("Status: "+paymentop);
            }
            else if(resultCode==RESULT_CANCELED)
            {
                reason = b.getString("reason");

                TextView4.setText("Reason for cancellation: "+reason);
            }
        }
    }
}
