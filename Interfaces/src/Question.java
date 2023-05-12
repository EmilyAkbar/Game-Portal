import java.util.Scanner;

public class Question {
    // Fields
    String label;
    long skipIndex; // ejects a question when assigned a positive value
    Answer[] possibleAnswers = new Answer[4];

    Question(String label) {
        this.label = label;
        double r = Math.random() * 7.0; 
        this.skipIndex = Math.round(r) - 4; // assigns skipIndex a value
    }

    // ask a question, and return the points of the answer
    int ask(Scanner sc) {
        System.out.println(this.label);
        // prints out all the answer choices
        for (int i = 0; i < this.possibleAnswers.length; i++) {
            String choice = Integer.toString(i + 1);
            if(i != this.skipIndex) {
                System.out.println("[" + choice + "]: " + this.possibleAnswers[i].label);
            }
            else {
                System.out.println("[" + choice + "]: <<<Error. Choice voted out and ejected for being too sus!>>>");
            }
        }
        int ans = errorCheck(sc);
        return possibleAnswers[ans - 1].susPoints;
    }

    int errorCheck(Scanner sc) {
        if(sc.hasNextInt()) {
            int input = sc.nextInt();
            if (input > this.possibleAnswers.length || input < 1 || input == this.skipIndex + 1) { // checks if the input is a possible answer
                System.out.println("Not a valid number. Please input a valid number.");
                return errorCheck(sc);
            } 
            else {
                return input;
            }
        } 
        else {
            System.out.println("Not an integer. Please input a valid integer.");
            sc.next(); // discarding the next input
            return errorCheck(sc); 
        }
    }
}
