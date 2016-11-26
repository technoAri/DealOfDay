//package com.example.hppc.dealofday.Repository;
//
//import android.content.ContentValues;
//import android.database.sqlite.SQLiteDatabase;
//import com.example.hppc.dealofday.DataBase.Flipkart;
//import com.example.hppc.dealofday.DatabaseManager;
//
///**
// * Created by HP PC on 11/24/2016.
// */
//public class FlipkartRepo {
//
//    private Flipkart flipkart;
//
//    public FlipkartRepo(){
//
//        flipkart = new Flipkart();
//
//    }
//
//    public static String createTable(){
//        return "CREATE TABLE " + Flipkart.TABLE  + "("
//                + Flipkart.KEY_FlipkartId + "   PRIMARY KEY    ,"
//                + Flipkart.KEY_Name + " TEXT )";
//    }
//
//
//    public int insert(Flipkart flipkart) {
//        int flipkartId;
//        SQLiteDatabase db = DatabaseManager.getInstance().openDatabase();
//        ContentValues values = new ContentValues();
//        values.put(Flipkart.KEY_FlipkartId, flipkart.getFlipkartId());
//        values.put(Flipkart.KEY_Name, flipkart.getName());
//
//        // Inserting Row
//        flipkartId =(int)db.insert(Flipkart.TABLE, null, values);
//        DatabaseManager.getInstance().closeDatabase();
//
//        return flipkartId;
//    }
//
//    public void delete( ) {
//        SQLiteDatabase db = DatabaseManager.getInstance().openDatabase();
//        db.delete(Flipkart.TABLE,null,null);
//        DatabaseManager.getInstance().closeDatabase();
//    }
//}
