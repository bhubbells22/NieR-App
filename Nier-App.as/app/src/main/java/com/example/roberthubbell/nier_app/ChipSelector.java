package com.example.roberthubbell.nier_app;

import android.graphics.Color;
import android.support.constraint.ConstraintLayout;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.ToggleButton;

/**
 * Created by Brandon on 4/12/2017.
 */

public class ChipSelector {

    private Button chip_button;
    private PopupWindow popupWindow;
    private LayoutInflater layoutInflater;
    private ConstraintLayout homeScreenLayout;

    private ToggleButton attack_button;
    private ToggleButton defense_button;
    private ToggleButton support_button;
    private ToggleButton hacking_button;

    private TextView chip1;
    private TextView chip2;
    private TextView chip3;
    private TextView chip4;
    private TextView chip5;
    private TextView chip6;
    private TextView chip7;
    private TextView chip8;
    private TextView chip9;
    private TextView chip10;
    private TextView chip11;
    private TextView chip12;
    private TextView[] chips = new TextView[13];
    public void ShowSelector(final AddActivity parent, RelativeLayout layout, ViewGroup container){


        //Set up chip select buttons

        attack_button = (ToggleButton) container.findViewById(R.id.attack_button);
        defense_button = (ToggleButton) container.findViewById(R.id.defense_button);
        support_button = (ToggleButton) container.findViewById(R.id.support_button);
        hacking_button = (ToggleButton) container.findViewById(R.id.hacking_button);

        //Set up chips
        chip1 = (TextView) container.findViewById(R.id.chip1);
        chip2 = (TextView) container.findViewById(R.id.chip2);
        chip3 = (TextView) container.findViewById(R.id.chip3);
        chip4 = (TextView) container.findViewById(R.id.chip4);
        chip5 = (TextView) container.findViewById(R.id.chip5);
        chip6 = (TextView) container.findViewById(R.id.chip6);
        chip7 = (TextView) container.findViewById(R.id.chip7);
        chip8 = (TextView) container.findViewById(R.id.chip8);
        chip9 = (TextView) container.findViewById(R.id.chip9);
        chip10 = (TextView) container.findViewById(R.id.chip10);
        chip11 = (TextView) container.findViewById(R.id.chip11);
        chip12 = (TextView) container.findViewById(R.id.chip12);

        chips[1]=chip1;
        chips[2]=chip2;
        chips[3]=chip3;
        chips[4]=chip4;
        chips[5]=chip5;
        chips[6]=chip6;
        chips[7]=chip7;
        chips[8]=chip8;
        chips[9]=chip9;
        chips[10]=chip10;
        chips[11]=chip11;
        chips[12]=chip12;

        //Draw initial box
        popupWindow  = new PopupWindow(container, 1000, 425, true);
        popupWindow.showAtLocation(layout, Gravity.NO_GRAVITY, 50, 100);
        //Starts on attack chips, but will save last selected category
        if(MyProperties.getInstance().chip_category == 1) {
            int chips_in_category = 8;
            attack_button.setChecked(true);
            defense_button.setChecked(false);
            support_button.setChecked(false);
            hacking_button.setChecked(false);
            attack_button.setTextColor(Color.RED);
            defense_button.setTextColor(Color.BLACK);
            support_button.setTextColor(Color.BLACK);
            hacking_button.setTextColor(Color.BLACK);


            int offset = 0;
            for(int i = 1; i<=chips_in_category; i++){
                chips[i].setText(MyProperties.getInstance().chips[(i) + offset]);
            }
            for(int i = chips_in_category+1; i<13; i++){
                chips[i].setText("");
            }
        }
        else if(MyProperties.getInstance().chip_category == 2) {
            int chips_in_category = 10;
            attack_button.setChecked(false);
            defense_button.setChecked(true);
            support_button.setChecked(false);
            hacking_button.setChecked(false);
            attack_button.setTextColor(Color.BLACK);
            defense_button.setTextColor(Color.RED);
            support_button.setTextColor(Color.BLACK);
            hacking_button.setTextColor(Color.BLACK);

            int offset = 8;
            for(int i = 1; i<=chips_in_category; i++){
                chips[i].setText(MyProperties.getInstance().chips[(i) + offset]);
            }
            for(int i = chips_in_category+1; i<13; i++){
                chips[i].setText("");
            }
        }
        else if(MyProperties.getInstance().chip_category == 3) {
            int chips_in_category = 9;
            attack_button.setChecked(false);
            defense_button.setChecked(false);
            support_button.setChecked(true);
            hacking_button.setChecked(false);

            attack_button.setTextColor(Color.BLACK);
            defense_button.setTextColor(Color.BLACK);
            support_button.setTextColor(Color.RED);
            hacking_button.setTextColor(Color.BLACK);

            int offset = 18;
            for(int i = 1; i<=chips_in_category; i++){
                chips[i].setText(MyProperties.getInstance().chips[(i) + offset]);
            }
            for(int i = chips_in_category+1; i<13; i++){
                chips[i].setText("");
            }
        }

        else if(MyProperties.getInstance().chip_category == 4) {
            MyProperties.getInstance().chip_category = 4;
            int chips_in_category = 4;
            attack_button.setChecked(false);
            defense_button.setChecked(false);
            support_button.setChecked(false);
            hacking_button.setChecked(true);

            attack_button.setTextColor(Color.BLACK);
            defense_button.setTextColor(Color.BLACK);
            support_button.setTextColor(Color.BLACK);
            hacking_button.setTextColor(Color.RED);

            int offset = 27;
            for(int i = 1; i<=chips_in_category; i++){
                chips[i].setText(MyProperties.getInstance().chips[(i) + offset]);
            }
            for(int i = chips_in_category+1; i<13; i++){
                chips[i].setText("");
            }
        }

        //Chip button onClickListeners
        chip1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                if(MyProperties.getInstance().chip_category == 1){
                    MyProperties.getInstance().chip_id = 1;
                    parent.updateButton();
                    popupWindow.dismiss();

                }
                else if(MyProperties.getInstance().chip_category == 2){
                    MyProperties.getInstance().chip_id = 9;
                    parent.updateButton();
                    popupWindow.dismiss();
                }
                else if(MyProperties.getInstance().chip_category == 3){
                    MyProperties.getInstance().chip_id = 19;
                    parent.updateButton();
                    popupWindow.dismiss();
                }
                else if(MyProperties.getInstance().chip_category == 4){
                    MyProperties.getInstance().chip_id = 28;
                    parent.updateButton();
                    popupWindow.dismiss();
                }
            }
        });

        chip2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                if(MyProperties.getInstance().chip_category == 1){
                    MyProperties.getInstance().chip_id = 2;
                    parent.updateButton();
                    popupWindow.dismiss();

                }
                else if(MyProperties.getInstance().chip_category == 2){
                    MyProperties.getInstance().chip_id = 10;
                    parent.updateButton();
                    popupWindow.dismiss();
                }
                else if(MyProperties.getInstance().chip_category == 3){
                    MyProperties.getInstance().chip_id = 20;
                    parent.updateButton();
                    popupWindow.dismiss();
                }
                else if(MyProperties.getInstance().chip_category == 4){
                    MyProperties.getInstance().chip_id = 29;
                    parent.updateButton();
                    popupWindow.dismiss();
                }
            }
        });

        chip3.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                if(MyProperties.getInstance().chip_category == 1){
                    MyProperties.getInstance().chip_id = 3;
                    parent.updateButton();
                    popupWindow.dismiss();

                }
                else if(MyProperties.getInstance().chip_category == 2){
                    MyProperties.getInstance().chip_id = 11;
                    parent.updateButton();
                    popupWindow.dismiss();
                }
                else if(MyProperties.getInstance().chip_category == 3){
                    MyProperties.getInstance().chip_id = 21;
                    parent.updateButton();
                    popupWindow.dismiss();
                }
                else if(MyProperties.getInstance().chip_category == 4){
                    MyProperties.getInstance().chip_id = 30;
                    parent.updateButton();
                    popupWindow.dismiss();
                }
            }
        });

        chip4.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                if(MyProperties.getInstance().chip_category == 1){
                    MyProperties.getInstance().chip_id = 4;
                    parent.updateButton();
                    popupWindow.dismiss();

                }
                else if(MyProperties.getInstance().chip_category == 2){
                    MyProperties.getInstance().chip_id = 12;
                    parent.updateButton();
                    popupWindow.dismiss();
                }
                else if(MyProperties.getInstance().chip_category == 3){
                    MyProperties.getInstance().chip_id = 22;
                    parent.updateButton();
                    popupWindow.dismiss();
                }
                else if(MyProperties.getInstance().chip_category == 4){
                    MyProperties.getInstance().chip_id = 31;
                    parent.updateButton();
                    popupWindow.dismiss();
                }
            }
        });

        chip5.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                if(MyProperties.getInstance().chip_category == 1){
                    MyProperties.getInstance().chip_id = 5;
                    parent.updateButton();
                    popupWindow.dismiss();

                }
                else if(MyProperties.getInstance().chip_category == 2){
                    MyProperties.getInstance().chip_id = 13;
                    parent.updateButton();
                    popupWindow.dismiss();
                }
                else if(MyProperties.getInstance().chip_category == 3){
                    MyProperties.getInstance().chip_id = 23;
                    parent.updateButton();
                    popupWindow.dismiss();
                }
            }
        });

        chip6.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                if(MyProperties.getInstance().chip_category == 1){
                    MyProperties.getInstance().chip_id = 6;
                    parent.updateButton();
                    popupWindow.dismiss();

                }
                else if(MyProperties.getInstance().chip_category == 2){
                    MyProperties.getInstance().chip_id = 14;
                    parent.updateButton();
                    popupWindow.dismiss();
                }
                else if(MyProperties.getInstance().chip_category == 3){
                    MyProperties.getInstance().chip_id = 24;
                    parent.updateButton();
                    popupWindow.dismiss();
                }
            }
        });

        chip7.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                if(MyProperties.getInstance().chip_category == 1){
                    MyProperties.getInstance().chip_id = 7;
                    parent.updateButton();
                    popupWindow.dismiss();

                }
                else if(MyProperties.getInstance().chip_category == 2){
                    MyProperties.getInstance().chip_id = 15;
                    parent.updateButton();
                    popupWindow.dismiss();
                }
                else if(MyProperties.getInstance().chip_category == 3){
                    MyProperties.getInstance().chip_id = 25;
                    parent.updateButton();
                    popupWindow.dismiss();
                }
            }
        });

        chip8.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                if(MyProperties.getInstance().chip_category == 1){
                    MyProperties.getInstance().chip_id = 8;
                    parent.updateButton();
                    popupWindow.dismiss();

                }
                else if(MyProperties.getInstance().chip_category == 2){
                    MyProperties.getInstance().chip_id = 16;
                    parent.updateButton();
                    popupWindow.dismiss();
                }
                else if(MyProperties.getInstance().chip_category == 3){
                    MyProperties.getInstance().chip_id = 26;
                    parent.updateButton();
                    popupWindow.dismiss();
                }
            }
        });

        chip9.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                if(MyProperties.getInstance().chip_category == 2){
                    MyProperties.getInstance().chip_id = 17;
                    parent.updateButton();
                    popupWindow.dismiss();
                }
                else if(MyProperties.getInstance().chip_category == 3){
                    MyProperties.getInstance().chip_id = 27;
                    parent.updateButton();
                    popupWindow.dismiss();
                }
            }
        });

        chip10.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                if(MyProperties.getInstance().chip_category == 2){
                    MyProperties.getInstance().chip_id = 18;
                    parent.updateButton();
                    popupWindow.dismiss();
                }
            }
        });

        chip11.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                //do nothing
            }
        });

        chip12.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                //do nothing
            }
        });

        //Chip category onClickListeners
        attack_button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                MyProperties.getInstance().chip_category = 1;
                int chips_in_category = 8;
                attack_button.setChecked(true);
                defense_button.setChecked(false);
                support_button.setChecked(false);
                hacking_button.setChecked(false);
                attack_button.setTextColor(Color.RED);
                defense_button.setTextColor(Color.BLACK);
                support_button.setTextColor(Color.BLACK);
                hacking_button.setTextColor(Color.BLACK);

                int offset = 0;
                for(int i = 1; i<=chips_in_category; i++){
                    chips[i].setText(MyProperties.getInstance().chips[(i) + offset]);
                }
                for(int i = chips_in_category+1; i<13; i++){
                    chips[i].setText("");
                }
            }
        });

        defense_button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                MyProperties.getInstance().chip_category = 2;
                int chips_in_category = 10;
                attack_button.setChecked(false);
                defense_button.setChecked(true);
                support_button.setChecked(false);
                hacking_button.setChecked(false);
                attack_button.setTextColor(Color.BLACK);
                defense_button.setTextColor(Color.RED);
                support_button.setTextColor(Color.BLACK);
                hacking_button.setTextColor(Color.BLACK);

                int offset = 8;
                for(int i = 1; i<=chips_in_category; i++){
                    chips[i].setText(MyProperties.getInstance().chips[(i) + offset]);
                }
                for(int i = chips_in_category+1; i<13; i++){
                    chips[i].setText("");
                }
            }
        });

        support_button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                MyProperties.getInstance().chip_category = 3;
                int chips_in_category = 9;
                attack_button.setChecked(false);
                defense_button.setChecked(false);
                support_button.setChecked(true);
                hacking_button.setChecked(false);

                attack_button.setTextColor(Color.BLACK);
                defense_button.setTextColor(Color.BLACK);
                support_button.setTextColor(Color.RED);
                hacking_button.setTextColor(Color.BLACK);

                int offset = 18;
                for(int i = 1; i<=chips_in_category; i++){
                    chips[i].setText(MyProperties.getInstance().chips[(i) + offset]);
                }
                for(int i = chips_in_category+1; i<13; i++){
                    chips[i].setText("");
                }
            }
        });

        hacking_button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                MyProperties.getInstance().chip_category = 4;
                int chips_in_category = 4;
                attack_button.setChecked(false);
                defense_button.setChecked(false);
                support_button.setChecked(false);
                hacking_button.setChecked(true);

                attack_button.setTextColor(Color.BLACK);
                defense_button.setTextColor(Color.BLACK);
                support_button.setTextColor(Color.BLACK);
                hacking_button.setTextColor(Color.RED);

                int offset = 27;
                for(int i = 1; i<=chips_in_category; i++){
                    chips[i].setText(MyProperties.getInstance().chips[(i) + offset]);
                }
                for(int i = chips_in_category+1; i<13; i++){
                    chips[i].setText("");
                }
            }
        });



        container.setOnTouchListener(new View.OnTouchListener(){
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                popupWindow.dismiss();
                return true;
            }
        });
    }

    public void ShowSelector(final FuseActivity parent, RelativeLayout layout, ViewGroup container){


        //Set up chip select buttons

        attack_button = (ToggleButton) container.findViewById(R.id.attack_button);
        defense_button = (ToggleButton) container.findViewById(R.id.defense_button);
        support_button = (ToggleButton) container.findViewById(R.id.support_button);
        hacking_button = (ToggleButton) container.findViewById(R.id.hacking_button);

        //Set up chips
        chip1 = (TextView) container.findViewById(R.id.chip1);
        chip2 = (TextView) container.findViewById(R.id.chip2);
        chip3 = (TextView) container.findViewById(R.id.chip3);
        chip4 = (TextView) container.findViewById(R.id.chip4);
        chip5 = (TextView) container.findViewById(R.id.chip5);
        chip6 = (TextView) container.findViewById(R.id.chip6);
        chip7 = (TextView) container.findViewById(R.id.chip7);
        chip8 = (TextView) container.findViewById(R.id.chip8);
        chip9 = (TextView) container.findViewById(R.id.chip9);
        chip10 = (TextView) container.findViewById(R.id.chip10);
        chip11 = (TextView) container.findViewById(R.id.chip11);
        chip12 = (TextView) container.findViewById(R.id.chip12);

        chips[1]=chip1;
        chips[2]=chip2;
        chips[3]=chip3;
        chips[4]=chip4;
        chips[5]=chip5;
        chips[6]=chip6;
        chips[7]=chip7;
        chips[8]=chip8;
        chips[9]=chip9;
        chips[10]=chip10;
        chips[11]=chip11;
        chips[12]=chip12;

        //Draw initial box
        popupWindow  = new PopupWindow(container, 1000, 425, true);
        popupWindow.showAtLocation(layout, Gravity.NO_GRAVITY, 50, 100);
        //Starts on attack chips, but will save last selected category
        if(MyProperties.getInstance().chip_category == 1) {
            int chips_in_category = 8;
            attack_button.setChecked(true);
            defense_button.setChecked(false);
            support_button.setChecked(false);
            hacking_button.setChecked(false);
            attack_button.setTextColor(Color.RED);
            defense_button.setTextColor(Color.BLACK);
            support_button.setTextColor(Color.BLACK);
            hacking_button.setTextColor(Color.BLACK);


            int offset = 0;
            for(int i = 1; i<=chips_in_category; i++){
                chips[i].setText(MyProperties.getInstance().chips[(i) + offset]);
            }
            for(int i = chips_in_category+1; i<13; i++){
                chips[i].setText("");
            }

        }
        else if(MyProperties.getInstance().chip_category == 2) {
            int chips_in_category = 10;
            attack_button.setChecked(false);
            defense_button.setChecked(true);
            support_button.setChecked(false);
            hacking_button.setChecked(false);
            attack_button.setTextColor(Color.BLACK);
            defense_button.setTextColor(Color.RED);
            support_button.setTextColor(Color.BLACK);
            hacking_button.setTextColor(Color.BLACK);

            int offset = 8;
            for(int i = 1; i<=chips_in_category; i++){
                chips[i].setText(MyProperties.getInstance().chips[(i) + offset]);
            }
            for(int i = chips_in_category+1; i<13; i++){
                chips[i].setText("");
            }
        }
        else if(MyProperties.getInstance().chip_category == 3) {
            int chips_in_category = 9;
            attack_button.setChecked(false);
            defense_button.setChecked(false);
            support_button.setChecked(true);
            hacking_button.setChecked(false);

            attack_button.setTextColor(Color.BLACK);
            defense_button.setTextColor(Color.BLACK);
            support_button.setTextColor(Color.RED);
            hacking_button.setTextColor(Color.BLACK);

            int offset = 18;
            for(int i = 1; i<=chips_in_category; i++){
                chips[i].setText(MyProperties.getInstance().chips[(i) + offset]);
            }
            for(int i = chips_in_category+1; i<13; i++){
                chips[i].setText("");
            }
        }

        else if(MyProperties.getInstance().chip_category == 4) {
            MyProperties.getInstance().chip_category = 4;
            int chips_in_category = 4;
            attack_button.setChecked(false);
            defense_button.setChecked(false);
            support_button.setChecked(false);
            hacking_button.setChecked(true);

            attack_button.setTextColor(Color.BLACK);
            defense_button.setTextColor(Color.BLACK);
            support_button.setTextColor(Color.BLACK);
            hacking_button.setTextColor(Color.RED);

            int offset = 27;
            for(int i = 1; i<=chips_in_category; i++){
                chips[i].setText(MyProperties.getInstance().chips[(i) + offset]);
            }
            for(int i = chips_in_category+1; i<13; i++){
                chips[i].setText("");
            }
        }

        //Chip button onClickListeners
        chip1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                if(MyProperties.getInstance().chip_category == 1){
                    MyProperties.getInstance().chip_id = 1;
                    parent.updateButton();
                    popupWindow.dismiss();

                }
                else if(MyProperties.getInstance().chip_category == 2){
                    MyProperties.getInstance().chip_id = 9;
                    parent.updateButton();
                    popupWindow.dismiss();
                }
                else if(MyProperties.getInstance().chip_category == 3){
                    MyProperties.getInstance().chip_id = 19;
                    parent.updateButton();
                    popupWindow.dismiss();
                }
                else if(MyProperties.getInstance().chip_category == 4){
                    MyProperties.getInstance().chip_id = 28;
                    parent.updateButton();
                    popupWindow.dismiss();
                }
            }
        });

        chip2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                if(MyProperties.getInstance().chip_category == 1){
                    MyProperties.getInstance().chip_id = 2;
                    parent.updateButton();
                    popupWindow.dismiss();

                }
                else if(MyProperties.getInstance().chip_category == 2){
                    MyProperties.getInstance().chip_id = 10;
                    parent.updateButton();
                    popupWindow.dismiss();
                }
                else if(MyProperties.getInstance().chip_category == 3){
                    MyProperties.getInstance().chip_id = 20;
                    parent.updateButton();
                    popupWindow.dismiss();
                }
                else if(MyProperties.getInstance().chip_category == 4){
                    MyProperties.getInstance().chip_id = 29;
                    parent.updateButton();
                    popupWindow.dismiss();
                }
            }
        });

        chip3.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                if(MyProperties.getInstance().chip_category == 1){
                    MyProperties.getInstance().chip_id = 3;
                    parent.updateButton();
                    popupWindow.dismiss();

                }
                else if(MyProperties.getInstance().chip_category == 2){
                    MyProperties.getInstance().chip_id = 11;
                    parent.updateButton();
                    popupWindow.dismiss();
                }
                else if(MyProperties.getInstance().chip_category == 3){
                    MyProperties.getInstance().chip_id = 21;
                    parent.updateButton();
                    popupWindow.dismiss();
                }
                else if(MyProperties.getInstance().chip_category == 4){
                    MyProperties.getInstance().chip_id = 30;
                    parent.updateButton();
                    popupWindow.dismiss();
                }
            }
        });

        chip4.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                if(MyProperties.getInstance().chip_category == 1){
                    MyProperties.getInstance().chip_id = 4;
                    parent.updateButton();
                    popupWindow.dismiss();

                }
                else if(MyProperties.getInstance().chip_category == 2){
                    MyProperties.getInstance().chip_id = 12;
                    parent.updateButton();
                    popupWindow.dismiss();
                }
                else if(MyProperties.getInstance().chip_category == 3){
                    MyProperties.getInstance().chip_id = 22;
                    parent.updateButton();
                    popupWindow.dismiss();
                }
                else if(MyProperties.getInstance().chip_category == 4){
                    MyProperties.getInstance().chip_id = 31;
                    parent.updateButton();
                    popupWindow.dismiss();
                }
            }
        });

        chip5.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                if(MyProperties.getInstance().chip_category == 1){
                    MyProperties.getInstance().chip_id = 5;
                    parent.updateButton();
                    popupWindow.dismiss();

                }
                else if(MyProperties.getInstance().chip_category == 2){
                    MyProperties.getInstance().chip_id = 13;
                    parent.updateButton();
                    popupWindow.dismiss();
                }
                else if(MyProperties.getInstance().chip_category == 3){
                    MyProperties.getInstance().chip_id = 23;
                    parent.updateButton();
                    popupWindow.dismiss();
                }
            }
        });

        chip6.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                if(MyProperties.getInstance().chip_category == 1){
                    MyProperties.getInstance().chip_id = 6;
                    parent.updateButton();
                    popupWindow.dismiss();

                }
                else if(MyProperties.getInstance().chip_category == 2){
                    MyProperties.getInstance().chip_id = 14;
                    parent.updateButton();
                    popupWindow.dismiss();
                }
                else if(MyProperties.getInstance().chip_category == 3){
                    MyProperties.getInstance().chip_id = 24;
                    parent.updateButton();
                    popupWindow.dismiss();
                }
            }
        });

        chip7.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                if(MyProperties.getInstance().chip_category == 1){
                    MyProperties.getInstance().chip_id = 7;
                    parent.updateButton();
                    popupWindow.dismiss();

                }
                else if(MyProperties.getInstance().chip_category == 2){
                    MyProperties.getInstance().chip_id = 15;
                    parent.updateButton();
                    popupWindow.dismiss();
                }
                else if(MyProperties.getInstance().chip_category == 3){
                    MyProperties.getInstance().chip_id = 25;
                    parent.updateButton();
                    popupWindow.dismiss();
                }
            }
        });

        chip8.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                if(MyProperties.getInstance().chip_category == 1){
                    MyProperties.getInstance().chip_id = 8;
                    parent.updateButton();
                    popupWindow.dismiss();

                }
                else if(MyProperties.getInstance().chip_category == 2){
                    MyProperties.getInstance().chip_id = 16;
                    parent.updateButton();
                    popupWindow.dismiss();
                }
                else if(MyProperties.getInstance().chip_category == 3){
                    MyProperties.getInstance().chip_id = 26;
                    parent.updateButton();
                    popupWindow.dismiss();
                }
            }
        });

        chip9.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                if(MyProperties.getInstance().chip_category == 2){
                    MyProperties.getInstance().chip_id = 17;
                    parent.updateButton();
                    popupWindow.dismiss();
                }
                else if(MyProperties.getInstance().chip_category == 3){
                    MyProperties.getInstance().chip_id = 27;
                    parent.updateButton();
                    popupWindow.dismiss();
                }
            }
        });

        chip10.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                if(MyProperties.getInstance().chip_category == 2){
                    MyProperties.getInstance().chip_id = 18;
                    parent.updateButton();
                    popupWindow.dismiss();
                }
            }
        });

        chip11.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                //do nothing
            }
        });

        chip12.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                //do nothing
            }
        });

        //Chip category onClickListeners
        attack_button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                MyProperties.getInstance().chip_category = 1;
                int chips_in_category = 8;
                attack_button.setChecked(true);
                defense_button.setChecked(false);
                support_button.setChecked(false);
                hacking_button.setChecked(false);
                attack_button.setTextColor(Color.RED);
                defense_button.setTextColor(Color.BLACK);
                support_button.setTextColor(Color.BLACK);
                hacking_button.setTextColor(Color.BLACK);

                int offset = 0;
                for(int i = 1; i<=chips_in_category; i++){
                    chips[i].setText(MyProperties.getInstance().chips[(i) + offset]);
                }
                for(int i = chips_in_category+1; i<13; i++){
                    chips[i].setText("");
                }
            }
        });

        defense_button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                MyProperties.getInstance().chip_category = 2;
                int chips_in_category = 10;
                attack_button.setChecked(false);
                defense_button.setChecked(true);
                support_button.setChecked(false);
                hacking_button.setChecked(false);
                attack_button.setTextColor(Color.BLACK);
                defense_button.setTextColor(Color.RED);
                support_button.setTextColor(Color.BLACK);
                hacking_button.setTextColor(Color.BLACK);

                int offset = 8;
                for(int i = 1; i<=chips_in_category; i++){
                    chips[i].setText(MyProperties.getInstance().chips[(i) + offset]);
                }
                for(int i = chips_in_category+1; i<13; i++){
                    chips[i].setText("");
                }
            }
        });

        support_button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                MyProperties.getInstance().chip_category = 3;
                int chips_in_category = 9;
                attack_button.setChecked(false);
                defense_button.setChecked(false);
                support_button.setChecked(true);
                hacking_button.setChecked(false);

                attack_button.setTextColor(Color.BLACK);
                defense_button.setTextColor(Color.BLACK);
                support_button.setTextColor(Color.RED);
                hacking_button.setTextColor(Color.BLACK);

                int offset = 18;
                for(int i = 1; i<=chips_in_category; i++){
                    chips[i].setText(MyProperties.getInstance().chips[(i) + offset]);
                }
                for(int i = chips_in_category+1; i<13; i++){
                    chips[i].setText("");
                }
            }
        });

        hacking_button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                MyProperties.getInstance().chip_category = 4;
                int chips_in_category = 4;
                attack_button.setChecked(false);
                defense_button.setChecked(false);
                support_button.setChecked(false);
                hacking_button.setChecked(true);

                attack_button.setTextColor(Color.BLACK);
                defense_button.setTextColor(Color.BLACK);
                support_button.setTextColor(Color.BLACK);
                hacking_button.setTextColor(Color.RED);

                int offset = 27;
                for(int i = 1; i<=chips_in_category; i++){
                    chips[i].setText(MyProperties.getInstance().chips[(i) + offset]);
                }
                for(int i = chips_in_category+1; i<13; i++){
                    chips[i].setText("");
                }
            }
        });



        container.setOnTouchListener(new View.OnTouchListener(){
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                popupWindow.dismiss();
                return true;
            }
        });
    }

    public void ShowSelector(final InfoActivity parent, RelativeLayout layout, ViewGroup container){


        //Set up chip select buttons

        attack_button = (ToggleButton) container.findViewById(R.id.attack_button);
        defense_button = (ToggleButton) container.findViewById(R.id.defense_button);
        support_button = (ToggleButton) container.findViewById(R.id.support_button);
        hacking_button = (ToggleButton) container.findViewById(R.id.hacking_button);

        //Set up chips
        chip1 = (TextView) container.findViewById(R.id.chip1);
        chip2 = (TextView) container.findViewById(R.id.chip2);
        chip3 = (TextView) container.findViewById(R.id.chip3);
        chip4 = (TextView) container.findViewById(R.id.chip4);
        chip5 = (TextView) container.findViewById(R.id.chip5);
        chip6 = (TextView) container.findViewById(R.id.chip6);
        chip7 = (TextView) container.findViewById(R.id.chip7);
        chip8 = (TextView) container.findViewById(R.id.chip8);
        chip9 = (TextView) container.findViewById(R.id.chip9);
        chip10 = (TextView) container.findViewById(R.id.chip10);
        chip11 = (TextView) container.findViewById(R.id.chip11);
        chip12 = (TextView) container.findViewById(R.id.chip12);

        chips[1]=chip1;
        chips[2]=chip2;
        chips[3]=chip3;
        chips[4]=chip4;
        chips[5]=chip5;
        chips[6]=chip6;
        chips[7]=chip7;
        chips[8]=chip8;
        chips[9]=chip9;
        chips[10]=chip10;
        chips[11]=chip11;
        chips[12]=chip12;

        //Draw initial box
        popupWindow  = new PopupWindow(container, 1000, 425, true);
        popupWindow.showAtLocation(layout, Gravity.NO_GRAVITY, 50, 100);
        //Starts on attack chips, but will save last selected category
        if(MyProperties.getInstance().chip_category == 1) {
            int chips_in_category = 8;
            attack_button.setChecked(true);
            defense_button.setChecked(false);
            support_button.setChecked(false);
            hacking_button.setChecked(false);
            attack_button.setTextColor(Color.RED);
            defense_button.setTextColor(Color.BLACK);
            support_button.setTextColor(Color.BLACK);
            hacking_button.setTextColor(Color.BLACK);


            int offset = 0;
            for(int i = 1; i<=chips_in_category; i++){
                chips[i].setText(MyProperties.getInstance().chips[(i) + offset]);
            }
            for(int i = chips_in_category+1; i<13; i++){
                chips[i].setText("");
            }
        }
        else if(MyProperties.getInstance().chip_category == 2) {
            int chips_in_category = 10;
            attack_button.setChecked(false);
            defense_button.setChecked(true);
            support_button.setChecked(false);
            hacking_button.setChecked(false);
            attack_button.setTextColor(Color.BLACK);
            defense_button.setTextColor(Color.RED);
            support_button.setTextColor(Color.BLACK);
            hacking_button.setTextColor(Color.BLACK);

            int offset = 8;
            for(int i = 1; i<=chips_in_category; i++){
                chips[i].setText(MyProperties.getInstance().chips[(i) + offset]);
            }
            for(int i = chips_in_category+1; i<13; i++){
                chips[i].setText("");
            }
        }
        else if(MyProperties.getInstance().chip_category == 3) {
            int chips_in_category = 9;
            attack_button.setChecked(false);
            defense_button.setChecked(false);
            support_button.setChecked(true);
            hacking_button.setChecked(false);

            attack_button.setTextColor(Color.BLACK);
            defense_button.setTextColor(Color.BLACK);
            support_button.setTextColor(Color.RED);
            hacking_button.setTextColor(Color.BLACK);

            int offset = 18;
            for(int i = 1; i<=chips_in_category; i++){
                chips[i].setText(MyProperties.getInstance().chips[(i) + offset]);
            }
            for(int i = chips_in_category+1; i<13; i++){
                chips[i].setText("");
            }
        }

        else if(MyProperties.getInstance().chip_category == 4) {
            MyProperties.getInstance().chip_category = 4;
            int chips_in_category = 4;
            attack_button.setChecked(false);
            defense_button.setChecked(false);
            support_button.setChecked(false);
            hacking_button.setChecked(true);

            attack_button.setTextColor(Color.BLACK);
            defense_button.setTextColor(Color.BLACK);
            support_button.setTextColor(Color.BLACK);
            hacking_button.setTextColor(Color.RED);

            int offset = 27;
            for(int i = 1; i<=chips_in_category; i++){
                chips[i].setText(MyProperties.getInstance().chips[(i) + offset]);
            }
            for(int i = chips_in_category+1; i<13; i++){
                chips[i].setText("");
            }
        }

        //Chip button onClickListeners
        chip1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                if(MyProperties.getInstance().chip_category == 1){
                    MyProperties.getInstance().chip_id = 1;
                    parent.updateButton();
                    popupWindow.dismiss();

                }
                else if(MyProperties.getInstance().chip_category == 2){
                    MyProperties.getInstance().chip_id = 9;
                    parent.updateButton();
                    popupWindow.dismiss();
                }
                else if(MyProperties.getInstance().chip_category == 3){
                    MyProperties.getInstance().chip_id = 19;
                    parent.updateButton();
                    popupWindow.dismiss();
                }
                else if(MyProperties.getInstance().chip_category == 4){
                    MyProperties.getInstance().chip_id = 28;
                    parent.updateButton();
                    popupWindow.dismiss();
                }
            }
        });

        chip2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                if(MyProperties.getInstance().chip_category == 1){
                    MyProperties.getInstance().chip_id = 2;
                    parent.updateButton();
                    popupWindow.dismiss();

                }
                else if(MyProperties.getInstance().chip_category == 2){
                    MyProperties.getInstance().chip_id = 10;
                    parent.updateButton();
                    popupWindow.dismiss();
                }
                else if(MyProperties.getInstance().chip_category == 3){
                    MyProperties.getInstance().chip_id = 20;
                    parent.updateButton();
                    popupWindow.dismiss();
                }
                else if(MyProperties.getInstance().chip_category == 4){
                    MyProperties.getInstance().chip_id = 29;
                    parent.updateButton();
                    popupWindow.dismiss();
                }
            }
        });

        chip3.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                if(MyProperties.getInstance().chip_category == 1){
                    MyProperties.getInstance().chip_id = 3;
                    parent.updateButton();
                    popupWindow.dismiss();

                }
                else if(MyProperties.getInstance().chip_category == 2){
                    MyProperties.getInstance().chip_id = 11;
                    parent.updateButton();
                    popupWindow.dismiss();
                }
                else if(MyProperties.getInstance().chip_category == 3){
                    MyProperties.getInstance().chip_id = 21;
                    parent.updateButton();
                    popupWindow.dismiss();
                }
                else if(MyProperties.getInstance().chip_category == 4){
                    MyProperties.getInstance().chip_id = 30;
                    parent.updateButton();
                    popupWindow.dismiss();
                }
            }
        });

        chip4.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                if(MyProperties.getInstance().chip_category == 1){
                    MyProperties.getInstance().chip_id = 4;
                    parent.updateButton();
                    popupWindow.dismiss();

                }
                else if(MyProperties.getInstance().chip_category == 2){
                    MyProperties.getInstance().chip_id = 12;
                    parent.updateButton();
                    popupWindow.dismiss();
                }
                else if(MyProperties.getInstance().chip_category == 3){
                    MyProperties.getInstance().chip_id = 22;
                    parent.updateButton();
                    popupWindow.dismiss();
                }
                else if(MyProperties.getInstance().chip_category == 4){
                    MyProperties.getInstance().chip_id = 31;
                    parent.updateButton();
                    popupWindow.dismiss();
                }
            }
        });

        chip5.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                if(MyProperties.getInstance().chip_category == 1){
                    MyProperties.getInstance().chip_id = 5;
                    parent.updateButton();
                    popupWindow.dismiss();

                }
                else if(MyProperties.getInstance().chip_category == 2){
                    MyProperties.getInstance().chip_id = 13;
                    parent.updateButton();
                    popupWindow.dismiss();
                }
                else if(MyProperties.getInstance().chip_category == 3){
                    MyProperties.getInstance().chip_id = 23;
                    parent.updateButton();
                    popupWindow.dismiss();
                }
            }
        });

        chip6.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                if(MyProperties.getInstance().chip_category == 1){
                    MyProperties.getInstance().chip_id = 6;
                    parent.updateButton();
                    popupWindow.dismiss();

                }
                else if(MyProperties.getInstance().chip_category == 2){
                    MyProperties.getInstance().chip_id = 14;
                    parent.updateButton();
                    popupWindow.dismiss();
                }
                else if(MyProperties.getInstance().chip_category == 3){
                    MyProperties.getInstance().chip_id = 24;
                    parent.updateButton();
                    popupWindow.dismiss();
                }
            }
        });

        chip7.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                if(MyProperties.getInstance().chip_category == 1){
                    MyProperties.getInstance().chip_id = 7;
                    parent.updateButton();
                    popupWindow.dismiss();

                }
                else if(MyProperties.getInstance().chip_category == 2){
                    MyProperties.getInstance().chip_id = 15;
                    parent.updateButton();
                    popupWindow.dismiss();
                }
                else if(MyProperties.getInstance().chip_category == 3){
                    MyProperties.getInstance().chip_id = 25;
                    parent.updateButton();
                    popupWindow.dismiss();
                }
            }
        });

        chip8.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                if(MyProperties.getInstance().chip_category == 1){
                    MyProperties.getInstance().chip_id = 8;
                    parent.updateButton();
                    popupWindow.dismiss();

                }
                else if(MyProperties.getInstance().chip_category == 2){
                    MyProperties.getInstance().chip_id = 16;
                    parent.updateButton();
                    popupWindow.dismiss();
                }
                else if(MyProperties.getInstance().chip_category == 3){
                    MyProperties.getInstance().chip_id = 26;
                    parent.updateButton();
                    popupWindow.dismiss();
                }
            }
        });

        chip9.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                if(MyProperties.getInstance().chip_category == 2){
                    MyProperties.getInstance().chip_id = 17;
                    parent.updateButton();
                    popupWindow.dismiss();
                }
                else if(MyProperties.getInstance().chip_category == 3){
                    MyProperties.getInstance().chip_id = 27;
                    parent.updateButton();
                    popupWindow.dismiss();
                }
            }
        });

        chip10.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                if(MyProperties.getInstance().chip_category == 2){
                    MyProperties.getInstance().chip_id = 18;
                    parent.updateButton();
                    popupWindow.dismiss();
                }
            }
        });

        chip11.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                //do nothing
            }
        });

        chip12.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                //do nothing
            }
        });

        //Chip category onClickListeners
        attack_button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                MyProperties.getInstance().chip_category = 1;
                int chips_in_category = 8;
                attack_button.setChecked(true);
                defense_button.setChecked(false);
                support_button.setChecked(false);
                hacking_button.setChecked(false);
                attack_button.setTextColor(Color.RED);
                defense_button.setTextColor(Color.BLACK);
                support_button.setTextColor(Color.BLACK);
                hacking_button.setTextColor(Color.BLACK);

                int offset = 0;
                for(int i = 1; i<=chips_in_category; i++){
                    chips[i].setText(MyProperties.getInstance().chips[(i) + offset]);
                }
                for(int i = chips_in_category+1; i<13; i++){
                    chips[i].setText("");
                }
            }
        });

        defense_button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                MyProperties.getInstance().chip_category = 2;
                int chips_in_category = 10;
                attack_button.setChecked(false);
                defense_button.setChecked(true);
                support_button.setChecked(false);
                hacking_button.setChecked(false);
                attack_button.setTextColor(Color.BLACK);
                defense_button.setTextColor(Color.RED);
                support_button.setTextColor(Color.BLACK);
                hacking_button.setTextColor(Color.BLACK);

                int offset = 8;
                for(int i = 1; i<=chips_in_category; i++){
                    chips[i].setText(MyProperties.getInstance().chips[(i) + offset]);
                }
                for(int i = chips_in_category+1; i<13; i++){
                    chips[i].setText("");
                }
            }
        });

        support_button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                MyProperties.getInstance().chip_category = 3;
                int chips_in_category = 9;
                attack_button.setChecked(false);
                defense_button.setChecked(false);
                support_button.setChecked(true);
                hacking_button.setChecked(false);

                attack_button.setTextColor(Color.BLACK);
                defense_button.setTextColor(Color.BLACK);
                support_button.setTextColor(Color.RED);
                hacking_button.setTextColor(Color.BLACK);

                int offset = 18;
                for(int i = 1; i<=chips_in_category; i++){
                    chips[i].setText(MyProperties.getInstance().chips[(i) + offset]);
                }
                for(int i = chips_in_category+1; i<13; i++){
                    chips[i].setText("");
                }
            }
        });

        hacking_button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                MyProperties.getInstance().chip_category = 4;
                int chips_in_category = 4;
                attack_button.setChecked(false);
                defense_button.setChecked(false);
                support_button.setChecked(false);
                hacking_button.setChecked(true);

                attack_button.setTextColor(Color.BLACK);
                defense_button.setTextColor(Color.BLACK);
                support_button.setTextColor(Color.BLACK);
                hacking_button.setTextColor(Color.RED);

                int offset = 27;
                for(int i = 1; i<=chips_in_category; i++){
                    chips[i].setText(MyProperties.getInstance().chips[(i) + offset]);
                }
                for(int i = chips_in_category+1; i<13; i++){
                    chips[i].setText("");
                }
            }
        });



        container.setOnTouchListener(new View.OnTouchListener(){
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                popupWindow.dismiss();
                return true;
            }
        });
    }

    public void ShowSelector(final TestActivity parent, RelativeLayout layout, ViewGroup container){


        //Set up chip select buttons

        attack_button = (ToggleButton) container.findViewById(R.id.attack_button);
        defense_button = (ToggleButton) container.findViewById(R.id.defense_button);
        support_button = (ToggleButton) container.findViewById(R.id.support_button);
        hacking_button = (ToggleButton) container.findViewById(R.id.hacking_button);

        //Set up chips
        chip1 = (TextView) container.findViewById(R.id.chip1);
        chip2 = (TextView) container.findViewById(R.id.chip2);
        chip3 = (TextView) container.findViewById(R.id.chip3);
        chip4 = (TextView) container.findViewById(R.id.chip4);
        chip5 = (TextView) container.findViewById(R.id.chip5);
        chip6 = (TextView) container.findViewById(R.id.chip6);
        chip7 = (TextView) container.findViewById(R.id.chip7);
        chip8 = (TextView) container.findViewById(R.id.chip8);
        chip9 = (TextView) container.findViewById(R.id.chip9);
        chip10 = (TextView) container.findViewById(R.id.chip10);
        chip11 = (TextView) container.findViewById(R.id.chip11);
        chip12 = (TextView) container.findViewById(R.id.chip12);

        chips[1]=chip1;
        chips[2]=chip2;
        chips[3]=chip3;
        chips[4]=chip4;
        chips[5]=chip5;
        chips[6]=chip6;
        chips[7]=chip7;
        chips[8]=chip8;
        chips[9]=chip9;
        chips[10]=chip10;
        chips[11]=chip11;
        chips[12]=chip12;

        //Draw initial box
        popupWindow  = new PopupWindow(container, 1000, 425, true);
        popupWindow.showAtLocation(layout, Gravity.NO_GRAVITY, 50, 100);
        //Starts on attack chips, but will save last selected category
        if(MyProperties.getInstance().chip_category == 1) {
            int chips_in_category = 8;
            attack_button.setChecked(true);
            defense_button.setChecked(false);
            support_button.setChecked(false);
            hacking_button.setChecked(false);
            attack_button.setTextColor(Color.RED);
            defense_button.setTextColor(Color.BLACK);
            support_button.setTextColor(Color.BLACK);
            hacking_button.setTextColor(Color.BLACK);


            int offset = 0;
            for(int i = 1; i<=chips_in_category; i++){
                chips[i].setText(MyProperties.getInstance().chips[(i) + offset]);
            }
            for(int i = chips_in_category+1; i<13; i++){
                chips[i].setText("");
            }
        }
        else if(MyProperties.getInstance().chip_category == 2) {
            int chips_in_category = 10;
            attack_button.setChecked(false);
            defense_button.setChecked(true);
            support_button.setChecked(false);
            hacking_button.setChecked(false);
            attack_button.setTextColor(Color.BLACK);
            defense_button.setTextColor(Color.RED);
            support_button.setTextColor(Color.BLACK);
            hacking_button.setTextColor(Color.BLACK);

            int offset = 8;
            for(int i = 1; i<=chips_in_category; i++){
                chips[i].setText(MyProperties.getInstance().chips[(i) + offset]);
            }
            for(int i = chips_in_category+1; i<13; i++){
                chips[i].setText("");
            }
        }
        else if(MyProperties.getInstance().chip_category == 3) {
            int chips_in_category = 9;
            attack_button.setChecked(false);
            defense_button.setChecked(false);
            support_button.setChecked(true);
            hacking_button.setChecked(false);

            attack_button.setTextColor(Color.BLACK);
            defense_button.setTextColor(Color.BLACK);
            support_button.setTextColor(Color.RED);
            hacking_button.setTextColor(Color.BLACK);

            int offset = 18;
            for(int i = 1; i<=chips_in_category; i++){
                chips[i].setText(MyProperties.getInstance().chips[(i) + offset]);
            }
            for(int i = chips_in_category+1; i<13; i++){
                chips[i].setText("");
            }
        }

        else if(MyProperties.getInstance().chip_category == 4) {
            MyProperties.getInstance().chip_category = 4;
            int chips_in_category = 4;
            attack_button.setChecked(false);
            defense_button.setChecked(false);
            support_button.setChecked(false);
            hacking_button.setChecked(true);

            attack_button.setTextColor(Color.BLACK);
            defense_button.setTextColor(Color.BLACK);
            support_button.setTextColor(Color.BLACK);
            hacking_button.setTextColor(Color.RED);

            int offset = 27;
            for(int i = 1; i<=chips_in_category; i++){
                chips[i].setText(MyProperties.getInstance().chips[(i) + offset]);
            }
            for(int i = chips_in_category+1; i<13; i++){
                chips[i].setText("");
            }
        }

        //Chip button onClickListeners
        chip1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                if(MyProperties.getInstance().chip_category == 1){
                    MyProperties.getInstance().chip_id = 1;
                    parent.updateButton();
                    popupWindow.dismiss();

                }
                else if(MyProperties.getInstance().chip_category == 2){
                    MyProperties.getInstance().chip_id = 9;
                    parent.updateButton();
                    popupWindow.dismiss();
                }
                else if(MyProperties.getInstance().chip_category == 3){
                    MyProperties.getInstance().chip_id = 19;
                    parent.updateButton();
                    popupWindow.dismiss();
                }
                else if(MyProperties.getInstance().chip_category == 4){
                    MyProperties.getInstance().chip_id = 28;
                    parent.updateButton();
                    popupWindow.dismiss();
                }
            }
        });

        chip2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                if(MyProperties.getInstance().chip_category == 1){
                    MyProperties.getInstance().chip_id = 2;
                    parent.updateButton();
                    popupWindow.dismiss();

                }
                else if(MyProperties.getInstance().chip_category == 2){
                    MyProperties.getInstance().chip_id = 10;
                    parent.updateButton();
                    popupWindow.dismiss();
                }
                else if(MyProperties.getInstance().chip_category == 3){
                    MyProperties.getInstance().chip_id = 20;
                    parent.updateButton();
                    popupWindow.dismiss();
                }
                else if(MyProperties.getInstance().chip_category == 4){
                    MyProperties.getInstance().chip_id = 29;
                    parent.updateButton();
                    popupWindow.dismiss();
                }
            }
        });

        chip3.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                if(MyProperties.getInstance().chip_category == 1){
                    MyProperties.getInstance().chip_id = 3;
                    parent.updateButton();
                    popupWindow.dismiss();

                }
                else if(MyProperties.getInstance().chip_category == 2){
                    MyProperties.getInstance().chip_id = 11;
                    parent.updateButton();
                    popupWindow.dismiss();
                }
                else if(MyProperties.getInstance().chip_category == 3){
                    MyProperties.getInstance().chip_id = 21;
                    parent.updateButton();
                    popupWindow.dismiss();
                }
                else if(MyProperties.getInstance().chip_category == 4){
                    MyProperties.getInstance().chip_id = 30;
                    parent.updateButton();
                    popupWindow.dismiss();
                }
            }
        });

        chip4.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                if(MyProperties.getInstance().chip_category == 1){
                    MyProperties.getInstance().chip_id = 4;
                    parent.updateButton();
                    popupWindow.dismiss();

                }
                else if(MyProperties.getInstance().chip_category == 2){
                    MyProperties.getInstance().chip_id = 12;
                    parent.updateButton();
                    popupWindow.dismiss();
                }
                else if(MyProperties.getInstance().chip_category == 3){
                    MyProperties.getInstance().chip_id = 22;
                    parent.updateButton();
                    popupWindow.dismiss();
                }
                else if(MyProperties.getInstance().chip_category == 4){
                    MyProperties.getInstance().chip_id = 31;
                    parent.updateButton();
                    popupWindow.dismiss();
                }
            }
        });

        chip5.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                if(MyProperties.getInstance().chip_category == 1){
                    MyProperties.getInstance().chip_id = 5;
                    parent.updateButton();
                    popupWindow.dismiss();

                }
                else if(MyProperties.getInstance().chip_category == 2){
                    MyProperties.getInstance().chip_id = 13;
                    parent.updateButton();
                    popupWindow.dismiss();
                }
                else if(MyProperties.getInstance().chip_category == 3){
                    MyProperties.getInstance().chip_id = 23;
                    parent.updateButton();
                    popupWindow.dismiss();
                }
            }
        });

        chip6.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                if(MyProperties.getInstance().chip_category == 1){
                    MyProperties.getInstance().chip_id = 6;
                    parent.updateButton();
                    popupWindow.dismiss();

                }
                else if(MyProperties.getInstance().chip_category == 2){
                    MyProperties.getInstance().chip_id = 14;
                    parent.updateButton();
                    popupWindow.dismiss();
                }
                else if(MyProperties.getInstance().chip_category == 3){
                    MyProperties.getInstance().chip_id = 24;
                    parent.updateButton();
                    popupWindow.dismiss();
                }
            }
        });

        chip7.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                if(MyProperties.getInstance().chip_category == 1){
                    MyProperties.getInstance().chip_id = 7;
                    parent.updateButton();
                    popupWindow.dismiss();

                }
                else if(MyProperties.getInstance().chip_category == 2){
                    MyProperties.getInstance().chip_id = 15;
                    parent.updateButton();
                    popupWindow.dismiss();
                }
                else if(MyProperties.getInstance().chip_category == 3){
                    MyProperties.getInstance().chip_id = 25;
                    parent.updateButton();
                    popupWindow.dismiss();
                }
            }
        });

        chip8.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                if(MyProperties.getInstance().chip_category == 1){
                    MyProperties.getInstance().chip_id = 8;
                    parent.updateButton();
                    popupWindow.dismiss();

                }
                else if(MyProperties.getInstance().chip_category == 2){
                    MyProperties.getInstance().chip_id = 16;
                    parent.updateButton();
                    popupWindow.dismiss();
                }
                else if(MyProperties.getInstance().chip_category == 3){
                    MyProperties.getInstance().chip_id = 26;
                    parent.updateButton();
                    popupWindow.dismiss();
                }
            }
        });

        chip9.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                if(MyProperties.getInstance().chip_category == 2){
                    MyProperties.getInstance().chip_id = 17;
                    parent.updateButton();
                    popupWindow.dismiss();
                }
                else if(MyProperties.getInstance().chip_category == 3){
                    MyProperties.getInstance().chip_id = 27;
                    parent.updateButton();
                    popupWindow.dismiss();
                }
            }
        });

        chip10.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                if(MyProperties.getInstance().chip_category == 2){
                    MyProperties.getInstance().chip_id = 18;
                    parent.updateButton();
                    popupWindow.dismiss();
                }
            }
        });

        chip11.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                //do nothing
            }
        });

        chip12.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                //do nothing
            }
        });

        //Chip category onClickListeners
        attack_button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                MyProperties.getInstance().chip_category = 1;
                int chips_in_category = 8;
                attack_button.setChecked(true);
                defense_button.setChecked(false);
                support_button.setChecked(false);
                hacking_button.setChecked(false);
                attack_button.setTextColor(Color.RED);
                defense_button.setTextColor(Color.BLACK);
                support_button.setTextColor(Color.BLACK);
                hacking_button.setTextColor(Color.BLACK);

                int offset = 0;
                for(int i = 1; i<=chips_in_category; i++){
                    chips[i].setText(MyProperties.getInstance().chips[(i) + offset]);
                }
                for(int i = chips_in_category+1; i<13; i++){
                    chips[i].setText("");
                }
            }
        });

        defense_button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                MyProperties.getInstance().chip_category = 2;
                int chips_in_category = 10;
                attack_button.setChecked(false);
                defense_button.setChecked(true);
                support_button.setChecked(false);
                hacking_button.setChecked(false);
                attack_button.setTextColor(Color.BLACK);
                defense_button.setTextColor(Color.RED);
                support_button.setTextColor(Color.BLACK);
                hacking_button.setTextColor(Color.BLACK);

                int offset = 8;
                for(int i = 1; i<=chips_in_category; i++){
                    chips[i].setText(MyProperties.getInstance().chips[(i) + offset]);
                }
                for(int i = chips_in_category+1; i<13; i++){
                    chips[i].setText("");
                }
            }
        });

        support_button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                MyProperties.getInstance().chip_category = 3;
                int chips_in_category = 9;
                attack_button.setChecked(false);
                defense_button.setChecked(false);
                support_button.setChecked(true);
                hacking_button.setChecked(false);

                attack_button.setTextColor(Color.BLACK);
                defense_button.setTextColor(Color.BLACK);
                support_button.setTextColor(Color.RED);
                hacking_button.setTextColor(Color.BLACK);

                int offset = 18;
                for(int i = 1; i<=chips_in_category; i++){
                    chips[i].setText(MyProperties.getInstance().chips[(i) + offset]);
                }
                for(int i = chips_in_category+1; i<13; i++){
                    chips[i].setText("");
                }
            }
        });

        hacking_button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                MyProperties.getInstance().chip_category = 4;
                int chips_in_category = 4;
                attack_button.setChecked(false);
                defense_button.setChecked(false);
                support_button.setChecked(false);
                hacking_button.setChecked(true);

                attack_button.setTextColor(Color.BLACK);
                defense_button.setTextColor(Color.BLACK);
                support_button.setTextColor(Color.BLACK);
                hacking_button.setTextColor(Color.RED);

                int offset = 27;
                for(int i = 1; i<=chips_in_category; i++){
                    chips[i].setText(MyProperties.getInstance().chips[(i) + offset]);
                }
                for(int i = chips_in_category+1; i<13; i++){
                    chips[i].setText("");
                }
            }
        });



        container.setOnTouchListener(new View.OnTouchListener(){
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                popupWindow.dismiss();
                return true;
            }
        });
    }

}

