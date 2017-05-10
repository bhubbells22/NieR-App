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
import com.example.roberthubbell.nier_app.FuseDrawerActivity;
import com.example.roberthubbell.nier_app.R;
import com.example.roberthubbell.nier_app.chip.Chip;
import com.example.roberthubbell.nier_app.chip.Fusion;

import java.util.ArrayList;

/**
 * Created by Brandon on 4/27/2017.
 */

public class FusionAdapter extends ArrayAdapter<Fusion> {
    public FusionAdapter(Context context, ArrayList<Fusion> fusion) {
        super(context, 0, fusion);
        this.context = context;
    }

    Context context;
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Get the data item for this position
        final Fusion fusion = getItem(position);
        // Check if an existing view is being reused, otherwise inflate the view
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.fuse_view_chips, parent, false);
        }
        // Lookup view for data population
        TextView chipASize = (TextView) convertView.findViewById(R.id.chipA_size);
        TextView chipBSize = (TextView) convertView.findViewById(R.id.chipB_size);
        TextView resultSize = (TextView) convertView.findViewById(R.id.result_size);
        ImageButton fuseButton = (ImageButton) convertView.findViewById(R.id.fuse_button);

        fuseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fusion.fuse();
                ((FuseDrawerActivity)context).updateFusions();
            }
        });

        // Populate the data into the template view using the data object
        chipASize.setText(Integer.toString(fusion.getChipA().getSize()));
        chipBSize.setText(Integer.toString(fusion.getChipB().getSize()));
        resultSize.setText(Integer.toString(fusion.getResult().getSize()));
        // Return the completed view to render on screen
        return convertView;
    }
}