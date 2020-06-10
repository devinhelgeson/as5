public class Knight extends Hero
{

    protected Knight()
    {

        super("Knight", 115, 5, AttackFactory.LanceFactory(),  .2);


    }//end constructor


    public void honor(DungeonCharacter opponent)
    {
        if (Math.random() <= .4)
        {
            int blowPoints = (int)(Math.random() * 76) + 100;
            System.out.println(name + " used KNGHTS HONOR for " + blowPoints
                    + " damage!");
            opponent.subtractHitPoints(blowPoints);
        }//end blow succeeded
        else
        {
            System.out.println(name + " is not honorable enough.");
            System.out.println();
        }//blow failed

    }//end crushingBlow method

    public void battleChoices(DungeonCharacter opponent)
    {
        int choice;

        super.battleChoices(opponent);

        do
        {
            System.out.println("1. Attack Opponent");
            System.out.println("2. Use Knights honor");
            System.out.print("Choose an option: ");
            choice = Keyboard.readInt();

            switch (choice)
            {
                case 1: attack(opponent);
                    break;
                case 2: honor(opponent);
                    break;
                default:
                    System.out.println("invalid choice!");
            }//end switch

            numTurns--;
            if (numTurns > 0)
                System.out.println("Number of turns remaining is: " + numTurns);

        } while(numTurns > 0);

    }//end battleChoices method

}//end Hero class