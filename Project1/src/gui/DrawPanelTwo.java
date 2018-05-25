package gui;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;
import java.awt.dnd.DnDConstants;
import java.awt.dnd.DropTarget;
import java.awt.dnd.DropTargetDragEvent;
import java.awt.dnd.DropTargetDropEvent;
import java.awt.dnd.DropTargetEvent;
import java.awt.dnd.DropTargetListener;
import java.util.ArrayList;

import javax.swing.JPanel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

public class DrawPanelTwo extends JPanel implements DropTargetListener{
	private Point mousePos;
	public static Point currentPos;
	public static Point previousPos;
	public static boolean isNextPoint = false;
	
	private ArrayList<DraggableIcon> IconRecord = new ArrayList<DraggableIcon>();
	private ArrayList<DrawArrow> ArrowRecord = new ArrayList<DrawArrow>();
	/**
	 * Create the panel.
	 */
	
	public DrawPanelTwo(){
		setBackground(Color.WHITE);
		new DropTarget(this, this);      
	}
	
	public void updatePanel() {
		this.removeAll();
		for(DraggableIcon currico:IconRecord) {
			this.add(currico);
		}
		
		for(DrawArrow arr:ArrowRecord) {
			/**
			 * DRAW LINES ON JPANEL USING COORDINATES FROM AROWRECORD
			 */
		}
		
		this.repaint();
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
				temp.setBounds(mousePos.x-50, mousePos.y-50, 100, 100);
				
				temp.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						if (isNextPoint == true) {
							previousPos = currentPos;
							currentPos = e.getPoint();
							System.out.println("" + currentPos + "  " + previousPos);
							ArrowRecord.add(new DrawArrow(previousPos, currentPos));
							isNextPoint = false;
						}
						if(isNextPoint==false) {
							currentPos = e.getPoint();
							isNextPoint = true;
						} 
						updatePanel();
					}
				});
				
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
