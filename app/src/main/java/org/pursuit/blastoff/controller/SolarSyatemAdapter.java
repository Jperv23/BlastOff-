package org.pursuit.blastoff.controller;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import org.pursuit.blastoff.R;
import org.pursuit.blastoff.fragments.FragmentInterface;
import org.pursuit.blastoff.model.SolarSystem;
import org.pursuit.blastoff.view.SolarSystemViewHolder;

import java.util.List;

public class SolarSyatemAdapter extends RecyclerView.Adapter<SolarSystemViewHolder> {

    private List<SolarSystem> solarSystemList;
    private FragmentInterface fragmentInterface;

    public SolarSyatemAdapter(List<SolarSystem> solarSystemList,
                              FragmentInterface fragmentInterface) {
        this.solarSystemList = solarSystemList;
        this.fragmentInterface = fragmentInterface;
    }

    @NonNull
    @Override
    public SolarSystemViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.solarsystem_itemview, viewGroup, false);
        return new SolarSystemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SolarSystemViewHolder solarSytemViewHolder, int i) {
        solarSytemViewHolder.onBind(solarSystemList.get(i), fragmentInterface);
    }

    @Override
    public int getItemCount() {
        return solarSystemList.size();
    }
}
