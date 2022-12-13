/**Authors
 * Trey & Arturo
 */
import java.awt.Color;
import java.util.Arrays;
import java.util.Scanner;


/*
 * The main class witch is the starting point for the game and holds most of the game play logic
 * @exception ArrayIndexOutOfBoundsException if user inputs less than 4 characters
 */
public class Play
{
    public static void main(String[] args) throws InterruptedException
    {
    	Play play = new Play();
		play.printIntroText();
    	Player player;
        Integer[] currentGuess = new Integer[4];
    	Scanner input = new Scanner(System.in);
        
        System.out.println("Enter a name:");
        String playerName = input.next();
        player = new Player(playerName);
//        
    	enterToProceed();
    	GameFrame gameFrame = new GameFrame();
        Integer[] boardSolution = play.setSolution();
    	
    	for (int k=0; k < 7; k++) {
    		
    	   	for(int i=0 ; i < 4 ; i++) gameFrame.addColorButtonListener(k, i);
    	   	
        	while (gameFrame.getGuessCount() == k) {
        		Thread.sleep(500);
        	}

        	for(int i=0 ; i < 4 ; i++) {
        		currentGuess[i] = gameFrame.getButton(k, i).getButtonColor().hashCode();
        	}

    	   	gameFrame.getHintsArray()[gameFrame.getGuessCount()-1].setText(play.checkAnswer(currentGuess , boardSolution));
    	}
    	
    	if (gameFrame.getGuessCount() == 7) {
    		System.out.println("Sorry " + player.getName() + " but you are out of moves.");
    		System.out.println("GAME OVER");
    	}
    }
    
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
    
    public String checkAnswer(Integer[] guessArray, Integer[] boardSolution) 
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
                return "you win";
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
        System.out.println("Move on to the next row and repeat until you guess all the colors in their place correctly");
        Thread.sleep(2000);
    }
    
    public static void enterToProceed(){
    	   System.out.println("Press 'Enter' to load the game...");
    	   Scanner scanner = new Scanner(System.in);
    	   scanner.nextLine();
    	}
}
