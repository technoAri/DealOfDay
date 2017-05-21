package com.example.hppc.dealofday.Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.ExpandableListView;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.hppc.dealofday.Adapters.ExpandableListAdapter;
import com.example.hppc.dealofday.R;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class CategoryActivity extends AppCompatActivity {

    List<String> groupList;
    List<String> childList;
    Map<String, List<String>> laptopCollection;
    ExpandableListView expListView;
    ImageView backButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar_activities_category);
        if (toolbar != null)
            setSupportActionBar(toolbar);
        getSupportActionBar().setTitle(null);

        createGroupList();

        createCollection();

        expListView = (ExpandableListView) findViewById(R.id.category_list);
        backButton = (ImageView) findViewById(R.id.back_button);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        final ExpandableListAdapter expListAdapter = new ExpandableListAdapter(
                this, groupList, laptopCollection);
        expListView.setAdapter(expListAdapter);

        expListView.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {

            public boolean onChildClick(ExpandableListView parent, View v,
                                        int groupPosition, int childPosition, long id) {
                final String selected = (String) expListAdapter.getChild(
                        groupPosition, childPosition);
                if(groupPosition == 0 && childPosition == 0){
                    Intent intent = new Intent(CategoryActivity.this, WebViewActivity.class);
                    intent.putExtra("keyName", "amazonMobile");
                    startActivity(intent);
                }
                else if(groupPosition == 0 && childPosition == 1){
                    Intent intent = new Intent(CategoryActivity.this, WebViewActivity.class);
                    intent.putExtra("keyName", "flipkartMobile");
                    startActivity(intent);
                }
                else if(groupPosition == 0 && childPosition == 2){
                    Intent intent = new Intent(CategoryActivity.this, WebViewActivity.class);
                    intent.putExtra("keyName", "snapdealMobile");
                    startActivity(intent);
                }
                else if(groupPosition == 1 && childPosition == 0){
                    Intent intent = new Intent(CategoryActivity.this, WebViewActivity.class);
                    intent.putExtra("keyName", "amazonLaptops");
                    startActivity(intent);
                }
                else if(groupPosition == 1 && childPosition == 1){
                    Intent intent = new Intent(CategoryActivity.this, WebViewActivity.class);
                    intent.putExtra("keyName", "flipkartLaptops");
                    startActivity(intent);
                }
                else if(groupPosition == 1 && childPosition == 2){
                    Intent intent = new Intent(CategoryActivity.this, WebViewActivity.class);
                    intent.putExtra("keyName", "snapdealLaptops");
                    startActivity(intent);
                }
                else if(groupPosition == 2 && childPosition == 0){
                    Intent intent = new Intent(CategoryActivity.this, WebViewActivity.class);
                    intent.putExtra("keyName", "amazonWatches");
                    startActivity(intent);
                }
                else if(groupPosition == 2 && childPosition == 1){
                    Intent intent = new Intent(CategoryActivity.this, WebViewActivity.class);
                    intent.putExtra("keyName", "flipkartWatches");
                    startActivity(intent);
                }
                else if(groupPosition == 2 && childPosition == 2){
                    Intent intent = new Intent(CategoryActivity.this, WebViewActivity.class);
                    intent.putExtra("keyName", "snapdealWatches");
                    startActivity(intent);
                }
                else if(groupPosition == 3 && childPosition == 0){
                    Intent intent = new Intent(CategoryActivity.this, WebViewActivity.class);
                    intent.putExtra("keyName", "amazonBooks");
                    startActivity(intent);
                }
                else if(groupPosition == 3 && childPosition == 1){
                    Intent intent = new Intent(CategoryActivity.this, WebViewActivity.class);
                    intent.putExtra("keyName", "flipkartBooks");
                    startActivity(intent);
                }
                else if(groupPosition == 3 && childPosition == 2){
                    Intent intent = new Intent(CategoryActivity.this, WebViewActivity.class);
                    intent.putExtra("keyName", "snapdealBooks");
                    startActivity(intent);
                }
                else if(groupPosition == 4 && childPosition == 0){
                    Intent intent = new Intent(CategoryActivity.this, WebViewActivity.class);
                    intent.putExtra("keyName", "amazonWM");
                    startActivity(intent);
                }
                else if(groupPosition == 4 && childPosition == 1){
                    Intent intent = new Intent(CategoryActivity.this, WebViewActivity.class);
                    intent.putExtra("keyName", "flipkartWM");
                    startActivity(intent);
                }
                else if(groupPosition == 4 && childPosition == 2){
                    Intent intent = new Intent(CategoryActivity.this, WebViewActivity.class);
                    intent.putExtra("keyName", "snapdealWM");
                    startActivity(intent);
                }
                else if(groupPosition == 5 && childPosition == 0){
                    Intent intent = new Intent(CategoryActivity.this, WebViewActivity.class);
                    intent.putExtra("keyName", "amazonFashion");
                    startActivity(intent);
                }
                else if(groupPosition == 5 && childPosition == 1){
                    Intent intent = new Intent(CategoryActivity.this, WebViewActivity.class);
                    intent.putExtra("keyName", "flipkartFashion");
                    startActivity(intent);
                }
                else if(groupPosition == 5 && childPosition == 2){
                    Intent intent = new Intent(CategoryActivity.this, WebViewActivity.class);
                    intent.putExtra("keyName", "snapdealFashion");
                    startActivity(intent);
                }


                return true;
            }
        });
    }

    private void createGroupList() {
        groupList = new ArrayList<String>();
        groupList.add("Mobile Phones");
        groupList.add("Laptops");
        groupList.add("Watches");
        groupList.add("Books");
        groupList.add("Washing Mechine");
        groupList.add("Fashion");
    }

    private void createCollection() {
        // preparing laptops collection(child)
        String[] mobileModels = {"Amazon", "flipkart",
                "Snapdeal"};
        String[] LaptopModels = {"Amazon", "flipkart",
                "Snapdeal"};
        String[] WatchesModels = {"Amazon", "flipkart",
                "Snapdeal"};
        String[] BooksModels = {"Amazon", "flipkart",
                "Snapdeal"};
        String[] WashingMechinesModel = {"Amazon", "flipkart",
                "Snapdeal"};
        String[] FashionModels = {"Amazon", "flipkart",
                "Snapdeal"};

        laptopCollection = new LinkedHashMap<String, List<String>>();

        for (String laptop : groupList) {
            if (laptop.equals("Mobile Phones")) {
                loadChild(mobileModels);
            } else if (laptop.equals("Laptops"))
                loadChild(LaptopModels);
            else if (laptop.equals("Watches"))
                loadChild(WatchesModels);
            else if (laptop.equals("Books"))
                loadChild(BooksModels);
            else if (laptop.equals("Washing Mechine"))
                loadChild(WashingMechinesModel);
            else
                loadChild(FashionModels);

            laptopCollection.put(laptop, childList);
        }
    }

    private void loadChild(String[] laptopModels) {
        childList = new ArrayList<String>();
        for (String model : laptopModels)
            childList.add(model);
    }

    private void setGroupIndicatorToRight() {
        /* Get the screen width */
        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);
        int width = dm.widthPixels;

        expListView.setIndicatorBounds(width - getDipsFromPixel(35), width
                - getDipsFromPixel(5));
    }

    // Convert pixel to dip
    public int getDipsFromPixel(float pixels) {
        // Get the screen's density scale
        final float scale = getResources().getDisplayMetrics().density;
        // Convert the dps to pixels, based on density scale
        return (int) (pixels * scale + 0.5f);
    }
}