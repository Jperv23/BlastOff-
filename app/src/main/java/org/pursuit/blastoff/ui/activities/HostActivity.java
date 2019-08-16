package org.pursuit.blastoff.ui.activities;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.TextView;

import org.pursuit.blastoff.R;
import org.pursuit.blastoff.ui.fragments.FragmentListener;
import org.pursuit.blastoff.ui.fragments.ChoiceFragment;
import org.pursuit.blastoff.ui.fragments.SolarSystemDetailFragment;
import org.pursuit.blastoff.ui.fragments.SolarSystemFragment;
import org.pursuit.blastoff.ui.fragments.UniverseDetailFragment;
import org.pursuit.blastoff.ui.fragments.UniverseFragment;

import java.util.Locale;

public class HostActivity extends AppCompatActivity implements FragmentListener {

    private TextToSpeech textToSpeech;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_host);

        Toolbar toolbar = findViewById(R.id.toolBar);
        setSupportActionBar(toolbar);
        setCollapsingToolbar();

        onChoiceFragmentInteraction();
        initTextToSpeech(getApplicationContext());
    }

    public void setCollapsingToolbar() {
        CollapsingToolbarLayout collapsingToolbarLayout = findViewById(R.id.collapsing_toolBar);
        collapsingToolbarLayout.setScrimAnimationDuration(500);
    }

    public void initTextToSpeech(final Context context) {
        textToSpeech = new TextToSpeech(context, status -> {
            if (status == TextToSpeech.SUCCESS) {
                int language = textToSpeech.setLanguage(Locale.US);
                if (language == TextToSpeech.LANG_MISSING_DATA
                        || language == TextToSpeech.LANG_NOT_SUPPORTED) {
                    Log.e("TTS", "The Language is not supported!");
                } else {
                    Log.i("TTS", "Language Supported.");
                }
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.contact_links, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.github_link:
                break;
            case R.id.linkedIn_link:
                break;
        }
        return true;
    }

    public void toGitHubPage() {
        String url = "https://github.com/Jperv23";
        Uri webPage = Uri.parse(url);
        Intent intent = new Intent(Intent.ACTION_VIEW, webPage);
        if (intent.resolveActivity(getApplicationContext().getPackageManager()) != null) {
            startActivity(intent);
        }
    }

    public void toLinkedInPage() {
        String url = "https://www.linkedin.com/in/jperv23";
        Uri webPage = Uri.parse(url);
        Intent intent = new Intent(Intent.ACTION_VIEW, webPage);
        if (intent.resolveActivity(getApplicationContext().getPackageManager()) != null) {
            startActivity(intent);
        }
    }


    @Override
    public void onChoiceFragmentInteraction() {
        getSupportFragmentManager().beginTransaction()
                .setCustomAnimations(R.anim.enter, R.anim.exit, R.anim.pop_enter, R.anim.pop_exit)
                .replace(R.id.fragment_container, ChoiceFragment.newInstance())
                .addToBackStack("choice")
                .commit();
    }

    @Override
    public void onUniverseFragmentInteraction() {
        getSupportFragmentManager().beginTransaction()
                .setCustomAnimations(R.anim.enter, R.anim.exit, R.anim.pop_enter, R.anim.pop_exit)
                .replace(R.id.fragment_container, UniverseFragment.newInstance())
                .addToBackStack("universe")
                .commit();
    }

    @Override
    public void onSolarSystemFragmentInteraction() {
        getSupportFragmentManager().beginTransaction()
                .setCustomAnimations(R.anim.enter, R.anim.exit, R.anim.pop_enter, R.anim.pop_exit)
                .replace(R.id.fragment_container, SolarSystemFragment.newInstance())
                .addToBackStack("solarSystem")
                .commit();
    }

    @Override
    public void onDetailUniverseFragmentInteraction(
            String name, String fact1, String text, String image) {
        getSupportFragmentManager().beginTransaction()
                .setCustomAnimations(R.anim.enter, R.anim.exit, R.anim.pop_enter, R.anim.pop_exit)
                .replace(R.id.fragment_container,
                        UniverseDetailFragment.newInstance(name, fact1, text, image))
                .addToBackStack("detailUniverse")
                .commit();
    }

    @Override
    public void onDetailSolarSystemFragmentInteraction(
            String name, String fact1, String fact2, String text, String image) {
        getSupportFragmentManager().beginTransaction()
                .setCustomAnimations(R.anim.enter, R.anim.exit, R.anim.pop_enter, R.anim.pop_exit)
                .replace(R.id.fragment_container,
                        SolarSystemDetailFragment.newInstance(name, fact1, fact2, text, image))
                .addToBackStack("detailSolarSystem")
                .commit();
    }

    @Override
    public void navigateToNasaWebsiteHome(Context context) {
        String url = "https://www.nasa.gov/kidsclub/index.html";
        Uri webPage = Uri.parse(url);
        Intent intent = new Intent(Intent.ACTION_VIEW, webPage);
        if (intent.resolveActivity(context.getPackageManager()) != null) {
            startActivity(intent);
        }
    }

    @Override
    public void navigateToNasaWebsiteSolarSystem(String name, Context context) {
        String url;
        if(name.equals("The Sun")){
            url = "https://solarsystem.nasa.gov/planets/" + name.substring(4,7).toLowerCase() + "/overview/";
        }else {
            url = "https://solarsystem.nasa.gov/planets/" + name.toLowerCase() + "/overview/";
        }
        Uri webPage = Uri.parse(url);
        Intent intent = new Intent(Intent.ACTION_VIEW, webPage);
        if (intent.resolveActivity(context.getPackageManager()) != null) {
            startActivity(intent);
        }
    }

    @Override
    public void onMapActivityInteraction(String input) {
        Intent intent = new Intent(HostActivity.this, MapsActivity.class);
        intent.putExtra("location", input);
        startActivity(intent);
    }

    @Override
    public void setTextToSpeechToViews(final TextView textView) {
        textView.setOnClickListener(v -> {
            int speakText = textToSpeech.speak(String.valueOf(textView.getText()),
                    TextToSpeech.QUEUE_FLUSH, null);
            if (speakText == TextToSpeech.ERROR) {
                Log.e("TTS", "Error in converting Text to Speech!");
            }
        });
    }
}
