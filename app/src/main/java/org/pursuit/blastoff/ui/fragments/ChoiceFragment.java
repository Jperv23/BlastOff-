package org.pursuit.blastoff.ui.fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import org.pursuit.blastoff.R;

public class ChoiceFragment extends Fragment {

    private FragmentListener fragmentListener;
    private TextView locationInput;

    public static ChoiceFragment newInstance() {
        return new ChoiceFragment();
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof FragmentListener) {
            fragmentListener = (FragmentListener) context;
        } else {
            throw new RuntimeException(context.toString() +
                    "must implement FragmentListener");
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
        onUniverseImageClick(view);
        onSolarSystemImageClick(view);
        setTextViews(view);
        getLocationInputAndMoveToMap(view);
    }

    @Override
    public void onDetach() {
        super.onDetach();
        fragmentListener = null;
    }

    public void onUniverseImageClick(View view) {
        ImageView universeImage = view.findViewById(R.id.universeImage);
        universeImage.isClickable();
        universeImage.setOnClickListener(v -> fragmentListener.onUniverseFragmentInteraction());
    }

    public void onSolarSystemImageClick(View view) {
        ImageView solarSystemImage = view.findViewById(R.id.solarSystemImage);
        solarSystemImage.setOnClickListener(v -> fragmentListener.onSolarSystemFragmentInteraction());
    }

    public void setTextViews(View view) {
        TextView universeText = view.findViewById(R.id.universeText);
        TextView solarText = view.findViewById(R.id.solartext);
        TextView exploreView = view.findViewById(R.id.explore_textView);
        TextView beyondView = view.findViewById(R.id.beyond_textView);
        TextView nasaKids = view.findViewById(R.id.nasaKids);
        fragmentListener.setTextToSpeechToViews(universeText);
        fragmentListener.setTextToSpeechToViews(solarText);
        fragmentListener.setTextToSpeechToViews(exploreView);
        fragmentListener.setTextToSpeechToViews(beyondView);
        nasaKids.setOnClickListener(v -> {
           fragmentListener.navigateToNasaWebsiteHome(getContext());
        });
    }

    public void getLocationInputAndMoveToMap(View view) {
        locationInput = view.findViewById(R.id.locationInput);
        Button submit = view.findViewById(R.id.submit);
        submit.setOnClickListener(v -> {
//            fragmentListener.onMapActivityInteraction(locationInput.toString());
        });
    }


}
