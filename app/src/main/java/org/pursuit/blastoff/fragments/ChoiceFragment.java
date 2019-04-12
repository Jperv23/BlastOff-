package org.pursuit.blastoff.fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.pursuit.blastoff.R;

import pl.droidsonroids.gif.GifImageView;

public class ChoiceFragment extends Fragment {

    private FragmenListener fragmenListener;
    private EditText locationInput;

    public static ChoiceFragment newInstance() {
        return new ChoiceFragment();
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof FragmenListener) {
            fragmenListener = (FragmenListener) context;
        } else {
            throw new RuntimeException(context.toString() +
                    "must implement FragmenListener");
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
        setTextViews(view);
        getLocationInputAndMoveToMap(view);
    }

    @Override
    public void onDetach() {
        super.onDetach();
        fragmenListener = null;
    }

    public void setUniverseImage(View view) {
        GifImageView universeImage = view.findViewById(R.id.universeImage);
        universeImage.isClickable();
        universeImage.setOnClickListener(v -> fragmenListener.toUniverseFragment());
    }

    public void setSolarSystemImage(View view) {
        GifImageView solarSystemImage = view.findViewById(R.id.solarSystemImage);
        solarSystemImage.setOnClickListener(v -> fragmenListener.toSolarSystemFragment());
    }

    public void setTextViews(View view) {
        TextView universeText = view.findViewById(R.id.universeText);
        TextView solarText = view.findViewById(R.id.solartext);
        TextView exploreView = view.findViewById(R.id.explore_textView);
        TextView beyondView = view.findViewById(R.id.beyond_textView);
        TextView nasaKids = view.findViewById(R.id.nasaKids);
        fragmenListener.setTextToSpeechToViews(universeText);
        fragmenListener.setTextToSpeechToViews(solarText);
        fragmenListener.setTextToSpeechToViews(exploreView);
        fragmenListener.setTextToSpeechToViews(beyondView);
        nasaKids.setOnClickListener(v -> {
           fragmenListener.toNasaWebsiteHome(getContext());
        });
    }

    public void getLocationInputAndMoveToMap(View view) {
        locationInput = view.findViewById(R.id.locationInput);
        Button submit = view.findViewById(R.id.submit);
        submit.setOnClickListener(v -> {
            fragmenListener.toMapActivity(locationInput.toString());
        });
    }


}
