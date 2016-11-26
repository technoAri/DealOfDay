package com.example.hppc.dealofday.Activity;

import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.os.CountDownTimer;
import android.provider.SyncStateContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Config;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.hppc.dealofday.DataBase.Amazon;
import com.example.hppc.dealofday.DataBase.Flipkart;
import com.example.hppc.dealofday.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.text.DateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class HomeScreenActivity extends AppCompatActivity {

    TextView textViewDateTime, amazonProdName, flipkartProdNeme, amazonPrice, flipkartPrice;
    Button categoryButton;
    AutoCompleteTextView search;
    ImageButton amazon, flipkart, ebay, paytm;
    private DatabaseReference mDatabase;
    public static final String FIREBASE_URL = "https://dealofday-26c4f.firebaseio.com/";

    String[] products = {"Coolpad Note 3 Lite","Coolpad New","Moto E3","Moto X","Moto G3","Samsung Galaxy Note7", "Redmi 2 Prime"};

    //@TargetApi(Build.VERSION_CODES.N)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_screen);

        //FirebaseDatabase.getInstance().setPersistenceEnabled(true);
       // mDatabase = FirebaseDatabase.getInstance().getReference();
        mDatabase = FirebaseDatabase.getInstance()
                .getReferenceFromUrl("https://dealofday-26c4f.firebaseio.com/");


        textViewDateTime  = (TextView) findViewById(R.id.tvDateTime);
        amazonProdName = (TextView)findViewById(R.id.tvproductnameAmazon);
        flipkartProdNeme = (TextView)findViewById(R.id.tvproductnameFlipkart);
        amazonPrice = (TextView)findViewById(R.id.tvproductpriceAmazon);
        flipkartPrice = (TextView)findViewById(R.id.tvproductpriceFlipkart);
        categoryButton = (Button) findViewById(R.id.btn_category);
        amazon = (ImageButton) findViewById(R.id.amazonLogo);
        flipkart = (ImageButton) findViewById(R.id.flipkartLogo);
        ebay = (ImageButton) findViewById(R.id.ebayLogo);
        paytm = (ImageButton) findViewById(R.id.paytmLogo);

        search = (AutoCompleteTextView)findViewById(R.id.autoCompleteTextView1);

        ArrayAdapter adapter = new
                ArrayAdapter(this,android.R.layout.simple_list_item_1,products);

        search.setAdapter(adapter);
        search.setThreshold(1);

        categoryButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = "Moto E3";
                String price = "5665";

                //Creating Person object
                final Amazon amazon = new Amazon();

                //Adding values
                amazon.setProdName(name);
                amazon.setPrice(price);

                //Storing values to firebase
                mDatabase.child("Amazon").setValue(amazon);

                String nameF = "Coolpad Note3";
                String priceF = "7000";
                final Flipkart flipkart = new Flipkart();

                flipkart.setProdName(nameF);
                flipkart.setPrice((priceF));
                mDatabase.child("Flipkart").setValue(flipkart);
                //mDatabase.push();

                mDatabase.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        for (DataSnapshot postSnapshot : dataSnapshot.getChildren()) {
                            //Getting the data from snapshot
//                            Amazon amazon = postSnapshot.getValue(Amazon.class);
//
//                            Flipkart flipkart = postSnapshot.getValue(Flipkart.class);

                            //Adding it to a string
                            String string = amazon.getProdName();

                            //Displaying it on textview
                            amazonProdName.setText(string);
                            amazonPrice.setText("price: "+amazon.getPrice());
                            flipkartProdNeme.setText(flipkart.getProdName());
                            flipkartPrice.setText("price: "+flipkart.getPrice());

                        }
                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {
                        System.out.println("The read failed: " + databaseError.getMessage());
                    }
                });

            }
        });

        final String currentDateTimeString = DateFormat.getDateTimeInstance().format(new Date());
        CountDownTimer newtimer = new CountDownTimer(1000000000, 1000) {

            public void onTick(long millisUntilFinished) {
                Calendar c = Calendar.getInstance();
                String dateTime = ((DateFormat.getDateInstance().format(new Date())+ "\n" + c.get(Calendar.HOUR)+":"+c.get(Calendar.MINUTE)+":"+c.get(Calendar.SECOND)));
                textViewDateTime.setText(dateTime);
            }
            public void onFinish() {

            }
        };
        newtimer.start();
        //insertSampleData();

        amazon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent activityIntent = new Intent(HomeScreenActivity.this, WebViewActivity.class);
                activityIntent.putExtra("keyName","amazon");
                startActivity(activityIntent);
            }
        });
        flipkart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent activityIntent = new Intent(HomeScreenActivity.this, WebViewActivity.class);
                activityIntent.putExtra("keyName","flipkart");
                startActivity(activityIntent);
            }
        });
    }

//    private void insertSampleData() {
//        AmazonRepo amazonRepo = new AmazonRepo();
//        FlipkartRepo flipkartRepo  = new FlipkartRepo();
//
//        amazonRepo.delete();
//        flipkartRepo.delete();
//
//        Amazon amazon = new Amazon();
//
//        amazon.setName("Moto E3");
//        amazon.setAmazonId("a1");
//        amazonRepo.insert(amazon);
//
//        amazon.setName("Moto g3");
//        amazon.setAmazonId("a2");
//        amazonRepo.insert(amazon);
//
//        amazon.setName("Moto X4");
//        amazon.setAmazonId("a3");
//        amazonRepo.insert(amazon);
//
//        amazon.setName("Coolpad Note 3 Lite");
//        amazon.setAmazonId("a4");
//        amazonRepo.insert(amazon);
//
//        amazon.setName("Coolpad New");
//        amazon.setAmazonId("a5");
//        amazonRepo.insert(amazon);
//
//        Flipkart flipkart = new Flipkart();
//
//        flipkart.setName("Moto E3");
//        flipkart.setFlipkartId("b1");
//        flipkartRepo.insert(flipkart);
//
//        flipkart.setName("Moto X Play");
//        flipkart.setFlipkartId("b2");
//        flipkartRepo.insert(flipkart);
//
//        flipkart.setName("Redmi Note Prime");
//        flipkart.setFlipkartId("b3");
//        flipkartRepo.insert(flipkart);
//
//        flipkart.setName("Samsung Galaxy s6");
//        flipkart.setFlipkartId("b4");
//        flipkartRepo.insert(flipkart);
//
//        flipkart.setName("Micromax Canvas spark");
//        flipkart.setFlipkartId("b5");
//        flipkartRepo.insert(flipkart);
//
//    }
}
