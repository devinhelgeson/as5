import java.util.Random;

public class Utilities {

    public static boolean Probability(int chance) {
        Random ran = new Random();
        int num = ran.nextInt(100);
        return (num <= chance);
    }

    public static int randomInt(int min, int max) {
        //Generate random int value from 50 to 100
        int random_int = (int)(Math.random() * (max - min + 1) + min);
        return random_int;
    }

}
