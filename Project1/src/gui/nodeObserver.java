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
		ArrayList<Nodes> a = (ArrayList<Nodes>) arg;
		editFontPanel.getTextArea().setText("");
		 nodeTotal= 1;
		for(Nodes n : a)
		{cpy.add(n);}
		for(Nodes n : cpy) {
			if(n.type == "circle" && n.isSingle == true){
				editFontPanel.getTextArea().setText(editFontPanel.getTextArea().getText() + "\nPublic interface icon" + nodeTotal);;
			}
			if(n.type == "rectangle" && n.isSingle == true){
				editFontPanel.getTextArea().setText(editFontPanel.getTextArea().getText() + "\nPublic class icon" + nodeTotal);;
			}
			nodeTotal++;
		}
	}

}
