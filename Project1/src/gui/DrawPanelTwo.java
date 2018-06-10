// Author: Cody

package gui;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;
import java.awt.dnd.DnDConstants;
import java.awt.dnd.DropTarget;
import java.awt.dnd.DropTargetDragEvent;
import java.awt.dnd.DropTargetDropEvent;
import java.awt.dnd.DropTargetEvent;
import java.awt.dnd.DropTargetListener;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

@SuppressWarnings("serial")
public class DrawPanelTwo extends JPanel implements DropTargetListener{
	private Point mousePos;
	public static Point currentPos;
	public static Point nextPos;
	public static int state = 0;
	private Point prevPoint = new Point();
	private Point nextPoint = new Point();
	private MouseHandler mouseHandler = new MouseHandler();

	
	
	private ArrayList<DraggableIcon> IconRecord = new ArrayList<DraggableIcon>();
	private ArrayList<DrawArrow> ArrowRecord = new ArrayList<DrawArrow>();
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
        g.setColor(Color.black);
        //g.drawLine(prevPoint.x+50, prevPoint.y+50, nextPoint.x+50, nextPoint.y+50);

        Graphics2D g2d = (Graphics2D) g.create();
        
        if (false)
        {
        	g2d.setStroke(new BasicStroke(3, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL, 0, new float[]{9}, 0));
        }
        
        g2d.drawLine(prevPoint.x, prevPoint.y, nextPoint.x, nextPoint.y);
        g2d.dispose();
	}
	
    private class MouseHandler extends MouseAdapter 
	{
		boolean twoPoints = false;
		boolean lineDrawn = false;
		
		@Override
	    public void mousePressed(MouseEvent e)
	    {
			Object obj = e.getSource();

			if(obj.getClass().getSimpleName().equals("DraggableIcon"))
			{
				
				DraggableIcon thisIcon = (DraggableIcon)obj;
				System.out.print(thisIcon.dragPoint());
				if(twoPoints == false)
		        {
		      	   nextPoint = thisIcon.dragPoint();
		       	   twoPoints = true;
	            }
	            else
	            {
		       	   prevPoint = nextPoint;
		       	   nextPoint = thisIcon.dragPoint();
		       	   drawLineHelper(prevPoint, nextPoint);
		       	   lineDrawn = true;
		       	   ArrowRecord.add(new DrawArrow(prevPoint, nextPoint));
		       	   if(lineDrawn == true)
		       	   {
		       		   prevPoint = null;
		       		   nextPoint = null;
	        	   }
		       	   twoPoints = false;
		       	}
			}

	     }
		
    }
	
	public void updatePanel() {
		this.removeAll();
		for(DraggableIcon currico:IconRecord) {
			this.add(currico);
			
		}
		//drawPanelLines();
		this.repaint();
	}
	public void drawPanelLines() {
		for(DrawArrow arr:ArrowRecord) {
			arr.setBounds(0,0, 700,650);
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
		//GET TXFR DATA AND ADD NEW COMPONENT TO PANEL
		try {
			
			Transferable recvData = dtde.getTransferable();
			if(recvData.isDataFlavorSupported(DataFlavor.stringFlavor)) {
				dtde.acceptDrop(DnDConstants.ACTION_MOVE);
				imgpth = (String) recvData.getTransferData(DataFlavor.stringFlavor);
				dtde.getDropTargetContext().dropComplete(true);
				
//				ADD PROPERTIES
				DraggableIcon temp = new DraggableIcon(imgpth, false);
				temp.setBounds(mousePos.x - 50, mousePos.y - 50, 100, 100);
				temp.addMouseListener(mouseHandler);
//				ADD to Handler.
				IconRecord.add(temp);
				
				updatePanel();
				
			} else {
				dtde.rejectDrop();
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	  }
	

}
