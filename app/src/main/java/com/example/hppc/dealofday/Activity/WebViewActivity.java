package com.example.hppc.dealofday.Activity;

import android.annotation.SuppressLint;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.os.Handler;
import android.view.MotionEvent;
import android.view.View;
import android.webkit.WebView;

import com.example.hppc.dealofday.R;

public class WebViewActivity extends AppCompatActivity {

    WebView webView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_view);

        String data = getIntent().getExtras().getString("keyName");

        webView = (WebView) findViewById(R.id.webview);
        webView.getSettings().setJavaScriptEnabled(true);

        if(data.equals("amazon"))
            webView.loadUrl("http://www.amazon.in/gp/goldbox/ref=nav_cs_gb");
        else if(data.equals("flipkart"))
            webView.loadUrl("https://www.flipkart.com/offers-list/deals-of-the-day?screen=dynamic&pk=contentTheme%3DDOTD_widgetType%3DdealCard&wid=2.dealCard.OMU&otracker=hp_omu_Deals+of+the+Day_0");
        else if(data.equals("coolpad"))
            webView.loadUrl("http://www.amazon.in/Coolpad-Note-Royal-Gold-32/dp/B01FM7H0K8/ref=sr_1_1?s=electronics&ie=UTF8&qid=1480441065&sr=1-1&keywords=coolpad+note+3+lite");
    }
}
