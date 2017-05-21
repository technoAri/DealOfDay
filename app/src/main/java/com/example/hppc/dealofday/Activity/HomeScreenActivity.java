package com.example.hppc.dealofday.Activity;

import android.content.Intent;
import android.os.CountDownTimer;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.hppc.dealofday.Adapters.DrawerItemCustomAdapter;
import com.example.hppc.dealofday.DataBase.CoolpadNote3;
import com.example.hppc.dealofday.Object.ObjectDrawerItem;
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
    ImageView menuButton;
    Button categoryButton;
    AutoCompleteTextView search;
    ImageButton amazon, flipkart, ebay, paytm, snapdeal;
    ImageView imageViewProd1;
    private DatabaseReference mDatabase;
    public static final String FIREBASE_URL = "https://dealofday-26c4f.firebaseio.com/";
    Bundle bundle;

    private String[] mNavigationDrawerItemTitles;
    public static DrawerLayout mDrawerLayout;
    private ListView mDrawerList;

    String[] products = {"Apple MacBook Air MMGF2HN", "Apple MacBook Pro MJLQ2HN", "Moto E3", "Coolpad Note Prime", "Moto G3", "Fastrack Analog Watch for Men", "LG Washing Machine", "Lenovo k3 Note", "Levi's Dark blue Jeans", "Nikon Coolpix S7000", "Samsung Galaxy S6", "iPhone 6S"};

    //@TargetApi(Build.VERSION_CODES.N)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_screen);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar_activities);
        if (toolbar != null)
            setSupportActionBar(toolbar);
        getSupportActionBar().setTitle(null);

        mNavigationDrawerItemTitles = getResources().getStringArray(R.array.navigation_drawer_items_array);
        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        mDrawerList = (ListView) findViewById(R.id.left_drawer);
        menuButton = (ImageView) findViewById(R.id.menu_button);

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

        imageViewProd1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentTrnd = new Intent(HomeScreenActivity.this, WebViewActivity.class);
                intentTrnd.putExtra("keyName", "coolpad");
                startActivity(intentTrnd);
            }
        });
        menuButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mDrawerLayout.isDrawerOpen(Gravity.LEFT)){
                    mDrawerLayout.closeDrawer(mDrawerList);
                    mDrawerLayout.closeDrawer(Gravity.RIGHT);
                }

                else
                    mDrawerLayout.openDrawer(Gravity.LEFT);
            }
        });

        categoryButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomeScreenActivity.this, CategoryActivity.class);
                startActivity(intent);
            }
        });

        ObjectDrawerItem[] drawerItem = new ObjectDrawerItem[6];

        drawerItem[0] = new ObjectDrawerItem(R.drawable.ic_plus, "Today's deals of Amazon");
        drawerItem[1] = new ObjectDrawerItem(R.drawable.ic_plus, "Today's deals of Flipkart");
        drawerItem[2] = new ObjectDrawerItem(R.drawable.ic_plus, "Today's deals of payTM");
        drawerItem[3] = new ObjectDrawerItem(R.drawable.ic_plus, "Today's deals of eBay");
        drawerItem[4] = new ObjectDrawerItem(R.drawable.ic_plus, "About Us");

        DrawerItemCustomAdapter adapter1 = new DrawerItemCustomAdapter(this, R.layout.listview_drawer_item, drawerItem);
        mDrawerList.setAdapter(adapter1);

        mDrawerList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                selectItem(position);
            }
        });

    search = (AutoCompleteTextView) findViewById(R.id.autoCompleteTextView1);

        ArrayAdapter adapter = new
                ArrayAdapter(this, android.R.layout.simple_list_item_1, products);

        search.setAdapter(adapter);
        search.setThreshold(1);

        search.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                bundle = new Bundle();
                if (search.getText().toString().equals("Apple MacBook Air MMGF2HN")) {
                    bundle.putString("product", "Apple MacBook Air MMGF2HN");
                } else if (search.getText().toString().equals("Apple MacBook Pro MJLQ2HN")) {
                    bundle.putString("product", "Apple MacBook Pro MJLQ2HN");
                } else if (search.getText().toString().equals("Lenovo k3 Note")) {
                    bundle.putString("product", "Lenovo k3 Note");
                } else if (search.getText().toString().equals("Fastrack Analog Watch for Men")) {
                    bundle.putString("product", "Fastrack Analog Watch for Men");
                } else if (search.getText().toString().equals("Coolpad Note Prime")) {
                    bundle.putString("product", "Coolpad Note Prime");
                } else if (search.getText().toString().equals("Levi's Dark blue Jeans")) {
                    bundle.putString("product", "Levi's Dark blue Jeans");
                } else if (search.getText().toString().equals("Moto G3")) {
                    bundle.putString("product", "Moto G3");
                } else if (search.getText().toString().equals("MotoE3")) {
                    bundle.putString("product", "MotoE3");
                } else if (search.getText().toString().equals("Nikon Coolpix S7000")) {
                    bundle.putString("product", "Nikon Coolpix S7000");
                } else if (search.getText().toString().equals("Samsung Galaxy S6")) {
                    bundle.putString("product", "Samsung Galaxy S6");
                } else if (search.getText().toString().equals("iPhone 6S")) {
                    bundle.putString("product", "iPhone 6S");
                } else if (search.getText().toString().equals("Sony Bravia KLV-32R302D 32 Inch")) {
                    bundle.putString("product", "Sony Bravia KLV-32R302D 32 Inch");
                } else {
                    Toast.makeText(getApplicationContext(), "Sorry! this product is not in our Database...", Toast.LENGTH_SHORT).show();
                }

                Intent i = new Intent(HomeScreenActivity.this, ProductAvailabilityActivity.class);
                i.putExtras(bundle);
                startActivity(i);
            }
        });
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
        //insertSampleData();

        amazon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent activityIntent = new Intent(HomeScreenActivity.this, WebViewActivity.class);
                activityIntent.putExtra("keyName", "amazon");
                startActivity(activityIntent);
            }
        });
        flipkart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent activityIntent = new Intent(HomeScreenActivity.this, WebViewActivity.class);
                activityIntent.putExtra("keyName", "flipkart");
                startActivity(activityIntent);
            }
        });
        snapdeal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent activityIntent = new Intent(HomeScreenActivity.this, WebViewActivity.class);
                activityIntent.putExtra("keyName", "snapdeal");
                startActivity(activityIntent);
            }
        });
        paytm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent activityIntent = new Intent(HomeScreenActivity.this, WebViewActivity.class);
                activityIntent.putExtra("keyName", "payTm");
                startActivity(activityIntent);
            }
        });
        ebay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent activityIntent = new Intent(HomeScreenActivity.this, WebViewActivity.class);
                activityIntent.putExtra("keyName", "ebay");
                startActivity(activityIntent);
            }
        });
    }

    private void selectItem(int position) {
        switch (position) {
            case 0:
                Intent intent = new Intent(HomeScreenActivity.this, WebViewActivity.class);
                startActivity(intent);
                break;
            case 1:
                Intent intent1 = new Intent(HomeScreenActivity.this, WebViewActivity.class);
                intent1.putExtra("keyName", "flipkart");
                startActivity(intent1);
                break;
            case 2:
                Intent intent2 = new Intent(HomeScreenActivity.this, WebViewActivity.class);
                startActivity(intent2);
                break;

            default:
                break;
        }
    }
}
