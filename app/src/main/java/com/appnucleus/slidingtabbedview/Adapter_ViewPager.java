package com.appnucleus.slidingtabbedview;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import java.util.ArrayList;

//The PagerSlidingTab contains an interface called "IconTabProvider" that needs to be implemented by your ViewPager's adapter. Implemented that and for each position you can provide a different icon.

public class Adapter_ViewPager extends FragmentStatePagerAdapter
{
    private ArrayList<Model_TabHolder> tabValueArrray;

    // Build a Constructor and assign the passed Values to appropriate values in the class
    public Adapter_ViewPager(FragmentManager fm, ArrayList<Model_TabHolder> oldList)
    {
        super(fm);

        tabValueArrray=new ArrayList<Model_TabHolder>(oldList);
    }

    //This method return the fragment for the every position in the View Pager
    @Override
    public Fragment getItem(int position)
    {
        String className=tabValueArrray.get(position).get_Class();
        Object tab_to_return = null;
        try
        {
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
        return tabValueArrray.get(position).get_Titile();
    }

    // This method return the Number of tabs for the tabs Strip

    @Override
    public int getCount()
    {
        return tabValueArrray.size();
    }
}