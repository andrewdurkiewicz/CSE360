package gui;

import java.util.ArrayList;
import java.util.Observable;



public class Nodes extends Observable{
	
	public ArrayList<Nodes> n = new ArrayList<Nodes>();
	
	DraggableIcon start;
	DraggableIcon end;
	DrawArrow arrow;
	public Nodes() {


	}
	public Nodes(DraggableIcon st){
		this.start = st;
		
	}
	public Nodes(DraggableIcon st, DraggableIcon e, DrawArrow a) {
		this.start = st;
		this.end = e;
		arrow = a;

	}
	public void addSingle(Nodes addthis) {
		n.add(addthis);
	}
	public void addConnect(Nodes addthis) {
		n.add(addthis);
	}
}