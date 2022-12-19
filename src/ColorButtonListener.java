import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/*
 * action listener to change button color
 */
public class ColorButtonListener implements ActionListener
{
	ColorButton colorButton;
	Color color;
	int click = 0;
	
	ColorButtonListener(ColorButton colorButton) {
		this.colorButton = colorButton;
	}
	
	//implement the actionPerformed method to change the color
	//variable to cycle through each of the colors when clicked
	public void actionPerformed(ActionEvent e) {
		
		click++; //increment the click
		if (click == 7) click = 0;	//reset click variable if at 7 clicks

		
		//switch to keep track of the color corresponding with clicks
		switch(click) {
			  case 1:
				color = Color.red;
			    break;
			  case 2:
				color = Color.green;
			    break;
			  case 3:
				color = Color.blue;
			    break;
			  case 4:
				color = Color.orange;
			    break;
			  case 5:
				color = Color.black;
			    break;
			  case 6:
				color = Color.pink;
			    break;
			}
		
		//change button color on click
		colorButton.setBackground(color);
		
		//may be needed for macs
//		colorButton.setOpaque(true);
	}

}
