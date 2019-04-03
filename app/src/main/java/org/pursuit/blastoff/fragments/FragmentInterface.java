package org.pursuit.blastoff.fragments;

public interface FragmentInterface {

    void toChoiceFragment();

    void toUniverseFragment();

    void toSolarSystemFragment();

    void toDetailUniverseFragment(String name, String text, String image);

    void toDetailSolarSystemFragment(String name, String text, String image);
}
