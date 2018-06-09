//Andrew
package gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseEvent;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.Border;


public class createTextPanel extends JPanel{
	String[] families = { "Serif", "SansSerif", "Monospaced" };
	Font de_font = new Font("Serif", Font.PLAIN, 18);
	int[] s_values = {8, 12, 18, 20, 22, 48};
	String[] s_names = {"8", "10", "12", "14", "16"};
	Border border = BorderFactory.createLineBorder(Color.BLACK);

	public createTextPanel(){
		this.setLayout(new GridLayout(2,1));
		
		JPanel textPanel = new JPanel();
		JTextArea textInput = new JTextArea(5,15);
		textInput.setLineWrap(true);
		textInput.setBorder(BorderFactory.createCompoundBorder(border,
				BorderFactory.createEmptyBorder(10, 10, 10, 10)));
		
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
		
		
		
		JButton editColor = new JButton("Edit Color");
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
		editColor.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				Color c = JColorChooser.showDialog(null, "Choose Color", Color.black);
				System.out.println(c);
				textInput.setForeground(c);
			}
		});
		editFont.add(en_italic);
		editFont.add(en_bold);
		editFont.add(editColor);
		editFont.add(clear);

		JComboBox<String> fontfamily = new JComboBox<>(families);
		JComboBox<String> sizeValues = new JComboBox<>(s_names);
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
		sizeValues.addItemListener(new ItemListener() {
			int getFont = textInput.getFont().getStyle();
			String family = textInput.getFont().getFamily();
			@Override
			public void itemStateChanged(ItemEvent e) {
				// TODO Auto-generated method stub
				String changeSize = (String) e.getItem();
				textInput.setFont(new Font(family, getFont, Integer.valueOf(changeSize)));

			}
		});
		
		
		textPanel.add(textInput,BorderLayout.CENTER);
		editFont.add(fontfamily);
		editFont.add(sizeValues);
		this.add(textPanel);
		this.add(editFont);
	}
	

}
