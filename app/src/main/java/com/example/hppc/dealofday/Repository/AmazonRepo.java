//package com.example.hppc.dealofday.Repository;
//
//import android.content.ContentValues;
//import android.database.sqlite.SQLiteDatabase;
//
//import com.example.hppc.dealofday.DataBase.CoolpadNote3;
//import com.example.hppc.dealofday.DatabaseManager;
//
///**
// * Created by HP PC on 11/24/2016.
// */
//public class AmazonRepo {
//
//    private CoolpadNote3 amazon;
//
//    public AmazonRepo(){
//
//        amazon = new CoolpadNote3();
//
//    }
//
//
//    public static String createTable(){
//        return "CREATE TABLE " + CoolpadNote3.TABLE  + "("
//                + CoolpadNote3.KEY_AmazonId  + "   PRIMARY KEY    ,"
//                + CoolpadNote3.KEY_Name + " TEXT )";
//    }
//
//
//    public int insert(CoolpadNote3 amazon) {
//        int amazonId;
//        SQLiteDatabase db = DatabaseManager.getInstance().openDatabase();
//        ContentValues values = new ContentValues();
//        values.put(CoolpadNote3.KEY_AmazonId, amazon.getAmazonId());
//        values.put(CoolpadNote3.KEY_Name, amazon.getName());
//
//        // Inserting Row
//        amazonId=(int)db.insert(CoolpadNote3.TABLE, null, values);
//        DatabaseManager.getInstance().closeDatabase();
//
//        return amazonId;
//    }
//
//
//
//    public void delete( ) {
//        SQLiteDatabase db = DatabaseManager.getInstance().openDatabase();
//        db.delete(CoolpadNote3.TABLE,null,null);
//        DatabaseManager.getInstance().closeDatabase();
//    }
//}
