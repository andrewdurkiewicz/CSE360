package gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;

import javax.swing.JLabel;

public class DrawArrow{
	private Point pointA;
	private Point pointB;
	
	public DrawArrow(Point p1, Point p2) {
		
		setPos(p1,p2);
		System.out.println("Created Arrow at" + p1 + " and " + p2);
	}
	

	public void setPos(Point A, Point B) {
		pointA = A;
		pointB = B;
	}
}
