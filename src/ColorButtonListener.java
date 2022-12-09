import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ColorButtonListener implements ActionListener
{
//	GameFrame gameFrame;
	ColorButton colorButton;
	Color color;
	int click = 0;
	
	ColorButtonListener(ColorButton colorButton) {
		this.colorButton = colorButton;
//		this.gameFrame = gameFrame;
	}
	 
	public void actionPerformed(ActionEvent e) {
		if (click == 6) click = 0;
		click++;
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
				color = Color.yellow;
			    break;
			  case 6:
				color = Color.pink;
			    break;
			}
		
		colorButton.setBackground(color);
	}

}
