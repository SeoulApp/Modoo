package com.minsung.examples.Info;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.LinearLayout;

import com.minsung.examples.R;

public class RegisterOption extends Activity {

    private LinearLayout linearLayout1;
    private LinearLayout linearLayout2;
    private Intent intent10;


    String option;
    String grade;
    String time;



    private ImageButton btn_back;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register_option);

        final Intent intent1 = new Intent(this,RegisterCamera.class ); // 카메라

        final Intent intent2 = new Intent(this, RegisterNumber.class); //숫자
        intent10 = getIntent();

        option = intent10.getStringExtra("Option");
        grade = intent10.getStringExtra("Grade");
        time = intent10.getStringExtra("Time");



        linearLayout1 = (LinearLayout) findViewById(R.id.line1); //카메라
        linearLayout2 = (LinearLayout) findViewById(R.id.line2); // 숫자
        btn_back = (ImageButton) findViewById(R.id.register_option_ib_back);

        linearLayout1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(intent1);
                finish();


            }
        });

        linearLayout2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                intent2.putExtra("Option",option);
                intent2.putExtra("Grade",grade);
                intent2.putExtra("Time",time);
                startActivity(intent2);
                finish();
            }
        });
        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

    }
}
