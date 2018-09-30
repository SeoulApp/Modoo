package com.minsung.examples.Info;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import com.minsung.examples.Data.Database;
import com.minsung.examples.R;

public class InfoMain extends Activity {

    private Button ChangeInfo;
    private ImageButton Info;
    private ImageButton Back;
    private TextView name;
    private TextView grade;
    private TextView bonus;
    private ImageView imageView;
    private int imagesrc;
    private Switch aSwitch1;
    private Switch aSwitch2;
    private Switch aSwitch3;
    private Switch aSwitch5;
    private Button Ok;


    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor editor;



    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.info_main);

        final Intent intent = new Intent(this, Register.class);

        name = (TextView)findViewById(R.id.name);
        grade = (TextView)findViewById(R.id.grade);
        bonus = (TextView)findViewById(R.id.bonus);
      //  imageView = (ImageView)findViewById(R.id.imageView2);
        Ok = (Button)findViewById(R.id.button4);
        Back = (ImageButton)findViewById(R.id.register_option_ib_back2);
        Info = (ImageButton)findViewById(R.id.info);

        aSwitch1 = (Switch)findViewById(R.id.switch1); // 시간추가
        aSwitch2 = (Switch)findViewById(R.id.switch2); // 진동
        aSwitch3 = (Switch)findViewById(R.id.switch3); // 소리
        aSwitch5 = (Switch)findViewById(R.id.switch5); // 알림


        sharedPreferences = getSharedPreferences("pref",MODE_PRIVATE);
        editor = sharedPreferences.edit();


        imagesrc = 0;
        switch (Database.getOption()){
            case "1":
                imagesrc = R.drawable.group_8;
                break;
            case "2":
                imagesrc = R.drawable.group_7;
                break;
            case "3":
                imagesrc = R.drawable.group_9;
                break;
            case "4":
                imagesrc = R.drawable.group_10;
                break;
            case "5":
                imagesrc = R.drawable.group_11;
                break;
                default:
                    imagesrc = R.drawable.ic_tutorial_1;
                    break;
        }



        name.setText(Database.getUserName());
        grade.setText(Database.getUserGrade());
        bonus.setText(Database.getBounusTimeString());
        Info.setImageResource(imagesrc);

        aSwitch1.setChecked(Database.isBounusTimeBool());
        aSwitch2.setChecked(Database.isAlarmbVibration());
        aSwitch3.setChecked(Database.isAlarmSound());
        aSwitch5.setChecked(Database.isAlarmPush());


        Ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean one = SwitchValue(aSwitch1);  // 추가시간
                boolean two = SwitchValue(aSwitch2);  // 진동
                boolean three = SwitchValue(aSwitch3); // 소리
                boolean four = SwitchValue(aSwitch5);  // 푸시

                Database.setBounusTimeBool(one);
                Database.setAlarmbVibration(two);
                Database.setAlarmSound(three);
                Database.setAlarmPush(four);

                editor.putString("Bonus",String.valueOf(one));
                editor.putString("V",String.valueOf(two));
                editor.putString("S",String.valueOf(three));
                editor.putString("P",String.valueOf(four));
                editor.commit();

                Toast.makeText(getApplicationContext(),"저장되었습니다.",Toast.LENGTH_SHORT).show();
                finish();


            }
        });

        Back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        Info.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent1 = new Intent(getApplicationContext(),InfoResult.class);
                intent1.putExtra("Img",imagesrc);
                startActivity(intent1);
            }
        });









        ChangeInfo = (Button)findViewById(R.id.button3);
        ChangeInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        name.setText(Database.getUserName());
        grade.setText(Database.getUserGrade());
        bonus.setText(Database.getBounusTimeString());

        switch (Database.getOption()){
            case "1":
                imagesrc = R.drawable.group_8;
                break;
            case "2":
                imagesrc = R.drawable.group_7;
                break;
            case "3":
                imagesrc = R.drawable.group_9;
                break;
            case "4":
                imagesrc = R.drawable.group_10;
                break;
            case "5":
                imagesrc = R.drawable.group_11;
                break;
            default:
                imagesrc = R.drawable.ic_tutorial_1;
                break;
        }


        Info.setImageResource(imagesrc);

    }



    Boolean SwitchValue(Switch input){
        Boolean result = false;
        if (input.isChecked()){
            result = true;
        }
        return result;
    }


}
