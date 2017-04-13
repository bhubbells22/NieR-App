package com.example.roberthubbell.nier_app.network;

import android.content.Context;
import android.os.AsyncTask;

import com.example.roberthubbell.nier_app.MyProperties;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by Brandon on 4/12/2017.
 */

public class GetChips extends AsyncTask<Void, Void, String> {

    @Override
    protected String doInBackground(Void... params) {

        try {
            // Create a URL for the desired page
            URL url = new URL("http://bbssu.a2hosted.com/chip_names.php");

            // Read all the text returned by the server
            BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream()));
            String str;
            while ((str = in.readLine()) != null) {
                MyProperties.getInstance().chips = str.split(",");
                //System.out.println(str);
                // str is one line of text; readLine() strips the newline character(s)
            }
            in.close();
        } catch (MalformedURLException e) {
            //
        } catch (IOException e) {
            //
        }
        return null;
    }

    /*@Override
    protected void onPostExecute(String result) {
    }*/
}
