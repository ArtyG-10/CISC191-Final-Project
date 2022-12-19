/**Authors
 * Trey & Arturo
 */
import java.awt.Color;
import java.util.Arrays;
import java.util.Scanner;


/*
 * The main class witch is the starting point for the game and holds most of the game play logic
 * @exception InterruptedException is thrown because the program needs to sleep while
 * 		the user makes their selection.
 */
public class Play
{
    public static void main(String[] args) throws InterruptedException
    {
    	Play play = new Play();
    	
        Integer[] boardSolution = play.setSolution();		//set a random board solution (stored in hash values)
        Integer[] currentGuess = new Integer[4];			//array to hold the players current guess

		play.printIntroText();								//print game rules
		
        //Get players name and start the game
    	Player player;
    	Scanner input = new Scanner(System.in);
        System.out.println("Enter a name:");
        String playerName = input.next();
        player = new Player(playerName);
        System.out.println("Okay "+player.getName()+" good luck!");
    	enterToProceed();
    	
    	GameFrame gameFrame = new GameFrame();  	//create the GUI
    	    
    	//this for loop cycles through 7 game turns
    	for (int k=0; k < 7; k++) {
    		
    		//add the capability to change button color only on current row
    	   	for(int i=0 ; i < 4 ; i++) 
    	   	{
    	   		gameFrame.addColorButtonListener(k, i);
    	   	}
    	   	
    	   	//this loop just waits the program until the user hits submit
        	while (gameFrame.getGuessCount() == k) 
        	{
        		Thread.sleep(500);
        	}

        	//after submit this loop sets the selected colors to the currentGuess variable
        	for(int i=0 ; i < 4 ; i++) {
        		currentGuess[i] = gameFrame.getButton(k, i).getButtonColor().hashCode();
        	}
        	
        	//check answer and display the hints to user
    	   	gameFrame.getHintsArray()[gameFrame.getGuessCount()-1].setText(play.checkAnswer(currentGuess , boardSolution, player));
    	}
    	
    	// end of game
    	if (gameFrame.getGuessCount() == 7) {
    		System.out.println("Sorry " + player.getName() + " but you are out of moves.");
    		System.out.println("GAME OVER");
    		System.out.println("The correct combination was: " + play.hashToColor(boardSolution));
    	}
    }
    
    /*
     * randomly sets the correct color combination represented in hashes
     */
    public Integer[] setSolution()
    {
        Integer[] boardSolution = new Integer[4];
        int[] possibleColors = {Color.blue.hashCode(), Color.red.hashCode(), Color.orange.hashCode(), Color.black.hashCode(), Color.green.hashCode(), Color.pink.hashCode()};

        for (int i = 0; i < 4; i++)
        {
            boardSolution[i] = possibleColors[(int)(Math.random() * possibleColors.length)];
        }
        return boardSolution;
    }
    
    /*
     * compares the user guess to board board solution to return a string which 
     * will be used for the players' hints
     */
    public String checkAnswer(Integer[] guessArray, Integer[] boardSolution, Player player) 
        {
            int correctColorCorrectPlace = 0;
            int correctColorWrongPlace = 0;
            int wrongColor = 0;
            
            for (int i=0;i<4;i++)
            {
                if (Arrays.asList(boardSolution).contains(guessArray[i]) )
                {
                    if ((int)guessArray[i] == (int)boardSolution[i]) 
                    {
                        correctColorCorrectPlace++;
                    }
                    else
                    {
                        correctColorWrongPlace++;
                    }
                }
                else
                {
                    wrongColor++;
                }
            }

            if (correctColorCorrectPlace == 4)
            {
                return ("Congratulations "+player.getName() +" you win!!");
            }
            else
            {
                return ("Correct color, correct place: " + correctColorCorrectPlace + "    Correct color, wrong place: " + 
            correctColorWrongPlace + "     Wrong color: " + wrongColor);
            }
        }

    //Announces the rules of the game
    public void printIntroText() throws InterruptedException
    {
        System.out.println("Welcome to Mastermind!");
        Thread.sleep(2000);
        System.out.println("The objective of the game is to guess the correct sequence of colors in 7 turns or less");
        Thread.sleep(2000);
        System.out.println("All of the possible colors are RED, GREEN, BLUE, BlACK, ORANGE, PINK");
        Thread.sleep(2000);
        System.out.println("Of the 6 colors, the sequence will only contain 4 colors, which can be repeated");
        Thread.sleep(2000);
        System.out.println("Start from the top four blocks.. clicking on each one until you get your desired color");
        Thread.sleep(2000);
        System.out.println("Press the submit button when colors are selected.");
        Thread.sleep(2000);
        System.out.println("The hint will display how many colors you got right and how many are also in the right square");
        Thread.sleep(2000);
        System.out.println("Be warned that to get a correct color, wrong place hint there just has to be one of that color in the sequence");
        Thread.sleep(2000);
        System.out.println("Move on to the next row and repeat until you guess all the colors in their place correctly");
        Thread.sleep(2000);
    }
    
    /*
     * simple way to prompt user to press a button to continue
     */
    public static void enterToProceed(){
    	   System.out.println("Press 'Enter' to load the game...");
    	   Scanner scanner = new Scanner(System.in);
    	   scanner.nextLine();
    	}
    
    /*
     * decode the hash numbers to the respective color names
     */
    public String hashToColor(Integer[] n) {
    	String colors = "";
    	for (int i=0;i<4;i++) {
    		switch(n[i]) {
  			  case -65536:
  				colors += "Red ";
  			    break;
  			  case -16711936:
  				colors += "Green ";
  			    break;
  			  case -16776961:
  				colors += "Blue ";
  			    break;
  			  case -14336:
  				colors += "Orange ";
  			    break;
  			  case -16777216:
  				colors += "Black ";
  			    break;
  			  case -20561:
  				colors += "Pink ";
  			    break;
  			}
    	}
    	return colors;
    }
}
