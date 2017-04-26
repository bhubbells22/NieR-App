package com.example.roberthubbell.nier_app;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.roberthubbell.nier_app.network.GetChips;

public class HomeScreenActivity extends AppCompatActivity {

    private TextView app_name;
    private Button add_button;
    private Button fuse_button;
    private Button info_button;


    private Button test_button;

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
