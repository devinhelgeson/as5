/**
 * Title: Dungeon.java
 *
 * Description: Driver file for Heroes and Monsters project
 *
 * Copyright:    Copyright (c) 2001
 * Company: Code Dogs Inc.
 * I.M. Knurdy
 *
 * History:
 *  11/4/2001: Wrote program
 *    --created DungeonCharacter class
 *    --created Hero class
 *    --created Monster class
 *    --had Hero battle Monster
 *    --fixed attack quirks (dead monster can no longer attack)
 *    --made Hero and Monster abstract
 *    --created Warrior
 *    --created Ogre
 *    --made Warrior and Ogre battle
 *    --added battleChoices to Hero
 *    --added special skill to Warrior
 *    --made Warrior and Ogre battle
 *    --created Sorceress
 *    --created Thief
 *    --created Skeleton
 *    --created Gremlin
 *    --added game play features to Dungeon.java (this file)
 *  11/27/2001: Finished documenting program
 * version 1.0
 */


/*
  This class is the driver file for the Heroes and Monsters project.  It will
  do the following:

  1.  Allow the user to choose a hero
  2.  Randomly select a monster
  3.  Allow the hero to battle the monster

  Once a battle concludes, the user has the option of repeating the above

*/
public class Dungeon
{


	private int DUNGEON_WIDTH = 5;
	private int DUNGEON_LENGTH = 5;
	private Room[][] grid = new Room[DUNGEON_LENGTH][DUNGEON_WIDTH];//mey need to be swipswapped
	private Room entrance;
	private Room exit;
	private int HeroX;
	private int HeroY;
	private Room location;


	public Dungeon() {
		chooseEntrance();
		chooseExit();
		placePillars();
		fillDungeon();
		this.location = entrance;
		this.HeroX = 4;
		this.HeroY = 2;

	}

	public Room getExit() {
		return exit;
	}

	public Room getLocation() {
		return location;
	}

	private void fillDungeon() {

		for(int i = 0; i < grid.length; i++) {

			for(int j = 0; j < grid[i].length; j++) {

				if(grid[i][j] == null) grid[i][j] = new Room(i, j);

			}

		}

	}

	private void chooseEntrance() {
		int y = Utilities.randomInt(0, 4);
		grid[y][0] = new Room(0, y, Entrance.getInstance());
		this.entrance = grid[y][0];
	}

	private void chooseExit() {
		int y = Utilities.randomInt(0, 4);
		grid[y][4] = new Room(4, y, Exit.getInstance());
		this.exit = grid[y][4];
	}

	private void placePillars() {
		int Ax, Ay;
		int Ex, Ey;
		int Ix, Iy;
		int Px, Py;

		do{
			Ax = Utilities.randomInt(0, 4);
			Ay = Utilities.randomInt(0, 4);
		} while(grid[Ax][Ay] != null);
		grid[Ax][Ay] = new Room(Ax, Ay, AbstractionPillar.getInstance());

		do{
			Ex = Utilities.randomInt(0, 4);
			Ey = Utilities.randomInt(0, 4);
		} while(grid[Ex][Ey] != null);
		grid[Ex][Ey] = new Room(Ex, Ey, EncapsulationPillar.getInstance());

		do{
			Ix = Utilities.randomInt(0, 4);
			Iy = Utilities.randomInt(0, 4);
		} while(grid[Ix][Iy] != null);
		grid[Ix][Iy] = new Room(Ix, Iy, InheritancePillar.getInstance());

		do{
			Px = Utilities.randomInt(0, 4);
			Py = Utilities.randomInt(0, 4);
		} while(grid[Px][Py] != null);
		grid[Px][Py] = new Room(Px, Py, PolymorphismPillar.getInstance());

	}

	public void left() throws IllegalMoveException {
		if(this.location.getxAxis() == 0) throw new IllegalMoveException();
		this.location = grid[this.location.getxAxis() - 1][this.location.getyAxis()];
		this.location.setxAxis(this.location.getxAxis() - 1);
	}

	public void right() throws IllegalMoveException {
		if(this.location.getxAxis() == DUNGEON_WIDTH - 1) throw new IllegalMoveException();
		this.location = grid[this.location.getxAxis() + 1][this.location.getyAxis()];
		this.location.setxAxis(this.location.getxAxis() + 1);
	}

	public void up() throws IllegalMoveException {
		if(this.location.getyAxis() == 0) throw new IllegalMoveException();
		this.location = grid[this.location.getxAxis()][this.location.getyAxis() - 1];
		this.location.setyAxis(this.location.getyAxis() - 1);
	}

	public void down() throws IllegalMoveException {
		if(this.location.getyAxis() == DUNGEON_LENGTH - 1) throw new IllegalMoveException();
		this.location = grid[this.location.getxAxis()][this.location.getyAxis() + 1];
		this.location.setyAxis(this.location.getyAxis() + 1);
	}

