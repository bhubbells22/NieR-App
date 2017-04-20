package com.example.roberthubbell.nier_app;

import android.net.Uri;
import android.os.AsyncTask;

import java.io.BufferedReader;
import java.io.Console;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

import com.example.roberthubbell.nier_app.database.DBFunctions;
import com.example.roberthubbell.nier_app.database.DBHandler;
import com.example.roberthubbell.nier_app.database.DBFunctions;
import com.squareup.okhttp.HttpUrl;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

/**
 * Created by Brandon on 4/12/2017.
 */

public class MyProperties {
    private static MyProperties mInstance= null;

    public int chip_id = 0;
    public int chip_category = 1;
    public String[] chips;
    public static DBHandler database;

    public static synchronized MyProperties getInstance(){
        if(null == mInstance){
            mInstance = new MyProperties();
        }
        return mInstance;
    }

    public static String getChip(){
        String name = database.getChip(0).getName();
        return name;
    }


}