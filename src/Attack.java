public interface Attack {

    public String toString();
    public int getAttackSpeed();
    public int getDamageMin();
    public int getDamageMax();

}

class Club implements Attack {
    private String name = "club";
    private String readOut = " slowly swings a " + this.name + " ";
    private int attackSpeed = 2;
    private int damageMin = 30;
    private int damageMax = 50;

    public String toString() {
        return readOut;
    }

    public int getAttackSpeed() {
        return this.attackSpeed;
    }

    public int getDamageMin() {
        return this.damageMin;
    }

    public int getDamageMax() {
        return this.damageMax;
    }
}

class RustyBlade implements Attack {
    private String name = "Rusty Blade";
    private String readOut = " slices his " + this.name + " ";
    private int attackSpeed = 3;
    private int damageMin = 30;
    private int damageMax = 50;

    public String toString() {
        return readOut;
    }

    public int getAttackSpeed() {
        return this.attackSpeed;
    }

    public int getDamageMin() {
        return this.damageMin;
    }

    public int getDamageMax() {
        return this.damageMax;
    }
}

class Kris implements Attack {
    private String name = "kris";
    private String readOut = " jabs his " + this.name + " ";
    private int attackSpeed = 5;
    private int damageMin = 15;
    private int damageMax = 30;

    public String toString() {
        return readOut;
    }

    public int getAttackSpeed() {
        return this.attackSpeed;
    }

    public int getDamageMin() {
        return this.damageMin;
    }

    public int getDamageMax() {
        return this.damageMax;
    }
}

class Sword implements Attack {
    private String name = "sword";
    private String readOut = " swings a mighty " + this.name + " ";
    private int attackSpeed = 4;
    private int damageMin = 35;
    private int damageMax = 60;

    public String toString() {
        return readOut;
    }

    public int getAttackSpeed() {
        return this.attackSpeed;
    }

    public int getDamageMin() {
        return this.damageMin;
    }

    public int getDamageMax() {
        return this.damageMax;
    }
}

class FireBallSpell implements Attack {
    private String name = "FireBall";
    private String readOut = " casts a spell of " + this.name + " ";
    private int attackSpeed = 5;
    private int damageMin = 25;
    private int damageMax = 50;

    public String toString() {
        return readOut;
    }

    public int getAttackSpeed() {
        return this.attackSpeed;
    }

    public int getDamageMin() {
        return this.damageMin;
    }

    public int getDamageMax() {
        return this.damageMax;
    }
}

class RegularAttack implements Attack {
    private String name = "attack";
    private String readOut = " attacked ";
    private int attackSpeed = 6;
    private int damageMin = 20;
    private int damageMax = 40;

    public String toString() {
        return readOut;
    }

    public int getAttackSpeed() {
        return this.attackSpeed;
    }

    public int getDamageMin() {
        return this.damageMin;
    }

    public int getDamageMax() {
        return this.damageMax;
    }
}

class Fang implements Attack {
    private String name = "fang";
    private String readOut = " bit with her " + this.name;
    private int attackSpeed = 8;
    private int damageMin = 15;
    private int damageMax = 30;

    public String toString() {
        return readOut;
    }

    public int getAttackSpeed() {
        return this.attackSpeed;
    }

    public int getDamageMin() {
        return this.damageMin;
    }

    public int getDamageMax() {
        return this.damageMax;
    }

}

class GolfClub implements Attack {
    private String name = "golf club";
    private String readOut = " swung his " + this.name;
    private int attackSpeed = 8;
    private int damageMin = 15;
    private int damageMax = 30;

    public String toString() {
        return readOut;
    }

    public int getAttackSpeed() {
        return this.attackSpeed;
    }

    public int getDamageMin() {
        return this.damageMin;
    }

    public int getDamageMax() {
        return this.damageMax;
    }

}