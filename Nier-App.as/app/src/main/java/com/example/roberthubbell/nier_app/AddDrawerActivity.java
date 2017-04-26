package com.example.roberthubbell.nier_app;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class AddDrawerActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    public Button chip_button;
    public Button add_button;
    public Button remove_button;
    public Button phantom_button;
    public TextView level_text;
    public Button level0;
    public Button level1;
    public Button level2;
    public Button level3;
    public Button level4;
    public Button level5;
    public Button level6;
    public Button level7;
    public Button level8;
    public TextView size_text;
    public Button size0;
    public Button size1;
    public Button size2;
    public Button size3;
    public Button size4;
    public Button size5;

    private LayoutInflater layoutInflater;
    private RelativeLayout layout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_drawer);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        chip_button = (Button) findViewById(R.id.chip_button);
        chip_button.setText(MyProperties.getInstance().chips[MyProperties.getInstance().chip_id]);
        phantom_button = (Button) findViewById(R.id.phantom_chip_button);
        phantom_button.setVisibility(View.INVISIBLE);
        add_button = (Button) findViewById(R.id.add_button);
        remove_button = (Button) findViewById(R.id.remove_button);
        layout = (RelativeLayout) findViewById(R.id.add_screen);

        chip_button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                layoutInflater = (LayoutInflater) getApplicationContext().getSystemService(LAYOUT_INFLATER_SERVICE);
                ViewGroup container = (ViewGroup) layoutInflater.inflate(R.layout.chip_selector, null);

                ChipSelector selector = new ChipSelector();
                selector.ShowSelector(AddDrawerActivity.this, layout, container);
            }
        });

        level_text = (TextView) findViewById(R.id.level_text);

        // create instance of buttons

        level0 = (Button) findViewById(R.id.level0);
        level1 = (Button) findViewById(R.id.level1);
        level2 = (Button) findViewById(R.id.level2);
        level3 = (Button) findViewById(R.id.level3);
        level4 = (Button) findViewById(R.id.level4);
        level5 = (Button) findViewById(R.id.level5);
        level6 = (Button) findViewById(R.id.level6);
        level7 = (Button) findViewById(R.id.level7);
        level8 = (Button) findViewById(R.id.level8);

        // hide size text and buttons

        size_text = (TextView) findViewById(R.id.size_text);
        size_text.setVisibility(View.GONE);
        size0 = (Button) findViewById(R.id.size0);
        size0.setVisibility(View.GONE);
        size1 = (Button) findViewById(R.id.size1);
        size1.setVisibility(View.GONE);
        size2 = (Button) findViewById(R.id.size2);
        size2.setVisibility(View.GONE);
        size3 = (Button) findViewById(R.id.size3);
        size3.setVisibility(View.GONE);
        size4 = (Button) findViewById(R.id.size4);
        size4.setVisibility(View.GONE);
        size5 = (Button) findViewById(R.id.size5);
        size5.setVisibility(View.GONE);

        // show size buttons when level button is clicked

        level0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                size_text.setVisibility(View.VISIBLE);
                size0.setVisibility(View.VISIBLE);
                size0.setText("4");
                size1.setVisibility(View.VISIBLE);
                size1.setText("5");
                size2.setVisibility(View.VISIBLE);
                size2.setText("6");
                size3.setVisibility(View.VISIBLE);
                size3.setText("7");
                size4.setVisibility(View.VISIBLE);
                size4.setText("8");
                size5.setVisibility(View.VISIBLE);
                size5.setText("9");
            }
        });

        level1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                size_text.setVisibility(View.VISIBLE);
                size0.setVisibility(View.VISIBLE);
                size0.setText("5");
                size1.setVisibility(View.VISIBLE);
                size1.setText("6");
                size2.setVisibility(View.VISIBLE);
                size2.setText("7");
                size3.setVisibility(View.VISIBLE);
                size3.setText("8");
                size4.setVisibility(View.VISIBLE);
                size4.setText("9");
                size5.setVisibility(View.GONE);
            }
        });

        level2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                size_text.setVisibility(View.VISIBLE);
                size0.setVisibility(View.VISIBLE);
                size0.setText("6");
                size1.setVisibility(View.VISIBLE);
                size1.setText("7");
                size2.setVisibility(View.VISIBLE);
                size2.setText("8");
                size3.setVisibility(View.GONE);
                size4.setVisibility(View.VISIBLE);
                size4.setText("9");
                size5.setVisibility(View.GONE);
            }
        });

        level3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                size_text.setVisibility(View.VISIBLE);
                size0.setVisibility(View.VISIBLE);
                size0.setText("7");
                size1.setVisibility(View.VISIBLE);
                size1.setText("8");
                size2.setVisibility(View.VISIBLE);
                size2.setText("9");
                size3.setVisibility(View.GONE);
                size4.setText("10");
                size4.setVisibility(View.VISIBLE);
                size5.setVisibility(View.GONE);
            }
        });

        level4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                size_text.setVisibility(View.VISIBLE);
                size0.setVisibility(View.VISIBLE);
                size0.setText("9");
                size1.setVisibility(View.VISIBLE);
                size1.setText("10");
                size2.setVisibility(View.VISIBLE);
                size2.setText("11");
                size3.setVisibility(View.GONE);
                size4.setVisibility(View.GONE);
                size5.setVisibility(View.GONE);
            }
        });

        level5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                size_text.setVisibility(View.VISIBLE);
                size0.setVisibility(View.VISIBLE);
                size0.setText("11");
                size1.setVisibility(View.VISIBLE);
                size1.setText("12");
                size2.setVisibility(View.VISIBLE);
                size2.setText("13");
                size3.setVisibility(View.GONE);
                size4.setVisibility(View.GONE);
                size5.setVisibility(View.GONE);
            }
        });

        level6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                size_text.setVisibility(View.VISIBLE);
                size0.setVisibility(View.VISIBLE);
                size0.setText("14");
                size1.setVisibility(View.VISIBLE);
                size1.setText("15");
                size2.setVisibility(View.GONE);
                size3.setVisibility(View.GONE);
                size4.setVisibility(View.GONE);
                size5.setVisibility(View.GONE);
            }
        });

        level7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                size_text.setVisibility(View.VISIBLE);
                size0.setVisibility(View.VISIBLE);
                size0.setText("17");
                size1.setVisibility(View.VISIBLE);
                size1.setText("18");
                size2.setVisibility(View.GONE);
                size3.setVisibility(View.GONE);
                size4.setVisibility(View.GONE);
                size5.setVisibility(View.GONE);
            }
        });

        level8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                size_text.setVisibility(View.VISIBLE);
                size0.setVisibility(View.GONE);
                size1.setText("21");
                size1.setVisibility(View.VISIBLE);
                size2.setVisibility(View.GONE);
                size3.setVisibility(View.GONE);
                size4.setVisibility(View.GONE);
                size5.setVisibility(View.GONE);
            }
        });


    }

    public void updateButton(){
        chip_button.setText(MyProperties.getInstance().chips[MyProperties.getInstance().chip_id]);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.add_drawer, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_add) {
            Intent intent = new Intent(AddDrawerActivity.this, AddDrawerActivity.class);
            startActivity(intent);

        } else if (id == R.id.nav_fuse) {
            Intent intent = new Intent(AddDrawerActivity.this, FuseDrawerActivity.class);
            startActivity(intent);

        } else if (id == R.id.nav_info) {
            Intent intent = new Intent(AddDrawerActivity.this, InfoDrawerActivity.class);
            startActivity(intent);

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }


}
