import java.util.*;

public class Room {
    private int xAxis;
    private int yAxis;
    private Monster aMonster;
    public final int MIN_ADD = 5;
    public final int MAX_ADD = 15;
    private ArrayList<DungeonItem> items;
    // If its 0,5,10,15
    public Room() {
        new Room(xAxis, yAxis);

    }

    public Room(int xAxis, int yAxis) {
        this.xAxis = xAxis;
        this.yAxis = yAxis;
        items = roomContains();
    }

    public ArrayList<DungeonItem> roomContains() {
        items = new ArrayList<DungeonItem>();
        if (Probability(10)) {
            items.add(new HealPotion());
        }
        if (Probability(10)) {
            items.add(new Pit());
        }
        if (Probability(10)) {
            items.add(new VisionPotion());
        }
        //if (Probability(30)) {
       //     items.add(new Monster());
       // }
        return items;
    }

    private boolean Probability(int chance) {
        Random ran = new Random();
        int num = ran.nextInt(100);
        return (num <= chance);
    }


    @Override
    public String toString() {
       return "";
    }


}
