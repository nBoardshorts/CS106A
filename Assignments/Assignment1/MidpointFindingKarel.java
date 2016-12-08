/*
 * File: MidpointFindingKarel.java
 * -------------------------------
 * When you finish writing it, the MidpointFindingKarel class should
 * leave a beeper on the corner closest to the center of 1st Street
 * (or either of the two central corners if 1st Street has an even
 * number of corners).  Karel can put down additional beepers as it
 * looks for the midpoint, but must pick them up again before it
 * stops.  The world may be of any size, but you are allowed to
 * assume that it is at least as tall as it is wide.
 */

import stanford.karel.*;

public class MidpointFindingKarel extends SuperKarel {

public void run()	{
	
	fillRow();
	while (beepersPresent())	{
		removeLastBeeperWest();
		removeLastBeeperEast();
	}
	placeMiddleBeeper();
	
	
}

	private void placeMiddleBeeper()	{
		putBeeper();
	}

/*Karel will move to the wall and pickBeeper or to the first intersection
 * that does not contain, then Karel will turn around and pick up the previous beeper.
 * Pre-Condition:None
 * Post-Condition: Karel will be facing east on the beeper west of the one Karel picked up.
 */

	private void removeLastBeeperEast()	{
		faceEast();
		if (beepersPresent())	{
			findLastBeeper();
		}
		pickBeeperIfBeeperPresent();
		faceWest();
		move();
		if (noBeepersPresent())	{
			faceEast();
			move();
		}
		faceEast();
	}
	
	private void faceEast()	{
		while (notFacingEast()) {
			turnLeft();
		}
	}
/*Karel will move to the wall and pickBeeper or to the first intersection that does not have
 * a beeper then Karel will turn around and pick beeper
 * Pre-Condition:None (the first step will be for Karel to face West)
 * Post-Condition:Karel will be facing West one intersection east
 * of the intersection Karel last executed pick beeper.
 */

	private void removeLastBeeperWest()	{
		faceWest();
		if (beepersPresent())	{
			findLastBeeper();
		}
		pickBeeperIfBeeperPresent();
		faceEast();
		move();
		if (noBeepersPresent())	{
			faceWest();
			move();
		}
		faceWest();
			
		}

//Karel will pickBeeper if there is one, otherwise Karel will not
 
	private void pickBeeperIfBeeperPresent()	{
		if (beepersPresent())	{
			pickBeeper();
		}
	}

/*If the beeper is against the wall, Karel will stop at the wall
 * If the beeper is not against the wall, Karel will move until
 * the first empty intersection, then Karel will turn around and
 * move to the previous intersection.
 * Pre-Condition:Karel needs to be facing the direction that Karel
 * needs to find the last beeper.
 * Post-Condition: Karel is facing the same direction as Karel Began.
 */

	private void findLastBeeper()	{
		while (frontIsClear() && beepersPresent())	{
			move();
		}
		if	(frontIsBlocked() && beepersPresent())	{
				turnAround();
			}	else	{
					if (frontIsClear() && noBeepersPresent())	{
							turnAround();
							move();
				}	else	{
					if (frontIsBlocked() && noBeepersPresent())	{
						turnAround();
						move();
					}
				}
			}
			turnAround();
		}

/*Karel will turn to face West from whatever direction Karel was previously.
 * Pre-Condition: None.
 * Post-Condition: Karel is facing West in the same intersection.
 */
	private void faceWest()	{
			while (notFacingWest()) {
				turnLeft();
			}
	}

/*Karel will fill the row with Beepers.
 * Pre-Condition: Next to and Facing Away From Any Wall
 * Post-Condition: Karel is facing the opposite wall 
 * and the row is full of Beepers
 */
	
	private void fillRow()	{	
		while (frontIsClear())	{
			putBeeper();
			move();
		}
		putBeeper();
	}
	
}
