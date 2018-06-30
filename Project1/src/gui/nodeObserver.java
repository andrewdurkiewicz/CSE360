package gui;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

import com.sun.xml.internal.ws.util.StringUtils;

public class nodeObserver implements Observer {

	public static ArrayList<Nodes> cpy = new ArrayList<Nodes>();

	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub
		cpy.add((Nodes) arg);
		editFontPanel.getTextArea().setText("");
		 if(((Nodes) arg).isSingle == false){
			 delSingle((((Nodes) arg).start.persistantName), ((Nodes) arg).start.persistantName); }
		for(Nodes n : cpy) {
			if(n.type == "circle" && n.isSingle == true){
				 changeText("\nPublic" + getImplementation(n.type) + " " + n.start.persistantName);
			}
			else if(n.type == "rectangle" && n.isSingle == true){
				 changeText("\nPublic" + getImplementation(n.type) + " " + n.start.persistantName);
			}
			else if(n.isSingle == false && n.arrow.inherit)
			{

				changeText("\nPublic interface " + n.start.persistantName + " extends " + n.end.persistantName);
			}
			else if(n.isSingle == false && n.arrow.aggregate)
			{
				changeText("\nPublic" + getImplementation(n.type) + n.start.persistantName + " implements " + n.end.persistantName);
			}
			else if(n.isSingle == false && n.arrow.associate)
			{
				changeText("\n     "  + StringUtils.capitalize(n.start.persistantName) + " " + n.end.persistantName + ";" );

			}
			else if(n.isSingle == false && (n.arrow.dashedLine1 || n.arrow.dashedLine1Bold || n.arrow.dashedLine2 || n.arrow.dashedLine2Bold)) {
				changeText("\nPublic interface " + n.start.persistantName + " implements " + n.end.persistantName);

			}
			
		}
	}
	
	public void changeText(String s)
	{
		editFontPanel.getTextArea().setText(editFontPanel.getTextArea().getText() + s);
	}
	
	public String getImplementation(String type) {
		if(type == "circle") {return " interface ";}
		else { return " class ";}
	}
	public void delSingle(String name1, String name2) {
		Nodes n2 = null,n1 = null;
		for(Nodes n: cpy) {
			if(n.isSingle == true && (n.start.persistantName == name1 )){
					n1 = n;
			}
			if(n.isSingle == true && n.start.persistantName == name2) {
				n2 = n;
			}
		}
		cpy.remove(n1);
		cpy.remove(n2);
	}
}

