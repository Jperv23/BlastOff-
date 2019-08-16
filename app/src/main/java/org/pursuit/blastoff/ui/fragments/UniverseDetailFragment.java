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

public class UniverseDetailFragment extends Fragment {

    private FragmentListener fragmentListener;

    private static final String NAME_KEY = "param1";
    private static final String FACT1_KEY = "param2";
    private static final String TEXT_KEY = "param3";
    private static final String IMAGE_URL_KEY = "param4";

    private String name;
    private String fact1;
    private String text;
    private String imageURL;

    public static UniverseDetailFragment newInstance(
            String name, String fact1, String text, String image) {
        UniverseDetailFragment universeDetailFragment = new UniverseDetailFragment();
        Bundle args = new Bundle();
        args.putString(NAME_KEY, name);
        args.putString(FACT1_KEY, fact1);
        args.putString(TEXT_KEY, text);
        args.putString(IMAGE_URL_KEY, image);
        universeDetailFragment.setArguments(args);
        return universeDetailFragment;
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
            text = getArguments().getString(TEXT_KEY);
            imageURL = getArguments().getString(IMAGE_URL_KEY);
        }
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_detail_universe, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ImageView imageView = view.findViewById(R.id.uni_imageView);
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
        button.setOnClickListener(v -> fragmentListener.navigateToNasaWebsiteHome(getContext()));
    }

    public void setTextViews(View view) {
        TextView nameView = view.findViewById(R.id.uni_name_textView);
        TextView fact1View = view.findViewById(R.id.uni_fact1_textView);
        TextView textView = view.findViewById(R.id.uni_text_texView);
        nameView.setText(name);
        fact1View.setText(fact1);
        textView.setText((text));
        fragmentListener.setTextToSpeechToViews(nameView);
        fragmentListener.setTextToSpeechToViews(fact1View);
        fragmentListener.setTextToSpeechToViews(textView);
    }
}
