//package com.example.hppc.dealofday;
//
//import android.content.Context;
//import android.database.sqlite.SQLiteDatabase;
//import android.database.sqlite.SQLiteOpenHelper;
//import android.util.Log;
//
//import com.example.hppc.dealofday.DataBase.Amazon;
//import com.example.hppc.dealofday.DataBase.Flipkart;
//import com.example.hppc.dealofday.Repository.AmazonRepo;
//import com.example.hppc.dealofday.Repository.FlipkartRepo;
//
///**
// * Created by HP PC on 11/24/2016.
// */
//public class DBHelper extends SQLiteOpenHelper {
//
//    //version number to upgrade database version
//    //each time if you Add, Edit table, you need to change the
//    //version number.
//    private static final int DATABASE_VERSION =8;
//    // Database Name
//    private static final String DATABASE_NAME = "sqliteDBMultiTbl.db";
//    private static final String TAG = DBHelper.class.getSimpleName().toString();
//    public DBHelper( ) {
//        super(App.getContext(), DATABASE_NAME, null, DATABASE_VERSION);
//    }
//
//    @Override
//    public void onCreate(SQLiteDatabase db) {
//        //All necessary tables you like to create will create here
//        db.execSQL(AmazonRepo.createTable());
//        db.execSQL(FlipkartRepo.createTable());
////        db.execSQL(MajorRepo.createTable());
////        db.execSQL(StudentCourseRepo.createTable());
//
//    }
//
//    @Override
//    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
//        Log.d(TAG, String.format("SQLiteDatabase.onUpgrade(%d -> %d)", oldVersion, newVersion));
//
//        // Drop table if existed, all data will be gone!!!
//        db.execSQL("DROP TABLE IF EXISTS " + Amazon.TABLE);
//        db.execSQL("DROP TABLE IF EXISTS " + Flipkart.TABLE);
////        db.execSQL("DROP TABLE IF EXISTS " + Major.TABLE);
////        db.execSQL("DROP TABLE IF EXISTS " + StudentCourse.TABLE);
//        onCreate(db);
//
//    }
//}
