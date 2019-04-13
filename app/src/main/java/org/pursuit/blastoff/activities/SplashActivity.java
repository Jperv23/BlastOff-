package org.pursuit.blastoff.activities;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;

import org.pursuit.blastoff.R;

public class SplashActivity extends AppCompatActivity {

    private static final int SPLASH_DISPLAY_LENGTH = 4000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        Intent intent = new Intent(
                SplashActivity.this, HostActivity.class);
        startActivity(intent);
    }

    @Override
    protected void onStart() {
        super.onStart();
        new Handler().postDelayed(() -> {
            Intent intent = new Intent(
                    SplashActivity.this, HostActivity.class);
            startActivity(intent);
        }, SPLASH_DISPLAY_LENGTH);
    }
}
