import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class GameFrame extends JFrame
{
    private int guessCount = 0;
	private JPanel mainPanel;
	private JPanel colorsPanel;
	private JPanel buttonPanel;
	private JPanel answersPanel;
	private ColorButtonListener buttonListener;
	private ColorButton[][] colorButtons3DArray = new ColorButton[7][4];
	private JButton submitButton = new JButton("SUBMIT");
	private JButton exitButton = new JButton("EXIT");
	private JTextArea[] hintsArray = new JTextArea[7];
	
	
	public GameFrame()
	{
		super("MASTERMIND");
		createMainPanel();
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
	
	public void createMainPanel() {
		mainPanel = new JPanel();
	}
	
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
		colorsPanel.setLayout(new GridLayout(7,4,2,2));
	}
	public void addColorButtonListener(int i, int k) {
		colorButtons3DArray[i][k].addActionListener(new ColorButtonListener(colorButtons3DArray[i][k]));
	}
	
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
	
	
	public void createButtonPanel() {
		buttonPanel = new JPanel();
		submitButton.setPreferredSize(new Dimension(100,50));
		exitButton.setPreferredSize(new Dimension(100,50));
		buttonPanel.add(submitButton);
		buttonPanel.add(exitButton);		
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
