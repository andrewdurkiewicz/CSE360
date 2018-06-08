package gui;

import java.awt.Button;
import java.awt.FlowLayout;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JPanel;

public class createTextPanel extends JPanel {

	public createTextPanel(){
		
		//first button group for changing text
		setLayout(new FlowLayout());
		JButton en_italic = new JButton("Italics");
		JButton en_bold = new JButton("Bold");
		JButton en_underline = new JButton("Underline");
		this.add(en_italic);
		this.add(en_bold);
		this.add(en_underline);
		
	}

}
