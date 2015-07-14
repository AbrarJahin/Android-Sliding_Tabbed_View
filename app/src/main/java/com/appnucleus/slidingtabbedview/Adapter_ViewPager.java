package com.appnucleus.slidingtabbedview;


import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

public class Adapter_ViewPager extends FragmentStatePagerAdapter
{
    CharSequence Titles[]; // This will Store the Titles of the Tabs which are Going to be passed when Adapter_ViewPager is created
    int NumbOfTabs; // Store the number of tabs, this will also be passed when the Adapter_ViewPager is created

    // Build a Constructor and assign the passed Values to appropriate values in the class
    public Adapter_ViewPager(FragmentManager fm, CharSequence mTitles[], int mNumbOfTabsumb)
    {
        super(fm);

        this.Titles = mTitles;
        this.NumbOfTabs = mNumbOfTabsumb;
    }

    //This method return the fragment for the every position in the View Pager
    @Override
    public Fragment getItem(int position)
    {
        switch (position+1)
        {
            case 1:
                Tab1 tab1 = new Tab1();
                return tab1;
            case 2:
                Tab2 tab2 = new Tab2();
                return tab2;
            case 3:
                Tab3 tab3 = new Tab3();
                /*String className = "Tab3";
                Object tab3 = null;
                try {
                    tab3 = Class.forName(className).newInstance();
                } catch (InstantiationException e) {
                    e.printStackTrace();
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }*/
                return (Fragment) tab3;
            default: return null;
        }
    }

    // This method return the titles for the Tabs in the Tab Strip
    @Override
    public CharSequence getPageTitle(int position)
    {
        return Titles[position];
    }

    // This method return the Number of tabs for the tabs Strip

    @Override
    public int getCount()
    {
        return NumbOfTabs;
    }
}