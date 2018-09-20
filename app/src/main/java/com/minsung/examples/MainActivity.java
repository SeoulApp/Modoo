package com.minsung.examples;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private TextView tv_time_left;
    private Button button;

    private static final int SMS_RECEIVE_PERMISSON = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv_time_left = (TextView) findViewById(R.id.main_tv_time_left);
        button = (Button) findViewById(R.id.alarmOn);


        Permission permission = new Permission(getApplicationContext(),this);
        permission.checkPermission();

        final Intent intent = new Intent(this, tutorial.class);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(intent);
            }
        });
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String permissions[], int grantResults[]) {
        switch (requestCode) {
            case SMS_RECEIVE_PERMISSON:
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {

                    Toast.makeText(getApplicationContext(), "SMS권한 승인함", Toast.LENGTH_LONG).show();
                    Log.d("ddddddddd", "OKOKOKOKOK");


                } else {
                    Toast.makeText(getApplicationContext(), "SMS권한 거부함", Toast.LENGTH_LONG).show();
                    Log.d("ddddddddd", "NONOONONO");
                    this.finish();
                }
                break;
        }
    }
}

