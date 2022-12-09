import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.*;

public class GameFrame extends JFrame
{
	private JPanel mainPanel;
	private JPanel colorsPanel;
	private JPanel buttonPanel;
	private JPanel answersPanel;
	ColorButton[][] colorArray = new ColorButton[7][4];
	JButton submitButton = new JButton("SUBMIT");
	JButton resetButton = new JButton("RESET");
	
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
		mainPanel.add(buttonPanel);
		mainPanel.add(answersPanel);
		setSize(500,500);
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
		    	ColorButtonListener listener = new ColorButtonListener(null, colorArray[i][k]);
				colorArray[i][k].addActionListener(listener);
				colorsPanel.add(colorArray[i][k]);				
			}
		}
		colorsPanel.setLayout(new GridLayout(7,4,2,2));
	}
	public void createAnswersPanel() {
		answersPanel = new JPanel();
		answersPanel.setBackground(Color.blue);
	}
	
	public void createButtonPanel() {
		buttonPanel = new JPanel();
		buttonPanel.setBackground(Color.pink);
		buttonPanel.add(submitButton);
		buttonPanel.add(resetButton);
	}
}
