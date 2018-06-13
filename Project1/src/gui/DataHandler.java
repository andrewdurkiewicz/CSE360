package gui;
/**
 * Handles the data and I/O of the gui
 * such as saving and loading
 * @author Cody
 */
import java.io.File;
import java.util.ArrayList;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
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
		JFileChooser sDia = new JFileChooser();
		sDia.setFileFilter(new drawingFileFilter());
		int diaRet = sDia.showSaveDialog(parent);
	}
	/**
	 * Opens a load dialog where the user can select a file to open
	 * @param parent Parent Frame for reference to set dialog location (can be null)
	 */
	public static void load(JFrame parent) {
		JFileChooser sDia = new JFileChooser();
		sDia.setFileFilter(new drawingFileFilter());
		int diaRet = sDia.showOpenDialog(parent);
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
	private final String FileExtension = "ud";


	
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
	