package com.minsung.examples.Info;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.minsung.examples.Data.Database;
import com.minsung.examples.R;

public class InfoResult extends Activity {

    private TextView name;
    private TextView number;
    private TextView bonus;
    private ImageView imageView;
    private Button Ok;
    private ImageButton Back;
    private Intent intent;
    private int imgsrc;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register_result);

        name = (TextView) findViewById(R.id.textView3);
        number = (TextView) findViewById(R.id.textView4);
        bonus = (TextView) findViewById(R.id.textView47);
        imageView = (ImageView)findViewById(R.id.imageView);
        Ok = (Button)findViewById(R.id.button5);
        Back = (ImageButton)findViewById(R.id.register_option_ib_back);

        intent = getIntent();

        imgsrc = intent.getIntExtra("Img",0);
        name.setText(Database.getUserName());
        bonus.setText(Database.getBounusTimeString());
        imageView.setImageResource(imgsrc);

        Ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        Back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });




    }

    @Override
    protected void onResume() {
        super.onResume();

        name.setText(Database.getUserName());
        bonus.setText(Database.getBounusTimeString());

    }
}
