package com.example.hppc.dealofday.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.hppc.dealofday.R;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.text.DateFormat;
import java.util.Calendar;
import java.util.Date;

public class HomeScreenActivityNew extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    TextView textViewDateTime;
    Button categoryButton;
    AutoCompleteTextView search;
    ImageButton amazon, flipkart, ebay, paytm, snapdeal;
    ImageView imageViewProd1, imageViewProd2, imageViewProd3, imageViewProd4;
    private DatabaseReference mDatabase;
    public static final String FIREBASE_URL = "https://dealofday-26c4f.firebaseio.com/";
    Bundle bundle;

    String[] products = {"Apple MacBook Air MMGF2HN", "Apple MacBook Pro MJLQ2HN", "Apple MacBook Pro MLH32HN",
            "Apple iPhone 6 (Space Gre", "Apple iPhone 6s (Space Gr", "Apple iPhone 7 (Black, 32", "Coolpad Note 5 Lite",
            "Dell Inspiron 7559 UltraH", "Inspiron i7-15RSLV Dell 1", "MSI GE62VR 7RF Apache Pro", "Mi Air Capsule Earphones",
            "Mi Basic In-Ear Headphone", "Micromax Canvas 6 Pro", "Moto G Play, 4th Gen", "OnePlus 3T (Gunmetal, 6GB",
            "Samsung Galaxy J7", "Samsung Galaxy S7", "Samsung On5 Pro", "Samsung On7 Pro", "Seagate Backup Plus Slim",
            "Seiko Men's SNK803 Seiko", "WD Elements 1TB Portable", "WD Elements 2TB Portable"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_screen_new);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar_activities);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        mDatabase = FirebaseDatabase.getInstance()
                .getReferenceFromUrl("https://dealofday-26c4f.firebaseio.com/");


        textViewDateTime = (TextView) findViewById(R.id.tvDateTime);
        categoryButton = (Button) findViewById(R.id.btn_category);
        amazon = (ImageButton) findViewById(R.id.amazonLogo);
        flipkart = (ImageButton) findViewById(R.id.flipkartLogo);
        ebay = (ImageButton) findViewById(R.id.ebayLogo);
        paytm = (ImageButton) findViewById(R.id.paytmLogo);
        snapdeal = (ImageButton) findViewById(R.id.snapdealLogo);
        imageViewProd1 = (ImageView) findViewById(R.id.coolpadImageTrend);
        imageViewProd2 = (ImageView) findViewById(R.id.watchImageTrend);
        imageViewProd3 = (ImageView) findViewById(R.id.miImageTrend);
        imageViewProd4 = (ImageView) findViewById(R.id.wmImageTrend);

        final String currentDateTimeString = DateFormat.getDateTimeInstance().format(new Date());
        CountDownTimer newtimer = new CountDownTimer(1000000000, 1000) {

            public void onTick(long millisUntilFinished) {
                Calendar c = Calendar.getInstance();
                String dateTime = ((DateFormat.getDateInstance().format(new Date()) + " " + c.get(Calendar.HOUR) + ":" + c.get(Calendar.MINUTE) + ":" + c.get(Calendar.SECOND)));
                textViewDateTime.setText(dateTime);
            }

            public void onFinish() {

            }
        };
        newtimer.start();

        //deal of day buttons
        amazon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent activityIntent = new Intent(HomeScreenActivityNew.this, WebViewActivity.class);
                activityIntent.putExtra("keyName", "amazon");
                startActivity(activityIntent);
            }
        });
        flipkart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent activityIntent = new Intent(HomeScreenActivityNew.this, WebViewActivity.class);
                activityIntent.putExtra("keyName", "flipkart");
                startActivity(activityIntent);
            }
        });
        snapdeal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent activityIntent = new Intent(HomeScreenActivityNew.this, WebViewActivity.class);
                activityIntent.putExtra("keyName", "snapdeal");
                startActivity(activityIntent);
            }
        });
        paytm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent activityIntent = new Intent(HomeScreenActivityNew.this, WebViewActivity.class);
                activityIntent.putExtra("keyName", "payTm");
                startActivity(activityIntent);
            }
        });
        ebay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent activityIntent = new Intent(HomeScreenActivityNew.this, WebViewActivity.class);
                activityIntent.putExtra("keyName", "ebay");
                startActivity(activityIntent);
            }
        });

        imageViewProd1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentTrnd = new Intent(HomeScreenActivityNew.this, WebViewActivity.class);
                intentTrnd.putExtra("keyName", "coolpad");
                startActivity(intentTrnd);
            }
        });
        imageViewProd2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentTrnd = new Intent(HomeScreenActivityNew.this, WebViewActivity.class);
                intentTrnd.putExtra("keyName", "watch");
                startActivity(intentTrnd);
            }
        });
        imageViewProd3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentTrnd = new Intent(HomeScreenActivityNew.this, WebViewActivity.class);
                intentTrnd.putExtra("keyName", "mi");
                startActivity(intentTrnd);
            }
        });
        imageViewProd4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentTrnd = new Intent(HomeScreenActivityNew.this, WebViewActivity.class);
                intentTrnd.putExtra("keyName", "wm");
                startActivity(intentTrnd);
            }
        });

        categoryButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomeScreenActivityNew.this, CategoryActivity.class);
                startActivity(intent);
            }
        });

        search = (AutoCompleteTextView) findViewById(R.id.autoCompleteTextView1);

        ArrayAdapter adapter = new
                ArrayAdapter(this, android.R.layout.simple_list_item_1, products);

        search.setAdapter(adapter);
        search.setThreshold(1);

        // for search
        search.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                bundle = new Bundle();
                if (search.getText().toString().equals("Apple MacBook Air MMGF2HN")) {
                    bundle.putString("product", "Apple MacBook Air MMGF2HN");
                } else if (search.getText().toString().equals("Apple MacBook Pro MJLQ2HN")) {
                    bundle.putString("product", "Apple MacBook Pro MJLQ2HN");
                } else if (search.getText().toString().equals("Apple MacBook Pro MLH32HN")) {
                    bundle.putString("product", "Apple MacBook Pro MLH32HN");
                } else if (search.getText().toString().equals("Apple iPhone 6 (Space Gre")) {
                    bundle.putString("product", "Apple iPhone 6 (Space Gre");
                } else if (search.getText().toString().equals("Apple iPhone 6s (Space Gr")) {
                    bundle.putString("product", "Apple iPhone 6s (Space Gr");
                } else if (search.getText().toString().equals("Apple iPhone 7 (Black, 32")) {
                    bundle.putString("product", "Apple iPhone 7 (Black, 32");
                } else if (search.getText().toString().equals("Coolpad Note 5 Lite")) {
                    bundle.putString("product", "Coolpad Note 5 Lite");
                } else if (search.getText().toString().equals("Dell Inspiron 7559 UltraH")) {
                    bundle.putString("product", "Dell Inspiron 7559 UltraH");
                } else if (search.getText().toString().equals("Inspiron i7-15RSLV Dell 1")) {
                    bundle.putString("product", "Inspiron i7-15RSLV Dell 1");
                } else if (search.getText().toString().equals("MSI GE62VR 7RF Apache Pro")) {
                    bundle.putString("product", "MSI GE62VR 7RF Apache Pro");
                } else if (search.getText().toString().equals("Mi Air Capsule Earphones")) {
                    bundle.putString("product", "Mi Air Capsule Earphones");
                } else if (search.getText().toString().equals("Mi Basic In-Ear Headphone")) {
                    bundle.putString("product", "Mi Basic In-Ear Headphone");
                } else if (search.getText().toString().equals("Micromax Canvas 6 Pro")) {
                    bundle.putString("product", "Micromax Canvas 6 Pro");

                } else if (search.getText().toString().equals("Moto G Play, 4th Gen")) {
                    bundle.putString("product", "Moto G Play, 4th Gen");

                } else if (search.getText().toString().equals("OnePlus 3T (Gunmetal, 6GB")) {
                    bundle.putString("product", "OnePlus 3T (Gunmetal, 6GB");

                } else if (search.getText().toString().equals("Samsung Galaxy J7")) {
                    bundle.putString("product", "Samsung Galaxy J7");

                } else if (search.getText().toString().equals("Samsung Galaxy S7")) {
                    bundle.putString("product", "Samsung Galaxy S7");

                } else if (search.getText().toString().equals("Samsung On5 Pro")) {
                    bundle.putString("product", "Samsung On5 Pro");

                } else if (search.getText().toString().equals("Samsung On7 Pro")) {
                    bundle.putString("product", "Samsung On7 Pro");

                } else if (search.getText().toString().equals("Seagate Backup Plus Slim")) {
                    bundle.putString("product", "Seagate Backup Plus Slim");

                } else if (search.getText().toString().equals("Seiko Men's SNK803 Seiko")) {
                    bundle.putString("product", "Seiko Men's SNK803 Seiko");

                } else if (search.getText().toString().equals("WD Elements 1TB Portable")) {
                    bundle.putString("product", "WD Elements 1TB Portable");

                } else if (search.getText().toString().equals("WD Elements 2TB Portable")) {
                    bundle.putString("product", "WD Elements 2TB Portable");

                } else {
                    Toast.makeText(getApplicationContext(), "Sorry! this product is not in our Database...", Toast.LENGTH_SHORT).show();
                }

                Intent i = new Intent(HomeScreenActivityNew.this, ProductAvailabilityActivity.class);
                i.putExtras(bundle);
                startActivity(i);


            }
        });
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.home_screen_activity_new, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_amazon) {
            Intent activityIntent = new Intent(HomeScreenActivityNew.this, WebViewActivity.class);
            activityIntent.putExtra("keyName", "amazon");
            startActivity(activityIntent);
        } else if (id == R.id.nav_flipkart) {
            Intent activityIntent = new Intent(HomeScreenActivityNew.this, WebViewActivity.class);
            activityIntent.putExtra("keyName", "flipkart");
            startActivity(activityIntent);

        } else if (id == R.id.nav_snapdeal) {
            Intent activityIntent = new Intent(HomeScreenActivityNew.this, WebViewActivity.class);
            activityIntent.putExtra("keyName", "snapdeal");
            startActivity(activityIntent);

        } else if (id == R.id.nav_paytm) {
            Intent activityIntent = new Intent(HomeScreenActivityNew.this, WebViewActivity.class);
            activityIntent.putExtra("keyName", "payTm");
            startActivity(activityIntent);

        } else if (id == R.id.nav_ebay) {
            Intent activityIntent = new Intent(HomeScreenActivityNew.this, WebViewActivity.class);
            activityIntent.putExtra("keyName", "ebay");
            startActivity(activityIntent);

        } else if (id == R.id.nav_send) {
            Intent activityIntent = new Intent(HomeScreenActivityNew.this, ContactDeveloperActivity.class);
            startActivity(activityIntent);
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
