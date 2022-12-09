import javax.swing.JButton;
import java.awt.Color;
import java.awt.Dimension;

public class ColorButton extends JButton
{
	Color buttonColor;
	private int row;
	private int column;
	
	ColorButton(int row, int column){
		this.row = row;
		this.column = column;
		setPreferredSize(new Dimension(20,20));
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
	
	@Override
	public void setBackground(Color bg) {
		super.setBackground(bg);
		buttonColor = bg;
//		System.out.println(buttonColor);
	}
}
