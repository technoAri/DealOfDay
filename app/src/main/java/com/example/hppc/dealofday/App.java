//package com.example.hppc.dealofday;
//
//import android.app.Application;
//import android.content.Context;
//
///**
// * Created by HP PC on 11/24/2016.
// */
//public class App extends Application {
//    private static Context context;
//    private static DBHelper dbHelper;
//
//    @Override
//    public void onCreate()
//    {
//        super.onCreate();
//        context = this.getApplicationContext();
//        dbHelper = new DBHelper();
//        DatabaseManager.initializeInstance(dbHelper);
//
//    }
//
//    public static Context getContext(){
//        return context;
//    }
//}
