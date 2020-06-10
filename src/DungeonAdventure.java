public class DungeonAdventure {

    public static void main(String[] args)
    {

        Hero theHero;
        Monster theMonster;

        do
        {
            theHero = chooseHero();
            theMonster = generateMonster();
            battle(theHero, theMonster);

        } while (playAgain());

    }//end main method

    /*-------------------------------------------------------------------
    chooseHero allows the user to select a hero, creates that hero, and
    returns it.  It utilizes a polymorphic reference (Hero) to accomplish
    this task
    ---------------------------------------------------------------------*/
    private static Hero chooseHero()
    {
        int choice;
        Hero theHero;

        System.out.println("Choose a hero:\n" +
                "1. Warrior\n" +
                "2. Sorceress\n" +
                "3. Thief\n" +
                "4. Knight\n" +
                "5. Soldier");
        choice = Keyboard.readInt();

        switch(choice)
        {
            case 1: return HeroFactory.createWarrior();

            case 2: return HeroFactory.createSourceress();

            case 3: return HeroFactory.createTheif();

            case 4: return HeroFactory.createKnight();

            case 5: return HeroFactory.createSoldier();

            default: System.out.println("invalid choice, returning Thief");
                return new Thief();
        }//end switch
    }//end chooseHero method

    /*-------------------------------------------------------------------
    generateMonster randomly selects a Monster and returns it.  It utilizes
    a polymorphic reference (Monster) to accomplish this task.
    ---------------------------------------------------------------------*/
    private static Monster generateMonster()
    {
        int choice;

        choice = (int)(Math.random() * 3) + 1;

        switch(choice)
        {
            case 1: return MonsterFactory.createOgre();

            case 2: return MonsterFactory.createGremlin();

            case 3: return MonsterFactory.createSkeleton();

            default: System.out.println("invalid choice, returning Skeleton");
                return new Skeleton();
        }//end switch
    }//end generateMonster method

    /*-------------------------------------------------------------------
    playAgain allows gets choice from user to play another game.  It returns
    true if the user chooses to continue, false otherwise.
    ---------------------------------------------------------------------*/
    private static boolean playAgain()
    {
        char again;

        System.out.println("Play again (y/n)?");
        again = Keyboard.readChar();

        return (again == 'Y' || again == 'y');
    }//end playAgain method


    /*-------------------------------------------------------------------
    battle is the actual combat portion of the game.  It requires a Hero
    and a Monster to be passed in.  Battle occurs in rounds.  The Hero
    goes first, then the Monster.  At the conclusion of each round, the
    user has the option of quitting.
    ---------------------------------------------------------------------*/
    private static void battle(Hero theHero, Monster theMonster)
    {
        char pause = 'p';
        System.out.println(theHero.getName() + " battles " +
                theMonster.getName() + " who has " + theMonster.getHitPoints() + " hitpoints.");
        System.out.println("---------------------------------------------");

        //do battle
        while (theHero.isAlive() && theMonster.isAlive() && pause != 'q')
        {
            //hero goes first
            theHero.battleChoices(theMonster);

            //monster's turn (provided it's still alive!)
            if (theMonster.isAlive())
                theMonster.attack(theHero);

            //let the player bail out if desired
            System.out.print("\n-->q to quit, anything else to continue: ");
            pause = Keyboard.readChar();

        }//end battle loop

        if (!theMonster.isAlive())
            System.out.println(theHero.getName() + " was victorious!");
        else if (!theHero.isAlive())
            System.out.println(theHero.getName() + " was defeated :-(");
        else//both are alive so user quit the game
            System.out.println("Quitters never win ;-)");

    }//end battle method


}

