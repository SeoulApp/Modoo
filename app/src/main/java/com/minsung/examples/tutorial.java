package com.minsung.examples;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class tutorial extends Activity{

    private Button button;
    private ImageView imageView;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tutorial_1);

        button = (Button) findViewById(R.id.button);
        //imageView = (ImageView)findViewById(R.id.imageView);
        //imageView.setImageResource(R.drawable.ic_red_light);

        final Intent intent = new Intent(this, tutorial2.class);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(intent);
            }
        });


    }
}
