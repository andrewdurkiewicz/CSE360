// Author: Cody

package gui;

import java.awt.Point;
import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.Transferable;
import java.awt.dnd.DnDConstants;
import java.awt.dnd.DragGestureEvent;
import java.awt.dnd.DragGestureListener;
import java.awt.dnd.DragSource;
import java.awt.dnd.DragSourceDragEvent;
import java.awt.dnd.DragSourceDropEvent;
import java.awt.dnd.DragSourceEvent;
import java.awt.dnd.DragSourceListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

import javafx.beans.InvalidationListener;
import javafx.beans.Observable;

/**

 * Implements Drag and Drop handling on a JLabel.
 * <p>Is a JLabel component with drag and drop listeners implemented</p> 
 * @author Cody
 */
public class DraggableIcon extends JLabel implements DragGestureListener, DragSourceListener{
	DragSource dSource;
	private static String iconType;
	private String imgSource;
	public Point dragPoint() {
		return this.getLocation();
	}
	static int iconCounter = -1; //helps us skip the initialization issues where it prints the 
	public DraggableIcon(String ImageSource, boolean draggable, String s){
		imgSource = ImageSource;
		iconType = s; //allows us to tell which type it is
		if(draggable) {
		// Create Drag and Drop listener
		dSource = new DragSource();
		dSource.createDefaultDragGestureRecognizer(this, DnDConstants.ACTION_MOVE, this);
		}
		System.out.println(iconType);
		// Set image of JLabel
		try {
			this.setIcon(new ImageIcon(ImageIO.read(new File(imgSource))));
			if(iconCounter > 0)
			{
				if(iconType == "circle")
				{
					System.out.println("hi");
			        editFontPanel.getTextArea().setText(editFontPanel.getTextArea().getText() + "\nPublic interface icon" + iconCounter + " {\n}");
				}
				else if(iconType == "rectangle")
				{
			        editFontPanel.getTextArea().setText(editFontPanel.getTextArea().getText() + "\n" + "Public icon" + iconCounter + " {\n}");
				}
			}
	        iconCounter++;


		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
	}

	@Override
	public void dragGestureRecognized(DragGestureEvent dge) {
		Transferable txfr = new StringSelection(imgSource);
		dSource.startDrag(dge, DragSource.DefaultCopyDrop, txfr, this);
	}

	public void setImgSource(String srcImg, String name) {
		imgSource = srcImg;
	}
	
	public static void setImgName(String name) {
		
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
