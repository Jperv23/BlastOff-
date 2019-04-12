package org.pursuit.blastoff;

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

import org.pursuit.blastoff.fragments.ChoiceFragment;
import org.pursuit.blastoff.fragments.DetailSolarSystemFragment;
import org.pursuit.blastoff.fragments.DetailUniverseFragment;
import org.pursuit.blastoff.fragments.FragmenListener;
import org.pursuit.blastoff.fragments.SolarSystemFragment;
import org.pursuit.blastoff.fragments.UniverseFragment;
import org.pursuit.blastoff.map.MapsActivity;

import java.util.Locale;

public class HostActivity extends AppCompatActivity implements FragmenListener {

    private TextToSpeech textToSpeech;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_host);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolBar);
        setSupportActionBar(toolbar);
        setCollapsingToolbar();

        toChoiceFragment();
        initTextToSpeech(getApplicationContext());
    }

    public void setCollapsingToolbar() {
        CollapsingToolbarLayout collapsingToolbarLayout = findViewById(R.id.collapsing_toolBar);
        collapsingToolbarLayout.setScrimAnimationDuration(500);
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
                toGitHubPage();
                break;
            case R.id.linkedIn_link:
                toLinkedInPage();
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
        } else {
            Log.d("ImplicitIntents", "Can't handle this!");
        }
    }

    public void toLinkedInPage() {
        String url = "https://www.linkedin.com/in/jperv23";
        Uri webPage = Uri.parse(url);
        Intent intent = new Intent(Intent.ACTION_VIEW, webPage);
        if (intent.resolveActivity(getApplicationContext().getPackageManager()) != null) {
            startActivity(intent);
        } else {
            Log.d("ImplicitIntents", "Can't handle this!");
        }
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

    @Override
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
    public void setTextToSpeechToViews(final TextView textView) {
        textView.setOnClickListener(v -> {
            int speakText = textToSpeech.speak(String.valueOf(textView.getText()),
                    TextToSpeech.QUEUE_FLUSH, null);
            if (speakText == TextToSpeech.ERROR) {
                Log.e("TTS", "Error in converting Text to Speech!");
            }
        });
    }

    @Override
    public void toNasaWebsiteHome(Context context) {
        String url = "https://www.nasa.gov/kidsclub/index.html";
        Uri webPage = Uri.parse(url);
        Intent intent = new Intent(Intent.ACTION_VIEW, webPage);
        if (intent.resolveActivity(context.getPackageManager()) != null) {
            startActivity(intent);
        }
    }

    @Override
    public void toNasaWebsiteSS(String name, String url, Context context) {
        if(name.equals("The Sun")){
            url = "https://solarsystem.nasa.gov/planets/" + name.substring(4,7).toLowerCase() + "/overview/";
        }else {
            url = "https://solarsystem.nasa.gov/planets/" + name.toLowerCase() + "/overview/";
        }
        Uri webPage = Uri.parse(url);
        Intent intent = new Intent(Intent.ACTION_VIEW, webPage);
        if (intent.resolveActivity(context.getPackageManager()) != null) {
            startActivity(intent);
        } else {
            Log.d("ImplicitIntents", "Can't handle this!");
        }
    }

    @Override
    public void toMapActivity(String input) {
        Intent intent = new Intent(HostActivity.this, MapsActivity.class);
        intent.putExtra("location", input);
        startActivity(intent);
    }

}
