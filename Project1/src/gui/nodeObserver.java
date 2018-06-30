package gui;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

public class nodeObserver implements Observer {

	public static int nodeTotal= 1;
	public static ArrayList<Nodes> cpy = new ArrayList<Nodes>();

	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub
		cpy.add((Nodes) arg);
		editFontPanel.getTextArea().setText("");
		 nodeTotal= 1;
		for(Nodes n : cpy) {
			if(n.type == "circle" && n.isSingle == true){
				 changeText("\nPublic interface icon" + nodeTotal);
			}
			else if(n.type == "rectangle" && n.isSingle == true){
				changeText("\nPublic class icon" + nodeTotal);
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
				System.out.println("association");

			}
			else if(n.isSingle == false && (n.arrow.dashedLine1 || n.arrow.dashedLine1Bold || n.arrow.dashedLine2 || n.arrow.dashedLine2Bold)) {
				changeText("\nPublic interface " + n.start.persistantName + " implements " + n.end.persistantName);

			}
			if(n.isSingle == true) {nodeTotal++;}
			
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


}
