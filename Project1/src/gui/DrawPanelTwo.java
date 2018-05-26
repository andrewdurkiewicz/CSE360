package gui;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Graphics;
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
	public static Point nextPos;
	public static int state = 0;
	
	
	private ArrayList<DraggableIcon> IconRecord = new ArrayList<DraggableIcon>();
	private ArrayList<DrawArrow> ArrowRecord = new ArrayList<DrawArrow>();
	/**
	 * Create the panel.
	 */
	public DrawPanelTwo(){
		setBackground(Color.WHITE);
		new DropTarget(this, this); 
		
		addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(state==0) {
					currentPos = e.getPoint();
				}
				
				if(state==1) {
					nextPos = e.getPoint();
				}
				state++;
				if(state==2) {
					ArrowRecord.add(new DrawArrow(currentPos, nextPos));
					state=0;
					updatePanel();
				}
				
			}
		});
		
	}
	 
	
	public void updatePanel() {
		this.removeAll();
		for(DraggableIcon currico:IconRecord) {
			this.add(currico);
		}
		drawPanelLines();
		this.repaint();
	}
	public void drawPanelLines() {
		for(DrawArrow arr:ArrowRecord) {
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
