package gui;
/**
 * Handles the data and I/O of the gui
 * such as saving and loading
 * @author Cody
 */
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileFilter;

public class DataHandler {
	/**
	 * Store user data
	 */
	private static ArrayList<DraggableIcon> IconRecord = new ArrayList<DraggableIcon>(); //Icons
	private static ArrayList<DrawArrow> ArrowRecord = new ArrayList<DrawArrow>(); //User Added Lines
	
	
	
	/**
	 * Opens a save dialog where the user can name and save their file.
	 * @param parent Parent Frame for reference to set dialog location (can be null)
	 */
	public static void save(JFrame parent) {
		//Generate Save Dialog
		JFileChooser sDia = new JFileChooser();
		sDia.setFileFilter(new drawingFileFilter());
		int diaRet = sDia.showSaveDialog(parent);
		
		//Process results if file chosen
		if(diaRet==JFileChooser.APPROVE_OPTION) {
			File selFile = sDia.getSelectedFile();
			try {
				//Append Extension if not present
				String fp = selFile.getPath();
				if(!fp.endsWith(".ud")) {
					selFile = new File(fp.concat(".ud"));
				}
				//Create streams and add icons to stream
				FileOutputStream fiStream = new FileOutputStream(selFile);
				ObjectOutputStream ooStream = new ObjectOutputStream(fiStream);
				//Create Root arraylist for export
				ArrayList<ArrayList> export = new ArrayList<ArrayList>();
				export.add(IconRecord);
				export.add(ArrowRecord);
				ooStream.writeObject(export);
				ooStream.close();
			} catch (Exception e) {
				System.out.println("***[ERROR][DataHandler.save@FileIO when save file is true]***");
				e.printStackTrace();
			}
		}
		
	}
	/**
	 * Opens a load dialog where the user can select a file to open
	 * @param parent Parent Frame for reference to set dialog location (can be null)
	 */
	public static void load(JFrame parent) {
		//confirm with the user that this will override any work they may have done
		int res = JOptionPane.showConfirmDialog(null, "This will overwrite any progress!\nLoad File?", "Warning", JOptionPane.YES_NO_OPTION);
		
		if(res==0) {
			//Generate Save Dialog
			JFileChooser sDia = new JFileChooser();
			sDia.setFileFilter(new drawingFileFilter());
			int diaRet = sDia.showOpenDialog(parent);
			
			try {
				//Create file input stream and set data if user selected their file
				if(diaRet==JFileChooser.APPROVE_OPTION) {
					File selFile = sDia.getSelectedFile();
					FileInputStream inStream = new FileInputStream(selFile);
					ObjectInputStream oiStream = new ObjectInputStream(inStream);
					//load root arraylist and assign children to user data objects
					ArrayList<ArrayList> temp = (ArrayList<ArrayList>) oiStream.readObject();
					IconRecord = temp.get(0);
					ArrowRecord = temp.get(1);
					}
				
				
			} catch(Exception e) {
				
			}
		} else {
			//do nothing, user had to have selected no on confirm dialog
		}
		
	}
	

	/**
	 * Returns ArrayList of all icons added to DrawPanelTwo
	 * @return ArrayList of DraggableIcon
	 */
	public static ArrayList<DraggableIcon> getIconRecord() {
		return IconRecord;
	}
	
	/**
	 * Adds new Icon objects to the array list
	 * @param DraggableIcon
	 */
	
	public static void addIcon(DraggableIcon icon) {
		IconRecord.add(icon);
	}
	
	/**
	 * Returns ArrayList of all Arrows added to DrawPanelTwo
	 * @return ArrayList of DrawArrow
	 */
	public static ArrayList<DrawArrow> getArrowRecord() {
		return ArrowRecord;
	}
	
	/**
	 * Adds new DrawArrow to ArrayList
	 * @param DrawArrow
	 */
	public static void addArrow(DrawArrow Arrow) {
		ArrowRecord.add(Arrow);
	}
}

/**
 * Used by the open/save dialog to filter it's results.
 * This is to help with readability and present the user
 * with only relevant files.
 * @author haliax
 *
 */
class drawingFileFilter extends FileFilter{
//	Set the desired file extension here
	protected final String FileExtension = "ud";


	
	/**
	 * Used to determine what should be accepted through the filter
	 * Directories need to be accepted, and files matching our extension
	 * @param f File/Folder to test in filter.
	 */
	@Override
	public boolean accept(File f) {
		if(f.isDirectory()==true) {
			return true;
		}
		//Get extension of the given file and test it against our set FileExtension
		String x = f.getName();
		int m = x.lastIndexOf(".");
		String ext = x.substring(m+1, x.length());
		if (ext.toLowerCase().equals(FileExtension)){
			return true;
		}
		
		
		return false;
	}

	@Override
	public String getDescription() {
		return "JavaDraw Save File (."+FileExtension+")";
	}
	
}
	