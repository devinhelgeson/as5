public interface DungeonItem {

    public String toString();

}

class HealPotion implements DungeonItem {
    private String name = "H";
    private String readOut = " drinks the healing potion.";
    public int MAX_ADD = 15;
    public int MIN_ADD = 5;
    public void usePotion() {
        int healAmount;

        healAmount = (int)(Math.random() * (MAX_ADD - MIN_ADD + 1)) + MIN_ADD;
        addHitPoints(healAmount);
        System.out.println(name + " added [" + healAmount + "] points.\n"
                + "Total hit points remaining are: "
                + hitPoints);
        System.out.println();
    }

    public String toString {
        String readOut1 = this.readOut;
        return readOut1;
    }
}

class Pit implements DungeonItem {
    private String name = "P";
    private String readOut = " fell into a pit";
    private int damageMin = 1;
    private int damageMax = 20;
    public void fallIntoPit () {
        int damage = (int)(Math.random() * (this.damageMin - this.damageMax + 1))
                + this.damageMin;
        super.subtractHitPoints(damage);
    }

    public String toString() {
        return readOut;
    }
 }

class VisionPotion implements DungeonItem {
    private String name = "V";
    private String readOut = " drinks the vision potion";
    public String toString() {
        return readOut;
    }

    public void displayVision() {

    }

}

class EncapsulationPillar implements DungeonItem {
    private String name = "1";
    private static EncapsulationPillar uniqueInstance;
    private EncapsulationPillar() {}
    public static EncapsulationPillar getInstance() {
        if (uniqueInstance == null) {
            uniqueInstance = new EncapsulationPillar();
        }
        return uniqueInstance;
    }

    public String toString () {
        return " found the encapsulation pillar!";
    }
}

class AbstractionPillar implements DungeonItem {
    private String name = "2";
    private static AbstractionPillar uniqueInstance;
    private AbstractionPillar() {}
    public static AbstractionPillar getInstance() {
        if (uniqueInstance == null) {
            uniqueInstance = new AbstractionPillar();
        }
        return uniqueInstance;
    }

    public String toString () {
        return " found the abstraction pillar!";
    }
}

class InheritancePillar implements DungeonItem {
    private String name = "3";
    private static InheritancePillar uniqueInstance;
    private InheritancePillar() {}
    public static InheritancePillar getInstance() {
        if (uniqueInstance == null) {
            uniqueInstance = new InheritancePillar();
        }
        return uniqueInstance;
    }

    public String toString () {
        return " found the inheritance pillar!";
    }
}

class PolymorphismPillar implements DungeonItem {
    private String name = "4";
    private static PolymorphismPillar uniqueInstance;
    private PolymorphismPillar() {}
    public static PolymorphismPillar getInstance() {
        if (uniqueInstance == null) {
            uniqueInstance = new PolymorphismPillar();
        }
        return uniqueInstance;
    }

    public String toString () {
        return " found the polymorphism pillar!";
    }
}

class Entrance implements DungeonItem {
    private String name = "I";
    private static Entrance uniqueInstance;
    private Entrance() {}
    public static Entrance getInstance() {
        if (uniqueInstance == null) {
            uniqueInstance = new Entrance();
        }
        return uniqueInstance;
    }

    public String toString () {
        return " found the entrance.";
    }
}

class Exit implements DungeonItem {
    private String name = "O";
    private static Exit uniqueInstance;
    private Exit() {}
    public static Exit getInstance() {
        if (uniqueInstance == null) {
            uniqueInstance = new Exit();
        }
        return uniqueInstance;
    }

    public String toString () {
        return " found the exit!";
    }
}

