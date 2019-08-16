package org.pursuit.blastoff.ui.rc;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import org.pursuit.blastoff.R;
import org.pursuit.blastoff.model.Universe;
import org.pursuit.blastoff.ui.fragments.FragmentListener;

import java.util.List;

public class UniverseAdapter extends RecyclerView.Adapter<UniverseViewHolder> {

    private List<Universe> universeList;
    private FragmentListener fragmentListener;

    public UniverseAdapter(List<Universe> universeList,
                           FragmentListener fragmentListener) {
        this.universeList = universeList;
        this.fragmentListener = fragmentListener;
    }

    @NonNull
    @Override
    public UniverseViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.itemview_universe, viewGroup, false);
        return new UniverseViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull UniverseViewHolder spaceViewHolder, int i) {
        spaceViewHolder.onBind(universeList.get(i), fragmentListener);
    }

    @Override
    public int getItemCount() {
        return universeList.size();
    }
}
