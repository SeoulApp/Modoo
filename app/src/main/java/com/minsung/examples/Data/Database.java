package com.minsung.examples.Data;

public class Database {
    static private boolean Tutorial = true;
    static private boolean AlarmSound = true;
    static private boolean AlarmbVibration = true;
    static private boolean BounusTimeBool = true;

    static private boolean Auth = false;
    static private boolean AlarmPush = true;
    static private String UserName = "홍길동";
    static private String UserGrade = "4급";
    static private String BounusTimeString = "3초";
    static private String Option = "0";

    public static boolean isBounusTimeBool() {
        return BounusTimeBool;
    }

    public static void setBounusTimeBool(boolean bounusTimeBool) {
        BounusTimeBool = bounusTimeBool;
    }

    public static String getOption() {
        return Option;
    }

    public static void setOption(String option) {
        Option = option;
    }

    public static boolean isTutorial() {
        return Tutorial;
    }

    public static void setTutorial(boolean tutorial) {
        Tutorial = tutorial;
    }

    public static boolean isAuth() {
        return Auth;
    }

    public static void setAuth(boolean auth) {
        Auth = auth;
    }

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

    public static String getBounusTimeString() {
        return BounusTimeString;
    }

    public static void setBounusTimeString(String bounusTime) {
        BounusTimeString = bounusTime;
    }
}
