import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
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
	private ColorButton[][] colorArray = new ColorButton[7][4];
	private JButton submitButton = new JButton("SUBMIT");
	private JButton exitButton = new JButton("EXIT");
	
	
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
		
		setSize(300,500);
		toFront();
	}
	
	public void createMainPanel() {
		mainPanel = new JPanel();
	}
	
	public void createColorsPanel()
	{
		colorsPanel = new JPanel();
		for (int i = 0 ; i < colorArray.length ; i++ ) {
			for (int k = 0 ; k <colorArray[i].length ; k++) {
				colorArray[i][k] = new ColorButton(i,k);
				colorArray[i][k].setBackground(Color.LIGHT_GRAY);
				colorArray[i][k].setPreferredSize(new Dimension(50,50));;
				colorsPanel.add(colorArray[i][k]);				
			}
		}
		colorsPanel.setLayout(new GridLayout(7,4,2,2));
	}
	public void addColorButtonListener(int i, int k) {
		colorArray[i][k].addActionListener(new ColorButtonListener(colorArray[i][k]));
	}
	
	public void createAnswersPanel() {
		answersPanel = new JPanel();
		answersPanel.setBackground(Color.blue);
	}
	
	public void createButtonPanel() {
		buttonPanel = new JPanel();
		buttonPanel.setBackground(Color.pink);
		buttonPanel.add(submitButton);
		buttonPanel.add(exitButton);		
		submitButton.addActionListener(  new ActionListener() {
		    public void actionPerformed(ActionEvent e) {	    	
		        guessCount++;
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
		return colorArray[row][column];
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
	
	
}
