package com.minsung.examples.Tutorial;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.minsung.examples.Data.Database;
import com.minsung.examples.Info.Register;
import com.minsung.examples.R;

public class tutorial3 extends AppCompatActivity {
    private Button btn_back;
    private Button btn_next;
    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor editor;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tutorial_3);

        //imageView = (ImageView)findViewById(R.id.imageView1);
        // imageView.setImageResource(R.drawable.ic_red_light);

        btn_back = (Button) findViewById(R.id.tutorial3_btn_back);
        btn_next = (Button) findViewById(R.id.tutorial3_btn_next);

        sharedPreferences = getSharedPreferences("pref",MODE_PRIVATE);
        editor = sharedPreferences.edit();


        btn_back.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(tutorial3.this,tutorial2.class);
                startActivity(intent);
                finish();
            }
        });


        btn_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(tutorial3.this,Register.class);
                Database.setTutorial(false);
                editor.putString("Tutorial","false");
                editor.commit();
                startActivity(intent);
                finish();
            }
        });
    }
}

