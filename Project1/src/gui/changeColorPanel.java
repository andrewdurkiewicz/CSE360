//andrew
package gui;

import java.awt.BorderLayout;

import javax.swing.JColorChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;

public class changeColorPanel extends JPanel{
	public changeColorPanel() {
	JColorChooser colorChooser = new JColorChooser();
	colorChooser.setPreviewPanel(new JPanel());
	this.add(colorChooser,BorderLayout.CENTER);	
	}
}
