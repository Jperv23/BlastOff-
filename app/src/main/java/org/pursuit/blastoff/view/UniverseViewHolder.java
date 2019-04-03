package org.pursuit.blastoff.view;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import org.pursuit.blastoff.R;
import org.pursuit.blastoff.fragments.FragmentInterface;
import org.pursuit.blastoff.model.Universe;

public class UniverseViewHolder extends RecyclerView.ViewHolder {

    private TextView nameView;

    public UniverseViewHolder(@NonNull View itemView) {
        super(itemView);
        nameView = itemView.findViewById(R.id.u_name);
    }

    public void onBind(final Universe universe,
                       final FragmentInterface fragmentInterface) {
        Log.e("nameOfUniverse: ", universe.getName());
        nameView.setText(universe.getName());

        nameView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = universe.getName();
                String text = universe.getText();
                String imageURL = universe.getImage();
                fragmentInterface.toDetailUniverseFragment(
                        name, text, imageURL
                );
            }
        });
    }
}
