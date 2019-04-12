package org.pursuit.blastoff;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class SplashActivity extends AppCompatActivity {

    private static final int SPLASH_DISPLAY_LENGTH = 6000;

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
//        new Handler().postDelayed(new Runnable(){
//            @Override
//            public void run() {
//                Intent intent = new Intent(
//                        SplashActivity.this, HostActivity.class);
//                startActivity(intent);
//            }
//        }, SPLASH_DISPLAY_LENGTH);
    }
}
