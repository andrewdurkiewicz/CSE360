//Andrew
package gui;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseListener;
import java.util.Observable;
import java.util.Observer;
import java.awt.event.MouseEvent;

import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.Border;


public class createTextPanel extends JTextArea{
	
	private static final long serialVersionUID = 1L;
	String[] families = { "Serif", "SansSerif", "Monospaced" };
	Font de_font = new Font("Serif", Font.PLAIN, 6);
	int[] s_values = {6, 8, 18, 20, 22, 48};
	String[] s_names = {"6", "8", "12", "14", "16"};
	Border border = BorderFactory.createLineBorder(Color.BLACK);
	
	//JPanel editFont = new editFontPanel();
	public createTextPanel()
	{
		this.setLayout(new BorderLayout());
		this.setLineWrap(true);
		this.setBorder(BorderFactory.createCompoundBorder(border,
		BorderFactory.createEmptyBorder(10, 10, 10, 10)));
		this.setEditable(false);
		
		MouseListener listener = new MouseListener() 
		{
			@Override
			public void mouseReleased(MouseEvent e) {}
			
			@Override
			public void mousePressed(MouseEvent e) {}
			
			@Override
			public void mouseExited(MouseEvent e) {}
			
			@Override
			public void mouseEntered(MouseEvent e) {}
			
			@Override
			public void mouseClicked(MouseEvent e) 
			{
				if(getText().compareTo("Type here....") == 0)
				{
					setText("");
				}
			}
		};

		this.addMouseListener(listener);
		this.setSize(new Dimension(100, 100));
	}


	
	

	

}
