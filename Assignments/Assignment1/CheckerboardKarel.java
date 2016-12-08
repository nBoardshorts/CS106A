/*
 * File: CheckerboardKarel.java
 * ----------------------------
 * When you finish writing it, the CheckerboardKarel class should draw
 * a checkerboard using beepers, as described in Assignment 1.  You
 * should make sure that your program works for all of the sample
 * worlds supplied in the starter folder.
 */

import stanford.karel.*;

public class CheckerboardKarel extends SuperKarel {

	public void run()	{
		makeCheckerBoard();
}

/* Karel will leave any size board with a checkerboard design.
 * Precondition: Karel is standing on 1st Street and 1st Avenue
 * Postcondition: Karel is standing on the most Southeastern Intersection
 */
	private void makeCheckerBoard()	{
		fillColumnPatternStartsWithBeeper();
		returnToBottom();
		faceEast();
		while (frontIsClear())	{
			moveOneEast();
			fillColumnPatternStartsNoBeeper();
			returnToBottom();
			faceEast();
			while (frontIsClear()){
			moveOneEast();
			fillColumnPatternStartsWithBeeper();
			returnToBottom();
			}
			faceEast();
				}
		}


	private void fillColumnPatternStartsNoBeeper()	{
		faceNorth();
		if (frontIsClear())	{
			move();
			putBeeper();
		while (frontIsClear())	{
			move();
			if (frontIsClear())	{
				move();
				putBeeper();
			}
			
		}
		if (frontIsBlocked() && noBeepersPresent())	{
			turnAround();
			move();
			if (beepersPresent())	{
				faceSouth();
			}	else	{
				turnAround();
				move();
				putBeeper();
			}
		}
		
	}
	}
	
/*Karel will turn east and check to see if there is a wall; if there is not a wall
 * Karel will move one space East.
 * Precondition: None
 * Postcondition: Karel is one intersection east of Karel's original location; however
 * if there was a wall directly east of Karels location; Karel did not move.
 */
	
	private void moveOneEast()	{
		faceEast();
		if (frontIsClear())	{
		move();
		}
	}

/*Positions Karel to be facing East.
 * Precondition: None
 * Postcondition: Karel is facing East and standing in the same intersection.
 */
	
	private void faceEast()	{
		while (notFacingEast())	{
			turnLeft();
		}
	}
	
/*Karel will move to the Southern most intersection in the same column.
 * Precondition: Karel is standing in the desired column
 * Postcondition: Karel is on the Southernmost Intersection of the same column.	
 */
	
	private void returnToBottom()	{
		faceSouth();
		while (frontIsClear())	{
			move();
		}
	}
	
	
/*Karel will fill the current column with a patern of beepers where the
 * the Southern Most Intersection will always contain a beeper.
 * Precondition: Karel is on furthest South Intersection in the desired column
 * Postcondition: Karel is on the furthest South Intersection in the desired column
 */
	
	private void fillColumnPatternStartsWithBeeper()	{
		faceNorth();
		putBeeper();
		while (frontIsClear())	{
			move();
			if (frontIsClear())	{
				move();
			putBeeper();
			}
		}
			
		if (frontIsBlocked() && noBeepersPresent())	{
			turnAround();
			move();
			if (beepersPresent())	{
				faceSouth();
			}	else	{
				turnAround();
				move();
				putBeeper();
			}
		}
		
	}
	


/*Positions Karel to be facing South
 * Precondition: None
 * Postcondition: Karel is facing South in the same intersection.	
 */
	
	private void faceSouth()	{
		while (notFacingSouth())	{
			turnLeft();
		}
	}
	
/*Positions Karel to be facing North.
 * Precondition: None
 * Postcondition: Karel is facing North in the same intersection.	
 */
	
	private void faceNorth()	{
		while (notFacingNorth())	{
			turnLeft();
		}
	}

}
