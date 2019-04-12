package org.pursuit.blastoff.view;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import org.pursuit.blastoff.R;
import org.pursuit.blastoff.fragments.FragmenListener;
import org.pursuit.blastoff.model.SolarSystem;

public class SolarSystemViewHolder extends RecyclerView.ViewHolder {

    private TextView nameView;
    private ImageView imageView;

    public SolarSystemViewHolder(@NonNull View itemView) {
        super(itemView);
        nameView = itemView.findViewById(R.id.s_name);
        imageView = itemView.findViewById(R.id.s_image);
    }

    public void onBind(final SolarSystem solarSystem,
                       final FragmenListener fragmenListener) {
        Log.e("nameOfSolarSystem: ", solarSystem.getName());
        nameView.setText(solarSystem.getName());
        fragmenListener.setTextToSpeechToViews(nameView);
        Glide.with(itemView)
                .load(solarSystem.getImage())
                .apply(RequestOptions.circleCropTransform())
                .into(imageView);
        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = solarSystem.getName();
                String text = solarSystem.getText();
                String imageURL = solarSystem.getImage();
                fragmenListener.toDetailSolarSystemFragment(
                        name, text, imageURL
                );
            }
        });
    }
}
