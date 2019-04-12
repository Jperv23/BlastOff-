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
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import org.pursuit.blastoff.R;

public class DetailSolarSystemFragment extends Fragment {

    FragmenListener fragmenListener;

    private static final String PARAM1 = "param1";
    private static final String PARAM2 = "param2";
    private static final String PARAM3 = "param3";

    private String name;
    private String text;
    private String imageURL;
    private String url;

    private TextView nameView;
    private TextView textView;
    private ImageView imageView;
    private Button nasaButton;

    public static DetailSolarSystemFragment newInstance(String name, String text, String image) {
        DetailSolarSystemFragment detailSolarSystemFragment = new DetailSolarSystemFragment();
        Bundle args = new Bundle();
        args.putString(PARAM1, name);
        args.putString(PARAM2, text);
        args.putString(PARAM3, image);
        detailSolarSystemFragment.setArguments(args);
        return detailSolarSystemFragment;
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
        if (getArguments() != null) {
            name = getArguments().getString(PARAM1);
            text = getArguments().getString(PARAM2);
            imageURL = getArguments().getString(PARAM3);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_detail_solar_system, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        nameView = view.findViewById(R.id.ss_name_textView);
        textView = view.findViewById(R.id.ss_text_textView);
        imageView = view.findViewById(R.id.ss_imageView);
        nameView.setText(name);
        textView.setText(text);
        Glide.with(getContext())
                .load(imageURL)
                .into(imageView);
        nasaButton = view.findViewById(R.id.planets_nasa_button);
        onButtonClick(nasaButton);
    }

    @Override
    public void onDetach() {
        super.onDetach();
        fragmenListener = null;
    }

    public void onButtonClick(Button button) {
        button.setOnClickListener(v -> fragmenListener.toNasaWebsiteSS(name, url, getContext()));
    }

//    public void toNasaWebsite() {
//        if(name.equals("The Sun")){
//            url = "https://solarsystem.nasa.gov/planets/" + name.substring(4,7).toLowerCase() + "/overview/";
//        }else {
//            url = "https://solarsystem.nasa.gov/planets/" + name.toLowerCase() + "/overview/";
//        }
//        Uri webPage = Uri.parse(url);
//        Intent intent = new Intent(Intent.ACTION_VIEW, webPage);
//        if (intent.resolveActivity(getContext().getPackageManager()) != null) {
//            startActivity(intent);
//        } else {
//            Log.d("ImplicitIntents", "Can't handle this!");
//        }
//    }
}
