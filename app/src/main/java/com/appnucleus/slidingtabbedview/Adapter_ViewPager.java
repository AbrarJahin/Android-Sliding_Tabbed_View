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
        String className="";
        Object tab_to_return = null;
        try
        {
            switch (position+1)
            {
                case 1:
                    className = "com.appnucleus.slidingtabbedview.Tab1";
                    break;
                case 2:
                    className = "com.appnucleus.slidingtabbedview.Tab2";
                    break;
                case 3:
                    className = "com.appnucleus.slidingtabbedview.Tab3";
                    break;
                default:
                    className=null;
            }
            tab_to_return = Class.forName(className).newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return (Fragment) tab_to_return;
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