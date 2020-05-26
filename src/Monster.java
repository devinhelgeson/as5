/**
 * Title:
 * Description:
 * Copyright:    Copyright (c) 2001
 * Company:
 * @author
 * @version 1.0
 */


public abstract class Monster extends DungeonCharacter
{
	protected double chanceToHeal;
	protected int minHeal, maxHeal;

//-----------------------------------------------------------------
  public Monster(String name, int hitPoints, double chanceToHit, Attack attack, double chanceToHeal, int minHeal, int maxHeal)
  {
	super(name, hitPoints, chanceToHit, attack);
	this.chanceToHeal = chanceToHeal;
	this.maxHeal = maxHeal;
	this.minHeal = minHeal;

  }//end monster construcotr

//-----------------------------------------------------------------
  public void heal()
  {
	boolean canHeal;
	int healAmount;

	canHeal = (Math.random() <= chanceToHeal) && (hitPoints > 0);

	if (canHeal)
	{
		healAmount = (int)(Math.random() * (maxHeal - minHeal + 1)) + minHeal;
		addHitPoints(healAmount);
		System.out.println(name + " healed itself for " + healAmount + " points.\n"
							+ "Total hit points remaining are: " + hitPoints);
		System.out.println();
	}//end can heal


  }//end heal method

//-----------------------------------------------------------------
 public void subtractHitPoints(int hitPoints)
 {
		super.subtractHitPoints(hitPoints);
		heal();

 }//end method


}//end Monster class