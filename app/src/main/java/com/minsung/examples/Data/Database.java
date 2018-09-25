package com.minsung.examples.Data;

public class Database {
    static private boolean AlarmSound = true;
    static private boolean AlarmbVibration = true;
    static private boolean AlarmPush = true;
    static private String UserName = "홍길동";
    static private String UserGrade = "4급";
    static private String BounusTime = "3초";



    public static boolean isAlarmSound() {
        return AlarmSound;
    }

    public static void setAlarmSound(boolean alarmSound) {
        AlarmSound = alarmSound;
    }

    public static boolean isAlarmbVibration() {
        return AlarmbVibration;
    }

    public static void setAlarmbVibration(boolean alarmbVibration) {
        AlarmbVibration = alarmbVibration;
    }

    public static boolean isAlarmPush() {
        return AlarmPush;
    }

    public static void setAlarmPush(boolean alarmPush) {
        AlarmPush = alarmPush;
    }

    public static String getUserName() {
        return UserName;
    }

    public static void setUserName(String userName) {
        UserName = userName;
    }

    public static String getUserGrade() {
        return UserGrade;
    }

    public static void setUserGrade(String userGrade) {
        UserGrade = userGrade;
    }

    public static String getBounusTime() {
        return BounusTime;
    }

    public static void setBounusTime(String bounusTime) {
        BounusTime = bounusTime;
    }
}
