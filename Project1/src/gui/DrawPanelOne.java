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

		DraggableIcon circle = new DraggableIcon("resources//Black_Circle.png", true);
		//circle.setBounds(12,0,171, 105);*This does nothing no need for it
		this.add(circle);
		
		DraggableIcon triangle = new DraggableIcon("resources//100px-Simple_triangle.png", true);
		//triangle.setBounds(183, 0, 171, 105);*This does nothing no need for it
		this.add(triangle);
		
		DraggableIcon rectangle = new DraggableIcon("resources//rectangle.png", true);
		//rectangle.setBounds(354, 0, 171, 105); *This does nothing no need for it
		this.add(rectangle);
		
		DraggableIcon star = new DraggableIcon("resources//star.png", true);
		//star.setBounds(525, 0, 171, 105);*This does nothing no need for it
		this.add(star);
		
	
	}

}
