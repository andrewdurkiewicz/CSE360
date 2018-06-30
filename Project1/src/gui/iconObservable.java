package gui;

import java.util.ArrayList;
import java.util.Observable;

public class iconObservable extends Observable {
	public static ArrayList<DraggableIcon> IconRecord;
	
	public iconObservable(ArrayList<DraggableIcon> IconRecord) {
		
		iconObservable.IconRecord = IconRecord;
	}
	
	public String getIconName() {
		return DraggableIcon.iconClass;
	}
	

	public void setIconName(ArrayList<DraggableIcon> IconRecord) {
		iconObservable.IconRecord = IconRecord;
		IconRecord.get(0);
		System.out.println( DraggableIcon.iconClass + "hi");
		setChanged();
		notifyObservers();
	}
	
	
}
