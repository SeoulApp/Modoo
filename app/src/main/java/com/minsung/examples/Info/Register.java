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
    private LinearLayout linearLayout5 ;

    private ImageView imageView1;
    private ImageView imageView2;
    private ImageView imageView3;
    private ImageView imageView4;
    private ImageView imageView5;

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
        linearLayout5 = (LinearLayout)findViewById(R.id.option5);  // 어린이

        imageView1 = (ImageView)findViewById(R.id.imageView4);
        imageView2 = (ImageView)findViewById(R.id.imageView5);
        imageView3 = (ImageView)findViewById(R.id.imageView6);
        imageView4 = (ImageView)findViewById(R.id.imageView7);
        imageView5 = (ImageView)findViewById(R.id.imageView1);


        imageView1.setImageResource(R.drawable.group_8);
        imageView2.setImageResource(R.drawable.group_7);
        imageView3.setImageResource(R.drawable.group_9);
        imageView4.setImageResource(R.drawable.group_10);
        imageView5.setImageResource(R.drawable.group_11);

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
                intent.putExtra("Option","1");
                intent.putExtra("Grade","장애인");
                intent.putExtra("Time","5초");
                startActivity(intent);
                finish();
            }
        });
        linearLayout2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent.putExtra("Option","2");
                intent.putExtra("Grade","고령자");
                intent.putExtra("Time","7.5초");
                startActivity(intent);
                finish();

            }
        });
        linearLayout3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent.putExtra("Option","3");
                intent.putExtra("Grade","임산부");
                intent.putExtra("Time","2.5초");
                startActivity(intent);
                finish();

            }
        });
        linearLayout4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent.putExtra("Option","4");
                intent.putExtra("Grade","다리 부상");
                intent.putExtra("Time","5초");
                startActivity(intent);
                finish();

            }
        });
        linearLayout5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent.putExtra("Option","5");
                intent.putExtra("Grade","어린이");
                intent.putExtra("Time","5.8초");
                startActivity(intent);
                finish();

            }
        });

    }

    @Override
    public void onBackPressed() {
        final Intent intent = new Intent(getApplicationContext(), MainActivity.class);
        startActivity(intent);
        finish();
    }
}
