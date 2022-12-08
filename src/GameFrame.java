import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.*;

public class GameFrame extends JFrame
{

	private JPanel mainPanel;
	ColorButton[][] colorArray = new ColorButton[7][4]; 
	
		
	public GameFrame() 
	{
		super("MASTERMIND");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(500,500);
		mainPanel = new JPanel();
		createColorsPanel();
		mainPanel.setLayout(new GridLayout(7,4));
		add(mainPanel);
		setVisible(true);
	}
	
	void createColorsPanel()
	{
		for (int i = 0 ; i < colorArray.length-1 ; i++ ) {
			for (int k = 0 ; k <colorArray[i].length-1 ; k++) {
				colorArray[i][k] = new ColorButton(i,k);
				colorArray[i][k].setBackground(Color.orange);
		    	ColorButtonListener listener = new ColorButtonListener(null, colorArray[i][k]);
				colorArray[i][k].addActionListener(listener);
				mainPanel.add(colorArray[i][k]);
			}
		}
	}
}
