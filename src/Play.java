/**Authors
 * Trey & Arturo
 */
import java.util.Scanner;

/*
 * The main class witch is the starting point for the game and holds most of the game play logic
 * @exception ArrayIndexOutOfBoundsException if user inputs less than 4 characters
 */
public class Play
{
    final int MAX_GUESSES = 10;  //Change the max guesses to adjust difficulty
    static GameFrame gameFrame;
    

    public static void main(String[] args) throws InterruptedException
    {
//    	printIntroText();
//        Board board = new Board();
//        Player player;
//        Scanner input = new Scanner(System.in);
//        boolean winStatus = false;
        
        
//        System.out.println("Enter a name:");
//        String playerName = input.next();
//        player = new Player(playerName);
        
//    	enterToProceed();
    	
    	gameFrame = new GameFrame();
    	
    	while(gameFrame.getGuessCount() < 7) {
    	    gameTurn();
    	}
    }
    	
    public static void gameTurn() 
    {
    	for(int i=0 ; i < 4 ; i++) {
        	gameFrame.addColorButtonListener(6 - gameFrame.getGuessCount(), i);
    	}
    }
//        while (guessCount < MAX_GUESSES && winStatus == false)
//        {
//            boolean validGuessFlag = false;   //flag used to make sure input is formatted correctly
//            
//            System.out.println("\nGuess " + (guessCount + 1) + " of " + MAX_GUESSES);
//            System.out.println("Enter your guess:");
//            String guess = input.next().toUpperCase();   //capture users input and convert it to uppercase
//            
//            while (guess.length() != 4) 			//Checks for right amount of colors in input
//            {
//               	System.out.println("Please input a guess with FOUR colors in this format: RYBO");
//               	System.out.println("All of the possible colors are R, O, Y, G, B, P");
//                System.out.println("Enter your guess:");
//                guess = input.next().toUpperCase();
//            }
//            
//            String[] guessArray = guess.split("");	//Split the guess into an array to check for correct input and to compare with the board results array
//            
//            try
//            {
//	            if (
//	            		(guessArray[0].equals("R") || guessArray[0].equals("O") || guessArray[0].equals("Y") || guessArray[0].equals("G") || guessArray[0].equals("B") || guessArray[0].equals("P"))
//	            		&& (guessArray[1].equals("R") || guessArray[1].equals("O") || guessArray[1].equals("Y") || guessArray[1].equals("G") || guessArray[1].equals("B") || guessArray[1].equals("P"))
//	            		&& (guessArray[2].equals("R") || guessArray[2].equals("O") || guessArray[2].equals("Y") || guessArray[2].equals("G") || guessArray[2].equals("B") || guessArray[2].equals("P"))
//	            		&& (guessArray[3].equals("R") || guessArray[3].equals("O") || guessArray[3].equals("Y") || guessArray[3].equals("G") || guessArray[3].equals("B") || guessArray[3].equals("P"))
//	            	)
//	            	{
//	            		validGuessFlag = true;
//	            	}
//            }
//            catch (Exception e)				//This prevents the program from breaking if the user inputs less than 4 colors
//            {
//            	System.out.println("Input error - You must guess 4 colors");
//            }
//            
//            try
//            {
//            while (validGuessFlag == false) 
//            {
//            	System.out.println("Please input a guess in this format: RYBO");
//               	System.out.println("All of the possible colors are R, O, Y, G, B, P");
//                System.out.println("Enter your guess:");
//                guess = input.next().toUpperCase();
//                guessArray = guess.split(""); 
//            	if (
//            		(guessArray[0].equals("R") || guessArray[0].equals("O") || guessArray[0].equals("Y") || guessArray[0].equals("G") || guessArray[0].equals("B") || guessArray[0].equals("P"))
//            		&& (guessArray[1].equals("R") || guessArray[1].equals("O") || guessArray[1].equals("Y") || guessArray[1].equals("G") || guessArray[1].equals("B") || guessArray[1].equals("P"))
//            		&& (guessArray[2].equals("R") || guessArray[2].equals("O") || guessArray[2].equals("Y") || guessArray[2].equals("G") || guessArray[2].equals("B") || guessArray[2].equals("P"))
//            		&& (guessArray[3].equals("R") || guessArray[3].equals("O") || guessArray[3].equals("Y") || guessArray[3].equals("G") || guessArray[3].equals("B") || guessArray[3].equals("P"))
//            		)
//            	{
//            		validGuessFlag = true;
//            	}
//            }
//            }
//            catch (Exception e)						//This prevents the program from breaking if the user inputs less than 4 colors
//            {
//            	System.out.println("Input error - You must guess 4 colors");
//            }
//            
//            winStatus = board.checkAnswer(guessArray);
//            guessCount++;
//        }
//
//        input.close();
//        //States how many turns it took for you to guess the answer.
//        if (winStatus == true)
//        {
//            System.out.println("Congratulations, " + player.getName() + "! You won in " + (guessCount + 1) + " guesses!");
//        }
//        else
//        {
//            System.out.println("Sorry, " + player.getName() + ". You lost. The answer was " + board.getBoardSolution());
//        }
  
    
    //Announces the rules of the game
    public static void printIntroText() throws InterruptedException
    {
        System.out.println("Welcome to Mastermind!");
        Thread.sleep(1500);
        System.out.println("The objective of the game is to guess the correct sequence of colors in 10 turns or less");
        Thread.sleep(1500);
        System.out.println("All of the possible colors are RED, GREEN, BLUE, YELLOW, ORANGE, PINK");
        Thread.sleep(1500);
        System.out.println("Of the 6 colors, the sequence will only contain 4, which can be repeated");
        Thread.sleep(1500);
        System.out.println("Start from the bottom four.. clicking on each one until you get your desired color");
        Thread.sleep(1500);
        System.out.println("Press the submit button when colors are selected.");
        Thread.sleep(1500);
        System.out.println("The hint will be grey for correct colors wrong place. And Black for correct colors correct place.");
        Thread.sleep(1500);
        System.out.println("Move on to the next row and repeat until you guess all the colors in their place correctly");
        Thread.sleep(1500);
    }
    
    public static void enterToProceed(){
    	   System.out.println("Press 'Enter' to load the game...");
    	   Scanner scanner = new Scanner(System.in);
    	   scanner.nextLine();
    	}
}
