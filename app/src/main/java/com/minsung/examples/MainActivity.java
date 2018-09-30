package com.minsung.examples;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.graphics.BitmapFactory;
import android.media.RingtoneManager;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.VibrationEffect;
import android.os.Vibrator;
import android.speech.tts.TextToSpeech;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.TaskStackBuilder;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RemoteViews;
import android.widget.TextView;
import android.widget.Toast;

import com.minsung.examples.Data.Database;
import com.minsung.examples.Info.InfoMain;
import com.minsung.examples.Info.Register;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    private static final int SMS_RECEIVE_PERMISSON = 1;
    private static final int ONE_SECOND = 1000;
    private static final int VIBRATE_ON = 1;
    private static final int VIBRATE_OFF = 0;

    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor editor;





    private TextView tv_light;
    private TextView tv_light_detail;
    private TextView tv_time_left;
    private ImageButton ib_drawer;
    private Button btn_alarmOn;
    private Button btn_alarmOff;
    private ProgressBar pb_progress;
    private ImageView test_btn_sign;
    private ImageButton Ring;

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
        Ring = (ImageButton)findViewById(R.id.main_ib_ring);

        Intent intent1 = new Intent(this, Register.class);

        setDefault();
        test();

        Log.d("SSSSSSSS", Database.getOption());

        sharedPreferences = getSharedPreferences("pref",MODE_PRIVATE);
        editor = sharedPreferences.edit();

        int imgsrc = 0;

        if (Database.isTotalAlarm()){
            imgsrc = R.drawable.ic_alarm;
        }
        else{
            imgsrc = R.drawable.group;
        }

        Ring.setImageResource(imgsrc);



        Permission permission = new Permission(getApplicationContext(), this);
        permission.checkPermission();

        final Intent intent = new Intent(this, InfoMain.class);
        ib_drawer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(intent);

            }
        });




        String channelId = "channel";
        String channelName = "Channel Name";

        NotificationManager notifManager
                = (NotificationManager) getSystemService  (Context.NOTIFICATION_SERVICE);

        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {

            int importance = NotificationManager.IMPORTANCE_HIGH;

            NotificationChannel mChannel = new NotificationChannel(
                    channelId, channelName, importance);

            notifManager.createNotificationChannel(mChannel);

        }

        NotificationCompat.Builder builder =
                new NotificationCompat.Builder(getApplicationContext(), channelId);

        Intent notificationIntent = new Intent(getApplicationContext()
                , MainActivity.class);

        notificationIntent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP |
                Intent.FLAG_ACTIVITY_SINGLE_TOP);

        int requestID = (int) System.currentTimeMillis();

        PendingIntent pendingIntent
                = PendingIntent.getActivity(getApplicationContext()
                , requestID
                , notificationIntent
                , PendingIntent.FLAG_UPDATE_CURRENT);

        RemoteViews remoteViews = new RemoteViews(getPackageName(), R.layout.notification);
        remoteViews.setTextViewText(R.id.noti_tv_light,"초록불");


        builder.setContentTitle("Title") // required
                .setContentText("Content")  // required
                .setDefaults(Notification.DEFAULT_ALL) // 알림, 사운드 진동 설정
                .setAutoCancel(true) // 알림 터치시 반응 후 삭제
                .setSound(RingtoneManager
                        .getDefaultUri(RingtoneManager.TYPE_NOTIFICATION))
                .setSmallIcon(android.R.drawable.btn_star)
                .setLargeIcon(BitmapFactory.decodeResource(getResources()
                        , R.drawable.group_7))
                .setBadgeIconType(R.drawable.group_8)

                        .setContent(remoteViews);




//
//        builder.setContent(remoteViews)
//                .setContentIntent(createPendingIntent());
//        builder.setContentIntent(createPendingIntent());
//        builder.setAutoCancel(true)
        notifManager.notify(0, builder.build());


        Ring.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (Database.isTotalAlarm()){

                    Database.setAlarmSound(false);
                    Database.setAlarmbVibration(false);
                    Database.setAlarmPush(false);
                    Database.setTotalAlarm(false);
                }
                else{
                    Database.setAlarmSound(true);
                    Database.setAlarmbVibration(true);
                    Database.setAlarmPush(true);
                    Database.setTotalAlarm(true);
                }

                editor.putString("V",String.valueOf(Database.isAlarmbVibration()));
                editor.putString("S",String.valueOf(Database.isAlarmSound()));
                editor.putString("P",String.valueOf(Database.isAlarmPush()));
                editor.putString("Total",String.valueOf(Database.isTotalAlarm()));
                editor.commit();

                int imgsrc = 0;

                if (Database.isTotalAlarm()){
                    imgsrc = R.drawable.ic_alarm;
                }
                else{
                    imgsrc = R.drawable.group;
                }

                Ring.setImageResource(imgsrc);

            }
        });







    }
    private PendingIntent createPendingIntent(){
        Intent resultIntent = new Intent(this, MainActivity.class);
        TaskStackBuilder stackBuilder = TaskStackBuilder.create(this);
        stackBuilder.addParentStack(MainActivity.class);
        stackBuilder.addNextIntent(resultIntent);

        return stackBuilder.getPendingIntent(
                0,
                PendingIntent.FLAG_UPDATE_CURRENT
        );
    }




    public void notificationcall(){

        int notify_id =1;



        NotificationCompat.Builder notificationBuilder = (NotificationCompat.Builder) new NotificationCompat.Builder(this)
                .setSmallIcon(R.drawable.ic_launcher_background)
                .setDefaults(NotificationCompat.DEFAULT_ALL)
                .setContentTitle("Notify")
                .setAutoCancel(true)
                .setContentText("인터넷 연결이 끊겼습니다.");
        NotificationManager notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        notificationManager.notify(notify_id, notificationBuilder.build());
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

    @Override
    protected void onResume() {
        super.onResume();

    }
}