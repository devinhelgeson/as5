import java.util.ArrayList;

public class User {
    private ArrayList<DungeonItem> inventory;
    private String name;
    private Hero character;

    public User(String name, Hero character) {
        this.name = name;
        this.character = character;
    }



}
