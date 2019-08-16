package org.pursuit.blastoff.ui.fragments;

import android.content.Context;
import android.widget.TextView;

public interface FragmentListener {

    void onChoiceFragmentInteraction();

    void onUniverseFragmentInteraction();

    void onSolarSystemFragmentInteraction();

    void onDetailUniverseFragmentInteraction(String name, String fact1, String text, String image);

    void onDetailSolarSystemFragmentInteraction(String name, String fact1, String fact2, String text, String image);

    void navigateToNasaWebsiteHome(Context context);

    void navigateToNasaWebsiteSolarSystem(String name, Context context);

    void onMapActivityInteraction(String locationInput);

    void setTextToSpeechToViews(final TextView textView);
}
