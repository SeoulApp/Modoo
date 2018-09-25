package com.minsung.examples;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.VibrationEffect;
import android.os.Vibrator;
import android.speech.tts.TextToSpeech;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.minsung.examples.Info.InfoMain;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    private static final int SMS_RECEIVE_PERMISSON = 1;
    private static final int ONE_SECOND = 1000;
    private static final int VIBRATE_ON = 1;
    private static final int VIBRATE_OFF = 0;


    private TextView tv_light;
    private TextView tv_light_detail;
    private TextView tv_time_left;
    private ImageButton ib_drawer;
    private Button btn_alarmOn;
    private Button btn_alarmOff;
    private ProgressBar pb_progress;
    private ImageView test_btn_sign;

    private CountDownTimer timer;
    private Vibrator vibrator;
    private TextToSpeech tts;
    private int allotted_time = 7000;
    private int time_left;
    private int vibrate_flag = VIBRATE_OFF;
    private int vibrate_start = 5000;
    long[] vibrate_pattern = {100,1000,100,1000};
    String[] tts_pattern = {"빨간불로 바뀌었습니다!","1초","2초","3초","4초","5초"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv_time_left = (TextView) findViewById(R.id.main_tv_time_sec);
        tv_light = (TextView) findViewById(R.id.main_tv_msgTop);
        tv_light_detail = (TextView) findViewById(R.id.main_tv_msgBottom);
        ib_drawer = (ImageButton) findViewById(R.id.main_ib_drawer);

        pb_progress = (ProgressBar) findViewById(R.id.main_pb_progress);
        test_btn_sign = findViewById(R.id.main_iv_sign);


        setDefault();
        test();


        Permission permission = new Permission(getApplicationContext(),this);
        permission.checkPermission();

        final Intent intent = new Intent(this, InfoMain.class);
        ib_drawer.setOnClickListener(new View.OnClickListener() {
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

    // default setting
    public void setDefault(){
        // drawer listener 달기

        // progress bar 색 설정
        pb_progress.setProgressTintList(getColorStateList(R.color.color_red_light));

    }


    // for test
    public void test(){
        // time_left 설정
        time_left = allotted_time;

        // 초록불모드
        test_btn_sign.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                test_btn_sign.setImageDrawable(getResources().
                        getDrawable(R.drawable.ic_green_light,getApplicationContext().getTheme()));
                tv_light.setText(getResources().getText(R.string.str_green_light));
                tv_light_detail.setText(getResources().getText(R.string.str_green_detail));

                // progress bar 색 변경
                pb_progress.setProgressTintList(getColorStateList(R.color.color_green_light));

                // time_left 설정
                time_left = allotted_time;

            }
        });

        // progress bar test
        pb_progress.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View view) {
                tv_time_left.setText(String.valueOf(time_left/1000));

                //timer
                timer=new CountDownTimer(allotted_time,ONE_SECOND) {
                    @Override
                    public void onTick(long l) {
                        pb_progress.setProgress((int)(100*l/allotted_time));
                        if(time_left<=vibrate_start && time_left>0){
                            tts.speak(tts_pattern[time_left/1000],TextToSpeech.QUEUE_FLUSH,null,"myUtteranceID");
                            System.out.println(tts_pattern[time_left/1000]);
                        }

                        tv_time_left.setText(String.valueOf(time_left/1000));
                        if(vibrate_flag==VIBRATE_OFF && time_left<=vibrate_start){
                            vibrator = (Vibrator) getSystemService(VIBRATOR_SERVICE);
                            vibrator.vibrate(VibrationEffect.createWaveform(vibrate_pattern,0));
                            vibrate_flag = VIBRATE_ON;
                        }
                        time_left-=1000;

                    }

                    @Override
                    public void onFinish() {
                        pb_progress.setProgress(0);
                        tts.speak(tts_pattern[0],TextToSpeech.QUEUE_FLUSH,null,"myUtteranceID");
                        tv_time_left.setText(String.valueOf(0));
                        vibrator.cancel();
                        vibrate_flag = VIBRATE_OFF;
                        time_left=0;
                    }
                }.start();

                // tts
                tts = new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {
                    @Override
                    public void onInit(int status) {
                        if(status!= TextToSpeech.ERROR){
                            tts.setLanguage(Locale.KOREAN);
                        }
                    }
                });

            }
        });
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        // TTS 객체가 남아있다면 실행을 중지하고 메모리에서 제거
        if(tts != null){
            tts.stop();
            tts.shutdown();
            tts = null;
        }
    }
}