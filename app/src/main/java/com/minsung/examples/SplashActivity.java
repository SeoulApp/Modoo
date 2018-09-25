package com.minsung.examples;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;

import com.minsung.examples.Data.Database;
import com.minsung.examples.Tutorial.tutorial;

public class SplashActivity extends Activity {

    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);



        sharedPreferences = getSharedPreferences("pref",MODE_PRIVATE);
        editor = sharedPreferences.edit();


        String s = (sharedPreferences.getString("S","NULL"));
        String v = (sharedPreferences.getString("V","NULL"));
        String p = (sharedPreferences.getString("P","NULL"));
        String n = sharedPreferences.getString("N","NULL");
        String g = sharedPreferences.getString("G","NULL");
        String t = sharedPreferences.getString("T","NULL");

        if (s.equals("NULL")){

            editor.putString("S","ture");
            editor.putString("V","ture");
            editor.putString("P","ture");
            editor.putString("N","홍길동");
            editor.putString("G","4급");
            editor.putString("T","3초");
            editor.commit();
        }
        else{
            Database.setAlarmSound(Boolean.valueOf(s));
            Database.setAlarmbVibration(Boolean.valueOf(v));
            Database.setAlarmPush(Boolean.valueOf(p));
            Database.setUserName(n);
            Database.setUserGrade(g);
            Database.setBounusTime(t);
        }
//
//        public void removePreferencesAll(){
//            editor.clear();
//            editor.commit();
//        }









        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(getBaseContext(),tutorial.class);
                startActivity(intent);
                finish();
            }
        },2000);

    }
}
