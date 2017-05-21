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
        //String data = getIntent().getExtras().getString("key");

        webView = (WebView) findViewById(R.id.webview);
        webView.getSettings().setJavaScriptEnabled(true);

        if(data.equals("amazon"))
            webView.loadUrl("http://www.amazon.in/gp/goldbox/ref=nav_cs_gb");
        else if(data.equals("flipkart"))
            webView.loadUrl("https://www.flipkart.com/offers-list/deals-of-the-day?screen=dynamic&pk=contentTheme%3DDOTD_widgetType%3DdealCard&wid=2.dealCard.OMU&otracker=hp_omu_Deals+of+the+Day_0");
        else if(data.equals("snapdeal"))
            webView.loadUrl("https://www.snapdeal.com/offers/deal-of-the-day");
        else if(data.equals("payTm"))
            webView.loadUrl("https://paytm.com/offer/deals-of-the-day/");
        else if(data.equals("ebay"))
            webView.loadUrl("http://www.ebay.com/deals/");

        // for category
        if(data.equals("amazonMobile"))
            webView.loadUrl("http://www.amazon.in/mobile-phones/b/ref=nav_shopall_sa_menu_mobile_all_mobiles?ie=UTF8&node=1389401031");
        else if(data.equals("flipkartMobile"))
            webView.loadUrl("https://www.flipkart.com/mobiles?otracker=nmenu_sub_Electronics_0_Mobiles");
        else if(data.equals("snapdealMobile"))
            webView.loadUrl("https://www.snapdeal.com/products/mobiles-mobile-phones");
        else if(data.equals("amazonLaptops"))
            webView.loadUrl("http://www.amazon.in/Laptops/b/ref=nav_shopall_computers_laptop?ie=UTF8&node=1375424031");
        else if(data.equals("flipkartLaptops"))
            webView.loadUrl("https://www.flipkart.com/laptops-store?otracker=nmenu_sub_Electronics_0_Laptops");
        else if(data.equals("snapdealLaptops"))
            webView.loadUrl("https://www.snapdeal.com/products/computers-laptops");
        else if(data.equals("amazonWatches"))
            webView.loadUrl("http://www.amazon.in/Watches/b/ref=nav_shopall_watches_all?ie=UTF8&node=1350387031");
        else if(data.equals("flipkartWatches"))
            webView.loadUrl("https://www.flipkart.com/mens-watches-store?otracker=nmenu_sub_Men_0_Watches");
        else if(data.equals("snapdealWatches"))
            webView.loadUrl("https://www.snapdeal.com/products/watches-men");
        else if(data.equals("amazonBooks"))
            webView.loadUrl("http://www.amazon.in/Books/b/ref=nav_shopall_books_all?ie=UTF8&node=976389031");
        else if(data.equals("flipkartBooks"))
            webView.loadUrl("https://www.flipkart.com/books/pr?sid=bks&q=books&otracker=categorytree");
        else if(data.equals("snapdealBooks"))
            webView.loadUrl("https://www.snapdeal.com/products/books");
        else if(data.equals("amazonWM"))
            webView.loadUrl("http://www.amazon.in/s/ref=nb_sb_ss_c_3_16?url=search-alias%3Dkitchen&field-keywords=washing+machine+cover&sprefix=washing+machine+%2Cstripbooks%2C604&crid=3QRCBFA34ZS0U&rh=n%3A976442031%2Ck%3Awashing+machine+cover");
        else if(data.equals("flipkartWM"))
            webView.loadUrl("https://www.flipkart.com/home-kitchen/home-appliances/washing-machines?otracker=nmenu_sub_Appliances_0_Washing%20Machine");
        else if(data.equals("snapdealWM"))
            webView.loadUrl("https://www.snapdeal.com/search?keyword=washing+machin&santizedKeyword=&catId=&categoryId=0&suggested=false&vertical=&noOfResults=20&searchState=&clickSrc=go_header&lastKeyword=&prodCatId=&changeBackToAll=false&foundInAll=false&categoryIdSearched=&cityPageUrl=&categoryUrl=&url=&utmContent=&dealDetail=");
        else if(data.equals("amazonFashion"))
            webView.loadUrl("http://www.amazon.in/Womens-clothing/b/ref=nav_shopall_sa_menu_cloacc_allwomen?ie=UTF8&node=1953602031");
        else if(data.equals("flipkartFashion"))
            webView.loadUrl("https://www.flipkart.com/mens-clothing/~mens-top-wear/pr?sid=2oq%2Cs9b&otracker=nmenu_sub_Men_0_Top%20wear");
        else if(data.equals("snapdealFashion"))
            webView.loadUrl("https://www.snapdeal.com/products/women-ethnicwear");


    }
}
