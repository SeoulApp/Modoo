//package com.minsung.examples.Noticication;
//
//import android.app.Activity;
//import android.app.AlertDialog;
//import android.app.NotificationChannel;
//import android.app.NotificationManager;
//import android.app.PendingIntent;
//import android.app.Service;
//import android.content.Context;
//import android.content.Intent;
//import android.graphics.BitmapFactory;
//import android.media.RingtoneManager;
//import android.net.Uri;
//import android.os.Handler;
//import android.os.IBinder;
//import android.support.annotation.Nullable;
//import android.support.v4.app.NotificationCompat;
//import android.util.Log;
//import android.widget.Toast;
//
//import com.minsung.examples.MainActivity;
//import com.minsung.examples.R;
//
//import java.util.Calendar;
//import java.util.Timer;
//
//import static android.content.Context.NOTIFICATION_SERVICE;
//
//public class Notification {
//    public void noti(Context context  , Class c){
//
//        String channelId = "channel";
//        String channelName = "Channel Name";
//
//        NotificationManager notifManager
//                = (NotificationManager) getSystemService  (context.NOTIFICATION_SERVICE);
//
//        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
//
//            int importance = NotificationManager.IMPORTANCE_HIGH;
//
//            NotificationChannel mChannel = new NotificationChannel(
//                    channelId, channelName, importance);
//
//            notifManager.createNotificationChannel(mChannel);
//
//        }
//
//        NotificationCompat.Builder builder =
//                new NotificationCompat.Builder(context, channelId);
//
//        Intent notificationIntent = new Intent(context
//                ,c);
//
//
//
//        notificationIntent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP |
//                Intent.FLAG_ACTIVITY_SINGLE_TOP);
//
//        int requestID = (int) System.currentTimeMillis();
//
//        PendingIntent pendingIntent
//                = PendingIntent.getActivity(context
//                , requestID
//                , notificationIntent
//                , PendingIntent.FLAG_UPDATE_CURRENT);
//
//        builder.setContentTitle("Title") // required
//                .setContentText("Content")  // required
//                .setDefaults(android.app.Notification.DEFAULT_ALL) // 알림, 사운드 진동 설정
//                .setAutoCancel(true) // 알림 터치시 반응 후 삭제
//
//                .setSound(RingtoneManager
//                        .getDefaultUri(RingtoneManager.TYPE_NOTIFICATION))
//                .setSmallIcon(android.R.drawable.btn_star)
//                .setLargeIcon(BitmapFactory.decodeResource(getResources()
//                        , R.drawable.group_7))
//                .setBadgeIconType(R.drawable.group_8)
//
//                .setContentIntent(pendingIntent);
//
//        notifManager.notify(0, builder.build());
//
//
//
//    }
//}