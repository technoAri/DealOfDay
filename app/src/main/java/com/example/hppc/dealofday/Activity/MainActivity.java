package com.example.hppc.dealofday.Activity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.hppc.dealofday.InternetConnection;
import com.example.hppc.dealofday.R;

public class MainActivity extends AppCompatActivity {

    AlertDialog alert11;
    TextView tvNext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //tvNext = (TextView) findViewById(R.id.tvNext);
//        tvNext.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent activityIntent = new Intent(MainActivity.this, HomeScreenActivity.class);
//                startActivity(activityIntent);
//            }
//        });

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                if (InternetConnection.checkConnection(getApplicationContext())) {
                    Intent i = new Intent(MainActivity.this, HomeScreenActivity.class);
                    startActivity(i);
                    finish();
                } else {
                    Toast.makeText(getApplicationContext(), "Some error occurred! Check your internet connection and try again..", Toast.LENGTH_SHORT).show();
                    finish();
                }
            }
        }, 2000);

    }
}
