// Author: Cody

package gui;

import java.awt.*;
import java.awt.datatransfer.*;
import java.awt.dnd.*;
import javax.swing.JPanel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.AffineTransform;
import java.util.Observable;
import java.util.Observer;

public class DrawPanelTwo extends JPanel implements DropTargetListener{
	/**
	 * 
	 */
	boolean twoPoints;
	private String name;
	private static final long serialVersionUID = 1L;
	private Point mousePos;
	public static Point currentPos;
	public static Point nextPos;
	public static int state = 0;
	private Point prevPoint = new Point();
	private Point nextPoint = new Point();
	private MouseHandler mouseHandler = new MouseHandler();
	public ButtonPanel lineReference;
	/**
	 * Create the panel.
	 */
	
	public DrawPanelTwo(){

		setBackground(Color.WHITE);
		this.setLayout(null);
		new DropTarget(this, this); 
		this.addMouseListener(mouseHandler);
        this.addMouseMotionListener(mouseHandler);
		
	}
	 
public void drawLineHelper(Point prev, Point next){
        Graphics g = getGraphics();
        Graphics2D g2d = (Graphics2D) g.create();
        g2d.setColor(lineReference.arrowPanel.c);
        
        // initialize arrow head to use on the end of lines
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
        if(lineReference.arrowPanel.dashedLine1 || lineReference.arrowPanel.dashedLine2)
        {
        	Stroke dashed = new BasicStroke(1, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL, 0, new float[]{9}, 0);
            g2d.setStroke(dashed);
        }
        
        // bold dashed line
        if(lineReference.arrowPanel.dashedLine1Bold || lineReference.arrowPanel.dashedLine2Bold)
        {
        	Stroke dashed = new BasicStroke(3, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL, 0, new float[]{9}, 0);
            g2d.setStroke(dashed);
        }
        
        // bold solid line
        if(lineReference.arrowPanel.solidArrowBold || lineReference.arrowPanel.solidArrow2Bold)
        {
        	g2d.setStroke(new BasicStroke(3));
        }
        
        // draw the line
        g2d.drawLine(prevPoint.x+50, prevPoint.y+50, nextPoint.x+50, nextPoint.y+50);
        
        // reset stroke for arrow heads
        if(lineReference.arrowPanel.solidArrowBold || lineReference.arrowPanel.solidArrow2Bold || lineReference.arrowPanel.dashedLine1Bold || lineReference.arrowPanel.dashedLine2Bold)
        {
        	g2d.setStroke(new BasicStroke(3));
        }
        else
        {
        	g2d.setStroke(new BasicStroke(1));
        }
        
        // draw the first arrow head
        if(lineReference.arrowPanel.dashedLine1 || lineReference.arrowPanel.dashedLine1Bold || lineReference.arrowPanel.solidArrow || lineReference.arrowPanel.solidArrowBold || lineReference.arrowPanel.inherit)
        {
        	tx.setToIdentity();
        	double angle = Math.atan2(nextPoint.y+50-prevPoint.y+50, nextPoint.x+50-prevPoint.x+50);
            tx.translate(nextPoint.x+50, nextPoint.y+50);
            tx.rotate((angle-Math.PI/2d));
            g2d.setTransform(tx);   
            g2d.drawPolygon(arrowHead);
        }
        
        // draw aggregate diamond head
        if(lineReference.arrowPanel.aggregate)
        {
        	tx.setToIdentity();
        	double angle = Math.atan2(nextPoint.y+50-prevPoint.y+50, nextPoint.x+50-prevPoint.x+50);
            tx.translate(nextPoint.x+50, nextPoint.y+50);
            tx.rotate((angle-Math.PI/2d));
            g2d.setTransform(tx);
            g2d.drawPolygon(diamondHead);
        }
        
        // draw associate arrow head (two lines)
        if(lineReference.arrowPanel.associate)
        {
        	tx.setToIdentity();
        	double angle = Math.atan2(nextPoint.y+50-prevPoint.y+50, nextPoint.x+50-prevPoint.x+50);
            tx.translate(nextPoint.x+50, nextPoint.y+50);
            tx.rotate((angle-Math.PI/2d));
            g2d.setTransform(tx);
            g2d.drawLine(0, 5, 5, -5);
            g2d.drawLine(0, 5, -5, -5);
        }
        
        // draw the two arrow heads
        if(lineReference.arrowPanel.dashedLine2 || lineReference.arrowPanel.dashedLine2Bold || lineReference.arrowPanel.solidArrow2 || lineReference.arrowPanel.solidArrow2Bold)
        {
        	tx.setToIdentity();
        	double angle = Math.atan2(nextPoint.y+50-prevPoint.y+50, nextPoint.x+50-prevPoint.x+50);
            tx.translate(nextPoint.x+50, nextPoint.y+50);
            tx.rotate((angle-Math.PI/2d));
            g2d.setTransform(tx);   
            g2d.drawPolygon(arrowHead);
        	tx.setToIdentity();
        	angle = Math.atan2(nextPoint.y+50-prevPoint.y+50, nextPoint.x+50-prevPoint.x+50);
            tx.translate(prevPoint.x+50, prevPoint.y+50);
            tx.rotate((angle-Math.PI/2d));
            g2d.setTransform(tx);  
            g2d.drawPolygon(arrowHead);
        }

	}
	 DraggableIcon icon1;
	 DraggableIcon icon2;

