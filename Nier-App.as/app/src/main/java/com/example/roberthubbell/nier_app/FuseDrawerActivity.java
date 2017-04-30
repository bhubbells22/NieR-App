package com.example.roberthubbell.nier_app;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;
import android.widget.RelativeLayout;

import com.example.roberthubbell.nier_app.chip.Chip;
import com.example.roberthubbell.nier_app.chip.Fusion;
import com.example.roberthubbell.nier_app.display_adapters.ChipAdapter;
import com.example.roberthubbell.nier_app.display_adapters.FusionAdapter;
import com.lantouzi.wheelview.WheelView;
import com.example.roberthubbell.nier_app.display_adapters.FusionLogAdapter;

import java.util.ArrayList;
import java.util.List;

public class FuseDrawerActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    public Button chip_button;
    private LayoutInflater layoutInflater;
    private RelativeLayout layout;


    private FusionAdapter adapter;
    private ArrayList<Fusion> arrayOfFusions;
    private ListView listView;

    public com.lantouzi.wheelview.WheelView wheel;
    List wheelnums = new ArrayList();
    private ListView listView2;
    private FusionLogAdapter adapter2;

    private Button undoButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fuse_drawer);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);


        MyProperties.getInstance().fusionLog.clear();
        chip_button = (Button) findViewById(R.id.chip_button);
        chip_button.setText(MyProperties.getInstance().chips[MyProperties.getInstance().chip_id]);
        layout = (RelativeLayout) findViewById(R.id.fuse_screen);
        undoButton = (Button) findViewById(R.id.fuse_undo_button);


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

        wheel.selectIndex(MyProperties.getInstance().chip_level);

        MyProperties.getInstance().chip_level = wheel.getSelectedPosition();

        wheel.setOnWheelItemSelectedListener(new WheelView.OnWheelItemSelectedListener() {
            @Override
            public void onWheelItemChanged(WheelView wheelView, int position) {
                MyProperties.getInstance().fusionLog.clear();
            }

            @Override
            public void onWheelItemSelected(WheelView wheelView, int position) {
                MyProperties.getInstance().chip_level = wheel.getSelectedPosition();
                updateFusions();

            }
        });

        // Construct the data source
        arrayOfFusions = new ArrayList<Fusion>();
        // Create the adapter to convert the array to views
        adapter = new FusionAdapter(this, arrayOfFusions);
        // Attach the adapter to a ListView
        listView = (ListView) findViewById(R.id.fuse_list);
        listView.setAdapter(adapter);

        // set up stuff for fusion log
        adapter2 = new FusionLogAdapter(this, MyProperties.getInstance().fusionLog);
        // Attach to a ListView
        listView2 = (ListView) findViewById(R.id.fuse_log_list);
        listView2.setAdapter(adapter2);

        Chip chipA = new Chip(this, 1, 0, 5);
        Chip chipB = new Chip(this, 1, 0, 5);
        adapter.add(new Fusion(this, chipA, chipB));

        chip_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                layoutInflater = (LayoutInflater) getApplicationContext().getSystemService(LAYOUT_INFLATER_SERVICE);
                ViewGroup container = (ViewGroup) layoutInflater.inflate(R.layout.chip_selector, null);

                ChipSelector selector = new ChipSelector();
                selector.ShowSelector(FuseDrawerActivity.this, layout, container);
            }
        });

        undoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(MyProperties.getInstance().fusionLog.size() != 0) {
                    MyProperties.getInstance().fusionLog.get(MyProperties.getInstance().fusionLog.size() - 1).unfuse();
                    updateFusions();
                }
            }
        });
        updateFusions();
    }

    public void updateFusions() {
        //reset adapter and reget fusions
        adapter.clear();
        adapter2 = new FusionLogAdapter(this, MyProperties.getInstance().fusionLog);

        if(MyProperties.getInstance().fusionLog.size() == 0) {
            undoButton.setAlpha(.5f);
            undoButton.setClickable(false);
        }
        else{
            undoButton.setAlpha(1f);
            undoButton.setClickable(true);
        }

        listView2.setSelection(adapter2.getCount() - 1);

        writeFusions();
        //get fusions function
    }

    public void writeFusions() {

        int arraySize = 0;
        int intialChipSize = 0;

        if (MyProperties.getInstance().chip_level == 0) {
            arraySize = 6;
            intialChipSize = 4;
        } else if (MyProperties.getInstance().chip_level == 1) {
            arraySize = 5;
            intialChipSize = 5;
        } else if (MyProperties.getInstance().chip_level == 2) {
            arraySize = 4;
            intialChipSize = 6;
        } else if (MyProperties.getInstance().chip_level == 3) {
            arraySize = 4;
            intialChipSize = 7;
        } else if (MyProperties.getInstance().chip_level == 4) {
            arraySize = 3;
            intialChipSize = 9;
        } else if (MyProperties.getInstance().chip_level == 5) {
            arraySize = 3;
            intialChipSize = 11;
        } else if (MyProperties.getInstance().chip_level == 6) {
            arraySize = 2;
            intialChipSize = 14;
        } else if (MyProperties.getInstance().chip_level == 7) {
            arraySize = 2;
            intialChipSize = 17;
        } else if (MyProperties.getInstance().chip_level == 8) {
            arraySize = 1;
            intialChipSize = 21;
        }

        Chip chipArray[] = new Chip[arraySize];
        ArrayList<Fusion> fusionArray = new ArrayList<Fusion>(0);

        //Create an array of all the possible chips
        for (int i = 0; i < arraySize; i++) {
            Chip tempChip = new Chip(this, MyProperties.getInstance().chip_id, MyProperties.getInstance().chip_level, intialChipSize + i);
            chipArray[i] = tempChip;
        }

        for(int i = 0; i < arraySize; i++){

            //Is the chip good to fuse with itself? Does it have 2 or more count?
            if(chipArray[i].inDb() && chipArray[i].selfFuse() && chipArray[i].getCount() > 1)
                fusionArray.add(new Fusion(this, chipArray[i], chipArray[i]));

            //Compare the chip to all other chips
            for(int j = 1; j < arraySize; j++){

                //Are they both in the database? Are they different chips?
                if(chipArray[i].inDb() && chipArray[j].inDb() && chipArray[i] != chipArray[j]){
                    Fusion tempFusion = new Fusion(this, chipArray[i], chipArray[j]);

                            //Is the result of their fusion a good result?
                            if(tempFusion.isGoodFusion())
                                fusionArray.add(tempFusion);

                }
            }
        }

        //Add all the accepted fusions onto the list
        for(int i = 0; i < fusionArray.size(); i++){
            adapter.add(fusionArray.get(i));
        }

    }



    public void updateButton(){
        chip_button.setText(MyProperties.getInstance().chips[MyProperties.getInstance().chip_id]);
        MyProperties.getInstance().fusionLog.clear();
        updateFusions();
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
        getMenuInflater().inflate(R.menu.fuse_drawer, menu);
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
            Intent intent = new Intent(FuseDrawerActivity.this, AddDrawerActivity.class);
            startActivity(intent);

        } else if (id == R.id.nav_fuse) {
            Intent intent = new Intent(FuseDrawerActivity.this, FuseDrawerActivity.class);
            startActivity(intent);

        } else if (id == R.id.nav_info) {
            Intent intent = new Intent(FuseDrawerActivity.this, InfoDrawerActivity.class);
            startActivity(intent);

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
