package gui;

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
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 * Implements Drag and Drop handling on a JLabel.
 * <p>Is a JLabel component with drag and drop listeners implemented</p> 
 * @author Cody
 */
public class DraggableIcon extends JLabel implements DragGestureListener, DragSourceListener{
	DragSource dSource;
	private String imgSource;
	
	public DraggableIcon(String ImageSource) throws IOException {
		imgSource = ImageSource;
		
		// Create Drag and Drop listener
		dSource = new DragSource();
		dSource.createDefaultDragGestureRecognizer(this, DnDConstants.ACTION_COPY, this);
		
		// Set image of JLabel
		this.setIcon(new ImageIcon(ImageIO.read(new File(imgSource))));
		
	}

	@Override
	public void dragGestureRecognized(DragGestureEvent dge) {
		Transferable txfr = new StringSelection(imgSource);
		dSource.startDrag(dge, DragSource.DefaultCopyDrop, txfr, this);
	}

	public void setImgSource(String srcImg) {
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
