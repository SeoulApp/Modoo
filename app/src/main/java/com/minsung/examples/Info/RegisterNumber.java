package com.minsung.examples.Info;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;

import com.minsung.examples.Data.Database;
import com.minsung.examples.R;

public class RegisterNumber extends Activity {

    private Button button;
    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor editor;




    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register_number);

        sharedPreferences = getSharedPreferences("pref",MODE_PRIVATE);
        editor = sharedPreferences.edit();
        button = (Button)findViewById(R.id.button14);

        final String s = String.valueOf(Database.isAlarmSound());
        final String v = String.valueOf(Database.isAlarmbVibration());
        final String p = String.valueOf(Database.isAlarmPush());
        final String n = Database.getUserName();
        final String g = Database.getUserGrade();
        final String t = Database.getBounusTime();



        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Database.





                editor.putString("S",s);
                editor.putString("V",v);
                editor.putString("P",p);
                editor.putString("N",n);
                editor.putString("G",g);
                editor.putString("T",t);
                editor.commit();
            }
        });



    }
}
