package com.example.roberthubbell.nier_app;

import android.content.Intent;
import android.graphics.Color;
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
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.roberthubbell.nier_app.chip.Chip;
import com.example.roberthubbell.nier_app.chip.Fusion;
import com.example.roberthubbell.nier_app.display_adapters.ChipAdapter;
import com.lantouzi.wheelview.WheelView;

import java.util.ArrayList;
import java.util.List;

final public class AddDrawerActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    public Button chip_button;
    public Button add_button;
    public Button remove_button;
    public Button phantom_button;
    public TextView level_text;

    public com.lantouzi.wheelview.WheelView wheel;
    List wheelnums = new ArrayList();

    private int level;
    private int size;

    private ChipAdapter adapter;
    private ArrayList<Chip> arrayOfChips;
    private ListView listView;

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

        // Construct the data source
        arrayOfChips = new ArrayList<Chip>();
        // Create the adapter to convert the array to views
        adapter = new ChipAdapter(this, arrayOfChips);
        // Attach the adapter to a ListView
        listView = (ListView) findViewById(R.id.chip_list);
        listView.setAdapter(adapter);


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

        wheel = (com.lantouzi.wheelview.WheelView) findViewById(R.id.wheel);

        wheel.setMinSelectableIndex(0);
        wheel.setMaxSelectableIndex(8);

        wheelnums.add("0");
        wheelnums.add("1");
        wheelnums.add("2");
        wheelnums.add("3");
        wheelnums.add("4");
        wheelnums.add("5");
        wheelnums.add("6");
        wheelnums.add("7");
        wheelnums.add("8");

        wheel.setItems(wheelnums);

        wheel.selectIndex(1);

        level = wheel.getSelectedPosition();

        writeChips();

        wheel.setOnWheelItemSelectedListener(new WheelView.OnWheelItemSelectedListener() {
            @Override
            public void onWheelItemChanged(WheelView wheelView, int position) {

            }

            @Override
            public void onWheelItemSelected(WheelView wheelView, int position) {
                level = wheel.getSelectedPosition();
                writeChips();

            }
        });


        add_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                increase();
            }
        });

        remove_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                decrease();
            }
        });

    }

    public void updateButton(){
        chip_button.setText(MyProperties.getInstance().chips[MyProperties.getInstance().chip_id]);
        if(level > -1)
            writeChips();
    }

    public void clearText(){
        adapter.clear();
    }

    public void writeChips(){

        clearText();

        int arraySize = 0;
        int intialChipSize = 0;

        if (level == 0) {
            arraySize = 6;
            intialChipSize = 4;
        }
        else if (level == 1) {
            arraySize = 5;
            intialChipSize = 5;
        }
        else if (level == 2) {
            arraySize = 4;
            intialChipSize = 6;
        }
        else if (level == 3) {
            arraySize = 4;
            intialChipSize = 7;
        }
        else if (level == 4) {
            arraySize = 3;
            intialChipSize = 9;
        }
        else if (level == 5) {
            arraySize = 3;
            intialChipSize = 11;
        }
        else if (level == 6) {
            arraySize = 2;
            intialChipSize = 14;
        }
        else if (level == 7) {
            arraySize = 2;
            intialChipSize = 17;
        }
        else if (level == 8) {
            arraySize = 1;
            intialChipSize = 21;
        }

        Chip chipArray[] = new Chip[arraySize];

        for(int i = 0; i < arraySize; i++){
            Chip tempChip = new Chip(this, MyProperties.getInstance().chip_id, level, intialChipSize+i);
            //if(tempChip.inDb())
                adapter.add(new Chip(this, MyProperties.getInstance().chip_id, level, intialChipSize+i));
        }
    }

    public void increase(){
        //make sure a size has been selected
        if(size > 0) {
            new Chip(this, MyProperties.getInstance().chip_id, level, size).increaseCount();
            writeChips();
        }
    }

    public void decrease(){
        //make sure a size has been selected
        if(size > 0) {
            new Chip(this, MyProperties.getInstance().chip_id, level, size).decreaseCount();
            writeChips();
        }
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
