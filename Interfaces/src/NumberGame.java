import java.util.Random;
import java.util.Scanner;
import java.io.File;
import java.util.ArrayList;

public class NumberGame implements GameWriteable {
    int score;
    //highscore

    public static void main(String args[]) throws Exception {
        NumberGame game = new NumberGame();
        game.play();
    }

    @Override
    public String getGameName() {
        return "Number Game";
    }

    @Override
    public void play() {
        ArrayList<Integer> randos = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        Random rand = new Random();

        boolean keepPlaying = true;
        while (keepPlaying) {
            Number number = new Number(rand.nextInt(2));
            number.nextGuess();
            if (number.isCorrect()) {
                score++;
                System.out.println("Score:" + getScore());
            }
            System.out.println("Would you like to keep playing? Type 'y' to continue or any other key to quit.");
            keepPlaying = sc.nextLine().equals("y");
        }
    }

    @Override
    public String getScore() {
        return Integer.toString(score);
    }

    @Override
    public boolean isHighScore(String score, String highscore) {
        int s = Integer.parseInt(score); 
        int h = 0;
        try {

            h = Integer.parseInt(highscore); 
        } catch (Exception e) {
            h = 0; // just convert it to zero if can't parse
        }

        if (s > h) {
            return true; 
        }

        else {
            return false; 
        }

       
       
    
        // convert strings to integers 
        // return true if score > highscore 
        
    }

    class Number {
        int guess;
        int thing;
        int attempts;
        Scanner sc;

        ArrayList<Integer> randos = new ArrayList<>();

        Number(int thing) {
            this.thing = thing;
            attempts = 0;
            System.out.println("I am thinking of a number from 1 to 100. Can you guess it?");
        }

        void nextGuess() {
            sc = new Scanner(System.in);

            try {
                guess = sc.nextInt();
                if (guess <= 100 && guess > -1) {
                    System.out.println("This is a number.");
                }

                if (randos.contains(guess)) {
                    System.out.println("You already put this input. Guess again.");
                    nextGuess();
                } else if (guess == thing) {
                    System.out.println("You got it!");
                    randos.add(guess);
                    System.out.println("It took you " + randos.size() + " tries to guess " + thing);
                } else if (guess > thing && guess <= 100) {
                    System.out.println("Nope! Go lower.");
                    randos.add(guess);
                    nextGuess();
                } else if (guess < thing && guess > -1) {
                    System.out.println("Nope! Go higher.");
                    randos.add(guess);
                    nextGuess();
                } else if (guess > 100) {
                    System.out.println("Hey! this number is out of the range. Try again.");
                    nextGuess();
                } else if (guess < 100) {
                    System.out.println("Hey! this number is out of the range. Try again.");
                    nextGuess();
                }
            } catch (Exception e) {
                System.out.println("Hey this is not what I expected.");
                nextGuess();
            }
        }

        boolean isCorrect() {
            return guess == thing;
        }
    }

}

/*
 * interface Game {
 * String getGameName();
 * void play();
 * String getScore();
 * void writeHighScore(File f);
 * }
 */
