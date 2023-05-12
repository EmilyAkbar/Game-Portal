import java.util.Scanner;
import java.io.File;
import java.io.IOException;
import java.lang.Math;

public class Quiz implements GameWriteable {
    int score = 0; 
    int highscore;
    int percent;

    @Override
    public String getGameName() {
        return "Buzzfeed Quiz"; 
    }

    @Override
    public void play() throws IOException, InterruptedException {


        // Create Categories
        Category notSus = new Category("NOT SUS", "Brown", "Not sus at all, you are a crewmate for sure for sure for sure.");
        Category slightlySus = new Category("SLIGHTLY SUS", "Dark Green",
        "You are very peculiar. Maybe you are a crewmate, but you sometimes act very sus for no reason. Why?");
        Category mediumSus = new Category("MEDIUM LEVEL SUS", "Pink", 
            "We hope that you are a crewmate and still like to trust you. You seem to do your tasks, or are you just acting?");
        Category Sus = new Category("SUS", "Yellow", "Scary. The definition of sus. People run away from you because you act sus. No matter how you prove you're a crewmate, you still act abnormally.");
        Category verySus = new Category("VERY VERY SUSSY", "Purple", "Nah bro I'm outta here you're going to betray me.");
        Category insanelySus = new Category("INSANELY SUSSY", "Black", "I'm running away ASAP.");
        Category extremelySus = new Category("EXTREMELY SUS 100% SUSSY", "Red", 
        "I don't know how its po1ssible to be this sus, anyways I'm out OH GOD AHHH YOU'RE RIGHT BEHIND ME YOU JUST VENTED OH NO OH NO OH NO I'M SO DOOMEDDDD!D!D");
        
        // Create Questions

        Question q1 = new Question("What's your favorite type of food...?");
        // Attach Answers to Questions
        q1.possibleAnswers[0] = new Answer("Red cotton candy", 10);
        q1.possibleAnswers[1] = new Answer("Slides", 6);
        q1.possibleAnswers[2] = new Answer("The Odyssey", 21);
        q1.possibleAnswers[3] = new Answer("Pizza", 1);

        Question q2 = new Question("How often do you eat food?!?");
        q2.possibleAnswers[0] = new Answer("Once every 2 weeks", 7);
        q2.possibleAnswers[1] = new Answer("Every other minute", 0);
        q2.possibleAnswers[2] = new Answer("Every minute", 20);
        q2.possibleAnswers[3] = new Answer("All of the above", 8);

        Question q3 = new Question("What is your favorite type of cheese......");
        q3.possibleAnswers[0] = new Answer("What is cheese", 10);
        q3.possibleAnswers[1] = new Answer("Earthworms", 0);
        q3.possibleAnswers[2] = new Answer("Blue cheese", 8);
        q3.possibleAnswers[3] = new Answer("Gray cheese", 20);

        Question q4 = new Question("What's your favorite color??");
        q4.possibleAnswers[0] = new Answer("Red", 50);
        q4.possibleAnswers[1] = new Answer("Pink", 1);
        q4.possibleAnswers[2] = new Answer("Yellow", 2);
        q4.possibleAnswers[3] = new Answer("Bleu is the color of the airspace of the heavens", 75);

        Question q5 = new Question("Why is that your favorite color?");
        q5.possibleAnswers[0] = new Answer("I don't know", 0);
        q5.possibleAnswers[1] = new Answer("Yes", 1);
        q5.possibleAnswers[2] = new Answer("Jazz", 10);
        q5.possibleAnswers[3] = new Answer("Floridaman", 15);

        Question q6 = new Question("Do you pull pranks on your friends? >:|");
        q6.possibleAnswers[0] = new Answer("Regularly", 5);
        q6.possibleAnswers[1] = new Answer("Astronomically", 10);
        q6.possibleAnswers[2] = new Answer("Neverly", -10);
        q6.possibleAnswers[3] = new Answer("Haha funny", 12);
        
        Question q7 = new Question("What are your opinions on milk.");
        q7.possibleAnswers[0] = new Answer("Delicious", 10);
        q7.possibleAnswers[1] = new Answer("Finger lickin good", 20);
        q7.possibleAnswers[2] = new Answer("Ew", 2);
        q7.possibleAnswers[3] = new Answer("Elon Musk", 25);

        Question q8 = new Question("What pet would you want to have?");
        q8.possibleAnswers[0] = new Answer("Donkey", 20);
        q8.possibleAnswers[1] = new Answer("Pigeon", 2);
        q8.possibleAnswers[2] = new Answer("Worm", 10);
        q8.possibleAnswers[3] = new Answer("I am vegan", 25);

        Question q9 = new Question("What superpower would you want to have?");
        q9.possibleAnswers[0] = new Answer("Invisibility", 30);
        q9.possibleAnswers[1] = new Answer("Metal detector arm", 3);
        q9.possibleAnswers[2] = new Answer("Transform into ant", 20);
        q9.possibleAnswers[3] = new Answer("Shapeshift", 25);

        Question q10 = new Question("What's your favorite class.......");
        q10.possibleAnswers[0] = new Answer("Intermediate programming", 1);
        q10.possibleAnswers[1] = new Answer("Spanish", 50);
        q10.possibleAnswers[2] = new Answer("HMO", 50);
        q10.possibleAnswers[3] = new Answer("P.E.", 10);

        // For each question, ask, read input, store answer.
        Scanner sc = new Scanner(System.in);
        gameIntro(sc);
        Question[] qList = {q1, q2, q3, q4, q5, q6, q7, q8, q9, q10};
        int totalPoints = 0;
        for (Question q : qList) {
            int c = q.ask(sc);
            totalPoints += c;
          
        }
        
        // Return Category
        double rPercent = (totalPoints/293.0); // get the sum of the answer points and find the percentage over the total points possible
        rPercent = Math.round(rPercent * 100.0); // round the percentage to an integer
        percent = (int)rPercent;

        for (int x = 0; x <= 6; x++) { // loading animation
            System.out.println(".");
            Thread.sleep(200);
        }
        
        // loading animation
        String load = "|/-\\";
        for (int x = 0; x <= 100; x += 5) { 
            String data = "\r" + "Sus counter loading: " + load.charAt(x % load.length()) + " " + x + "%"; 
            System.out.write(data.getBytes());
            Thread.sleep(150);
        }
        System.out.println("");

        // print quiz results
        System.out.println("You are " + percent + "% sus.");
        if (percent <= 15) {
            System.out.println("You would be the " + notSus.color + " among us.");
            System.out.println(notSus.description);
            score ++; 
        }
        else if (percent <= 30) {
            System.out.println("You would be the " + slightlySus.color + " among us.");
            System.out.println(slightlySus.description);
            score ++; 
        }
        else if (percent <= 45) {
            System.out.println("You would be the " + mediumSus.color + " among us.");
            System.out.println(mediumSus.description);
            score ++; 
        }
        else if (percent <= 60) {
            System.out.println("You would be the " + Sus.color + " among us.");
            System.out.println(Sus.description);
            score ++; 
        }
        else if (percent <= 75) {
            System.out.println("You would be the " + verySus.color + " among us.");
            System.out.println(verySus.description);
            score ++; 
        }
        else if (percent <= 90) {
            System.out.println("You would be the " + insanelySus.color + " among us.");
            System.out.println(insanelySus.description);
            score ++; 
        }
        else {
            System.out.println("You would be the " + extremelySus.color + " among us.");
            System.out.println(extremelySus.description);
            score ++; 
        }
        


    }

    @Override
    public String getScore() {
        return Integer.toString(percent);
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

    }
  

    // instructions
    public static void gameIntro(Scanner sc) {
        // requires ok to keep going
        System.out.println("Are you ready to find out how SUSSY are you?!");
        System.out.println("Can the crew really trust you??");
        System.out.println("Enter [OK] to play!");
        String play = sc.nextLine();
        play = play.toLowerCase();
        if (!play.equals("ok")) {
            System.out.println("Unidentifiable input. Please enter [OK] to play!");
            gameIntro(sc);
        }
    }


  

}
