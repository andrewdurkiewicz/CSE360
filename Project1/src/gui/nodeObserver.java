package gui;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

import com.sun.xml.internal.ws.util.StringUtils;

public class nodeObserver implements Observer {

	private static ArrayList<Nodes> cpy = new ArrayList<Nodes>();

	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub
		cpy.add((Nodes) arg);
		editFontPanel.getTextArea().setText("");

		 if(((Nodes) arg).isSingle == false){delSingle((((Nodes) arg).start.persistantName), ((Nodes) arg).end.persistantName);}

		 for(Nodes n : cpy) {
			if(n.type == "circle" && n.isSingle == true){changeText("\nPublic interface " + n.start.persistantName + "{\n}");}//interface
			else if(n.type == "rectangle" && n.isSingle == true){changeText("\nPublic class " + n.start.persistantName + "{\n}");} //class type
			else if(n.isSingle == false && n.arrow.inherit){changeText("\npublic " + getImplementation(n.start.iconClass)//extends
						+ n.start.persistantName + " extends " + n.end.persistantName + "{\n}");}
			else if(n.isSingle == false && n.arrow.aggregate && n.start.iconClass == "rectangle" && n.end.iconClass == "rectangle"){changeText("\nPublic" 
						+ " class "  + n.start.persistantName + "{\n\t" + StringUtils.capitalize(n.end.persistantName) 
									+ " " + StringUtils.decapitalize(n.end.persistantName)  + "{\n}");} //aggregate
			else if(n.isSingle == false && n.arrow.associate && n.start.iconClass == "rectangle" && n.end.iconClass == "rectangle"){
								changeText("\npublic" + " class "  + n.start.persistantName + "{\n     public " + StringUtils.capitalize(n.start.persistantName) + "(){\n        "       
											+ StringUtils.capitalize(n.end.persistantName) + " " + StringUtils.decapitalize(n.end.persistantName) + " = new " + 
													StringUtils.capitalize(n.end.persistantName) + "();\n}");}//association

			else if(n.isSingle == false && (n.arrow.dashedLine1 || n.arrow.dashedLine1Bold || n.arrow.dashedLine2 || n.arrow.dashedLine2Bold) //implementation
								&& (n.end.iconClass == "circle" && n.start.iconClass == "rectangle")) {
										changeText("\npublic interface " + n.end.persistantName + " implements " + n.start.persistantName + "();\n}");}
			}
		 }
	public String getImplementation(String type) {
		if(type == "circle") {return " interface ";}
		else { return " class ";}
	}
	
	public void changeText(String s)
	{
		editFontPanel.getTextArea().setText(editFontPanel.getTextArea().getText() + s);
	}
	
	public void delSingle(String name1, String name2) { //this removes individual icons before linking to allow us to not reprint icons
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

