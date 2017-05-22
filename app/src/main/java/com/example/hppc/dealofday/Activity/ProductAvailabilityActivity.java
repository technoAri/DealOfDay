package com.example.hppc.dealofday.Activity;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.hppc.dealofday.R;
import com.example.hppc.dealofday.Repository.Amazon;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.Map;

public class ProductAvailabilityActivity extends AppCompatActivity {

    TextView prodName, prodDesc, amazonPrice, amazonBuy, flipkartPrice, flipkartBuy, paytmPrice, paytmBuy;
    private DatabaseReference mDatabase;
    ImageView backButton;
    Bundle bundle;
    String product;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_availability);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar_activities_new);
        if (toolbar != null)
            setSupportActionBar(toolbar);
        getSupportActionBar().setTitle(null);

        prodName = (TextView) findViewById(R.id.tvProductName);
        prodDesc = (TextView) findViewById(R.id.tvProductDescription);
        amazonPrice = (TextView) findViewById(R.id.tvamazonPrice);
        amazonBuy = (TextView) findViewById(R.id.tvamazonBuy);
        flipkartPrice = (TextView) findViewById(R.id.tvflipkartPrice);
        flipkartBuy = (TextView) findViewById(R.id.tvflipkartBuy);
        paytmPrice = (TextView) findViewById(R.id.tvpaytmPrice);
        paytmBuy = (TextView) findViewById(R.id.tvpaytmBuy);
        backButton = (ImageView) findViewById(R.id.back_button);

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        mDatabase = FirebaseDatabase.getInstance()
                .getReferenceFromUrl("https://dealofday-26c4f.firebaseio.com/");

        bundle = getIntent().getExtras();
        product = bundle.getString("product");

        DatabaseReference amaziRref = FirebaseDatabase.getInstance().getReference().child("amazon");
        DatabaseReference amazonRef1 = amaziRref.child(product).child("cost");
        amazonRef1.addListenerForSingleValueEvent(
                new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {

                        prodName.setText(product);
                        String cost = dataSnapshot.getValue(String.class);
                        amazonPrice.setText(cost);

                        //Get map of users in datasnapshot
//                        for (DataSnapshot postSnapshot : dataSnapshot.getChildren()) {
//                            String cost = (String) postSnapshot.child("amazon").child(product).child("cost").getValue().toString();
//                            System.out.println(cost);
//                            amazonPrice.setText(postSnapshot.child("amazon").child(product).getValue().toString());
//                            Map<String, Object> value = ((Map<String, Object>) dataSnapshot.getValue());
//                            System.out.println(value);
//                        }
                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {
                        //handle databaseError
                    }
                });
        DatabaseReference flipkartRref = FirebaseDatabase.getInstance().getReference().child("flipkar");
        DatabaseReference flipkartRef1 = flipkartRref.child(product).child("cost");
        flipkartRef1.addListenerForSingleValueEvent(
                new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {

                        prodName.setText(product);
                        String cost = dataSnapshot.getValue(String.class);
                        flipkartPrice.setText(cost);
                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {
                        //handle databaseError
                    }
                });

        DatabaseReference snapdealRref = FirebaseDatabase.getInstance().getReference().child("snapdea");
        DatabaseReference snapdealRef1 = snapdealRref.child(product).child("cost");
        snapdealRef1.addListenerForSingleValueEvent(
                new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {

                        prodName.setText(product);
                        String cost = dataSnapshot.getValue(String.class);
                        paytmPrice.setText(cost);
                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {
                        //handle databaseError
                    }
                });

//        mDatabase.child("amazon").addValueEventListener(new ValueEventListener() {
//            @Override
//            public void onDataChange(DataSnapshot dataSnapshot) {
//                for (DataSnapshot postSnapshot : dataSnapshot.getChildren()) {
//                    postSnapshot.child("amazon").getValue();
//
//                    Map<String, Object> value = (Map<String, Object>) dataSnapshot.getValue();
//                    priceCoolpad = String.valueOf(value.get("Amazon"));
//
//                    if (product.equals("coolpad")) {
//                        prodName.setText(product);
//                        amazonPrice.setText(priceCoolpad);
//                        flipkartPrice.setText(String.valueOf(value.get("Flipkart")));
//                        paytmPrice.setText(String.valueOf(value.get("PayTm")));
//                        prodDesc.setText("Smartphone Android 5.1 \n 5 inch display");
//
//                        if (!value.get("Amazon").equals("--")) {
//                            amazonBuy.setTextColor(Color.BLUE);
//                        }
//                        if (!value.get("Flipkart").equals("--")) {
//                            flipkartBuy.setTextColor(Color.BLUE);
//                        }
//                        if (!value.get("PayTm").equals("--")) {
//                            paytmBuy.setTextColor(Color.BLUE);
//                        }
//                        amazonBuy.setOnClickListener(new View.OnClickListener() {
//                            @Override
//                            public void onClick(View v) {
//                                Intent i = new Intent(ProductAvailabilityActivity.this, WebViewActivity.class);
//                                i.putExtra("keyName", "coolpad");
//                                startActivity(i);
//                            }
//                        });
//                    }
//
//                }
//            }
//
//            @Override
//            public void onCancelled(DatabaseError databaseError) {
//                System.out.println("The read failed: " + databaseError.getMessage());
//            }
//        });
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch(item.getItemId()){

        }
        return super.onOptionsItemSelected(item);
    }
}
