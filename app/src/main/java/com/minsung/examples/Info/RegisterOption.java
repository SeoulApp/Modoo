package com.minsung.examples.Info;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.LinearLayout;

import com.minsung.examples.R;

public class RegisterOption extends Activity {

    private LinearLayout linearLayout1;
    private LinearLayout linearLayout2;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register_option);

        final Intent intent1 = new Intent(this,RegisterCamera.class ); // 카메라

        final Intent intent2 = new Intent(this, RegisterNumber.class); //숫자

        linearLayout1 = (LinearLayout) findViewById(R.id.line1); //카메라
        linearLayout2 = (LinearLayout) findViewById(R.id.line2); // 숫자

        linearLayout1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(intent1);


            }
        });

        linearLayout2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(intent2);
            }
        });




    }
}
