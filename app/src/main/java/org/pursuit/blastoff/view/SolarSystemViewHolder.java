package org.pursuit.blastoff.view;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import org.pursuit.blastoff.R;
import org.pursuit.blastoff.fragments.FragmentInterface;
import org.pursuit.blastoff.model.SolarSystem;

public class SolarSystemViewHolder extends RecyclerView.ViewHolder {

    private TextView nameView;

    public SolarSystemViewHolder(@NonNull View itemView) {
        super(itemView);
        nameView = itemView.findViewById(R.id.s_name);
    }

    public void onBind(final SolarSystem solarSystem,
                       final FragmentInterface fragmentInterface) {
        Log.e("nameOfSolarSystem: ", solarSystem.getName());
        nameView.setText(solarSystem.getName());

        nameView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = solarSystem.getName();
                String text = solarSystem.getText();
                String imageURL = solarSystem.getImage();
                fragmentInterface.toDetailSolarSystemFragment(
                        name, text, imageURL
                );
            }
        });
    }
}
