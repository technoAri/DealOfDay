package com.example.hppc.dealofday.Activity;

import android.content.Intent;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.hppc.dealofday.R;

import java.text.DateFormat;
import java.util.Calendar;
import java.util.Date;

public class HomeScreenActivity extends AppCompatActivity {

    TextView textViewDateTime;
    Button categoryButton;
    AutoCompleteTextView search;
    ImageButton amazon, flipkart, ebay, paytm;

    String[] products = {"Coolpad Note 3 Lite","Coolpad New","Moto E3","Moto X","Moto G3","Samsung Galaxy Note7", "Redmi 2 Prime"};

    //@TargetApi(Build.VERSION_CODES.N)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_screen);

        textViewDateTime  = (TextView) findViewById(R.id.tvDateTime);
        categoryButton = (Button) findViewById(R.id.btn_category);
        amazon = (ImageButton) findViewById(R.id.amazonLogo);
        flipkart = (ImageButton) findViewById(R.id.flipkartLogo);

        search = (AutoCompleteTextView)findViewById(R.id.autoCompleteTextView1);

        ArrayAdapter adapter = new
                ArrayAdapter(this,android.R.layout.simple_list_item_1,products);

        search.setAdapter(adapter);
        search.setThreshold(1);

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
}
