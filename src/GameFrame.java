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
	ColorButton[][] colorArray = new ColorButton[7][4];
	JButton[] submitButton = new JButton[7];
	
	
	public GameFrame() 
	{
		super("MASTERMIND");
		createMainPanel();
		createColorsPanel();
		createButtonPanel();
		
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		add(mainPanel);
		mainPanel.add(colorsPanel);
		mainPanel.add(buttonPanel);
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
	
	public void createButtonPanel() {
		buttonPanel = new JPanel();
		buttonPanel.setPreferredSize(new Dimension(40,350));
		for (int i=0 ; i < 7 ; i++) {
			submitButton[i] = new JButton("Submit");
			submitButton[i].setPreferredSize(new Dimension(35,35));
			buttonPanel.add(submitButton[i]);
		}
//		buttonPanel.setLayout(new FlowLayout(FlowLayout.LEADING, 5, 16));
	}
}
