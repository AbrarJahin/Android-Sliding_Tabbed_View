package com.appnucleus.slidingtabbedview;

import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;

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
    private Toolbar toolbar;
    private ViewPager pager;
    private Adapter_ViewPager adapter;
    private SlidingTabLayout tabs;

    private ArrayList<Model_TabHolder> tabElements = new ArrayList<Model_TabHolder>();

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Creating The Toolbar and setting it as the Toolbar for the activity
        toolbar = (Toolbar) findViewById(R.id.tool_bar);
        setSupportActionBar(toolbar);

        SetTabContents();

        // Creating The Adapter_ViewPager and Passing Fragment Manager, Titles fot the Tabs and Number Of Tabs.
        adapter =  new Adapter_ViewPager(getSupportFragmentManager(),tabElements);

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

    void SetTabContents()
    {
        String[]    Titles      =   {"Events","Home","Events","Tab New","Tab Old"};
        String[]    packages    =   {"com.appnucleus.slidingtabbedview.Tab1","com.appnucleus.slidingtabbedview.Tab1","com.appnucleus.slidingtabbedview.Tab2","com.appnucleus.slidingtabbedview.Tab3","com.appnucleus.slidingtabbedview.Tab1"};

        for (int i=0;i<packages.length && i<Titles.length;i++)
        {
            final Model_TabHolder temp_data = new Model_TabHolder();
            temp_data.set_Class(packages[i]);
            temp_data.set_Title(Titles[i].toString());
            tabElements.add(temp_data);
        }
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