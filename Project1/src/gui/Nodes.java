package gui;

import java.util.ArrayList;
import java.util.Observable;



public class Nodes extends Observable{
	String type;
	static int nodelist = 0;
	boolean isSingle;
	DraggableIcon start;
	DraggableIcon end;
	DrawArrow arrow;

	public Nodes() 
	{
		super();
	}
	
	public Nodes(DraggableIcon st)
	{
		super();
		this.isSingle = true;
		this.type = st.iconClass;
		this.start = st;
	}
	
	public Nodes(DraggableIcon st, DraggableIcon e, DrawArrow a) 
	{
		super();
		isSingle = false;
		start = st;
		end = e;
		arrow = a;
	}
	
	public void addSingle(Nodes newNode) 
	{
		if(newNode.isSingle == true) {nodelist++;}
		newNode.start.persistantName = "Icon" + nodelist;
		newNode.addObserver(new nodeObserver());
		setChanged();
		notifyObservers(newNode);
	}
}