package org.pursuit.blastoff;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import org.pursuit.blastoff.fragments.ChoiceFragment;
import org.pursuit.blastoff.fragments.DetailSolarSystemFragment;
import org.pursuit.blastoff.fragments.DetailUniverseFragment;
import org.pursuit.blastoff.fragments.FragmentInterface;
import org.pursuit.blastoff.fragments.SolarSystemFragment;
import org.pursuit.blastoff.fragments.UniverseFragment;

public class MainActivity extends AppCompatActivity implements FragmentInterface {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        getSupportFragmentManager().beginTransaction()
//                .replace(R.id.fragment_container, SplashPageFragment.newInstance())
//                .commit();
        toChoiceFragment();
    }

    @Override
    public void toChoiceFragment() {
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragment_container, ChoiceFragment.newInstance())
                .addToBackStack("choice")
                .commit();
    }

    @Override
    public void toUniverseFragment() {
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragment_container, UniverseFragment.newInstance())
                .addToBackStack("universe")
                .commit();
    }

    @Override
    public void toSolarSystemFragment() {
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragment_container, SolarSystemFragment.newInstance())
                .addToBackStack("solarSystem")
                .commit();
    }

    @Override
    public void toDetailUniverseFragment(String name, String text, String image) {
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragment_container,
                        DetailUniverseFragment.newInstance(name, text, image))
                .addToBackStack("detailUniverse")
                .commit();
    }

    @Override
    public void toDetailSolarSystemFragment(String name, String text, String image) {
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragment_container,
                        DetailSolarSystemFragment.newInstance(name, text, image))
                .addToBackStack("detailSolarSystem")
                .commit();
    }
}
