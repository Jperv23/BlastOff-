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

import com.bumptech.glide.Glide;

import org.pursuit.blastoff.R;

public class SolarSystemDetailFragment extends Fragment {

    private FragmentListener fragmentListener;

    private static final String NAME_KEY = "param1";
    private static final String FACT1_KEY = "param2";
    private static final String FACT2_KEY = "param3";
    private static final String TEXT_KEY = "param4";
    private static final String IMAGE_URL_KEY = "param5";

    private String name;
    private String fact1;
    private String fact2;
    private String text;
    private String imageURL;

    public static SolarSystemDetailFragment newInstance(
            String name, String fact1, String fact2, String text, String imageURL) {
        SolarSystemDetailFragment solarSystemDetailFragment = new SolarSystemDetailFragment();
        Bundle args = new Bundle();
        args.putString(NAME_KEY, name);
        args.putString(FACT1_KEY, fact1);
        args.putString(FACT2_KEY, fact2);
        args.putString(TEXT_KEY, text);
        args.putString(IMAGE_URL_KEY, imageURL);
        solarSystemDetailFragment.setArguments(args);
        return solarSystemDetailFragment;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof FragmentListener) {
            fragmentListener = (FragmentListener) context;
        } else {
            throw new RuntimeException(context.toString() +
                    " must implement FragmentListener");
        }
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            name = getArguments().getString(NAME_KEY);
            fact1 = getArguments().getString(FACT1_KEY);
            fact2 = getArguments().getString(FACT2_KEY);
            text = getArguments().getString(TEXT_KEY);
            imageURL = getArguments().getString(IMAGE_URL_KEY);
        }
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_detail_solar_system, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ImageView imageView = view.findViewById(R.id.solar_imageView);
        Button nasaButton = view.findViewById(R.id.nasa_button);
        setTextViews(view);
        Glide.with(requireContext())
                .load(imageURL)
                .into(imageView);
        onButtonClick(nasaButton);
    }

    @Override
    public void onDetach() {
        super.onDetach();
        fragmentListener = null;
    }

    public void onButtonClick(Button button) {
        button.setOnClickListener(v -> fragmentListener.navigateToNasaWebsiteSolarSystem(name, getContext()));
    }

    public void setTextViews(View view) {
        TextView nameView = view.findViewById(R.id.solar_name_textView);
        TextView fact1View = view.findViewById(R.id.solar_fact1_textView);
        TextView fact2View = view.findViewById(R.id.solar_fact2_textView);
        TextView textView = view.findViewById(R.id.solar_text_texView);
        nameView.setText(name);
        fact1View.setText(fact1);
        fact2View.setText(fact2);
        textView.setText(text);
        fragmentListener.setTextToSpeechToViews(nameView);
        fragmentListener.setTextToSpeechToViews(fact1View);
        fragmentListener.setTextToSpeechToViews(fact2View);
        fragmentListener.setTextToSpeechToViews(textView);
    }
}
