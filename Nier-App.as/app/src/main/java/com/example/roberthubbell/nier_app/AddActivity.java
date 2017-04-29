package com.example.roberthubbell.nier_app;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.roberthubbell.nier_app.chip.Chip;

public class AddActivity extends AppCompatActivity {

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




    private int level;
    private int size;

    private LayoutInflater layoutInflater;
    private RelativeLayout layout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);
        chip_button = (Button) findViewById(R.id.chip_button);
        chip_button.setText(MyProperties.getInstance().chips[MyProperties.getInstance().chip_id]);
        phantom_button = (Button) findViewById(R.id.phantom_chip_button);
        phantom_button.setVisibility(View.INVISIBLE);
        add_button = (Button) findViewById(R.id.add_button);
        remove_button = (Button) findViewById(R.id.remove_button);
        layout = (RelativeLayout) findViewById(R.id.add_screen);


        clearText();

        chip_button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                layoutInflater = (LayoutInflater) getApplicationContext().getSystemService(LAYOUT_INFLATER_SERVICE);
                ViewGroup container = (ViewGroup) layoutInflater.inflate(R.layout.chip_selector, null);

                ChipSelector selector = new ChipSelector();
                //selector.ShowSelector(AddActivity.this, layout, container);
            }
        });

        level_text = (TextView) findViewById(R.id.level_text);

        // create instance of buttons



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
        unstage();
    }

    public void unstage(){
        level = 0;
        size = 0;
        size0.setVisibility(View.GONE);
        size1.setVisibility(View.GONE);
        size2.setVisibility(View.GONE);
        size3.setVisibility(View.GONE);
        size4.setVisibility(View.GONE);
        size5.setVisibility(View.GONE);

        clearText();

    }

    public void clearText(){

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
            arraySize = 3;
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
            chipArray[i] = new Chip(this, MyProperties.getInstance().chip_id, level, intialChipSize+i);
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
}
