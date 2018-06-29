package gui;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JTextArea;

class iconObserver implements Observer {
	

	private Observable observable;
	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub
		
		observable = (Observable) o;  
		observable.addObserver(new iconObserver());
		System.out.println("In observable");
	}

}
