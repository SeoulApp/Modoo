package com.minsung.examples.Tutorial;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.minsung.examples.Info.Register;
import com.minsung.examples.R;

public class tutorial3 extends AppCompatActivity {
    private Button btn_back;
    private Button btn_next;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.tutorial_3);

        //imageView = (ImageView)findViewById(R.id.imageView1);
        // imageView.setImageResource(R.drawable.ic_red_light);

        btn_back = (Button) findViewById(R.id.tutorial3_btn_back);
        btn_next = (Button) findViewById(R.id.tutorial3_btn_next);

        btn_back.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });


        btn_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(tutorial3.this,Register.class);
                startActivity(intent);
                finish();
            }
        });


    }
}

