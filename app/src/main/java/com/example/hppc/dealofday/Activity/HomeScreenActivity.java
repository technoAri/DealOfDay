package com.example.hppc.dealofday.Activity;

import android.content.Intent;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.hppc.dealofday.DataBase.CoolpadNote3;
import com.example.hppc.dealofday.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

public class HomeScreenActivity extends AppCompatActivity {

    TextView textViewDateTime, amazonProdName, flipkartProdNeme, amazonPrice, flipkartPrice;
    Button categoryButton;
    AutoCompleteTextView search;
    ImageButton amazon, flipkart, ebay, paytm;
    private DatabaseReference mDatabase;
    public static final String FIREBASE_URL = "https://dealofday-26c4f.firebaseio.com/";
    Bundle bundle;

    String[] products = {"Coolpad Note3","Sony Bravia KLV-32R302D 32 Inch","Moto E3","Coolpad Note Prime","Moto G3","Fastrack Analog Watch for Men", "LG Washing Machine", "Lenovo k3 Note", "Levi's Dark blue Jeans", "Nikon Coolpix S7000", "Samsung Galaxy S6", "iPhone 6S"};

    //@TargetApi(Build.VERSION_CODES.N)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_screen);

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

        search.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                bundle = new Bundle();
                if(search.getText().toString().equals("Coolpad Note3")){
                    bundle.putString("product", "coolpad");
                }
                else if(search.getText().toString().equals("LG Washing Machine")) {
                    bundle.putString("product", "LG Washing Machine");
                }
                else if(search.getText().toString().equals("Lenovo k3 Note")) {
                    bundle.putString("product", "Lenovo k3 Note");
                }
                else if(search.getText().toString().equals("Fastrack Analog Watch for Men")) {
                    bundle.putString("product", "Fastrack Analog Watch for Men");
                }
                else if(search.getText().toString().equals("Coolpad Note Prime")) {
                    bundle.putString("product", "Coolpad Note Prime");
                }
                else if(search.getText().toString().equals("Levi's Dark blue Jeans")) {
                    bundle.putString("product", "Levi's Dark blue Jeans");
                }
                else if(search.getText().toString().equals("Moto G3")) {
                    bundle.putString("product", "Moto G3");
                }
                else if(search.getText().toString().equals("MotoE3")) {
                    bundle.putString("product", "MotoE3");
                }
                else if(search.getText().toString().equals("Nikon Coolpix S7000")) {
                    bundle.putString("product", "Nikon Coolpix S7000");
                }
                else if(search.getText().toString().equals("Samsung Galaxy S6")) {
                    bundle.putString("product", "Samsung Galaxy S6");
                }
                else if(search.getText().toString().equals("iPhone 6S")) {
                    bundle.putString("product", "iPhone 6S");
                }
                else if(search.getText().toString().equals("Sony Bravia KLV-32R302D 32 Inch")) {
                    bundle.putString("product", "Sony Bravia KLV-32R302D 32 Inch");
                }
                Intent i = new Intent(HomeScreenActivity.this, ProductAvailabilityActivity.class);
                i.putExtras(bundle);
                startActivity(i);
            }
        });
        categoryButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                String name = "Moto E3";
//                String price = "5665";
//
//                //Creating Person object
                //final CoolpadNote3 amazonPriceCoolpad = new CoolpadNote3();
//
//                //Adding values
//                amazon.setProdName(name);
//                amazon.setPrice(price);
//
//                //Storing values to firebase
//                mDatabase.child("CoolpadNote3").setValue(amazon);
//
//                String nameF = "Coolpad Note3";
//                String priceF = "7000";
               // final CoolpadNote3 flipkart = new CoolpadNote3();
//
//                flipkart.setProdName(nameF);
//                flipkart.setPrice((priceF));
                //mDatabase.child("CoolpadNote3").setValue(flipkart);
                //mDatabase.push();

                mDatabase.child("Coolpad Note3").addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        for (DataSnapshot postSnapshot : dataSnapshot.getChildren()) {
                            postSnapshot.child("Coolpad Note Prime").getValue();

                            Map<String,Object> value = (Map<String, Object>) dataSnapshot.getValue();
                            String name1 = String.valueOf(value.get("Amazon"));
                            //Displaying it on textview
                            //amazonProdName.setText();
                            amazonPrice.setText("price: " + name1);
//                            flipkartProdNeme.setText(flipkart.getProdName());
//                            flipkartPrice.setText("price: " + flipkart.getPrice());

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
//        CoolpadNote3 amazon = new CoolpadNote3();
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
//        Lenovok3Note flipkart = new Lenovok3Note();
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
