package gui;

import java.util.ArrayList;
import java.util.Observable;



public class Nodes extends Observable{
	ArrayList<Nodes> n = new ArrayList<Nodes>();
	String type;
	
	boolean isSingle;
	DraggableIcon start;
	DraggableIcon end;
	DrawArrow arrow;
	Nodes asSinglet1; //startNode
	Nodes asSinglet2; //endNode

	public Nodes() {
		super();
	}
	public Nodes(DraggableIcon st){
		super();
		this.isSingle = true;
		this.type = st.iconClass;
		this.start = st;
		
	}
	public Nodes(DraggableIcon st, DraggableIcon e, DrawArrow a) {
		super();
		
		this.isSingle = false;
		this.start = st;
		this.end = e;
		this.arrow = a;
		this.asSinglet1 = new Nodes(st);
		this.asSinglet2 = new Nodes(e);



	}
	public void addSingle(Nodes addthis) {

		addthis.addObserver(new nodeObserver());
		n.add(addthis);
		setChanged();
		notifyObservers(n);
		
	}
	public void addConnect(Nodes addthis) {

		n.add(addthis);

		
	}
	public ArrayList<Nodes> getNewArray()
	{
		return n;
	}
	

	
}