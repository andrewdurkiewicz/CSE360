package gui;
import javax.swing.JPanel;
import java.awt.Color;



public class DrawPanelOne extends JPanel{
	public DrawPanelOne(){
		setBackground(Color.white);
		setLayout(null);
		DraggableIcon circle = new DraggableIcon("resources//Black_Circle.png", true);
		circle.setBounds(12,0,171, 105);
		this.add(circle);
		
		DraggableIcon triangle = new DraggableIcon("resources//100px-Simple_triangle.png", true);
		triangle.setBounds(183, 0, 171, 105);
		this.add(triangle);
		
		DraggableIcon rectangle = new DraggableIcon("resources//rectangle.png", true);
		rectangle.setBounds(354, 0, 171, 105);
		this.add(rectangle);
		
		DraggableIcon star = new DraggableIcon("resources//star.png", true);
		star.setBounds(525, 0, 171, 105);
		this.add(star);
	}

}
