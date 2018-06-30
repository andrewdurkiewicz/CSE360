package gui;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JTextArea;

class iconObserver implements Observer {
	static int iconCounter = 1;

	public static ArrayList<DraggableIcon> IconRecord;
	public Observable observable;
	
	public iconObserver(ArrayList<DraggableIcon> iconrecord)
	{
		super();
		this.IconRecord = iconrecord;
	}
	
	public ArrayList<DraggableIcon> getIconObservers()
	{
		return this.IconRecord;
	}
	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub
		this.IconRecord = (ArrayList<DraggableIcon>) arg;
			if(IconRecord.get(0).iconClass == "circle")
			{
		        editFontPanel.getTextArea().setText(editFontPanel.getTextArea().getText() + "\nPublic interface icon" + iconCounter + " {\n}");
			}
			else if(IconRecord.get(0).iconClass == "rectangle")
			{
		        editFontPanel.getTextArea().setText(editFontPanel.getTextArea().getText() + "\n" + "Public icon" + iconCounter + " {\n}");
			}
        iconCounter++;

	}

}
