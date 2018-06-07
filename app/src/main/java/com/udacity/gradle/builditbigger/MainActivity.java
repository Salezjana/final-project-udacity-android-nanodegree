package com.udacity.gradle.builditbigger;


import android.arch.core.BuildConfig;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.FrameLayout;

import com.example.myjokeandroidlib.JokeFragment;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;

import butterknife.BindView;
import butterknife.ButterKnife;
import pl.mrodkiewicz.jokegenerator.JokeMain;
import timber.log.Timber;

public class MainActivity extends AppCompatActivity {


    @BindView(R.id.main_container)
    FrameLayout mainContainer;

    AdView adView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        Timber.plant(new Timber.DebugTree());
        if (BuildConfig.FLAVOR == "free") {

            MobileAds.initialize(this,
                    "ca-app-pub-3940256099942544~3347511713");


            adView = findViewById(R.id.adView);
            AdRequest adRequest = new AdRequest.Builder().build();
            adView.loadAd(adRequest);
        }

        new EndpointsAsyncTask().execute(this);
        JokeMain jokeMain = new JokeMain();
        Timber.d(jokeMain.getJoke());
    }




}
