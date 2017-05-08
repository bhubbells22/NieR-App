package com.example.roberthubbell.nier_app;

import android.content.Intent;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.roberthubbell.nier_app.network.GetChips;

public class HomeScreenActivity extends AppCompatActivity {

    private TextView app_name;
    private TextView add_name;
    private TextView fuse_name;
    private ImageButton add_button;
    private ImageButton fuse_button;
    private ImageButton info_button;
    private Drawable plus_drawable;


    private Button test_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_screen);
        //GetChips task = new GetChips();
        //task.execute();

        app_name = (TextView)findViewById(R.id.title_text);
        add_name = (TextView)findViewById(R.id.add_name);
        fuse_name = (TextView)findViewById(R.id.fuse_name);
        add_button = (ImageButton) findViewById(R.id.add_button);
        fuse_button = (ImageButton)findViewById(R.id.fuse_button);
        info_button = (ImageButton) findViewById(R.id.info_button);
        plus_drawable = getResources().getDrawable(R.drawable.plus_sign);

        Typeface font = Typeface.createFromAsset(getAssets(), "Benguiat.ttf");
        app_name.setTypeface(font);

        test_button = (Button) findViewById(R.id.test_button);



        add_button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent intent = new Intent(HomeScreenActivity.this, AddDrawerActivity.class);
                startActivity(intent);
            }
        });

        fuse_button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent intent = new Intent(HomeScreenActivity.this, FuseDrawerActivity.class);
                startActivity(intent);
            }
        });

        info_button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent intent = new Intent(HomeScreenActivity.this, InfoDrawerActivity.class);
                startActivity(intent);
            }
        });

        test_button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent intent = new Intent(HomeScreenActivity.this, TestActivity.class);
                startActivity(intent);
            }
        });

    }

}
