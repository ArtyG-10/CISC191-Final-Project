import java.util.Arrays;

public class Board
{
    private String[] boardSolution = new String[4];		//This field holds the board answer which will be randomized
    public Player player;

    public String[] possibleColors = {"R", "O", "Y", "G", "B", "P"};
    
    //Randomizes the answer each time a new game begins
    public Board()
    {
        for (int i = 0; i < boardSolution.length; i++)
        {
            boardSolution[i] = possibleColors[(int)(Math.random() * possibleColors.length)];
        }
    }
    //Checks your guess and returns whether you got the correct color in the correct place or no
    public boolean checkAnswer(String[] guessArray) 
    {
        int correctColorCorrectPlace = 0;
        int correctColorWrongPlace = 0;
        int wrongColor = 0;
        
        for (String color : guessArray)
        {
            if (Arrays.asList(boardSolution).contains(color))
            {
                if (Arrays.asList(boardSolution).indexOf(color) == Arrays.asList(guessArray).indexOf(color))
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

        System.out.println("Correct color, correct place: " + correctColorCorrectPlace);
        System.out.println("Correct color, wrong place: " + correctColorWrongPlace);
        System.out.println("Wrong color: " + wrongColor);

        if (correctColorCorrectPlace == 4)
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    public String getBoardSolution()
    {
        return Arrays.toString(boardSolution);
    }
}