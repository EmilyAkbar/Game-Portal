import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;

public class Games {
    static String[] gameChoices = { "Number Game", "Store Game", "Buzzfeed Quiz" };
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) throws IOException, InterruptedException {

        HashMap<Game, Integer> gameCounts = new HashMap<Game, Integer>();
        // writes scores
        File f = new File("Highscore.csv");
        while (true) {
            System.out.println("Which game would you like to play?");
            printGameChoices();
            Game g = getGameChoice();
            System.out.println("You're playing " + g.getGameName());
            g.play();
            g.writeHighScore(f);
            // add one to game counts or add it to the hashmap
            if (gameCounts.containsKey(g)) {
                gameCounts.put(g, gameCounts.get(g) + 1);
            } else {
                gameCounts.put(g, 1);
            }
        }
    }

    public static void printGameChoices() {
        int n = 1;
        for (String s : gameChoices) {
            System.out.println("[" + (n++) + "]: " + s);
        }
    }

    /*
     * Takes in user input for printing out all games in
     */
    public static Game getGameChoice() {
        int choice = ErrorCheck.getInt(sc);
        // for it to be numbered, we can't use hashmaps.

        // Check if the choice is 3
        if (choice == 3) {
        return new Quiz();
    }
        while (choice < 1 || choice > gameChoices.length) {
            System.out.println("We don't have this number. Try again.");
            choice = ErrorCheck.getInt(sc);
        }

        // valid game choice
        String gameString = gameChoices[choice - 1];
        if (gameString.equals("Number Game")) {
            return new NumberGame();
        } else if (gameString.equals("Store Game")) {
            return new StoreGame();
        } 
        else if (gameString.equals("Buzzfeed Quiz")) {
            return null;
        } 
        else {
            return new Quiz();
        }

    }
}

class ErrorCheck {

    public static int getInt(Scanner sc) {
        if (sc.hasNextInt()) {
            return sc.nextInt();
        } else {
            System.out.println("This is not a number. Discarding this input");
            sc.next();
            return getInt(sc);
        }
    }
}