package com.example.roberthubbell.nier_app.display_adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.roberthubbell.nier_app.AddDrawerActivity;
import com.example.roberthubbell.nier_app.MyProperties;
import com.example.roberthubbell.nier_app.R;
import com.example.roberthubbell.nier_app.chip.Chip;

import java.util.ArrayList;

/**
 * Created by Brandon on 4/27/2017.
 */

public class ChipAdapter extends ArrayAdapter<Chip> {
    public ChipAdapter(Context context, ArrayList<Chip> chip) {
        super(context, 0, chip);
        this.context = context;
    }

    Context context;
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Get the data item for this position
        final Chip chip = getItem(position);
        // Check if an existing view is being reused, otherwise inflate the view
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.add_view_chips, parent, false);
        }
        // Lookup view for data population
        TextView chipSize = (TextView) convertView.findViewById(R.id.chipSize);
        TextView chipCount = (TextView) convertView.findViewById(R.id.chipCount);
        ImageButton plusButton = (ImageButton) convertView.findViewById(R.id.plusButton);
        ImageButton  minusButton = (ImageButton) convertView.findViewById(R.id.minusButton);

        plusButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                chip.increaseCount();
                ((AddDrawerActivity)context).writeChips();
            }
        });

        minusButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                chip.decreaseCount();
                ((AddDrawerActivity)context).writeChips();
            }
        });
        // Populate the data into the template view using the data object
        chipSize.setText(Integer.toString(chip.getSize()));
        chipCount.setText(Integer.toString(chip.getCount()));
        // Return the completed view to render on screen
        return convertView;
    }
}