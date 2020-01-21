package com.coba.achmadazwar;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class SplashScreenActivity extends AppCompatActivity {
    private static int lama_splash_screen = 3000;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        ImageView azwarmisbah;

        // peng-koneksian variable dengan objek
        azwarmisbah = (ImageView) findViewById(R.id.azwaar);

        // sumber animasi nye dari mane si..
        Animation azwaaar = AnimationUtils.loadAnimation(this, R.anim.azwar);

        // mulaiin animasi nye
        azwarmisbah.startAnimation(azwaaar);


        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent homeIntent = new Intent(SplashScreenActivity. this, MainActivity.class);
                startActivity(homeIntent);
                finish();
            }
        }, lama_splash_screen);
    }
}
