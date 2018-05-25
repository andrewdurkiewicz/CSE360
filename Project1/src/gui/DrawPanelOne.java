package gui;
import javax.swing.JPanel;
import java.awt.Color;



public class DrawPanelOne extends JPanel{
	public DrawPanelOne(){
		setBackground(Color.white);
		setLayout(null);
		DraggableIcon circle = new DraggableIcon("src/resources/Black_Circle.png", true);
		circle.setBounds(12,0,171, 105);
		this.add(circle);
		
		DraggableIcon triangle = new DraggableIcon("src/resources/100px-Simple_triangle.png", true);
		triangle.setBounds(183, 0, 171, 105);
		this.add(triangle);
		
		
	}

}
