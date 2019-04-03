package org.pursuit.blastoff.fragments;

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
import org.pursuit.blastoff.controller.UniverseAdapter;
import org.pursuit.blastoff.model.SpaceResponse;
import org.pursuit.blastoff.network.RetrofitSingleton;
import org.pursuit.blastoff.network.SpaceService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class UniverseFragment extends Fragment {

    private FragmentInterface fragmentInterface;
    private static final String TAG = "UniverseFragment";

    public static UniverseFragment newInstance() {
        return new UniverseFragment();
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof FragmentInterface) {
            fragmentInterface = (FragmentInterface) context;
        } else {
            throw new RuntimeException(context.toString() +
                    " must implement FragmentInterface");
        }
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
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
        fragmentInterface = null;
    }

    public void initRecyclerView(View view) {
        final RecyclerView recyclerView = view.findViewById(R.id.universe_recyclerview);
        recyclerView.setHasFixedSize(true);
        RetrofitSingleton.getRetrofitInstance()
                .create(SpaceService.class)
                .getSpaceResponse()
                .enqueue(new Callback<SpaceResponse>() {
                    @Override
                    public void onResponse(Call<SpaceResponse> call,
                                           Response<SpaceResponse> response) {
                        Log.e("universeItems: ", response.body().getSpace()
                                .get(1).getUniverse().get(0).getName());
                        recyclerView.setAdapter(new UniverseAdapter(
                                response.body().getSpace().get(1).getUniverse(),
                                fragmentInterface));
                        recyclerView.setLayoutManager(new LinearLayoutManager(getContext(),
                                LinearLayoutManager.HORIZONTAL, false));
                    }

                    @Override
                    public void onFailure(Call<SpaceResponse> call, Throwable t) {
                        Log.d(TAG, "onFailure: " + t.getMessage());
                    }
                });
    }
}