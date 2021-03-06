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

import org.w3c.dom.Text;

public class InfoActivity extends AppCompatActivity {

    public Button chip_button;
    public Button phantom_button;

    private LayoutInflater layoutInflater;
    private RelativeLayout layout;

    private TextView chipDescription;
    private TextView maxEffect;
    private TextView optimalSetup;
    private TextView enemyName;

    private Chip chip;
    private Chip test;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);
        chip_button = (Button) findViewById(R.id.chip_button);
        chip_button.setText(MyProperties.getInstance().chips[MyProperties.getInstance().chip_id]);
        phantom_button = (Button) findViewById(R.id.phantom_chip_button);
        phantom_button.setVisibility(View.INVISIBLE);
        layout = (RelativeLayout) findViewById(R.id.info_screen);

        chipDescription = (TextView) findViewById(R.id.chip_description);
        maxEffect = (TextView) findViewById(R.id.max_effect);
        optimalSetup = (TextView) findViewById(R.id.optimal_setup);
        enemyName = (TextView) findViewById(R.id.enemy_name);

        chip_button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                layoutInflater = (LayoutInflater) getApplicationContext().getSystemService(LAYOUT_INFLATER_SERVICE);
                ViewGroup container = (ViewGroup) layoutInflater.inflate(R.layout.chip_selector, null);

                ChipSelector selector = new ChipSelector();
                // selector.ShowSelector(InfoActivity.this, layout, container);
            }
        });

        test = new Chip(this, 1, 0, 4);
        updateButton();

    }

    public void updateButton(){
        chip_button.setText(MyProperties.getInstance().chips[MyProperties.getInstance().chip_id]);
        chip = new Chip(this, MyProperties.getInstance().chip_id);
        chipDescription.setText(chip.getDescription());
        enemyName.setText(Integer.toString(test.getCount()));


    }


}
