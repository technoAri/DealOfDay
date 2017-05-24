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
import android.widget.Toast;

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
    ImageView backButton;
    Bundle bundle;
    String product;
    public static String amazonLink, flipkartLink, snapdealLink;

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
                        if (cost != null)
                            amazonPrice.setText(cost);
                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {
                        Toast.makeText(getApplicationContext(), "Some error occured. Check your internet connection and try again...", Toast.LENGTH_SHORT).show();
                    }
                });
        if (product.contains("MacBook"))
            prodDesc.setText("Apple OS X MacBook Laptop");
        else if (product.contains("iPhone"))
            prodDesc.setText("ios smartphone 5.5 inch");
        else if (product.contains("Coolpad") || product.contains("Moto") || product.contains("OnePlus") || product.contains("Samsung") || product.contains("Micromax"))
            prodDesc.setText("Android smart phone 5.5 inch");
        else if (product.contains("Inspiron"))
            prodDesc.setText("Dell Laptop");
        else if (product.contains("Mi"))
            prodDesc.setText("Mi high quality earphones");
        else if (product.contains("WD") || product.contains("Seagate"))
            prodDesc.setText("WD hard disk");
        else if (product.contains("MSI"))
            prodDesc.setText("MSI Laptop Core i7/ 16 GB/ 1 TB");
        else if (product.contains("Seiko"))
            prodDesc.setText("Seiko Men's Analog watch");
        DatabaseReference amazonRef2 = amaziRref.child(product).child("link");
        amazonRef2.addListenerForSingleValueEvent(
                new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {

                        amazonLink = dataSnapshot.getValue(String.class);
                        if (amazonLink != null) {
                            if (!amazonLink.equals("-")) {
                                amazonBuy.setTextColor(Color.BLUE);
                                amazonBuy.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View v) {
                                        Intent intent = new Intent(ProductAvailabilityActivity.this, WebViewActivity.class);
                                        intent.putExtra("keyName", "buyAmazon");
                                        startActivity(intent);
                                    }
                                });
                            }
                        }
                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {
                        Toast.makeText(getApplicationContext(), "Some error occured. Check your internet connection and try again...", Toast.LENGTH_SHORT).show();
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
                        if (cost != null)
                            flipkartPrice.setText(cost);
                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {
                        Toast.makeText(getApplicationContext(), "Some error occured. Check your internet connection and try again...", Toast.LENGTH_SHORT).show();
                    }
                });
        DatabaseReference flipkartRef2 = flipkartRref.child(product).child("link");
        flipkartRef2.addListenerForSingleValueEvent(
                new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {

                        flipkartLink = dataSnapshot.getValue(String.class);
                        if (flipkartLink != null) {
                            if (!flipkartLink.equals("-")) {
                                flipkartBuy.setTextColor(Color.BLUE);
                                flipkartBuy.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View v) {
                                        Intent intent = new Intent(ProductAvailabilityActivity.this, WebViewActivity.class);
                                        intent.putExtra("keyName", "buyFlipkart");
                                        startActivity(intent);
                                    }
                                });
                            }
                        }
                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {
                        Toast.makeText(getApplicationContext(), "Some error occured. Check your internet connection and try again...", Toast.LENGTH_SHORT).show();
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
                        if (cost != null)
                        paytmPrice.setText(cost);
                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {
                        Toast.makeText(getApplicationContext(), "Some error occured. Check your internet connection and try again...", Toast.LENGTH_SHORT).show();
                    }
                });

        DatabaseReference snapdealRef2 = snapdealRref.child(product).child("link");
        snapdealRef2.addListenerForSingleValueEvent(
                new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        snapdealLink = dataSnapshot.getValue(String.class);
                        if (snapdealLink != null) {
                            if (!snapdealLink.equals("-")) {
                                paytmBuy.setTextColor(Color.BLUE);
                                paytmBuy.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View v) {
                                        Intent intent = new Intent(ProductAvailabilityActivity.this, WebViewActivity.class);
                                        intent.putExtra("keyName", "buySnapdeal");
                                        startActivity(intent);
                                    }
                                });
                            }
                        }
                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {
                        Toast.makeText(getApplicationContext(), "Some error occured. Check your internet connection and try again...", Toast.LENGTH_SHORT).show();
                    }
                });

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {

        }
        return super.onOptionsItemSelected(item);
    }
}
