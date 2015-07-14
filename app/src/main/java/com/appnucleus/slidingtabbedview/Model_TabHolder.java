package com.appnucleus.slidingtabbedview;

public class Model_TabHolder
{
    private String Title;                           //Can be any string
    private String class_name_including_package;    //Must be like - com.appnucleus.slidingtabbedview.Tab1

    String get_Titile()
    {
        return Title;
    }
    String get_Class()
    {
        //String Package_Name = getApplicationContext().getPackageName();
        return class_name_including_package;
    }

    void set_Class(String to_set)
    {
        class_name_including_package=to_set;
    }
    void set_Title(String to_set)
    {
        Title=to_set;
    }
}
