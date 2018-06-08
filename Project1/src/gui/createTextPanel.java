package gui;

import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class createTextPanel extends JPanel{

	public createTextPanel(){
		this.setLayout(new GridLayout(3,1));
		JTextArea textInput = new JTextArea("Type here....");

		MouseListener listener = new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				if(textInput.getText().compareTo("Type here....") == 0) {
					textInput.setText("");

				}
				else if ((e.getSource() instanceof JButton)) {
					textInput.setText("");

				}
			}
		};
		textInput.addMouseListener(listener);

		
		//first button group for changing text
		JButton en_italic = new JButton("Italic");
		JButton en_bold = new JButton("Bold");
		JButton en_underline = new JButton("Underline");

		
		
		JPanel editFont = new JPanel();
		editFont.setLayout(new FlowLayout());
		editFont.add(en_italic);
		editFont.add(en_bold);
		editFont.add(en_underline);
		
		
		JButton complete = new JButton("Complete");
		JButton clear = new JButton("Clear Text");
		clear.addMouseListener(listener);
		//add to panel

		editFont.add(complete);
		editFont.add(clear);
		this.add(textInput);
		this.add(editFont);
		
	}

}
