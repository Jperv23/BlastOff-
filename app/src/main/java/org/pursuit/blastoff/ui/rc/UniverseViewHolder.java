package org.pursuit.blastoff.ui.rc;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import org.pursuit.blastoff.R;
import org.pursuit.blastoff.model.Universe;
import org.pursuit.blastoff.ui.fragments.FragmentListener;

public class UniverseViewHolder extends RecyclerView.ViewHolder {

    private TextView nameView;
    private ImageView imageView;

    public UniverseViewHolder(@NonNull View itemView) {
        super(itemView);
        nameView = itemView.findViewById(R.id.u_name);
        imageView = itemView.findViewById(R.id.u_image);
    }

    public void onBind(final Universe universe,
                       final FragmentListener fragmentListener) {
        nameView.setText(universe.getName());
        fragmentListener.setTextToSpeechToViews(nameView);
        Glide.with(itemView)
                .load(universe.getImage())
                .placeholder(R.drawable.ic_launcher_foreground)
                .into(imageView);
        itemView.setOnClickListener(v -> {
            String name = universe.getName();
            System.out.println(name);
            String fact1 = universe.getFact1();
            System.out.println(fact1);
            String text = universe.getText();
            System.out.println(text);
            String imageURL = universe.getImage();
            fragmentListener.onDetailUniverseFragmentInteraction(
                    name, fact1, text, imageURL
            );
        });
    }
}
