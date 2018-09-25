package com.minsung.examples.Info;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.minsung.examples.Data.Database;
import com.minsung.examples.R;

public class InfoMain extends Activity {

    private Button ChangeInfo;
    private TextView name;
    private TextView grade;
    private TextView bonus;




    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.info_main);

        final Intent intent = new Intent(this, Register.class);

        name = (TextView)findViewById(R.id.name);
        grade = (TextView)findViewById(R.id.grade);
        bonus = (TextView)findViewById(R.id.bonus);

        name.setText(Database.getUserName());
        grade.setText(Database.getUserGrade());
        bonus.setText(Database.getBounusTime());




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
        bonus.setText(Database.getBounusTime());
    }
}
