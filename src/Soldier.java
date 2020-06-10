public class Soldier extends Hero {

    protected Soldier() {

        super("Soldier", 100, 2, AttackFactory.GunFactory(), .3);


    }//end constructor


    public void meele(DungeonCharacter opponent) {
        if (Math.random() <= .4) {
            int blowPoints = (int) (Math.random() * 76) + 100;
            System.out.println(name + " MELLED for " + blowPoints
                    + " damage!");
            opponent.subtractHitPoints(blowPoints);
        }//end blow succeeded
        else {
            System.out.println(name + " failed to meele");
            System.out.println();
        }//blow failed

    }//end crushingBlow method

    public void battleChoices(DungeonCharacter opponent) {
        int choice;

        super.battleChoices(opponent);

        do {
            System.out.println("1. Attack Opponent");
            System.out.println("2. Meele Opponent");
            System.out.print("Choose an option: ");
            choice = Keyboard.readInt();

            switch (choice) {
                case 1:
                    attack(opponent);
                    break;
                case 2:
                    meele(opponent);
                    break;
                default:
                    System.out.println("invalid choice!");
            }//end switch

            numTurns--;
            if (numTurns > 0)
                System.out.println("Number of turns remaining is: " + numTurns);

        } while (numTurns > 0);

    }//end battleChoices method

}
