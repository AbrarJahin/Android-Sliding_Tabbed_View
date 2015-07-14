package com.appnucleus.slidingtabbedview;

import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

/*
*   SlidingTabLayout.java
*       &
*   SlidingTabStrip.java
*
*   This 2 is provided by google for using sliding tabbed view in latest way - since now
*   So you need not to change this 2 files unless u have to work on more complex things
* */

public class Activity_Main extends ActionBarActivity
{
    // Declaring Your View and Variables
    Toolbar toolbar;
    ViewPager pager;
    Adapter_ViewPager adapter;
    SlidingTabLayout tabs;

    CharSequence Titles[]={"Home","Events","Tab New"};
    int Numboftabs =3;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Creating The Toolbar and setting it as the Toolbar for the activity
        toolbar = (Toolbar) findViewById(R.id.tool_bar);
        setSupportActionBar(toolbar);

        // Creating The Adapter_ViewPager and Passing Fragment Manager, Titles fot the Tabs and Number Of Tabs.
        adapter =  new Adapter_ViewPager(getSupportFragmentManager(),Titles,Numboftabs);

        // Assigning ViewPager View and setting the adapter
        pager = (ViewPager) findViewById(R.id.pager);
        pager.setAdapter(adapter);

        // Assiging the Sliding Tab Layout View
        tabs = (SlidingTabLayout) findViewById(R.id.tabs);
        tabs.setDistributeEvenly(true); // To make the Tabs Fixed set this true, This makes the tabs Space Evenly in Available width

        // Setting Custom Color for the Scroll bar indicator of the Tab View
        tabs.setCustomTabColorizer(new SlidingTabLayout.TabColorizer()
        {
            @Override
            public int getIndicatorColor(int position)
            {
                return getResources().getColor(R.color.tabsScrollColor);
            }
        });

        // Setting the ViewPager For the SlidingTabsLayout
        tabs.setViewPager(pager);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings)
        {
            //Toast t= new Toast(getApplicationContext()).setText("Settings Clicked").;
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}