package com.example.hppc.dealofday;

import android.content.Intent;
import android.os.Build;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import java.text.DateFormat;
import java.util.Calendar;
import java.util.Date;

public class HomeScreenActivity extends AppCompatActivity {

    TextView textViewDateTime;
    Button categoryButton;
    ImageButton amazon, flipkart, ebay, paytm;

    //@TargetApi(Build.VERSION_CODES.N)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_screen);

        textViewDateTime  = (TextView) findViewById(R.id.tvDateTime);
        categoryButton = (Button) findViewById(R.id.btn_category);
        amazon = (ImageButton) findViewById(R.id.amazonLogo);
        flipkart = (ImageButton) findViewById(R.id.flipkartLogo);

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
