public interface DungeonItem {

    public String toString();

}
// Change toString to just the letter.
//
class HealPotion implements DungeonItem {

    public String toString() {
        return "H";
    }
}

class Pit implements DungeonItem {

    public String toString() {
        return "P";
    }
 }

class VisionPotion implements DungeonItem {
    public String toString() {
        return "V";
    }

}

class EncapsulationPillar implements DungeonItem {
    private static EncapsulationPillar uniqueInstance;
    private EncapsulationPillar() {}
    public static EncapsulationPillar getInstance() {
        if (uniqueInstance == null) {
            uniqueInstance = new EncapsulationPillar();
        }
        return uniqueInstance;
    }

    public String toString () {
        return "1";
    }
}

class AbstractionPillar implements DungeonItem {
    private static AbstractionPillar uniqueInstance;
    private AbstractionPillar() {}
    public static AbstractionPillar getInstance() {
        if (uniqueInstance == null) {
            uniqueInstance = new AbstractionPillar();
        }
        return uniqueInstance;
    }

    public String toString () {
        return "2";
    }
}

class InheritancePillar implements DungeonItem {
    private static InheritancePillar uniqueInstance;
    private InheritancePillar() {}
    public static InheritancePillar getInstance() {
        if (uniqueInstance == null) {
            uniqueInstance = new InheritancePillar();
        }
        return uniqueInstance;
    }

    public String toString () {
        return "3";
    }
}

class PolymorphismPillar implements DungeonItem {
    private static PolymorphismPillar uniqueInstance;
    private PolymorphismPillar() {}
    public static PolymorphismPillar getInstance() {
        if (uniqueInstance == null) {
            uniqueInstance = new PolymorphismPillar();
        }
        return uniqueInstance;
    }

    public String toString () {
        return "4";
    }
}

class Entrance implements DungeonItem {
    private static Entrance uniqueInstance;
    public static Entrance getInstance() {
        if (uniqueInstance == null) {
            uniqueInstance = new Entrance();
        }
        return uniqueInstance;
    }

    public String toString () {
        return "I";
    }
}

class Exit implements DungeonItem {
    private static Exit uniqueInstance;
    private Exit() {}
    public static Exit getInstance() {
        if (uniqueInstance == null) {
            uniqueInstance = new Exit();
        }
        return uniqueInstance;
    }

    public String toString () {
        return "O";
    }
}

class EmptyRoom implements DungeonItem {
    public String toString() {
        return "E";
    }
}
