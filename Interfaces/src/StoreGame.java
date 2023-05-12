import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class StoreGame implements GameWriteable {
    int score; 
    int highscore;
    public static void main(String[] args) throws Exception {
        StoreGame game = new StoreGame(); 
        game.play(); 

    }

    @Override
    public String getGameName() {
        return "Store Game"; 
    }

    public void play() {
        Scanner sc = new Scanner(System.in);
      
        boolean replay = true;
        while (replay) {
            int money = 100;
            int initialhealth = 0;
            System.out.println("Hello. Welcome to Java Market. Have fun shopping—but don't forget to watch for your health!");
    
            System.out.println("You have 100 dollars to spend.");
            Store st = new Store();
            st.printitems();
    
            for (Item item : st.items) {
                Item i = st.buyItem(item);
                money = money - i.price;
                System.out.println("You have $" + money + " left");
                initialhealth = initialhealth + i.initialhealth;
                System.out.println("Your health level: " + initialhealth);
                i.healthAffect();
                i.yummyNess();
    
                if (money <= 0) {
                    System.out.println("You cannot afford anything else.");
                    System.out.println("Final health level: " + initialhealth);
                    score++;
                    System.out.println(getScore());
                    break;
                }
            }
            System.out.println("Thank you for playing!");
            System.out.println("Would you like to keep playing? Type 'y' to continue or any other key to quit.");
            replay = sc.nextLine().equals("y");
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

      
    }
}

class Store {
    Scanner sc;
    ArrayList<Item> items = new ArrayList<Item>();

    Store() {
        items.add(new Dairy ("Milk", 4, 0, "Yummy!"));
        items.add(new Dairy ("Eggs", 8, 1, "Meh"));
        items.add(new Dairy ("Cheese", 8, 2, "Meh"));
        items.add(new Meat ( "Chicken", 9, 3, "Yummy!"));
        items.add(new Meat ( "Beef", 15, 4, "Yummy!"));
        items.add(new Meat ( "Fish", 10, 5, "Meh"));
        items.add(new Fruits ( "Strawberry", 6, 6, "Yummy!"));
        items.add(new Fruits ( "Banana", 3, 7, "Meh"));
        items.add(new Fruits ( "Orange", 4, 8, "Meh"));
        items.add(new Fruits ( "Mango", 4, 9, "Yummy!"));
        items.add(new Fruits ( "Broccoli", 4, 10, "Yummy!"));
        items.add(new Fruits ( "Tomato", 4, 11, "Meh"));
        items.add(new Fruits ( "Cucumber", 3, 12, "Meh"));
        items.add(new Fruits ( "Spinach", 3, 13, "Meh"));
        items.add(new Grains ( "Rice", 4, 14, "Yummy!"));
        items.add(new Grains ( "Pasta", 4, 15, "Yummy!"));
        items.add(new Grains ( "Bread", 3, 16, "Yummy!"));
        items.add(new SugaryFood("Chocolate Bar", 1, 17, "Yummy!"));
        items.add(new SugaryFood("Cake", 10, 18, "Yummy!"));
        items.add(new SugaryFood("Soda", 2, 19, "Meh"));
        items.add(new SugaryFood("Cookie", 2, 20, "Yummy!"));
        items.add(new SugaryFood("Donut", 1, 21, "Yummy!"));
        items.add(new SugaryFood("Candy", 1, 22, "Meh"));
        items.add(new SugaryFood("Snackerty Board", 10, 23, "Yummy!"));
        items.add(new FrozenFood ( "Frozen Pizza", 3, 24, "Meh"));
        items.add(new FrozenFood ( "Eggos", 3, 25, "Meh"));
        items.add(new FrozenFood ( "Dino Nuggests", 4, 26, "Yummy!"));
        items.add(new FrozenFood ( "Frozen Mozza Sticks", 4, 27, "Yummy!"));
    }

    void printitems() {
        for (int i = 0; i < items.size(); i++) {
            Item item = items.get(i);
            item.print();
        }
    }

    Item buyItem(Item i) {
        int index;

        System.out.println("What would you like to buy? Enter: ");
        Scanner sc = new Scanner(System.in);

        // Checks it input is valid ~ fix the error checking

        try {
            index = sc.nextInt();
            Item item = items.get(index);

            if (index > -1 && index < items.size()) {
                item.print();
                return item;
            }

            else {
                System.out.println("This is not a valid input. Please enter a number from 0-27");
                return buyItem(i);
            }
        } catch (Exception e) { //
            System.out.println("This is not a valid input. Please enter a number from 0-27");
            return buyItem(i);
        }

    }

}

// Also the error check doesnt work