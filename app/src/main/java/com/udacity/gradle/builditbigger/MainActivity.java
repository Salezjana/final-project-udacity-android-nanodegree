package com.udacity.gradle.builditbigger;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.FrameLayout;

import com.example.myjokeandroidlib.JokeFragment;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {


    @BindView(R.id.main_container)
    FrameLayout mainContainer;
    @BindView(R.id.ad_continer)
    @Nullable
    FrameLayout adContiner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        new EndpointsAsyncTask(){
            @Override
            protected void onPostExecute(String result) {
                if (result != null){
                    startFragment(result);
                }else{
                    startFragment("PROBLEM WITH LOADING");
                }
            }
        }.execute();
    }

    public void startFragment(String joke){
        Bundle bundle = new Bundle();
        bundle.putString(JokeFragment.BUNDLE_JOKE,joke);
        JokeFragment jokeFragment = new JokeFragment();
        jokeFragment.setArguments(bundle);

        if (BuildConfig.FLAVOR == "free") {
            adContiner.setVisibility(View.VISIBLE);
            getSupportFragmentManager().beginTransaction().replace(adContiner.getId(), jokeFragment).commit();
        }

        getSupportFragmentManager().beginTransaction().replace(mainContainer.getId(), jokeFragment).commit();
    }


}
