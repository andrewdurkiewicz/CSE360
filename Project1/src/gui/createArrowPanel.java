//Author: Tyler Cole
package gui;

import javax.swing.*;
import javax.swing.border.Border;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class createArrowPanel extends JPanel {
	public Color c;
	
	public createArrowPanel() {
		
		c = Color.black;
		
		JPanel lineColor = new JPanel();
		
		JLabel lineColorLabel = new JLabel("Line Color:");
		
		JButton editColor = new JButton(" ");
		editColor.setBackground(Color.black);
		editColor.addActionListener(new ActionListener() {
				
		@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					Color newColor = JColorChooser.showDialog(null, "Choose Color", Color.black);
					editColor.setBackground(newColor);
					c = editColor.getBackground();
					
					//debug info
					System.out.println("Color changed to " + c);
				}
			});
		
		lineColor.add(lineColorLabel);
		lineColor.add(editColor);
		this.add(lineColor);
	}
}
