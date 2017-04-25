package com.example.roberthubbell.nier_app;

import com.example.roberthubbell.nier_app.database.DatabaseAccess;

/**
 * Created by Brandon on 4/12/2017.
 */

public class MyProperties {
    private static MyProperties mInstance= null;

    public int chip_id = 1;
    public int chip_category = 1;
    public String[] chips;

    public static synchronized MyProperties getInstance(){
        if(null == mInstance){
            mInstance = new MyProperties();
        }
        return mInstance;
    }


}