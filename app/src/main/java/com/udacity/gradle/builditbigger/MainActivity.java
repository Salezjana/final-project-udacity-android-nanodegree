package com.udacity.gradle.builditbigger;


import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.FrameLayout;

import com.example.myjokeandroidlib.JokeFragment;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {


    @BindView(R.id.main_container)
    FrameLayout mainContainer;
    @BindView(R.id.ad_continer)
    FrameLayout adContiner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        getSupportFragmentManager().beginTransaction().replace(adContiner.getId(), new JokeFragment()).commit();
        getSupportFragmentManager().beginTransaction().replace(mainContainer.getId(), new JokeFragment()).commit();
    }


}
