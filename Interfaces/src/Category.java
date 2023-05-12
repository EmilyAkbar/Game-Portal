public class Category {

    String label;
    String color;
    String description; // after user is done and gets this category, will output description.
    int points = 0;

    Category(String c, String color, String description) {
        this.label = c;
        this.color = color; // color of the corresponding among us character
        this.description = description;
    }

}
