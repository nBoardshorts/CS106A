/*
 * File: StoneMasonKarel.java
 * --------------------------
 * The StoneMasonKarel subclass as it appears here does nothing.
 * When you finish writing it, it should solve the "repair the quad"
 * problem from Assignment 1.  In addition to editing the program,
 * you should be sure to edit this comment so that it no longer
 * indicates that the program does nothing.
 */

import stanford.karel.*;

public class StoneMasonKarel extends SuperKarel {
	
	public void run()	{
		turnNorth();
		rebuildEmptyPartsOfColumn();
		turnAroundMoveToWall();
		turnEast();
		while (frontIsClear())	{
			moveFourToNextColumn();
			turnNorth();
			rebuildEmptyPartsOfColumn();
			turnAroundMoveToWall();
			turnEast();
		}
	}
	
/* This checks to see if there is a wall ahead, and if there isn't
* a wall ahead it runs method "fillEmptyBeeperInstersection" for the intersection
* Karel is currently standing on. Then Karel moves forward to the next intersection
* and then calls on method "fillEmptyBeeperIntersection" to place a beeper only if
* there is not a beeper on the current intersection.
*/

	private void rebuildEmptyPartsOfColumn()	{
		fillEmptyBeeperIntersection();
		while (frontIsClear()) {
			move();
			fillEmptyBeeperIntersection();
			}	
								
		}

/*This will make Karel turn around and move until there is a wall in front of Karel*/

	private void turnAroundMoveToWall()	{
		turnAround();
			while (frontIsClear()) {
				move();
			}
	}

/* Karel will check if Karel is facing North, if Karel is not facing North, Karel will turn Left until
 * Karel is facing North.
 */
	
	private void turnNorth() {
		while (notFacingNorth())	{
			turnLeft();
		}
	}
	
	/* Karel will check if Karel is facing East, if Karel is not facing east, Karel will turn Left*/	
	
	private void turnEast()	{
		while (notFacingEast()) {
			turnLeft();
		}
	
	}
	
/* This checks the current intersection for a Beeper,
 * if there is not a Beeper then it will place a Beeper
 * at this intersection. If there is already a Beeper, 
 * it will not place a beeper.
 */
	
	private void fillEmptyBeeperIntersection ()	{
		if (noBeepersPresent ()) {
			putBeeper ();
			}

		}

/* This will instruct Karel to check for a wall. If there is a wall Karel will do nothing.
 * If there is not a wall, Karel will make sure that Karel is facing East and move 4 times. If
 * Karel is not facing East, Karel will call method (turnEast) and then move 4 times*/
	
	private void moveFourToNextColumn()	{
		if (frontIsClear()	&& facingEast()) {
				move();
			}
		
		if (frontIsClear()	&& facingEast()) {
				move();
			}
		
		if (frontIsClear()	&& facingEast()) {
			move();
			}
		
		if (frontIsClear()	&& facingEast()) {
			move();
			
			}
		}
	}



