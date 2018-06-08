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
	public ButtonPanel()
	{
		setBackground(Color.blue);
		this.setLayout(new GridLayout(2, 1));
		this.add(new createArrowPanel(), BorderLayout.NORTH);
		this.add(new createTextPanel(), BorderLayout.SOUTH);
		this.setBorder(BorderFactory.createLineBorder(Color.black));
	
	}

}
