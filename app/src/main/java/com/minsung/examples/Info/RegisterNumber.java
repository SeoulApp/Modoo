package com.minsung.examples.Info;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.minsung.examples.Data.Database;
import com.minsung.examples.MainActivity;
import com.minsung.examples.R;

public class RegisterNumber extends Activity {

    private Button button;
    private EditText name;
    private EditText number;
    private Context context;
    private ImageButton Back;
    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor editor;
    private  Intent intent;
    private  Intent intent10;

    String option;
    String grade;
    String time;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register_number);

        sharedPreferences = getSharedPreferences("pref",MODE_PRIVATE);
        editor = sharedPreferences.edit();
        intent10 = getIntent();

        option = intent10.getStringExtra("Option");
        grade = intent10.getStringExtra("Grade");
        time = intent10.getStringExtra("Time");



        context = this.getApplicationContext();
        button = (Button)findViewById(R.id.button14);
        name = (EditText)findViewById(R.id.editText2);
        number = (EditText)findViewById(R.id.editText3);
        Back = (ImageButton)findViewById(R.id.register_option_ib_back);


        final String s = String.valueOf(Database.isAlarmSound());
        final String v = String.valueOf(Database.isAlarmbVibration());
        final String p = String.valueOf(Database.isAlarmPush());
        final String n = Database.getUserName();
        final String g = grade;
        final String t = time;


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (name.getText().toString().equals("")){
                    Toast.makeText(context,"이름을 입력해주세요.",Toast.LENGTH_SHORT).show();
                    return;
                }



                final String n_ = name.getText().toString();
                final String number_ = number.getText().toString();

                editor.putString("S",s);
                editor.putString("V",v);
                editor.putString("P",p);
                editor.putString("N",n_);
                editor.putString("G",g);
                editor.putString("T",t);
                editor.putString("Auth","true");
                editor.putString("Option",option);
                editor.commit();

                Database.setBounusTimeString(time);
                Database.setUserGrade(grade);
                Database.setOption(option);

                if (!Database.isAuth()){
                    intent = new Intent(getApplicationContext(), MainActivity.class);
                    Intent intent1 = new Intent(getApplicationContext(), InfoResult.class);
                    Database.setUserName(n_);
                    Database.setAuth(true);
                    startActivity(intent);
                    startActivity(intent1);
                    Toast.makeText(context,"변경이 완료되었습니다.",Toast.LENGTH_SHORT).show();

                    finish();
                }
                else{
                    Database.setUserName(n_);
                    Intent intent1 = new Intent(getApplicationContext(), InfoResult.class);
                    startActivity(intent1);
                    Toast.makeText(context,"변경이 완료되었습니다.",Toast.LENGTH_SHORT).show();
                    finish();
                }
            }
        });

        Back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),RegisterOption.class);
                startActivity(intent);
                finish();
            }
        });


    }
}
