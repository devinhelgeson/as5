public class DungeonAdventure {

    // Gabe created the Room class with it's respective methods for creating a room object
    // which can contain Dungeon Items, Pillars, or be the entrance or exit depending on the probability method
    // made that is stored in the utility class. The DungeonItem interface was also created by Gabe as well as the
    // respective items. The JUnit files were created by Gabe as well as the introduction, howToPlay, and move methods
    // in DungeonAdventure. The UML was also created by Gabe.

    // Devin created the Hero and Monster Factories as well as the flyweight implementation for Attack. Additionally,
    // Devin also worked on the Dungeon method and created the fillDungeon, chooseEntrance, choose exit and the
    // placePillars method. Devin also created two new hero characters (Soldier&Knight( and two new villans
    // (Bat&Zombie) Devin also created the User class

    public static User player;
    public static Dungeon theDungeon;

     public static void main(String[] args)
    {
        introduction();
        howToPlay();
        player = new User(readName(), chooseHero());
        theDungeon = new Dungeon();

        // Need to move around in the dungeon and then only battle if a room contains a monster essentially.
        do{
            System.out.println();
            System.out.println();

            System.out.println("Hitpoints: " + player.getHero().hitPoints);
            System.out.println("Pillars Found: " + player.pillars());
            System.out.println(theDungeon);
            System.out.println("users coords " + theDungeon.getLocation().getxAxis() + ", " + theDungeon.getLocation().getyAxis());
            System.out.println("entrance coords " + theDungeon.getEntrance().getxAxis() + ", " + theDungeon.getEntrance().getyAxis());
            System.out.println(theDungeon.getCurrentRoom()); //change this depending on visibility
            move();





            } while (willContinue()); //isded?
        // Need to add method that checks if the Hero has all of the pillars

    }//end main method

    public static String readName()
    {
        System.out.print("Enter character name: ");
        return Keyboard.readString();
    }//end readName method

    private static boolean willContinue() {
         if(player.getHero().hitPoints <= 0) {
             System.out.println("You have died.");
             return false;
         }
        if(theDungeon.getLocation().equals(theDungeon.getExit())) {
            System.out.println("You are about to exit the Dungeon.");
            if(hasWon()) {
                System.out.println("Congradulations, you have won.");
                return false;
            } else {
                System.out.println("You have not collected all of the pillars. Are you sure you want to end the game? (y/n)");
                String answer = Keyboard.readString();
                if(answer.equals("y")) {
                    System.out.println("You have lost the game.");
                    return false;
                } else {
                    return true;
                }
            }
        }
        return true;
    }

    private static boolean hasWon() {
        return player.pillars() == 4;
    }

    public static void introduction() {
        System.out.println("Welcome, to The Dungeon.");
        System.out.println("You, young programmer, have been chosen for a very important mission.");
        System.out.println("In the dark and musty rooms of this dungeon lies four very important pillars.");
        System.out.println("These pillars are the very foundation for Objected Oriented Programming.");
        System.out.println("Without these pillar, programmers around the world will be lost forever.");
        System.out.println("It is your mission to find these pillars and escape the dungeon to save your fellow programmers from coding chaos.");
        System.out.println("But first, we have some pointers for your mission");
        System.out.println("...");
    }

    public static void howToPlay() {
        System.out.println("To move around the rooms, use the A, W, S ,D keys");
        System.out.println("To view your inventory press the E key");
        System.out.println("Now, we need to choose your hero.");
    }

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
    public static Monster generateMonster()
    {
        int choice;

        choice = (int)(Math.random() * 5) + 1;

        switch(choice)
        {
            case 1: return MonsterFactory.createOgre();

            case 2: return MonsterFactory.createGremlin();

            case 3: return MonsterFactory.createSkeleton();

            case 4: return MonsterFactory.createBat();

            case 5: return MonsterFactory.createZombie();

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

    private static void move() {
        System.out.println("What direction would you like to go?");
        System.out.println("Forward(w)");
        System.out.println("Left(a)");
        System.out.println("Right(d)");
        System.out.println("Down(s)");
        //ADD INVENTORY OPTION
        char choice = Keyboard.readChar();
        // Might need to add to the while loop if the direction they choose is out of bounds too.
        while((choice != 'w' )&& (choice != 'a') && (choice != 'd' )&& (choice != 's')) {
            System.out.println("Not a valid choice, try again.");
            System.out.println("What direction would you like to go?");
            System.out.println("Forward(w)");
            System.out.println("Left(a)");
            System.out.println("Right(d)");
            System.out.println("Down(s)");

            choice = Keyboard.readChar();
        }

        if(choice == 'E') {
            String str = "Inventory: ";
            for(DungeonItem x : player.getInventory()) {
                str += x.toString();
            }
        }

        try {
            if(choice == 'a') theDungeon.left();
            if(choice == 'd') theDungeon.right();
            if(choice == 'w') theDungeon.up();
            if(choice == 's') theDungeon.down();
        } catch(IllegalMoveException e) {
            System.out.println("You cannot move in this direction.");
        }

        //return choice;

    }

    public static void updateRoomStatus() {
        if(theDungeon.getLocation().getItems() == null) return;
        if(theDungeon.getLocation().containsMonster()) battle(player.getHero(), theDungeon.getLocation().getaMonster());
    }


}

