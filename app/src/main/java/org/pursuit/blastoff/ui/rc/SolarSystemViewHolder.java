package org.pursuit.blastoff.ui.rc;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import org.pursuit.blastoff.R;
import org.pursuit.blastoff.model.SolarSystem;
import org.pursuit.blastoff.ui.fragments.FragmentListener;

public class SolarSystemViewHolder extends RecyclerView.ViewHolder {

    private TextView nameView;
    private ImageView imageView;

    public SolarSystemViewHolder(@NonNull View itemView) {
        super(itemView);
        nameView = itemView.findViewById(R.id.s_name);
        imageView = itemView.findViewById(R.id.s_image);
    }

    public void onBind(final SolarSystem solarSystem,
                       final FragmentListener fragmentListener) {
        nameView.setText(solarSystem.getName());
        fragmentListener.setTextToSpeechToViews(nameView);
        Glide.with(itemView)
                .load(solarSystem.getImage())
                .placeholder(R.drawable.ic_launcher_foreground)
                .apply(RequestOptions.circleCropTransform())
                .into(imageView);
        itemView.setOnClickListener(v -> {
            String name = solarSystem.getName();
            String fact1 = solarSystem.getFact1();
            String fact2 = solarSystem.getFact2();
            String text = solarSystem.getText();
            String imageURL = solarSystem.getImage();
            fragmentListener.onDetailSolarSystemFragmentInteraction(
                    name, fact1, fact2, text, imageURL
            );
        });
    }
}
