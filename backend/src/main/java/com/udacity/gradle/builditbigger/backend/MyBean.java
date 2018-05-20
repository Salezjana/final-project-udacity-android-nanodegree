package com.udacity.gradle.builditbigger.backend;

import pl.mrodkiewicz.jokegenerator.JokeMain;

/** The object model for the data we are sending through endpoints */
public class MyBean {

    private JokeMain jokeMain;

    public MyBean() {
        jokeMain = new JokeMain();
    }

    public String getJoke(){
        return jokeMain.getRandomJoke();
    }
}