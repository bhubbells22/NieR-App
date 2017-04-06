package com.example.roberthubbell.nier_app;

import android.support.annotation.IdRes;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebHistoryItem;
import android.widget.Button;
import android.widget.TextView;

public class HomeScreenActivity extends AppCompatActivity {

    private TextView app_name;
    private Button add_button;
    private Button fuse_button;
    private Button info_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_screen);

        app_name = (TextView)findViewById(R.id.title_text);
        add_button = (Button)findViewById(R.id.add_button);
        fuse_button = (Button)findViewById(R.id.fuse_button);
        info_button = (Button)findViewById(R.id.info_button);

        add_button.setX(210);
        add_button.setY(600);
        fuse_button.setX(210);
        fuse_button.setY(800);
        info_button.setX(210);
        info_button.setY(1000);


    }

}
