package gui;

import java.util.ArrayList;
import java.util.Observable;



public class Nodes extends Observable{
	ArrayList<Nodes> n = new ArrayList<Nodes>();

	DraggableIcon start;
	DraggableIcon end;
	DrawArrow arrow;

	public Nodes() {
		super();
	}
	public Nodes(DraggableIcon st){
		super();

		this.start = st;
		this.addObserver(new nodeObserver());

		
		
	}
	public Nodes(DraggableIcon st, DraggableIcon e, DrawArrow a) {
		super();
		this.start = st;
		this.end = e;
		this.arrow = a;
		this.addObserver(new nodeObserver());


	}
	public void addSingle(Nodes addthis) {

		addthis.addObserver(new nodeObserver());
		n.add(addthis);
		setChanged();
		notifyObservers();
		
	}
	public void addConnect(Nodes addthis) {

		n.add(addthis);

		
	}
	public ArrayList<Nodes> getNewArray()
	{
		return n;
	}
}