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


public class createTextPanel extends JTextArea implements Observer{
	/**
	 * 
	 */
	
	private static final long serialVersionUID = 1L;
	String[] families = { "Serif", "SansSerif", "Monospaced" };
	Font de_font = new Font("Serif", Font.PLAIN, 18);
	int[] s_values = {8, 12, 18, 20, 22, 48};
	String[] s_names = {"8", "10", "12", "14", "16"};
	Border border = BorderFactory.createLineBorder(Color.BLACK);
	//JPanel editFont = new editFontPanel();
	public createTextPanel(){
		this.setLayout(new BorderLayout());
		
		//JPanel textPanel = new JPanel();
		//textPanel.setSize(new Dimension(100, 100));
		this.setLineWrap(true);
		this.setBorder(BorderFactory.createCompoundBorder(border,
				BorderFactory.createEmptyBorder(10, 10, 10, 10)));
		

		this.setEditable(false);
		
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
				if(getText().compareTo("Type here....") == 0) {
					setText("");

				}
			}
		};

		this.addMouseListener(listener);
		this.setSize(new Dimension(100, 100));
		//editFont.setIgnoreRepaint(true);
	}

	@Override
	public void update(Observable arg0, Object arg1) {
		// TODO Auto-generated method stub
		System.out.println("got to the createTextPanel update void function");
	}
	
	

	

}
