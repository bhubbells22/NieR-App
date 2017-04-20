package com.example.roberthubbell.nier_app;

import android.content.Intent;
import android.graphics.Color;
import android.support.annotation.IdRes;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebHistoryItem;
import android.widget.Button;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.ToggleButton;

import com.example.roberthubbell.nier_app.database.DBFunctions;
import com.example.roberthubbell.nier_app.network.GetChips;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

public class HomeScreenActivity extends AppCompatActivity {

    private TextView app_name;
    private Button add_button;
    private Button fuse_button;
    private Button info_button;

    //chip selector testing




    //end

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_screen);
        GetChips task = new GetChips();
        task.execute();

        app_name = (TextView)findViewById(R.id.title_text);
        add_button = (Button)findViewById(R.id.add_button);
        fuse_button = (Button)findViewById(R.id.fuse_button);
        info_button = (Button)findViewById(R.id.info_button);

        //chip selector testing


        add_button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent intent = new Intent(HomeScreenActivity.this, AddActivity.class);
                startActivity(intent);
            }
        });

        fuse_button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent intent = new Intent(HomeScreenActivity.this, FuseActivity.class);
                startActivity(intent);
            }
        });

        info_button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent intent = new Intent(HomeScreenActivity.this, InfoActivity.class);
                startActivity(intent);
            }
        });

        //end


    }

}
