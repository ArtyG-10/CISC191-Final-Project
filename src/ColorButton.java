import javax.swing.JButton;
import java.awt.Color;

public class ColorButton extends JButton
{
	Color buttonColor;
	private int row;
	private int column;
	
	ColorButton(int row, int column){
		this.row = row;
		this.column = column;
	}
	
	public int getRow() {
		return row;
	}
	
	public int getColumn() {
		return column;
	}
	
	public Color getButtonColor() {
		return buttonColor;
	}
	
//	public void setBackground() {
//		
//	}
}
