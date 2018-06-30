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

				System.out.println("inheritance");
			}
			else if(n.isSingle == false && n.arrow.aggregate)
			{
				System.out.println(cpy.contains(n.asSinglet1));
				System.out.println(cpy.contains(n.asSinglet2));

			}
			else if(n.isSingle == false && n.arrow.associate)
			{
				System.out.println("association");

			}
			if(n.isSingle == true) {nodeTotal++;}
			
		}
	}
	
	public void changeText(String s)
	{
		editFontPanel.getTextArea().setText(editFontPanel.getTextArea().getText() + s);
	}


}
