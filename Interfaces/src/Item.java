public class Item {
    String Category; 
    String Name; 
    int price; 
    int initialhealth; 
    int number; 
    String yummy; 

    Item(String Category, String Name, int price, int initialhealth, int number, String yummy){
        this.Category = Category; 
        this.Name = Name; 
        this.price = price; 
        this.initialhealth = initialhealth; 
        this.number = number; 
        this.yummy = yummy; 
    
    }

    void print() {
        System.out.print("Category: "); 
        System.out.print(this.Category);
        System.out.print(" Item: "); 
        System.out.print(this.Name);
        System.out.print(" Price: $" + this.price);
        System.out.print(" Number: "); 
        System.out.println(this.number); 
    }

    void healthAffect() {

    }

    void yummyNess() {

    }



}

class Yummy extends Item {
    Yummy(String Category, String Name, int price, int initialhealth, int number) {
        super(Category, Name, price, initialhealth, number, "Yummy!");
      
    }
    @Override
    void yummyNess() {
        System.out.println("Emily likes this!"); 
    }
}

class Meh extends Item {
    Meh(String Category, String Name, int price, int initialhealth, int number) {
        super(Category, Name, price, initialhealth, number, "Meh");
    }
    @Override
    void yummyNess() {
        System.out.println("Emily thinks this is ok..."); 
    }
}



class Dairy extends Item {

    Dairy(String Name, int price, int number, String yummy) {
        super("Dairy", Name, price, 40, number, yummy);
        //TODO Auto-generated constructor stub
    } 

    @Override
    
    void healthAffect() {
        System.out.println("Health boost!");
    }
    
}

class Meat extends Item {

    Meat(String Name, int price, int number, String yummy) {
        super("Meat", Name, price, 50, number, yummy);
        //TODO Auto-generated constructor stub
    } 
    
    @Override
    
    void healthAffect() {
        System.out.println("Health boost!");
    }
}

class Fruits extends Item {

    Fruits(String Name, int price, int number, String yummy) {
        super("Fruits", Name, price, 70, number, yummy);
        //TODO Auto-generated constructor stub
    } 

    @Override
    
    void healthAffect() {
        System.out.println("Health boost!");
    }
    
}

class Grains extends Item {

    Grains(String Name, int price, int number, String yummy) {
        super("Grains", Name, price, 30, number, yummy);
        //TODO Auto-generated constructor stub
    } 

    @Override
    
    void healthAffect() {
        System.out.println("Health boost!");
    }
    
}


class SugaryFood extends Item {

    SugaryFood(String Name, int price, int number, String yummy) {
        super("Sugary Foods", Name, price, -20, number, yummy);
        //TODO Auto-generated constructor stub
    }

    @Override
    
    void healthAffect() {
        System.out.println("This is bad for you!");
    }


}

class FrozenFood extends Item {

    FrozenFood(String Name, int price, int number, String yummy) {
        super("Frozen Foods", Name, price, -10, number, yummy);
        //TODO Auto-generated constructor stub
    } 

    @Override
    
    void healthAffect() {
        System.out.println("This is bad for you!");
    }
    
}

 




    

