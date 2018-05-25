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
	/**
	 * Create the panel.
	 */
	private ArrayList<DraggableIcon> IconRecord = new ArrayList<DraggableIcon>();
	   public DrawPanelTwo(){
	      setBackground(Color.WHITE);
	      new DropTarget(this, this);   
	      
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
		//GET TXFR DATA
		try {
			Transferable recvData = dtde.getTransferable();
			if(recvData.isDataFlavorSupported(DataFlavor.stringFlavor)) {
				dtde.acceptDrop(DnDConstants.ACTION_MOVE);
				imgpth = (String) recvData.getTransferData(DataFlavor.stringFlavor);
				dtde.getDropTargetContext().dropComplete(true);
				
//				ADD ICON TO PANE
				Point ms = MouseInfo.getPointerInfo().getLocation();
				DraggableIcon temp = new DraggableIcon(imgpth, false);
				temp.setBounds(mousePos.x-50, mousePos.y-50, 100, 100);
				this.add(temp);
				this.repaint();
				
			} else {
				dtde.rejectDrop();
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	  }
	

}
