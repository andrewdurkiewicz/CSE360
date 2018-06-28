// author Andrew
package gui;
import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JTextArea;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.LayoutManager;

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
