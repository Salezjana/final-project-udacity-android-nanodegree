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
        jokes[0] = "Joke nr 1";
        jokes[1] = "Joke nr 2";
        jokes[2] = "Joke nr 3";
        jokes[3] = "Joke nr 4";
        jokes[4] = "Joke nr 5";
        jokes[5] = "Joke nr 6";
        jokes[6] = "Joke nr 7";
        jokes[7] = "Joke nr 8";
    }

    public String getRandomJoke() {
        return jokes[random.nextInt(jokes.length)];
    }
}
