package com.example.roberthubbell.nier_app;

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
import android.widget.TextView;
import android.widget.ToggleButton;

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
    public Button chip_button;
    private PopupWindow popupWindow;
    private LayoutInflater layoutInflater;
    private ConstraintLayout homeScreenLayout;



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
        chip_button = (Button) findViewById(R.id.chip_button);
        homeScreenLayout = (ConstraintLayout) findViewById(R.id.home_screen);
        chip_button.setText("Select Chip");

        chip_button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                layoutInflater = (LayoutInflater) getApplicationContext().getSystemService(LAYOUT_INFLATER_SERVICE);
                ViewGroup container = (ViewGroup) layoutInflater.inflate(R.layout.chip_selector, null);

                ChipSelector selector = new ChipSelector();
                selector.ShowSelector(HomeScreenActivity.this, homeScreenLayout, container);
            }
        });

        //end


        add_button.setX(210);
        add_button.setY(600);
        fuse_button.setX(210);
        fuse_button.setY(800);
        info_button.setX(210);
        info_button.setY(1000);


    }

    public void updateButton(){
        chip_button.setText(MyProperties.getInstance().chips[MyProperties.getInstance().chip_id]);
    }
}
