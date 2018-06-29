//Andrew
package gui;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;


public class editFontPanel extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	static JTextArea textInput;
	String[] families = { "Serif", "SansSerif", "Monospaced" };
	Font de_font = new Font("Serif", Font.PLAIN, 18);
	int[] s_values = {8, 12, 18, 20, 22, 48};
	String[] s_names = {"8", "10", "12", "14", "16"};
	public editFontPanel()
	{	
		textInput = new createTextPanel();
		this.setLayout(new BorderLayout());
		//first button group for changing text
		JToggleButton en_italic = new JToggleButton("Italic");
		JToggleButton en_bold = new JToggleButton("Bold");
		JPanel editFont = new JPanel();
		editFont.setLayout(new GridLayout(5,5));
		JButton editBorderColor = new JButton("Edit Border Color");
		JButton editColor = new JButton("Edit Font Color");
		JButton clear = new JButton("Clear Text");
		editBorderColor.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				Color c = JColorChooser.showDialog(null, "Choose Color", Color.black);
				Border border = BorderFactory.createLineBorder(c);
				textInput.setBorder(BorderFactory.createCompoundBorder(border,
						BorderFactory.createEmptyBorder(10, 10, 10, 10)));
			}
		});
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
				textInput.setForeground(c);
			}
		});
		
		editFont.add(en_italic);
		editFont.add(en_bold);
		editFont.add(editColor);
		editFont.add(editBorderColor);
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
		textInput.setFont(de_font);

		JPanel collectButtons = new JPanel();
		collectButtons.setLayout(new FlowLayout());
		collectButtons.add(fontfamily);
		collectButtons.add(sizeValues);

		collectButtons.add(editFont);
		this.add(textInput, BorderLayout.CENTER);
		this.add(collectButtons,BorderLayout.SOUTH);
		this.setBorder(BorderFactory.createLineBorder(Color.black));


		
		
	}
	public static JTextArea getTextArea()
	{
		return textInput;
		
	}
}
