package org.pursuit.blastoff.fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import org.pursuit.blastoff.R;

public class ChoiceFragment extends Fragment {

    private FragmentInterface fragmentInterface;

    public static ChoiceFragment newInstance() {
        return new ChoiceFragment();
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof FragmentInterface) {
            fragmentInterface = (FragmentInterface) context;
        }else {
            throw new RuntimeException(context.toString() +
                    "must implement FragmentInterface");
        }
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_choice, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        setUniverseImage(view);
        setSolarSystemImage(view);
    }

    @Override
    public void onDetach() {
        super.onDetach();
        fragmentInterface = null;
    }

    public void setUniverseImage(View view) {
        ImageView universeImage = view.findViewById(R.id.universeImage);
        universeImage.isClickable();
        universeImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fragmentInterface.toUniverseFragment();
            }
        });
    }

    public void setSolarSystemImage(View view) {
        ImageView solarSystemImage = view.findViewById(R.id.solarSystemImage);
        solarSystemImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fragmentInterface.toSolarSystemFragment();
            }
        });
    }
}
