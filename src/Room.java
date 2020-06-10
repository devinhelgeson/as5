import java.util.*;

public class Room {
    private int xAxis;
    private int yAxis;
    private String item;
    private String[] shell;
    // If its 0,5,10,15
    public Room() {
        new Room(xAxis, yAxis);

    }

    public Room(int xAxis, int yAxis) {
        this.xAxis = xAxis;
        this.yAxis = yAxis;
        getPillar();
        item = roomContains();
        shell = determineShell(xAxis, yAxis);
    }

    public String roomContains() {
        String item = "";
        if (didItHappen(10)) {
            item += "P";
        }
        if (didItHappen(10)) {
            item += "H";
        }
        if (didItHappen(10)) {
            item += "V";
        }
        return item;
    }

    private String getPillar() {

        return "";
    }

    private boolean didItHappen(int chance) {
        Random ran = new Random();
        int num = ran.nextInt(100);
        return (num <= chance);
    }

    public String[] determineShell(int xAxis, int yAxis) {

        return null;
    }

    public int healing() {
        return 0;
    }

    public int pit() {
        return 0;
    }

    //public door entrance() {
    //   return null;
    //}

    public void vision() {

    }

    @Override
    public String toString() {
       return "";
    }


}
