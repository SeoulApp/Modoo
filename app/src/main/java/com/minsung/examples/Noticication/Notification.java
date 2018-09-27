//package com.minsung.examples.Noticication;

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