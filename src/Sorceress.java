/**
 * Title:
 * Description:
 * Copyright:    Copyright (c) 2001
 * Company:
 * @author
 * @version 1.0
 */



public class Sorceress extends Hero
{
	public final int MIN_ADD = 25;
	public final int MAX_ADD = 50;

//-----------------------------------------------------------------
    protected Sorceress()
	{
		super("Sorceress", 75, 5, new FireBallSpell(),  .3);


    }//end constructor

//-----------------------------------------------------------------
	public void increaseHitPoints()
    {
	    int healAmount;

		healAmount = (int)(Math.random() * (MAX_ADD - MIN_ADD + 1)) + MIN_ADD;
		addHitPoints(healAmount);
		System.out.println(name + " added [" + healAmount + "] points.\n"
							+ "Total hit points remaining are: "
							+ hitPoints);
		 System.out.println();

    }//end increaseHitPoints method

//-----------------------------------------------------------------


//-----------------------------------------------------------------
    public void battleChoices(DungeonCharacter opponent)
	{
		super.battleChoices(opponent);
		int choice;

		do
		{
		    System.out.println("1. Attack Opponent");
		    System.out.println("2. Increase Hit Points");
		    System.out.print("Choose an option: ");
		    choice = Keyboard.readInt();

		    switch (choice)
		    {
			    case 1: attack(opponent);
			        break;
			    case 2: increaseHitPoints();
			        break;
			    default:
			        System.out.println("invalid choice!");
		    }//end switch

			numTurns--;
		    if (numTurns > 0)
			    System.out.println("Number of turns remaining is: " + numTurns);

		} while(numTurns > 0 && hitPoints > 0 && opponent.getHitPoints() > 0);

    }//end overridden method

}//end class