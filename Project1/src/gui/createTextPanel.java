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
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseEvent;
import java.awt.Font;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextArea;


public class createTextPanel extends JPanel{
	String[] families = { "Serif", "SansSerif", "Monospaced" };
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
		JToggleButton en_italic = new JToggleButton("Italic");
		JToggleButton en_bold = new JToggleButton("Bold");
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
				String family = textInput.getFont().getFamily();
				int size = textInput.getFont().getSize();
				
				if(textInput.getFont().isBold() != true) {
					textInput.setFont(new Font(family, getFont + Font.BOLD, 18));
				}
				else {
					textInput.setFont(new Font(family, getFont - Font.BOLD, 18));
				}
			
			}
		});
		en_italic.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				int getFont = textInput.getFont().getStyle();
				String family = textInput.getFont().getFamily();
				int size = textInput.getFont().getSize();

				if(textInput.getFont().isItalic() != true) {
					textInput.setFont(new Font(family, Font.ITALIC, size));
				}
				else {
					textInput.setFont(new Font(family, getFont - Font.ITALIC, 18));
				}
			}
		});
		
		editFont.add(en_italic);
		editFont.add(en_bold);
		editFont.add(complete);
		editFont.add(clear);
		
		JComboBox<String> fontfamily = new JComboBox<>(families);
		fontfamily.addItemListener(new ItemListener() {
			int getFont = textInput.getFont().getStyle();
			String family = textInput.getFont().getFamily();
			int size = textInput.getFont().getSize();
			@Override
			public void itemStateChanged(ItemEvent e) {
				// TODO Auto-generated method stub
				if (e.getStateChange() == ItemEvent.SELECTED) {
					String item = (String) e.getItem();
					
					textInput.setFont(new Font(item, getFont, size));
				}
			}
		});
		editFont.add(fontfamily);
		this.add(textInput);
		this.add(editFont);
		
	}

}
