import java.util.ArrayList;

public class User {
    private ArrayList<DungeonItem> inventory;
    private String name;
    private Hero character;

    public User(String name, Hero character) {
        this.name = name;
        this.character = character;
        this.inventory = new ArrayList<DungeonItem>();
    }

    public Hero getHero() {
        return character;
    }

    public int pillars() {
        int found = 0;
        for(DungeonItem x : inventory) {
            if((x instanceof AbstractionPillar) || (x instanceof EncapsulationPillar) || (x instanceof InheritancePillar) || (x instanceof PolymorphismPillar));  {
                found++;
            }
        }
        return found;
    }



}
