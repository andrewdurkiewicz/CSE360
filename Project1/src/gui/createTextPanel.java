//Andrew
package gui;

import java.awt.Button;
import javax.swing.*;
import java.awt.*;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.MouseListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.Font;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextArea;


public class createTextPanel extends JPanel{

	Font de_font = new Font("Serif", Font.PLAIN, 18);
	public createTextPanel(){
		this.setLayout(new GridLayout(3,1));
		JTextArea textInput = new JTextArea();
		textInput.setLineWrap(true);
		textInput.setFont(de_font);
		textInput.setText("Type here....");

		
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
			}
		};
		textInput.addMouseListener(listener);

		
		//first button group for changing text
		JButton en_italic = new JButton("Italic");
		JButton en_bold = new JButton("Bold");
		JPanel editFont = new JPanel();
		editFont.setLayout(new FlowLayout());

		
		
		JButton complete = new JButton("Complete");
		JButton clear = new JButton("Clear Text");
		clear.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				textInput.setText("");
			}
		});
		
		en_bold.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				int getFont = textInput.getFont().getStyle();
				if(textInput.getFont().isBold() != true) {
					textInput.setFont(new Font("Serif", getFont + Font.BOLD, 18));
				}
				else {
					textInput.setFont(new Font("Serif", getFont - Font.BOLD, 18));
				}
			
			}
		});
		//add to panel
		
		en_italic.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				int getFont = textInput.getFont().getStyle();

				if(textInput.getFont().isItalic() != true) {
					textInput.setFont(new Font("Serif", Font.ITALIC, 18));
				}
				else {
					textInput.setFont(new Font("Serif", getFont - Font.ITALIC, 18));
				}
			}
		});
		
		editFont.add(en_italic);
		editFont.add(en_bold);
		editFont.add(complete);
		editFont.add(clear);
		this.add(textInput);
		this.add(editFont);
		
	}

}
