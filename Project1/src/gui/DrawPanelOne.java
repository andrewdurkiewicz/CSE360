// Author: Spencer
package gui;
import javax.swing.JPanel;
import javax.swing.plaf.IconUIResource;

import java.awt.Color;
import java.awt.FlowLayout;

public class DrawPanelOne extends JPanel{
	
	private static final long serialVersionUID = 1L;

	public DrawPanelOne()
	{
		this.setBackground(Color.white);
		setLayout(new FlowLayout(FlowLayout.CENTER,50,18));
		iconCircle c = new iconCircle();
		iconRectangle r = new iconRectangle();
		
		this.add(c); //add circle
		this.add(r); //add rectangle
	}
}
