// Author: Tyler
package gui;


import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Polygon;
import java.awt.Stroke;
import java.awt.geom.AffineTransform;

import javax.swing.JLabel;

public class DrawArrow extends JLabel{
	public Point pointA;
	public Point pointB;
	private Color c;
	private boolean plainLine, dashedLine1, dashedLine1Bold, dashedLine2, 
	   				dashedLine2Bold, solidArrow, solidArrowBold, solidArrow2, solidArrow2Bold,
	   				inherit, aggregate, associate;
	
	public DrawArrow(Point p1, Point p2, ButtonPanel line) {
		setPos(p1,p2);
		setOpaque(true);
		
		// declaring the variables at the times they are when instantiated (don't change afterwards)
		c = line.arrowPanel.c;
		plainLine = line.arrowPanel.plainLine;
		dashedLine1 = line.arrowPanel.dashedLine1;
		dashedLine1Bold = line.arrowPanel.dashedLine1Bold;
		dashedLine2 = line.arrowPanel.dashedLine2;
		dashedLine2Bold = line.arrowPanel.dashedLine2Bold;
		solidArrow = line.arrowPanel.solidArrow;
		solidArrowBold = line.arrowPanel.solidArrowBold;
		solidArrow2 = line.arrowPanel.solidArrow2;
		solidArrow2Bold = line.arrowPanel.solidArrow2Bold;
		inherit = line.arrowPanel.inherit;
		aggregate = line.arrowPanel.aggregate;
		associate = line.arrowPanel.associate;
	}
	
	public void paintComponent(Graphics g) {
        Graphics2D g2d = (Graphics2D) g.create();
        g2d.setColor(c);
        
        // create the polygon Arrow Head to be used for creating arrows
        Polygon arrowHead = new Polygon();  
        arrowHead.addPoint( 0,5);
        arrowHead.addPoint( -5, -5);
        arrowHead.addPoint( 5,-5);
        
        // create diamond head polygon to be used for aggregation
        Polygon diamondHead = new Polygon();
        diamondHead.addPoint( 0,5);
        diamondHead.addPoint( -5, -5);
        diamondHead.addPoint( 0,-10);
        diamondHead.addPoint( 5,-5);
        
        AffineTransform tx = new AffineTransform();
        
        // dashed line
        if(dashedLine1 || dashedLine2)
        {
        	Stroke dashed = new BasicStroke(1, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL, 0, new float[]{9}, 0);
            g2d.setStroke(dashed);
        }
        
        // bold dashed line
        if(dashedLine1Bold || dashedLine2Bold)
        {
        	Stroke dashed = new BasicStroke(3, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL, 0, new float[]{9}, 0);
            g2d.setStroke(dashed);
        }
        
        // bold solid line
        if(solidArrowBold || solidArrow2Bold)
        {
        	g2d.setStroke(new BasicStroke(3));
        }
        
        // draw the line
        g2d.drawLine(pointA.x+50, pointA.y+50, pointB.x+50, pointB.y+50);
        
        // reset stroke for arrow heads
        if(solidArrowBold || solidArrow2Bold || dashedLine1Bold || dashedLine2Bold)
        {
        	g2d.setStroke(new BasicStroke(3));
        }
        else
        {
        	g2d.setStroke(new BasicStroke(1));
        }
        
        // draw first arrow head
        if(dashedLine1 || dashedLine1Bold || solidArrow || solidArrowBold || inherit)
        {
        	tx.setToIdentity();
        	double angle = Math.atan2(pointB.y+50-pointA.y+50, pointB.x+50-pointA.x+50);
            tx.translate(pointB.x+50, pointB.y+50);
            tx.rotate((angle-Math.PI/2d));
            g2d.setTransform(tx);   
            g2d.drawPolygon(arrowHead);
        }
        
        // draw diamondhead for aggregation
        if(aggregate)
        {
        	tx.setToIdentity();
        	double angle = Math.atan2(pointB.y+50-pointA.y+50, pointB.x+50-pointA.x+50);
            tx.translate(pointB.x+50, pointB.y+50);
            tx.rotate((angle-Math.PI/2d));
            g2d.setTransform(tx);   
            g2d.drawPolygon(diamondHead);
        }
        
        // draw arrowhead for association (two lines
        if(associate)
        {
        	tx.setToIdentity();
        	double angle = Math.atan2(pointB.y+50-pointA.y+50, pointB.x+50-pointA.x+50);
            tx.translate(pointB.x+50, pointB.y+50);
            tx.rotate((angle-Math.PI/2d));
            g2d.setTransform(tx);   
            g2d.drawLine(0, 5, 5, -5);
            g2d.drawLine(0, 5, -5, -5);
        }
        
        // draw two arrow heads
        if(dashedLine2 || dashedLine2Bold || solidArrow2 || solidArrow2Bold)
        {
        	tx.setToIdentity();
        	double angle = Math.atan2(pointB.y+50-pointA.y+50, pointB.x+50-pointA.x+50);
            tx.translate(pointB.x+50, pointB.y+50);
            tx.rotate((angle-Math.PI/2d));
            g2d.setTransform(tx);   
            g2d.drawPolygon(arrowHead);
        	tx.setToIdentity();
        	angle = Math.atan2(pointB.y+50-pointA.y+50, pointB.x+50-pointA.x+50);
            tx.translate(pointA.x+50, pointA.y+50);
            tx.rotate((angle-Math.PI/2d));
            g2d.setTransform(tx);   
            g2d.drawPolygon(arrowHead);
        }
	}
	

	public void setPos(Point A, Point B) {
		pointA = A;
		pointB = B;
	}
}
