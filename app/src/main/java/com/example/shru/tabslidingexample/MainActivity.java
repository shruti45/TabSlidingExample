package com.example.shru.tabslidingexample;

import android.content.Context;
import android.graphics.Color;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.SearchView;
import android.widget.Toast;


import java.util.ArrayList;


public class MainActivity extends ActionBarActivity implements View.OnClickListener {

    // Declaring Your View and Variables

    Context context;
    Toolbar toolbar;
    ViewPager pager,Pager2;
    ViewPagerAdapter adapter;
    TabLayout tabs;
    CharSequence Titles[] = {"Apps&Games", "Entertainment"};
    int Numboftabs = 2;
   ImageView hamimg,viceicon;
    DrawerLayout mDrawerLayout;
    int value1,value2;
    private static final Integer[] IMAGES = {R.drawable.lightblueimage, R.drawable.greenimage, R.drawable.pinkimage, R.drawable.ic_launcher, R.drawable.color, R.drawable.image1};
    private ArrayList<Integer> ImagesArray = new ArrayList<Integer>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();


        hamimg=(ImageView)findViewById(R.id.hamburgerimg);
        viceicon=(ImageView)findViewById(R.id.voiceicon);

        //to get value from the categotyactivity edittexts
        Bundle bundle = getIntent().getExtras();
        value1 = bundle.getInt("value_1");
        value2 =bundle.getInt("value_2");
        System.out.println("value1:" +value1);
        System.out.println("value1:" +value2);



        /* to set edittext inputtext color*/
        final EditText et = (EditText) findViewById(R.id.editTextName);
        // to set text color using RGB code
        et.setTextColor(Color.parseColor("#000000"));

        // Creating The ViewPagerAdapter and Passing Fragment Manager, Titles fot the Tabs and Number Of Tabs.
        adapter = new ViewPagerAdapter(getSupportFragmentManager(), Titles, Numboftabs);

        // Assigning ViewPager View and setting the adapter
        pager = (ViewPager) findViewById(R.id.viewpager);
        pager.setAdapter(adapter);

        // Assiging the Sliding Tab Layout View
        TabLayout tabLayout = (TabLayout) findViewById(R.id.tablayout);
        tabLayout.setupWithViewPager(pager);// To make the Tabs Fixed set this true, This makes the tabs Space Evenly in Available width

        // Defined inside activity_main.xml
        mDrawerLayout= (DrawerLayout)findViewById(R.id.drawer_layout);

        hamimg.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                mDrawerLayout.openDrawer(Gravity.LEFT);

            }
        });

        viceicon.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {


                Toast.makeText(getApplicationContext(),
                        "Clicked voice icon",
                        Toast.LENGTH_LONG).show();

            }
        });
    }

    private void init() {
        for (int i = 0; i < IMAGES.length; i++)
            ImagesArray.add(IMAGES[i]);
        Pager2 = (ViewPager) findViewById(R.id.pager);

        Pager2.setAdapter(new ToolBarImageAdapter(MainActivity.this, ImagesArray));
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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


    @Override
    public void onClick(View v) {

    }
}