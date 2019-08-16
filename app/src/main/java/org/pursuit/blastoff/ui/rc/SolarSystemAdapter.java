package org.pursuit.blastoff.ui.rc;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import org.pursuit.blastoff.R;
import org.pursuit.blastoff.model.SolarSystem;
import org.pursuit.blastoff.ui.fragments.FragmentListener;

import java.util.List;

public class SolarSystemAdapter extends RecyclerView.Adapter<SolarSystemViewHolder> {

    private List<SolarSystem> solarSystemList;
    private FragmentListener fragmentListener;

    public SolarSystemAdapter(List<SolarSystem> solarSystemList,
                              FragmentListener fragmentListener) {
        this.solarSystemList = solarSystemList;
        this.fragmentListener = fragmentListener;
    }

    @NonNull
    @Override
    public SolarSystemViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.itemview_solar_system, viewGroup, false);
        return new SolarSystemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SolarSystemViewHolder solarSytemViewHolder, int i) {
        solarSytemViewHolder.onBind(solarSystemList.get(i), fragmentListener);
    }

    @Override
    public int getItemCount() {
        return solarSystemList.size();
    }
}
