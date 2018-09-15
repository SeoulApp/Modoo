package com.minsung.examples;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class tutorial2 extends Activity {

    private ImageView imageView;
    private Button button;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tutorial_2);

        imageView = (ImageView)findViewById(R.id.imageView1);
        imageView.setImageResource(R.drawable.ic_red_light);

        button = (Button) findViewById(R.id.button4);

        final Intent intent = new Intent(this,drawer.class);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(intent);

            }
        });


    }
}