    private class MouseHandler extends MouseAdapter 
	{
		public boolean twoPoints = false;
		public boolean lineDrawn = false;
		
		@Override
	    public void mousePressed(MouseEvent e)
	    {
			Object obj = e.getSource();

			if(e.isAltDown())
			{
				DataHandler.removeIcon((DraggableIcon) obj);
				updatePanel();
			}

			if(obj.getClass().getSimpleName().equals("DraggableIcon"))
			{
				
				DraggableIcon thisIcon = (DraggableIcon)obj;
				if(twoPoints == false)
		        {
					icon1 = thisIcon;
		      	   nextPoint = thisIcon.dragPoint();
		       	   twoPoints = true;
	            }
	            else
	            {
	            	icon2 = thisIcon;
		       	   prevPoint = nextPoint;
		       	   nextPoint = thisIcon.dragPoint();
		       	   drawLineHelper(prevPoint, nextPoint);
		       	   lineDrawn = true;
		       	   
		       	   DataHandler.addArrow(new DrawArrow(prevPoint, nextPoint, lineReference));
		       	   if(lineDrawn == true)
		       	   {
			       		Nodes n = new Nodes();
			    		nodeObserver o = new nodeObserver();
			    		n.addObserver(o);
			    		n.addSingle(new Nodes(icon1,icon2,new DrawArrow(prevPoint, nextPoint, lineReference)));
		       		   prevPoint = null;
		       		   nextPoint = null;
	        	   }
		       	   twoPoints = false;

		       	}
			}
			else {twoPoints = false; lineDrawn = false;}
	     }
		
    }
	
    /**
     * Removes and re-adds all DraggableIcons to panel
     * Calls: DrawPanelLines
     */
	public void updatePanel() {
		this.removeAll();
		drawPanelLines();
		for(DraggableIcon currico:DataHandler.getIconRecord()) {
			this.add(currico);	
		}
		
		this.repaint();
	}
	/**
	 * Call this to add a listener to all Icons in the IconRecord
	 * (SHOULD NEVER BE CALLED EXCEPT FOR AFTER LOADING A SAVE FILE)
	 */
	public void addLoadedListeners() {
		for(DraggableIcon currico:DataHandler.getIconRecord()) {
			currico.addMouseListener(mouseHandler);
		}
		
	}
	
	/**
	 * Re-Adds all lines to pane after forced pane redraw, 
	 */
	//TODO: [BUG][SEVERE](cody) Lines are initially drawn to DrawPanelTwo as graphics, after panel update, are readded as objects
	public void drawPanelLines() {
		for(DrawArrow arr:DataHandler.getArrowRecord()) {
			arr.setBounds(0,0, 870, 485);
			this.add(arr);
		}
	}
	
	@Override
	public void dragEnter(DropTargetDragEvent dtde) {
		// TODO Auto-generated method stub
	}
	
	@Override
	public void dragOver(DropTargetDragEvent dtde) {
		mousePos = dtde.getLocation();
		
	}

	@Override
	public void dropActionChanged(DropTargetDragEvent dtde) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void dragExit(DropTargetEvent dte) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void drop(DropTargetDropEvent dtde) {
		String imgpth;
		DraggableIcon temp;
		twoPoints = false;

		//GET TXFR DATA AND ADD NEW COMPONENT TO PANEL
		try {
			Transferable recvData = dtde.getTransferable();
			if(recvData.isDataFlavorSupported(DataFlavor.stringFlavor)) {
				dtde.acceptDrop(DnDConstants.ACTION_MOVE);
				imgpth = (String) recvData.getTransferData(DataFlavor.stringFlavor);
				dtde.getDropTargetContext().dropComplete(true);

				if((imgpth).contains("Black_Circle")){name = "circle";} //sets the name variable for the Draggable icon 
				else if((imgpth).contains("rectangle")){name = "rectangle";}//sets the name variable for the Draggable icon 
					temp = new DraggableIcon(imgpth, false, name);
					Nodes n = new Nodes();
					nodeObserver o = new nodeObserver();
					n.addObserver(o);
					n.addSingle(new Nodes(temp));
//					ADD PROPERTIES
					temp.setBounds(mousePos.x-50, mousePos.y-50, 100, 100);
					temp.addMouseListener(mouseHandler);
					
//					ADD to Handler.
					DataHandler.addIcon(temp);

				
//				ADD PROPERTIES

				//observable.addObserver(observer);
				updatePanel();
		
			} else {
				dtde.rejectDrop();
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	  }





	

}
