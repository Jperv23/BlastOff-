package org.pursuit.blastoff.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import org.pursuit.blastoff.R;

public class SplashPageFragment extends Fragment {


    public static SplashPageFragment newInstance() {
        return new SplashPageFragment();
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_splash_page, container, false);
    }

}
