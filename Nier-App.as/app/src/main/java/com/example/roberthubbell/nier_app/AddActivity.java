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

    public TextView chip1;
    public TextView chip2;
    public TextView chip3;
    public TextView chip4;
    public TextView chip5;
    public TextView chip6;


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
        chip1 = (TextView) findViewById(R.id.chipView1);
        chip2 = (TextView) findViewById(R.id.chipView2);
        chip3 = (TextView) findViewById(R.id.chipView3);
        chip4 = (TextView) findViewById(R.id.chipView4);
        chip5 = (TextView) findViewById(R.id.chipView5);
        chip6 = (TextView) findViewById(R.id.chipView6);

        clearText();

        chip_button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                layoutInflater = (LayoutInflater) getApplicationContext().getSystemService(LAYOUT_INFLATER_SERVICE);
                ViewGroup container = (ViewGroup) layoutInflater.inflate(R.layout.chip_selector, null);

                ChipSelector selector = new ChipSelector();
<<<<<<< HEAD
                selector.ShowSelector(AddActivity.this, layout, container);
=======
                // selector.ShowSelector(AddActivity.this, layout, container);
>>>>>>> bc39747cbddc606e276105118b486a039ec7baa7
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
                level = 0;
                size = 0; //unselect a size
                writeChips();
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
                level = 1;
                size = 0; //unselect a size
                writeChips();
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
                level = 2;
                size = 0; //unselect a size
                writeChips();
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
                level = 3;
                size = 0; //unselect a size
                writeChips();
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
                level = 4;
                size = 0; //unselect a size
                writeChips();
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
                level = 5;
                size = 0; //unselect a size
                writeChips();
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
                level = 6;
                size = 0; //unselect a size
                writeChips();
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
                level = 7;
                size = 0; //unselect a size
                writeChips();
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
                level = 8;
                size = 0; //unselect a size
                writeChips();
            }
        });

        //size buttons

        size0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (level == 0)
                    size = 4;
                else if (level == 1)
                    size = 5;
                else if (level == 2)
                    size = 6;
                else if (level == 3)
                    size = 7;
                else if (level == 4)
                    size = 9;
                else if (level == 5)
                    size = 11;
                else if (level == 6)
                    size = 14;
                else if (level == 7)
                    size = 17;
            }
        });

        size1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (level == 0)
                    size = 5;
                else if (level == 1)
                    size = 6;
                else if (level == 2)
                    size = 7;
                else if (level == 3)
                    size = 8;
                else if (level == 4)
                    size = 10;
                else if (level == 5)
                    size = 12;
                else if (level == 6)
                    size = 15;
                else if (level == 7)
                    size = 18;
                else if (level == 8)
                    size = 21;
            }
        });

        size2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (level == 0)
                    size = 6;
                else if (level == 1)
                    size = 7;
                else if (level == 2)
                    size = 8;
                else if (level == 3)
                    size = 9;
                else if (level == 4)
                    size = 11;
                else if (level == 5)
                    size = 13;
            }
        });

        size3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (level == 0)
                    size = 7;
                else if (level == 1)
                    size = 8;
            }
        });

        size4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (level == 0)
                    size = 8;
                else if (level == 1)
                    size = 9;
                else if (level == 2)
                    size = 9;
                else if (level == 3)
                    size = 10;
            }
        });

        size5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (level == 0)
                    size = 9;
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
        chip1.setText("");
        chip2.setText("");
        chip3.setText("");
        chip4.setText("");
        chip5.setText("");
        chip6.setText("");
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

        if(chipArray[0].inDb())
            chip1.setText(chipArray[0].getSize() + "     " + Integer.toString(chipArray[0].getCount()));
        if(arraySize > 1){
            if(chipArray[1].inDb())
                chip2.setText(chipArray[1].getSize() + "     " + Integer.toString(chipArray[1].getCount()));
        }
        if(arraySize > 2){
            if(chipArray[2].inDb())
                chip3.setText(chipArray[2].getSize() + "     " + Integer.toString(chipArray[2].getCount()));
        }
        if(arraySize > 3){
            if(chipArray[3].inDb())
                chip4.setText(chipArray[3].getSize() + "     " + Integer.toString(chipArray[3].getCount()));
        }
        if(arraySize > 4){
            if(chipArray[4].inDb())
                chip5.setText(chipArray[4].getSize() + "     " + Integer.toString(chipArray[4].getCount()));
        }
        if(arraySize > 5){
            if(chipArray[5].inDb())
                chip6.setText(chipArray[5].getSize() + "     " + Integer.toString(chipArray[5].getCount()));
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
