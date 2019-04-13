package org.pursuit.blastoff.fragments;

import android.content.Context;
import android.widget.TextView;

public interface FragmenListener {

    void toChoiceFragment();

    void toUniverseFragment();

    void toSolarSystemFragment();

    void toDetailUniverseFragment(String name, String text, String image);

    void toDetailSolarSystemFragment(String name, String text, String image);

    void initTextToSpeech(final Context context);

    void setTextToSpeechToViews(final TextView textView);

    void toNasaWebsiteHome(Context context);

    void toNasaWebsiteSS(String name, Context context);

    void toMapActivity(String locationInput);
}
