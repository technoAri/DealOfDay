//package com.example.hppc.dealofday.Repository;
//
//import android.content.ContentValues;
//import android.database.sqlite.SQLiteDatabase;
//
//import com.example.hppc.dealofday.DataBase.Amazon;
//import com.example.hppc.dealofday.DatabaseManager;
//
///**
// * Created by HP PC on 11/24/2016.
// */
//public class AmazonRepo {
//
//    private Amazon amazon;
//
//    public AmazonRepo(){
//
//        amazon = new Amazon();
//
//    }
//
//
//    public static String createTable(){
//        return "CREATE TABLE " + Amazon.TABLE  + "("
//                + Amazon.KEY_AmazonId  + "   PRIMARY KEY    ,"
//                + Amazon.KEY_Name + " TEXT )";
//    }
//
//
//    public int insert(Amazon amazon) {
//        int amazonId;
//        SQLiteDatabase db = DatabaseManager.getInstance().openDatabase();
//        ContentValues values = new ContentValues();
//        values.put(Amazon.KEY_AmazonId, amazon.getAmazonId());
//        values.put(Amazon.KEY_Name, amazon.getName());
//
//        // Inserting Row
//        amazonId=(int)db.insert(Amazon.TABLE, null, values);
//        DatabaseManager.getInstance().closeDatabase();
//
//        return amazonId;
//    }
//
//
//
//    public void delete( ) {
//        SQLiteDatabase db = DatabaseManager.getInstance().openDatabase();
//        db.delete(Amazon.TABLE,null,null);
//        DatabaseManager.getInstance().closeDatabase();
//    }
//}
