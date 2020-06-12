import java.lang.reflect.Array;
import java.util.*;

public class Room {
    private int xAxis;
    private int yAxis;
    private Monster aMonster;
    public final int MIN_ADD = 5;
    public final int MAX_ADD = 15;
    private ArrayList<DungeonItem> items = new ArrayList<DungeonItem>();
    // If its 0,5,10,15
    public Room() {
        new Room(xAxis, yAxis);

    }

    public Room(int xAxis, int yAxis) {
        this.xAxis = xAxis;
        this.yAxis = yAxis;
        items = roomContains();
    }

    public Room(int x, int y, DungeonItem item) {
        this.xAxis = x;
        this.yAxis = y;
        this.items.add(item);
    }

    public ArrayList<DungeonItem> roomContains() {
        if (Probability(10)) {
            items.add(new HealPotion());
        }
        else if (Probability(10)) {
            items.add(new Pit());
        }
        else if (Probability(10)) {
            items.add(new VisionPotion());
        }
        else if (Probability(30)) {
            items.add(DungeonAdventure.generateMonster());
        }
        return items;
    }

    private static boolean Probability(int chance) {
        Random ran = new Random();
        int num = ran.nextInt(100);
        return (num <= chance);
    }


    @Override
    public String toString() {
       if(items.size() > 1) return "M";
       if(items.size() <1) return "E";
       return items.get(0).toString();
    }


}
