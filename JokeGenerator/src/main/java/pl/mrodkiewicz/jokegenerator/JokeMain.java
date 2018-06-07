package pl.mrodkiewicz.jokegenerator;

import java.util.Random;

public class JokeMain {
    private Random random = new Random();

    public String getJoke() {
        String joke;
        switch (random.nextInt(6)) {
            case 0:
                joke = "JOKE 1";
                break;
            case 1:
                joke = "JOKE 2";
                break;
            case 3:
                joke = "JOKE 3";
                break;
            case 4:
                joke = "JOKE 4";
                break;
            case 5:
                joke = "JOKE 5";
                break;
            case 6:
                joke = "JOKE 6";
                break;
            default:
                joke = "JOKE 7";
                break;
        }
        return joke;
    }
}