	public String toString() {
		String str = "";

		for(int x = 0; x < DUNGEON_WIDTH * 2 + 1; x++) str += "*";
		str += "\n";
		for(int i = 0; i < DUNGEON_LENGTH; i++) {

			str += "*" + grid[i][0].toString();
			for(int j = 1; j < DUNGEON_WIDTH; j++) {
				str += "|" + grid[i][j].toString();
			}
			str += "*";
			if (i < DUNGEON_LENGTH - 1) str += "\n*";
			for(int k = 0; (k < DUNGEON_WIDTH) && (i < DUNGEON_LENGTH - 1); k++) {
				str += "-*";
			}
			str += "\n";
		}
		for(int x = 0; x < DUNGEON_WIDTH * 2 + 1; x++) str += "*";

		return str;

	}

	public String getCurrentRoom(int HeroX, int HeroY) {
		String room = "";
		if (HeroY == 0) {
			room = "***\n";
		}
		else {
			room = "*-*\n";
		}
		if (HeroX > 0 || HeroX < 4) {
			room += "|" + grid[HeroX][HeroY].toString() + "|\n";
		}
		else if (HeroX == 0 ) {
			room += "*" + grid[HeroX][HeroY].toString() + "|\n";
		}
		else {
			room += "|" + grid[HeroX][HeroY].toString() + "*\n";
		}
		if (HeroY == 4) {
			room += "***";
		}
		else {
			room+= "*-*";
		}
		return room;
	}

	public int getHeroX() {
		return this.HeroX;
	}

	public int getHeroY() {
		return this.HeroY;
	}

	public String grid() {
		String str = "";

		for(int i = 0; i < grid.length; i++) {
			for(int j = 0; j < grid[i].length; j++) {
				str += grid[i][j].toString();
			}
			str += "\n";
		}
		return str;
	}

	public String getCurrentRoom() {
		return null;
	}

	public String getWithPotion() {return null;}


//
//private static Hero chooseHero()
//	{
//		int choice;
//		Hero theHero;
//
//		System.out.println("Choose a hero:\n" +
//					       "1. Warrior\n" +
//						   "2. Sorceress\n" +
//						   "3. Thief\n" +
//						   "4. Knight\n" +
//						   "5. Soldier");
//		choice = Keyboard.readInt();
//
//		switch(choice)
//		{
//			case 1: return HeroFactory.createWarrior();
//
//			case 2: return HeroFactory.createSourceress();
//
//			case 3: return HeroFactory.createTheif();
//
//			case 4: return HeroFactory.createKnight();
//
//			case 5: return HeroFactory.createSoldier();
//
//			default: System.out.println("invalid choice, returning Thief");
//				     return new Thief();
//		}//end switch
//	}//end chooseHero method
//
///*-------------------------------------------------------------------
//generateMonster randomly selects a Monster and returns it.  It utilizes
//a polymorphic reference (Monster) to accomplish this task.
//---------------------------------------------------------------------*/
//	private static Monster generateMonster()
//	{
//		int choice;
//
//		choice = (int)(Math.random() * 3) + 1;
//
//		switch(choice)
//		{
//			case 1: return MonsterFactory.createOgre();
//
//			case 2: return MonsterFactory.createGremlin();
//
//			case 3: return MonsterFactory.createSkeleton();
//
//			default: System.out.println("invalid choice, returning Skeleton");
//				     return new Skeleton();
//		}//end switch
//	}//end generateMonster method
//
///*-------------------------------------------------------------------
//playAgain allows gets choice from user to play another game.  It returns
//true if the user chooses to continue, false otherwise.
//---------------------------------------------------------------------*/
//	private static boolean playAgain()
//	{
//		char again;
//
//		System.out.println("Play again (y/n)?");
//		again = Keyboard.readChar();
//
//		return (again == 'Y' || again == 'y');
//	}//end playAgain method
//
//
///*-------------------------------------------------------------------
//battle is the actual combat portion of the game.  It requires a Hero
//and a Monster to be passed in.  Battle occurs in rounds.  The Hero
//goes first, then the Monster.  At the conclusion of each round, the
//user has the option of quitting.
//---------------------------------------------------------------------*/
//	private static void battle(Hero theHero, Monster theMonster)
//	{
//		char pause = 'p';
//		System.out.println(theHero.getName() + " battles " +
//							theMonster.getName() + " who has " + theMonster.getHitPoints() + " hitpoints.");
//		System.out.println("---------------------------------------------");
//
//		//do battle
//		while (theHero.isAlive() && theMonster.isAlive() && pause != 'q')
//		{
//		    //hero goes first
//			theHero.battleChoices(theMonster);
//
//			//monster's turn (provided it's still alive!)
//			if (theMonster.isAlive())
//			    theMonster.attack(theHero);
//
//			//let the player bail out if desired
//			System.out.print("\n-->q to quit, anything else to continue: ");
//			pause = Keyboard.readChar();
//
//		}//end battle loop
//
//		if (!theMonster.isAlive())
//		    System.out.println(theHero.getName() + " was victorious!");
//		else if (!theHero.isAlive())
//			System.out.println(theHero.getName() + " was defeated :-(");
//		else//both are alive so user quit the game
//			System.out.println("Quitters never win ;-)");
//
//	}//end battle method
//
//*/
}//end Dungeon class