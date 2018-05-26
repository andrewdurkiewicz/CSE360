package gui;


import java.awt.Graphics;
import java.awt.Point;

import javax.swing.JLabel;

public class DrawArrow extends JLabel{
	public Point pointA;
	public Point pointB;
	
	public DrawArrow(Point p1, Point p2) {
		setPos(p1,p2);
		System.out.println("Create Arrow at" + p1 + " and " + p2);
		setOpaque(true);
		
	}
	
	public void paintComponent(Graphics g) {
		g.drawLine(pointA.x, pointA.y, pointB.x,pointB.y);
	}
	

	public void setPos(Point A, Point B) {
		pointA = A;
		pointB = B;
	}
}