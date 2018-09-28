package com.minsung.examples.Tutorial;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.minsung.examples.R;

public class tutorial2 extends Activity {

    private ImageView imageView;

    private Button btn_next;
    private Button btn_back;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tutorial_2);

        //imageView = (ImageView)findViewById(R.id.imageView1);
        //imageView.setImageResource(R.drawable.ic_red_light);

        btn_back = (Button) findViewById(R.id.tutorial2_btn_back);
        btn_next = (Button) findViewById(R.id.tutorial2_btn_next);

        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(tutorial2.this,tutorial.class);
                startActivity(intent);
                finish();
            }
        });

        btn_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(tutorial2.this,tutorial3.class);
                startActivity(intent);
                finish();
            }
        });


    }
}