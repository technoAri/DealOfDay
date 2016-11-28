package com.example.hppc.dealofday.Activity;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.example.hppc.dealofday.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.Map;

public class ProductAvailabilityActivity extends AppCompatActivity {

    TextView prodName, prodDesc, amazonPrice, amazonBuy, flipkartPrice, flipkartBuy, paytmPrice, paytmBuy;
    private DatabaseReference mDatabase;
    String priceCoolpad, priceCoolpadF, priceCoolpadP;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_availability);

        prodName = (TextView)findViewById(R.id.tvProductName);
        prodDesc = (TextView)findViewById(R.id.tvProductDescription);
        amazonPrice = (TextView)findViewById(R.id.tvamazonPrice);
        amazonBuy = (TextView)findViewById(R.id.tvamazonBuy);
        flipkartPrice = (TextView)findViewById(R.id.tvflipkartPrice);
        flipkartBuy = (TextView)findViewById(R.id.tvflipkartBuy);
        paytmPrice = (TextView)findViewById(R.id.tvpaytmPrice);
        paytmBuy = (TextView)findViewById(R.id.tvpaytmBuy);

        mDatabase = FirebaseDatabase.getInstance()
                .getReferenceFromUrl("https://dealofday-26c4f.firebaseio.com/");

        mDatabase.child("Coolpad Note3").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for (DataSnapshot postSnapshot : dataSnapshot.getChildren()) {
                    postSnapshot.child("Coolpad Note Prime").getValue();

                    Map<String,Object> value = (Map<String, Object>) dataSnapshot.getValue();
                    priceCoolpad = String.valueOf(value.get("Amazon"));

                    //Displaying it on textview
                    //amazonProdName.setText();
                    //amazonPrice.setText("price: " + priceCoolpad);
//                            flipkartProdNeme.setText(flipkart.getProdName());
//                            flipkartPrice.setText("price: " + flipkart.getPrice());

                    Bundle bundle = getIntent().getExtras();
                    String prodPrice = bundle.getString("product");
                    if(prodPrice.equals("coolpad")){
                        prodName.setText("Coolpad Note3 Lite");
                        amazonPrice.setText(priceCoolpad);
                        flipkartPrice.setText(String.valueOf(value.get("Flipkart")));
                        paytmPrice.setText(String.valueOf(value.get("PayTm")));

                        if(!value.get("Amazon").equals("--")){
                            amazonBuy.setTextColor(Color.BLUE);
                        }
                        if(!value.get("Flipkart").equals("--")) {
                            flipkartBuy.setTextColor(Color.BLUE);
                        }
                        if(!value.get("PayTm") .equals("--")) {
                            paytmBuy.setTextColor(Color.BLUE);
                        }

                    }

                }
            }
            @Override
            public void onCancelled(DatabaseError databaseError) {
                System.out.println("The read failed: " + databaseError.getMessage());
            }
        });

        mDatabase.child("LG Washing Machine").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for (DataSnapshot postSnapshot : dataSnapshot.getChildren()) {
                    postSnapshot.child("LG Washing Machine").getValue();
                    Map<String,Object> value = (Map<String, Object>) dataSnapshot.getValue();
                    Bundle bundle = getIntent().getExtras();
                    String prodPrice = bundle.getString("product");
                    if(prodPrice.equals("LG Washing Machine")){
                        prodName.setText("LG Washing Machine");
                        amazonPrice.setText(String.valueOf(value.get("Amazon")));
                        flipkartPrice.setText(String.valueOf(value.get("Flipkart")));
                        paytmPrice.setText(String.valueOf(value.get("PayTm")));

                        if(!value.get("Amazon").equals("--")){
                            amazonBuy.setTextColor(Color.BLUE);
                        }
                        if(!value.get("Flipkart").equals("--")) {
                            flipkartBuy.setTextColor(Color.BLUE);
                        }
                        if(!value.get("PayTm") .equals("--")) {
                            paytmBuy.setTextColor(Color.BLUE);
                        }

                    }

                }
            }
            @Override
            public void onCancelled(DatabaseError databaseError) {
                System.out.println("The read failed: " + databaseError.getMessage());
            }
        });

        mDatabase.child("Lenovo k3 Note").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for (DataSnapshot postSnapshot : dataSnapshot.getChildren()) {
                    postSnapshot.child("Lenovo k3 Note").getValue();
                    Map<String,Object> value = (Map<String, Object>) dataSnapshot.getValue();
                    Bundle bundle = getIntent().getExtras();
                    String prodPrice = bundle.getString("product");
                    if(prodPrice.equals("Lenovo k3 Note")){
                        prodName.setText("Lenovo k3 Note");
                        amazonPrice.setText(String.valueOf(value.get("Amazon")));
                        flipkartPrice.setText(String.valueOf(value.get("Flipkart")));
                        paytmPrice.setText(String.valueOf(value.get("PayTm")));

                        if(!value.get("Amazon").equals("--")){
                            amazonBuy.setTextColor(Color.BLUE);
                        }
                        if(!value.get("Flipkart").equals("--")) {
                            flipkartBuy.setTextColor(Color.BLUE);
                        }
                        if(!value.get("PayTm") .equals("--")) {
                            paytmBuy.setTextColor(Color.BLUE);
                        }
                    }

                }
            }
            @Override
            public void onCancelled(DatabaseError databaseError) {
                System.out.println("The read failed: " + databaseError.getMessage());
            }
        });

        mDatabase.child("Fastrack Analog Watch for Men").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for (DataSnapshot postSnapshot : dataSnapshot.getChildren()) {
                    postSnapshot.child("Fastrack Analog Watch for Men").getValue();
                    Map<String,Object> value = (Map<String, Object>) dataSnapshot.getValue();
                    Bundle bundle = getIntent().getExtras();
                    String prodPrice = bundle.getString("product");
                    if(prodPrice.equals("Fastrack Analog Watch for Men")){
                        prodName.setText("Fastrack Analog Watch for Men");
                        amazonPrice.setText(String.valueOf(value.get("Amazon")));
                        flipkartPrice.setText(String.valueOf(value.get("Flipkart")));
                        paytmPrice.setText(String.valueOf(value.get("PayTm")));

                        if(!value.get("Amazon").equals("--")){
                            amazonBuy.setTextColor(Color.BLUE);
                        }
                        if(!value.get("Flipkart").equals("--")) {
                            flipkartBuy.setTextColor(Color.BLUE);
                        }
                        if(!value.get("PayTm") .equals("--")) {
                            paytmBuy.setTextColor(Color.BLUE);
                        }

                    }

                }
            }
            @Override
            public void onCancelled(DatabaseError databaseError) {
                System.out.println("The read failed: " + databaseError.getMessage());
            }
        });

        mDatabase.child("Coolpad Note Prime").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for (DataSnapshot postSnapshot : dataSnapshot.getChildren()) {
                    postSnapshot.child("Coolpad Note Prime").getValue();
                    Map<String,Object> value = (Map<String, Object>) dataSnapshot.getValue();
                    Bundle bundle = getIntent().getExtras();
                    String prodPrice = bundle.getString("product");
                    if(prodPrice.equals("Coolpad Note Prime")){
                        prodName.setText("Coolpad Note Prime");
                        amazonPrice.setText(String.valueOf(value.get("Amazon")));
                        flipkartPrice.setText(String.valueOf(value.get("Flipkart")));
                        paytmPrice.setText(String.valueOf(value.get("PayTm")));

                        if(!value.get("Amazon").equals("--")){
                            amazonBuy.setTextColor(Color.BLUE);
                        }
                        if(!value.get("Flipkart").equals("--")) {
                            flipkartBuy.setTextColor(Color.BLUE);
                        }
                        if(!value.get("PayTm") .equals("--")) {
                            paytmBuy.setTextColor(Color.BLUE);
                        }

                    }

                }
            }
            @Override
            public void onCancelled(DatabaseError databaseError) {
                System.out.println("The read failed: " + databaseError.getMessage());
            }
        });

        mDatabase.child("Levi's Dark blue Jeans").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for (DataSnapshot postSnapshot : dataSnapshot.getChildren()) {
                    postSnapshot.child("Levi's Dark blue Jeans").getValue();
                    Map<String,Object> value = (Map<String, Object>) dataSnapshot.getValue();
                    Bundle bundle = getIntent().getExtras();
                    String prodPrice = bundle.getString("product");
                    if(prodPrice.equals("Levi's Dark blue Jeans")){
                        prodName.setText("Levi's Dark blue Jeans");
                        amazonPrice.setText(String.valueOf(value.get("Amazon")));
                        flipkartPrice.setText(String.valueOf(value.get("Flipkart")));
                        paytmPrice.setText(String.valueOf(value.get("PayTm")));

                        if(!value.get("Amazon").equals("--")){
                            amazonBuy.setTextColor(Color.BLUE);
                        }
                        if(!value.get("Flipkart").equals("--")) {
                            flipkartBuy.setTextColor(Color.BLUE);
                        }
                        if(!value.get("PayTm") .equals("--")) {
                            paytmBuy.setTextColor(Color.BLUE);
                        }
                    }

                }
            }
            @Override
            public void onCancelled(DatabaseError databaseError) {
                System.out.println("The read failed: " + databaseError.getMessage());
            }
        });

        mDatabase.child("Moto G3").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for (DataSnapshot postSnapshot : dataSnapshot.getChildren()) {
                    postSnapshot.child("Moto G3").getValue();
                    Map<String,Object> value = (Map<String, Object>) dataSnapshot.getValue();
                    Bundle bundle = getIntent().getExtras();
                    String prodPrice = bundle.getString("product");
                    if(prodPrice.equals("Moto G3")){
                        prodName.setText("Moto G3");
                        amazonPrice.setText(String.valueOf(value.get("Amazon")));
                        flipkartPrice.setText(String.valueOf(value.get("Flipkart")));
                        paytmPrice.setText(String.valueOf(value.get("PayTm")));

                        if(!value.get("Amazon").equals("--")){
                            amazonBuy.setTextColor(Color.BLUE);
                        }
                        if(!value.get("Flipkart").equals("--")) {
                            flipkartBuy.setTextColor(Color.BLUE);
                        }
                        if(!value.get("PayTm") .equals("--")) {
                            paytmBuy.setTextColor(Color.BLUE);
                        }
                    }

                }
            }
            @Override
            public void onCancelled(DatabaseError databaseError) {
                System.out.println("The read failed: " + databaseError.getMessage());
            }
        });


        mDatabase.child("MotoE3").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for (DataSnapshot postSnapshot : dataSnapshot.getChildren()) {
                    postSnapshot.child("MotoE3").getValue();
                    Map<String,Object> value = (Map<String, Object>) dataSnapshot.getValue();
                    Bundle bundle = getIntent().getExtras();
                    String prodPrice = bundle.getString("product");
                    if(prodPrice.equals("MotoE3")){
                        prodName.setText("MotoE3");
                        amazonPrice.setText(String.valueOf(value.get("Amazon")));
                        flipkartPrice.setText(String.valueOf(value.get("Flipkart")));
                        paytmPrice.setText(String.valueOf(value.get("PayTm")));

                        if(!value.get("Amazon").equals("--")){
                            amazonBuy.setTextColor(Color.BLUE);
                        }
                        if(!value.get("Flipkart").equals("--")) {
                            flipkartBuy.setTextColor(Color.BLUE);
                        }
                        if(!value.get("PayTm") .equals("--")) {
                            paytmBuy.setTextColor(Color.BLUE);
                        }
                    }

                }
            }
            @Override
            public void onCancelled(DatabaseError databaseError) {
                System.out.println("The read failed: " + databaseError.getMessage());
            }
        });

        mDatabase.child("Nikon Coolpix S7000").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for (DataSnapshot postSnapshot : dataSnapshot.getChildren()) {
                    postSnapshot.child("Nikon Coolpix S7000").getValue();
                    Map<String,Object> value = (Map<String, Object>) dataSnapshot.getValue();
                    Bundle bundle = getIntent().getExtras();
                    String prodPrice = bundle.getString("product");
                    if(prodPrice.equals("Nikon Coolpix S7000")){
                        prodName.setText("Nikon Coolpix S7000");
                        amazonPrice.setText(String.valueOf(value.get("Amazon")));
                        flipkartPrice.setText(String.valueOf(value.get("Flipkart")));
                        paytmPrice.setText(String.valueOf(value.get("PayTm")));

                        if(!value.get("Amazon").equals("--")){
                            amazonBuy.setTextColor(Color.BLUE);
                        }
                        if(!value.get("Flipkart").equals("--")) {
                            flipkartBuy.setTextColor(Color.BLUE);
                        }
                        if(!value.get("PayTm") .equals("--")) {
                            paytmBuy.setTextColor(Color.BLUE);
                        }
                    }

                }
            }
            @Override
            public void onCancelled(DatabaseError databaseError) {
                System.out.println("The read failed: " + databaseError.getMessage());
            }
        });

        mDatabase.child("Samsung Galaxy S6").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for (DataSnapshot postSnapshot : dataSnapshot.getChildren()) {
                    postSnapshot.child("Samsung Galaxy S6").getValue();
                    Map<String,Object> value = (Map<String, Object>) dataSnapshot.getValue();
                    Bundle bundle = getIntent().getExtras();
                    String prodPrice = bundle.getString("product");
                    if(prodPrice.equals("Samsung Galaxy S6")){
                        prodName.setText("Samsung Galaxy S6");
                        amazonPrice.setText(String.valueOf(value.get("Amazon")));
                        flipkartPrice.setText(String.valueOf(value.get("Flipkart")));
                        paytmPrice.setText(String.valueOf(value.get("PayTm")));

                        if(!value.get("Amazon").equals("--")){
                            amazonBuy.setTextColor(Color.BLUE);
                        }
                        if(!value.get("Flipkart").equals("--")) {
                            flipkartBuy.setTextColor(Color.BLUE);
                        }
                        if(!value.get("PayTm") .equals("--")) {
                            paytmBuy.setTextColor(Color.BLUE);
                        }
                    }

                }
            }
            @Override
            public void onCancelled(DatabaseError databaseError) {
                System.out.println("The read failed: " + databaseError.getMessage());
            }
        });

        mDatabase.child("iPhone 6S").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for (DataSnapshot postSnapshot : dataSnapshot.getChildren()) {
                    postSnapshot.child("iPhone 6S").getValue();
                    Map<String,Object> value = (Map<String, Object>) dataSnapshot.getValue();
                    Bundle bundle = getIntent().getExtras();
                    String prodPrice = bundle.getString("product");
                    if(prodPrice.equals("iPhone 6S")){
                        prodName.setText("iPhone 6S");
                        amazonPrice.setText(String.valueOf(value.get("Amazon")));
                        flipkartPrice.setText(String.valueOf(value.get("Flipkart")));
                        paytmPrice.setText(String.valueOf(value.get("PayTm")));

                        if(!value.get("Amazon").equals("--")){
                            amazonBuy.setTextColor(Color.BLUE);
                        }
                        if(!value.get("Flipkart").equals("--")) {
                            flipkartBuy.setTextColor(Color.BLUE);
                        }
                        if(!value.get("PayTm") .equals("--")) {
                            paytmBuy.setTextColor(Color.BLUE);
                        }
                    }

                }
            }
            @Override
            public void onCancelled(DatabaseError databaseError) {
                System.out.println("The read failed: " + databaseError.getMessage());
            }
        });
        mDatabase.child("Sony Bravia KLV-32R302D 32 Inch").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for (DataSnapshot postSnapshot : dataSnapshot.getChildren()) {
                    postSnapshot.child("Sony Bravia KLV-32R302D 32 Inch").getValue();
                    Map<String,Object> value = (Map<String, Object>) dataSnapshot.getValue();
                    Bundle bundle = getIntent().getExtras();
                    String prodPrice = bundle.getString("product");
                    if(prodPrice.equals("Sony Bravia KLV-32R302D 32 Inch")){
                        prodName.setText("Sony Bravia KLV-32R302D 32 Inch");
                        amazonPrice.setText(String.valueOf(value.get("Amazon")));
                        flipkartPrice.setText(String.valueOf(value.get("Flipkart")));
                        paytmPrice.setText(String.valueOf(value.get("PayTm")));

                        if(value.get("Amazon")!= "--"){
                            amazonBuy.setTextColor(Color.BLUE);
                        }
                        if(!value.get("Flipkart").equals("--")) {
                            flipkartBuy.setTextColor(Color.BLUE);
                        }
                        if(!value.get("PayTm") .equals("--")) {
                            paytmBuy.setTextColor(Color.BLUE);
                        }
                    }

                }
            }
            @Override
            public void onCancelled(DatabaseError databaseError) {
                System.out.println("The read failed: " + databaseError.getMessage());
            }
        });
    }
}
