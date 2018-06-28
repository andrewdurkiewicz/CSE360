// Author: Spencer

package gui;
import javax.swing.JPanel;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;



public class DrawPanelOne extends JPanel{
	public DrawPanelOne(){
		setBackground(Color.white);
		setLayout(new FlowLayout(FlowLayout.LEFT,50,18));
		
		Circle c = new Circle();
		Triangle t = new Triangle();
		Star s = new Star();
		Rectangle r = new Rectangle();
		
		this.add(c);
		this.add(t);
		this.add(s);
		this.add(r);

		
	
	}

}
