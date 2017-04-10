package com.example.roberthubbell.nier_app;

import android.graphics.Color;
import android.support.annotation.IdRes;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebHistoryItem;
import android.widget.Button;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.ToggleButton;

public class HomeScreenActivity extends AppCompatActivity {

    private TextView app_name;
    private Button add_button;
    private Button fuse_button;
    private Button info_button;

    //chip selector testing
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


    public int chip_id;
    private int chip_category;

    //end

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_screen);

        app_name = (TextView)findViewById(R.id.title_text);
        add_button = (Button)findViewById(R.id.add_button);
        fuse_button = (Button)findViewById(R.id.fuse_button);
        info_button = (Button)findViewById(R.id.info_button);

        //chip selector testing
        chip_id = 0; //id of currently selected chip
        chip_category = 1; //1=attack,2=defense,3=support,4=hacking
        chip_button = (Button) findViewById(R.id.chip_button);
        homeScreenLayout = (ConstraintLayout) findViewById(R.id.home_screen);


        chip_button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                layoutInflater = (LayoutInflater) getApplicationContext().getSystemService(LAYOUT_INFLATER_SERVICE);
                ViewGroup container = (ViewGroup) layoutInflater.inflate(R.layout.chip_selector, null);

                popupWindow = new PopupWindow(container, 1000, 425, true);
                popupWindow.showAtLocation(homeScreenLayout, Gravity.NO_GRAVITY, 50, 100);

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


                //Draw initial box
                //Starts on attack chips, but will save last selected category
                if(chip_category == 1) {
                    attack_button.setChecked(true);
                    defense_button.setChecked(false);
                    support_button.setChecked(false);
                    hacking_button.setChecked(false);
                    attack_button.setTextColor(Color.RED);
                    defense_button.setTextColor(Color.BLACK);
                    support_button.setTextColor(Color.BLACK);
                    hacking_button.setTextColor(Color.BLACK);

                    chip1.setText("Charge Attack");
                    chip2.setText("Counter");
                    chip3.setText("Critical Up");
                    chip4.setText("Down-Attack Up");
                    chip5.setText("Last Stand");
                    chip6.setText("Ranged Attack Up");
                    chip7.setText("Shock Wave");
                    chip8.setText("Weapon Attack Up");
                    chip9.setText("");
                    chip10.setText("");
                }
                else if(chip_category == 2) {
                    attack_button.setChecked(false);
                    defense_button.setChecked(true);
                    support_button.setChecked(false);
                    hacking_button.setChecked(false);
                    attack_button.setTextColor(Color.BLACK);
                    defense_button.setTextColor(Color.RED);
                    support_button.setTextColor(Color.BLACK);
                    hacking_button.setTextColor(Color.BLACK);

                    chip1.setText("Anti Chain Damage");
                    chip2.setText("Auto-Heal");
                    chip3.setText("Damage Absorb");
                    chip4.setText("Deadly Heal");
                    chip5.setText("Max HP Up");
                    chip6.setText("Melee Defense Up");
                    chip7.setText("Offensive Heal");
                    chip8.setText("Ranged Defense Up");
                    chip9.setText("Reset");
                    chip10.setText("Resilience");
                }
                else if(chip_category == 3) {
                    attack_button.setChecked(false);
                    defense_button.setChecked(false);
                    support_button.setChecked(true);
                    hacking_button.setChecked(false);

                    attack_button.setTextColor(Color.BLACK);
                    defense_button.setTextColor(Color.BLACK);
                    support_button.setTextColor(Color.RED);
                    hacking_button.setTextColor(Color.BLACK);

                    chip1.setText("Auto-Use Item");
                    chip2.setText("Drop Rate Up");
                    chip3.setText("EXP Gain Up");
                    chip4.setText("Evade Range Up");
                    chip5.setText("Fast Cooldown");
                    chip6.setText("Moving Speed Up");
                    chip7.setText("Overclock");
                    chip8.setText("Taunt Up");
                    chip9.setText("Vengeance");
                    chip10.setText("");
                }

                else if(chip_category == 4) {
                    chip_category = 4;
                    attack_button.setChecked(false);
                    defense_button.setChecked(false);
                    support_button.setChecked(false);
                    hacking_button.setChecked(true);

                    attack_button.setTextColor(Color.BLACK);
                    defense_button.setTextColor(Color.BLACK);
                    support_button.setTextColor(Color.BLACK);
                    hacking_button.setTextColor(Color.RED);

                    chip1.setText("Combust");
                    chip2.setText("Heal Drops Up");
                    chip3.setText("Hijack Boost");
                    chip4.setText("Stun");
                    chip5.setText("");
                    chip6.setText("");
                    chip7.setText("");
                    chip8.setText("");
                    chip9.setText("");
                    chip10.setText("");
                }

                //Chip button onClickListeners
                chip1.setOnClickListener(new View.OnClickListener(){
                    @Override
                    public void onClick(View view){
                        if(chip_category == 1){
                            chip_id = 1;
                            chip_button.setText("Charge Attack");
                            popupWindow.dismiss();

                        }
                        else if(chip_category == 2){
                            chip_id = 9;
                            chip_button.setText("Anti Chain Damage");
                            popupWindow.dismiss();
                        }
                        else if(chip_category == 3){
                            chip_id = 19;
                            chip_button.setText("Auto-Use Item");
                            popupWindow.dismiss();
                        }
                        else if(chip_category == 4){
                            chip_id = 28;
                            chip_button.setText("Combust");
                            popupWindow.dismiss();
                        }
                    }
                });

                chip2.setOnClickListener(new View.OnClickListener(){
                    @Override
                    public void onClick(View view){
                        if(chip_category == 1){
                            chip_id = 2;
                            chip_button.setText("Counter");
                            popupWindow.dismiss();

                        }
                        else if(chip_category == 2){
                            chip_id = 10;
                            chip_button.setText("Auto-Heal");
                            popupWindow.dismiss();
                        }
                        else if(chip_category == 3){
                            chip_id = 20;
                            chip_button.setText("Drop Rate Up");
                            popupWindow.dismiss();
                        }
                        else if(chip_category == 4){
                            chip_id = 29;
                            chip_button.setText("Heal Drops Up");
                            popupWindow.dismiss();
                        }
                    }
                });

                chip3.setOnClickListener(new View.OnClickListener(){
                    @Override
                    public void onClick(View view){
                        if(chip_category == 1){
                            chip_id = 3;
                            chip_button.setText("Critical Up");
                            popupWindow.dismiss();

                        }
                        else if(chip_category == 2){
                            chip_id = 11;
                            chip_button.setText("Damage Absorb");
                            popupWindow.dismiss();
                        }
                        else if(chip_category == 3){
                            chip_id = 21;
                            chip_button.setText("EXP Gain Up");
                            popupWindow.dismiss();
                        }
                        else if(chip_category == 4){
                            chip_id = 30;
                            chip_button.setText("Hijack Boost");
                            popupWindow.dismiss();
                        }
                    }
                });

                chip4.setOnClickListener(new View.OnClickListener(){
                    @Override
                    public void onClick(View view){
                        if(chip_category == 1){
                            chip_id = 4;
                            chip_button.setText("Down-Attack Up");
                            popupWindow.dismiss();

                        }
                        else if(chip_category == 2){
                            chip_id = 12;
                            chip_button.setText("Deadly Heal");
                            popupWindow.dismiss();
                        }
                        else if(chip_category == 3){
                            chip_id = 22;
                            chip_button.setText("Evade Range Up");
                            popupWindow.dismiss();
                        }
                        else if(chip_category == 4){
                            chip_id = 31;
                            chip_button.setText("Stun");
                            popupWindow.dismiss();
                        }
                    }
                });

                chip5.setOnClickListener(new View.OnClickListener(){
                    @Override
                    public void onClick(View view){
                        if(chip_category == 1){
                            chip_id = 5;
                            chip_button.setText("Last Stand");
                            popupWindow.dismiss();

                        }
                        else if(chip_category == 2){
                            chip_id = 13;
                            chip_button.setText("Max HP Up");
                            popupWindow.dismiss();
                        }
                        else if(chip_category == 3){
                            chip_id = 23;
                            chip_button.setText("Fast Cooldown");
                            popupWindow.dismiss();
                        }
                    }
                });

                chip6.setOnClickListener(new View.OnClickListener(){
                    @Override
                    public void onClick(View view){
                        if(chip_category == 1){
                            chip_id = 6;
                            chip_button.setText("Ranged Attack Up");
                            popupWindow.dismiss();

                        }
                        else if(chip_category == 2){
                            chip_id = 14;
                            chip_button.setText("Melee Defense Up");
                            popupWindow.dismiss();
                        }
                        else if(chip_category == 3){
                            chip_id = 24;
                            chip_button.setText("Moving Speed Up");
                            popupWindow.dismiss();
                        }
                    }
                });

                chip7.setOnClickListener(new View.OnClickListener(){
                    @Override
                    public void onClick(View view){
                        if(chip_category == 1){
                            chip_id = 7;
                            chip_button.setText("Shock Wave");
                            popupWindow.dismiss();

                        }
                        else if(chip_category == 2){
                            chip_id = 15;
                            chip_button.setText("Offensive Heal");
                            popupWindow.dismiss();
                        }
                        else if(chip_category == 3){
                            chip_id = 25;
                            chip_button.setText("Overclock");
                            popupWindow.dismiss();
                        }
                    }
                });

                chip8.setOnClickListener(new View.OnClickListener(){
                    @Override
                    public void onClick(View view){
                        if(chip_category == 1){
                            chip_id = 8;
                            chip_button.setText("Weapon Attack Up");
                            popupWindow.dismiss();

                        }
                        else if(chip_category == 2){
                            chip_id = 16;
                            chip_button.setText("Ranged Defense Up");
                            popupWindow.dismiss();
                        }
                        else if(chip_category == 3){
                            chip_id = 26;
                            chip_button.setText("Taunt Up");
                            popupWindow.dismiss();
                        }
                    }
                });

                chip9.setOnClickListener(new View.OnClickListener(){
                    @Override
                    public void onClick(View view){
                        if(chip_category == 2){
                            chip_id = 17;
                            chip_button.setText("Reset");
                            popupWindow.dismiss();
                        }
                        else if(chip_category == 3){
                            chip_id = 27;
                            chip_button.setText("Vengeance");
                            popupWindow.dismiss();
                        }
                    }
                });

                chip10.setOnClickListener(new View.OnClickListener(){
                    @Override
                    public void onClick(View view){
                        if(chip_category == 2){
                            chip_id = 18;
                            chip_button.setText("Resilience");
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
                        chip_category = 1;
                        attack_button.setChecked(true);
                        defense_button.setChecked(false);
                        support_button.setChecked(false);
                        hacking_button.setChecked(false);
                        attack_button.setTextColor(Color.RED);
                        defense_button.setTextColor(Color.BLACK);
                        support_button.setTextColor(Color.BLACK);
                        hacking_button.setTextColor(Color.BLACK);

                        chip1.setText("Charge Attack");
                        chip2.setText("Counter");
                        chip3.setText("Critical Up");
                        chip4.setText("Down-Attack Up");
                        chip5.setText("Last Stand");
                        chip6.setText("Ranged Attack Up");
                        chip7.setText("Shock Wave");
                        chip8.setText("Weapon Attack Up");
                        chip9.setText("");
                        chip10.setText("");
                    }
                });

                defense_button.setOnClickListener(new View.OnClickListener(){
                    @Override
                    public void onClick(View view){
                        chip_category = 2;
                        attack_button.setChecked(false);
                        defense_button.setChecked(true);
                        support_button.setChecked(false);
                        hacking_button.setChecked(false);
                        attack_button.setTextColor(Color.BLACK);
                        defense_button.setTextColor(Color.RED);
                        support_button.setTextColor(Color.BLACK);
                        hacking_button.setTextColor(Color.BLACK);

                        chip1.setText("Anti Chain Damage");
                        chip2.setText("Auto-Heal");
                        chip3.setText("Damage Absorb");
                        chip4.setText("Deadly Heal");
                        chip5.setText("Max HP Up");
                        chip6.setText("Melee Defense Up");
                        chip7.setText("Offensive Heal");
                        chip8.setText("Ranged Defense Up");
                        chip9.setText("Reset");
                        chip10.setText("Resilience");
                    }
                });

                support_button.setOnClickListener(new View.OnClickListener(){
                    @Override
                    public void onClick(View view){
                        chip_category = 3;
                        attack_button.setChecked(false);
                        defense_button.setChecked(false);
                        support_button.setChecked(true);
                        hacking_button.setChecked(false);

                        attack_button.setTextColor(Color.BLACK);
                        defense_button.setTextColor(Color.BLACK);
                        support_button.setTextColor(Color.RED);
                        hacking_button.setTextColor(Color.BLACK);

                        chip1.setText("Auto-Use Item");
                        chip2.setText("Drop Rate Up");
                        chip3.setText("EXP Gain Up");
                        chip4.setText("Evade Range Up");
                        chip5.setText("Fast Cooldown");
                        chip6.setText("Moving Speed Up");
                        chip7.setText("Overclock");
                        chip8.setText("Taunt Up");
                        chip9.setText("Vengeance");
                        chip10.setText("");
                    }
                });

                hacking_button.setOnClickListener(new View.OnClickListener(){
                    @Override
                    public void onClick(View view){
                        chip_category = 4;
                        attack_button.setChecked(false);
                        defense_button.setChecked(false);
                        support_button.setChecked(false);
                        hacking_button.setChecked(true);

                        attack_button.setTextColor(Color.BLACK);
                        defense_button.setTextColor(Color.BLACK);
                        support_button.setTextColor(Color.BLACK);
                        hacking_button.setTextColor(Color.RED);

                        chip1.setText("Combust");
                        chip2.setText("Heal Drops Up");
                        chip3.setText("Hijack Boost");
                        chip4.setText("Stun");
                        chip5.setText("");
                        chip6.setText("");
                        chip7.setText("");
                        chip8.setText("");
                        chip9.setText("");
                        chip10.setText("");
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
        });
        //end


        add_button.setX(210);
        add_button.setY(600);
        fuse_button.setX(210);
        fuse_button.setY(800);
        info_button.setX(210);
        info_button.setY(1000);


    }

}
