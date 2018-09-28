package com.minsung.examples.Info;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.minsung.examples.Data.Database;
import com.minsung.examples.MainActivity;
import com.minsung.examples.R;

public class Register extends Activity {

    private LinearLayout linearLayout1 ;
    private LinearLayout linearLayout2 ;
    private LinearLayout linearLayout3 ;
    private LinearLayout linearLayout4 ;

    private ImageView imageView1;
    private ImageView imageView2;
    private ImageView imageView3;
    private ImageView imageView4;

    private ImageButton btn_back;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.register);


        final Intent intent = new Intent(this,RegisterOption.class);

        linearLayout1 = (LinearLayout)findViewById(R.id.option1); // 장애인
        linearLayout2 = (LinearLayout)findViewById(R.id.option2); // 고령자
        linearLayout3 = (LinearLayout)findViewById(R.id.option3); // 임산부
        linearLayout4 = (LinearLayout)findViewById(R.id.option4); // 다리부상

        imageView1 = (ImageView)findViewById(R.id.imageView4);
        imageView2 = (ImageView)findViewById(R.id.imageView5);
        imageView3 = (ImageView)findViewById(R.id.imageView6);
        imageView4 = (ImageView)findViewById(R.id.imageView7);

        imageView1.setImageResource(R.drawable.group_8);
        imageView2.setImageResource(R.drawable.group_7);
        imageView3.setImageResource(R.drawable.group_9);
        imageView4.setImageResource(R.drawable.group_10);

        btn_back = findViewById(R.id.register_ib_back);

        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

        linearLayout1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Database.setOption("1");
                Database.setUserGrade("장애인");
                Database.setBounusTimeString("7초");
                startActivity(intent);
                finish();
            }
        });
        linearLayout2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Database.setOption("2");
                Database.setUserGrade("고령자");
                Database.setBounusTimeString("6초");
                startActivity(intent);
                finish();

            }
        });
        linearLayout3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Database.setOption("3");
                Database.setUserGrade("임산부");
                Database.setBounusTimeString("5초");
                startActivity(intent);
                finish();

            }
        });
        linearLayout4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Database.setOption("4");
                Database.setUserGrade("다리 부상");
                Database.setBounusTimeString("4초");
                startActivity(intent);
                finish();

            }
        });

    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();
    }
}
