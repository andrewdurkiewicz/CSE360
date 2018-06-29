// author Andrew
package gui;
import javax.swing.*;
import java.awt.*;

public class ButtonPanel extends JPanel {
	public createArrowPanel arrowPanel;
	
	public ButtonPanel()
	{
		arrowPanel = new createArrowPanel();
		setBackground(Color.blue);
		this.setLayout(new GridLayout(1, 2));
		this.add(arrowPanel);
		this.add(new editFontPanel());
		this.setBorder(BorderFactory.createLineBorder(Color.black));
		
	}

}
