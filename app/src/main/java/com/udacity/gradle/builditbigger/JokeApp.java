package com.udacity.gradle.builditbigger;

import android.app.Application;
import android.content.Intent;

public class JokeApp extends Application{
    @Override
    public void onCreate() {
        super.onCreate();
        startActivity(new Intent(this,MainActivity.class));
    }
}
