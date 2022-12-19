import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

/*
 * GUI game board creation
 */
public class GameFrame extends JFrame
{
    private int guessCount = 0;
	private JPanel mainPanel;
	private JPanel colorsPanel;	//holds the color buttons
	private JPanel buttonPanel;  //holds submit and exit buttons
	private JPanel answersPanel;  //holds the text hints
	private ColorButtonListener buttonListener;
	private ColorButton[][] colorButtons3DArray = new ColorButton[7][4];
	private JButton submitButton = new JButton("SUBMIT");
	private JButton exitButton = new JButton("EXIT");
	private JTextArea[] hintsArray = new JTextArea[7];
	
	//constructor adds all the elements to the main panel
	public GameFrame()
	{
		super("MASTERMIND");
		mainPanel = new JPanel();
		createColorsPanel();
		createButtonPanel();
		createAnswersPanel();
		
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		add(mainPanel);
		mainPanel.add(colorsPanel);
		mainPanel.add(answersPanel);
		mainPanel.add(buttonPanel);
		
		setSize(450,500);
		toFront();
	}
	
	//This panel holds a 3D array of 
	public void createColorsPanel()
	{
		colorsPanel = new JPanel();
		for (int i = 0 ; i < colorButtons3DArray.length ; i++ ) {
			for (int k = 0 ; k <colorButtons3DArray[i].length ; k++) {
				colorButtons3DArray[i][k] = new ColorButton(i,k);
				colorButtons3DArray[i][k].setBackground(Color.LIGHT_GRAY);
				colorButtons3DArray[i][k].setPreferredSize(new Dimension(50,50));;
				colorsPanel.add(colorButtons3DArray[i][k]);				
			}
		}
		
		//buttons set in a grid of 7 rows, 4 columns, with a spacing of 2 
		colorsPanel.setLayout(new GridLayout(7,4,2,2)); 
	}
	
	//adds event listener to button to change colors when clicked
	public void addColorButtonListener(int i, int k) 
	{
		colorButtons3DArray[i][k].addActionListener(new ColorButtonListener(colorButtons3DArray[i][k]));
	}
	
	//this JPanel holds an array of text fields for the game hints
	public void createAnswersPanel() {
		answersPanel = new JPanel();
		answersPanel.setPreferredSize(new Dimension(180,350));
		answersPanel.setLayout(new GridLayout(7,1));
		for (int i=0;i<7;i++) {
			hintsArray[i] = new JTextArea();
			hintsArray[i].setLineWrap(true);
			hintsArray[i].setFont(new Font("Arial", Font.TRUETYPE_FONT, 12));
			answersPanel.add(hintsArray[i]);
		}
	}

	//panel to hold submit and exit buttons
	public void createButtonPanel() {
		buttonPanel = new JPanel();
		submitButton.setPreferredSize(new Dimension(100,50));
		exitButton.setPreferredSize(new Dimension(100,50));
		buttonPanel.add(submitButton);
		buttonPanel.add(exitButton);		
		
		//anonymous inner class for action listeners on the buttons
		submitButton.addActionListener(  new ActionListener() {
		    public void actionPerformed(ActionEvent e) {	
		    	if (guessCount < 7) {
		        guessCount++;
		    	}
		      }
		    }
		  );
		exitButton.addActionListener(  new ActionListener() {
		    public void actionPerformed(ActionEvent e) {	    					
		        System.exit(0);
		      }
		    }
		  );
	}
	
	//getters and setter below
	public ColorButton getButton(int row, int column) {
		return colorButtons3DArray[row][column];
	}
	
	public ColorButton[][] getColorButtons3DArray(){
		return colorButtons3DArray;
	}
	
	public void setButtonListener(ColorButtonListener buttonListener) {
		this.buttonListener = buttonListener;
	}
	public ColorButtonListener getButtonListener() {
		return buttonListener;
	}
	public int getGuessCount() {
		return guessCount;
	}	
	public JTextArea[] getHintsArray() {
		return hintsArray;
	}
}
