//package com.example.hppc.dealofday.Repository;
//
//import android.content.ContentValues;
//import android.database.sqlite.SQLiteDatabase;
//import com.example.hppc.dealofday.DataBase.Lenovok3Note;
//import com.example.hppc.dealofday.DatabaseManager;
//
///**
// * Created by HP PC on 11/24/2016.
// */
//public class FlipkartRepo {
//
//    private Lenovok3Note flipkart;
//
//    public FlipkartRepo(){
//
//        flipkart = new Lenovok3Note();
//
//    }
//
//    public static String createTable(){
//        return "CREATE TABLE " + Lenovok3Note.TABLE  + "("
//                + Lenovok3Note.KEY_FlipkartId + "   PRIMARY KEY    ,"
//                + Lenovok3Note.KEY_Name + " TEXT )";
//    }
//
//
//    public int insert(Lenovok3Note flipkart) {
//        int flipkartId;
//        SQLiteDatabase db = DatabaseManager.getInstance().openDatabase();
//        ContentValues values = new ContentValues();
//        values.put(Lenovok3Note.KEY_FlipkartId, flipkart.getFlipkartId());
//        values.put(Lenovok3Note.KEY_Name, flipkart.getName());
//
//        // Inserting Row
//        flipkartId =(int)db.insert(Lenovok3Note.TABLE, null, values);
//        DatabaseManager.getInstance().closeDatabase();
//
//        return flipkartId;
//    }
//
//    public void delete( ) {
//        SQLiteDatabase db = DatabaseManager.getInstance().openDatabase();
//        db.delete(Lenovok3Note.TABLE,null,null);
//        DatabaseManager.getInstance().closeDatabase();
//    }
//}
