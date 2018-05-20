package pl.mrodkiewicz.jokegenerator;

import java.util.Random;

public class JokeMain {
    private String [] jokes;
    private Random random;

    public JokeMain() {
        jokes = new String[8];
        generateJokes();
    }

    private void generateJokes() {
        jokes[0] = "Grate Joke nr 1";
        jokes[1] = "Grate Joke nr 2";
        jokes[2] = "Grate Joke nr 3";
        jokes[3] = "Grate Joke nr 4";
        jokes[4] = "Grate Joke nr 5";
        jokes[5] = "Grate Joke nr 6";
        jokes[6] = "Grate Joke nr 7";
        jokes[7] = "Grate Joke nr 8";
    }

    public String getRandomJoke() {
        return jokes[random.nextInt(jokes.length)];
    }
}
