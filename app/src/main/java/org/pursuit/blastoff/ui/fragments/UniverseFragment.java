package org.pursuit.blastoff.ui.fragments;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import org.pursuit.blastoff.R;
import org.pursuit.blastoff.ui.UniverseAdapter;
import org.pursuit.blastoff.model.SpaceResponse;
import org.pursuit.blastoff.network.RetrofitSingleton;
import org.pursuit.blastoff.network.SpaceService;
import org.pursuit.blastoff.ui.FragmenListener;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class UniverseFragment extends Fragment {

    private static final String TAG = "UniverseFragment";
    private FragmenListener fragmenListener;

    public static UniverseFragment newInstance() {
        return new UniverseFragment();
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof FragmenListener) {
            fragmenListener = (FragmenListener) context;
        } else {
            throw new RuntimeException(context.toString() +
                    " must implement FragmenListener");
        }
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_universe, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initRecyclerView(view);
    }

    @Override
    public void onDetach() {
        super.onDetach();
        fragmenListener = null;
    }

    @SuppressLint("CheckResult")
    public void initRecyclerView(View view) {
        final RecyclerView recyclerView = view.findViewById(R.id.universe_recyclerview);
        recyclerView.setHasFixedSize(true);
        RetrofitSingleton.getRetrofitInstance()
                .create(SpaceService.class)
                .getSpaceResponse()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe((SpaceResponse spaceResponse) -> {
                            Log.e("universeItems: ", spaceResponse.getSpace()
                                    .get(1).getUniverse().get(0).getName());
                            recyclerView.setAdapter(new UniverseAdapter(
                                    spaceResponse.getSpace().get(1).getUniverse(),
                                    fragmenListener));
                            recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
                        }, throwable -> Log.d(TAG, "onFailure: " + throwable)
                );
    }
}