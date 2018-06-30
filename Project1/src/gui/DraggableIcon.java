// Author: Cody

package gui;

import java.awt.Point;
import java.awt.datatransfer.*;
import java.awt.dnd.*;
import java.io.*;
import javax.imageio.ImageIO;
import javax.swing.*;

/**

 * Implements Drag and Drop handling on a JLabel.
 * <p>Is a JLabel component with drag and drop listeners implemented</p> 
 * @author Cody
 */
public class DraggableIcon extends JLabel implements DragGestureListener, DragSourceListener{
	/**
	 * 
	 */
	DragSource dSource;
	public String iconClass;
	private String imgSource;
	public String persistantName;
	public Point dragPoint() {
		return this.getLocation();
	}
	public DraggableIcon(String ImageSource, boolean draggable, String s){
		imgSource = ImageSource;
		iconClass = s; //allows us to tell which type it is
		if(draggable) {
		// Create Drag and Drop listener
		dSource = new DragSource();
		dSource.createDefaultDragGestureRecognizer(this, DnDConstants.ACTION_MOVE, this);
		}
		try {
			this.setIcon(new ImageIcon(ImageIO.read(new File(imgSource))));

	        


		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
	}

	@Override
	public void dragGestureRecognized(DragGestureEvent dge) {
		System.out.println("here");
		Transferable txfr = new StringSelection(imgSource);
		dSource.startDrag(dge, DragSource.DefaultCopyDrop, txfr, this);


		
	}

	public void setImgSource(String srcImg, String name) {
		imgSource = srcImg;
	}
	
	

	

	@Override
	public void dragEnter(DragSourceDragEvent dsde) {
		// Do Nothing, required due to implemented class
		
	}

	@Override
	public void dragOver(DragSourceDragEvent dsde) {
		// Do Nothing, required due to implemented class
		
	}

	@Override
	public void dropActionChanged(DragSourceDragEvent dsde) {
		// Do Nothing, required due to implemented class
		
	}

	@Override
	public void dragExit(DragSourceEvent dse) {
		// Do Nothing, required due to implemented class
		
	}

	@Override
	public void dragDropEnd(DragSourceDropEvent dsde) {
		// Do Nothing, required due to implemented class

	}


}
