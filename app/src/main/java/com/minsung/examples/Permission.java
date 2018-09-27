package com.minsung.examples;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageManager;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Toast;

public class Permission {

    private Context context;
    private Activity activity;
    private static final int SMS_RECEIVE_PERMISSON=1;

    public Permission(Context context, Activity activity) {
        this.context = context;
        this.activity = activity;
    }
    void checkPermission(){
        int permissonCheck= ContextCompat.checkSelfPermission(context, Manifest.permission.BLUETOOTH);

        if(permissonCheck == PackageManager.PERMISSION_GRANTED){
            Toast.makeText(context, "SMS 수신권한 있음", Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(context, "SMS 수신권한 없음", Toast.LENGTH_SHORT).show();


            if(ActivityCompat.shouldShowRequestPermissionRationale(activity, Manifest.permission.BLUETOOTH)){
                Toast.makeText(context, "블루투스 권한이 필요합니다", Toast.LENGTH_SHORT).show();
                ActivityCompat.requestPermissions(activity, new String[]{ Manifest.permission.BLUETOOTH}, SMS_RECEIVE_PERMISSON);

                Log.d("MSG :        ", "NUMBER1");


            }else{
                ActivityCompat.requestPermissions(activity, new String[]{ Manifest.permission.BLUETOOTH}, SMS_RECEIVE_PERMISSON);

                Log.d("MSG :        ", "NUMBER2");

            }
        }
    }
}
