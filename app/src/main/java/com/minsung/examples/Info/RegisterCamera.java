package com.minsung.examples.Info;

import android.Manifest;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.os.Build;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.util.Log;
import android.view.SurfaceView;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.minsung.examples.R;
public class RegisterCamera extends Activity {

    private Button button;
    private ImageView imageView;
    private static final int MY_CAMERA_REQUEST_CODE = 100;

    private Intent intent10;


    String option;
    String grade;
    String time;


//

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_card_authentication);

        intent10 = getIntent();
        option = intent10.getStringExtra("Option");
        grade = intent10.getStringExtra("Grade");
        time = intent10.getStringExtra("Time");


        imageView = (ImageView)findViewById(R.id.imageView8);

                if (checkSelfPermission(Manifest.permission.CAMERA)
                        != PackageManager.PERMISSION_GRANTED) {
                    requestPermissions(new String[]{Manifest.permission.CAMERA},
                            MY_CAMERA_REQUEST_CODE);
                }
                else {
                    Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                    startActivityForResult(intent,1);
                }
            }
    @Override

    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {

        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        if (requestCode == MY_CAMERA_REQUEST_CODE) {

            if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {

                Toast.makeText(this, "camera permission granted", Toast.LENGTH_LONG).show();

            } else {

                Toast.makeText(this, "camera permission denied", Toast.LENGTH_LONG).show();

            }

        }
    }



    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data)
    {
        Bundle extras = data.getExtras();
        Bitmap mImageBitmap = (Bitmap)extras.get("data");
        imageView.setImageBitmap(mImageBitmap);
        try {
            Thread.sleep(2000);
            Toast.makeText(this, "글자 인식을 실패하였습니다. 번호로 입력해주세요", Toast.LENGTH_LONG).show();
            Intent intent = new Intent(this,RegisterNumber.class);
            intent.putExtra("Option",option);
            intent.putExtra("Grade",grade);
            intent.putExtra("Time",time);
            startActivity(intent);
            finish();
        }catch (Exception e){
            e.printStackTrace();
        }






    }



}
