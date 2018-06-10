// Author: Tyler
package gui;


import java.awt.Graphics;
import java.awt.Point;
import java.awt.BasicStroke;
import java.awt.Graphics2D;

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
		//g.drawLine(pointA.x, pointA.y, pointB.x,pointB.y);
		
		Graphics2D g2d = (Graphics2D) g.create();

        //set the stroke of the copy, not the original 
        g2d.setStroke(new BasicStroke(3, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL, 0, new float[]{9}, 0));
        g2d.drawLine(pointA.x, pointA.y, pointB.x,pointB.y);

        //gets rid of the copy
        g2d.dispose();
	}
	

	public void setPos(Point A, Point B) {
		pointA = A;
		pointB = B;
	}
	
}
