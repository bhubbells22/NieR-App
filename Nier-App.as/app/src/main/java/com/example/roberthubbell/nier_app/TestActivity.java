package com.example.roberthubbell.nier_app;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.example.roberthubbell.nier_app.MyProperties;

import com.example.roberthubbell.nier_app.chip.Chip;
import com.example.roberthubbell.nier_app.database.DatabaseAccess;

import java.util.List;

public class TestActivity extends AppCompatActivity {

    private TextView chipName;
    private TextView chipCount;
    private TextView chipInDb;

    private Button increase;
    private Button decrease;

    private Chip chip;

    /*chip selector*/
    public Button chip_button;
    private LayoutInflater layoutInflater;
    private RelativeLayout layout;
    /*chip selector*/

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_view);
        chipName = (TextView) findViewById(R.id.chipName);
        chipCount = (TextView) findViewById(R.id.chipCount);
        chipInDb = (TextView) findViewById(R.id.inDB);

        increase = (Button) findViewById(R.id.add);
        decrease = (Button) findViewById(R.id.remove);

        chip = new Chip(this, MyProperties.getInstance().chip_id, 1, 6);
        chipName.setText(chip.getName());
        chipCount.setText(Integer.toString(chip.getCount()));

        if(chip.inDb(this))
            chipInDb.setText("True");
        else
            chipInDb.setText("False");

        increase.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                increase();
            }
        });

        decrease.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                decrease();
            }
        });

        /*chip selector*/
        chip_button = (Button) findViewById(R.id.chip_button);
        chip_button.setText(MyProperties.getInstance().chips[MyProperties.getInstance().chip_id]);
        layout = (RelativeLayout) findViewById(R.id.test_screen);

        chip_button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                layoutInflater = (LayoutInflater) getApplicationContext().getSystemService(LAYOUT_INFLATER_SERVICE);
                ViewGroup container = (ViewGroup) layoutInflater.inflate(R.layout.chip_selector, null);

                ChipSelector selector = new ChipSelector();
                selector.ShowSelector(TestActivity.this, layout, container);
            }
        });


        /*chip selector*/





    }

    public void update(){
        chip = new Chip(this, MyProperties.getInstance().chip_id, 1, 6);
        chipName.setText(chip.getName());
        chipCount.setText(Integer.toString(chip.getCount()));

        if(chip.inDb(this))
            chipInDb.setText("True");
        else
            chipInDb.setText("False");

    }

    public void increase(){
        chip.increaseCount(this);
        update();
    }

    public void decrease(){
        chip.decreaseCount(this);
        update();
    }

    public void updateButton(){
        chip_button.setText(MyProperties.getInstance().chips[MyProperties.getInstance().chip_id]);
        update();
    }



}
