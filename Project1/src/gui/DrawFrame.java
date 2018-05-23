package gui;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.FlowLayout;
import java.awt.Color;


@SuppressWarnings("serial")//TODO: Remove
public class DrawFrame extends JFrame {
	private JFrame mainWindow;
	private JPanel	contentPane;
	
	/**
	 * Default Constructor.
	 * Used to create a new instance of the GUI and makes it visible
	 */
	public DrawFrame() {
		initialize();
		mainWindow.setVisible(true);
	}
	
	/**
	 * Creates GUI objects and populates the gui with UI Components
	 */
	private void initialize() {
		/**
		 * Create Basic structure and assign the properties of the JFrame and Main Content Pane
		 */
		mainWindow = new JFrame();
		mainWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainWindow.setTitle("JavaDraw GUI");
		mainWindow.setBounds(100, 100, 900, 650);
		contentPane = new JPanel();
		contentPane.setBackground(Color.GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		mainWindow.setContentPane(contentPane);
		contentPane.setLayout(null);
		
		//Add Panel One
		DrawPanelOne dpOne = new DrawPanelOne();
		dpOne.setBounds(10, 10, 870, 100);
		contentPane.add(dpOne);
		
		//Add Panel Two
		DrawPanelTwo dpTwo = new DrawPanelTwo();
		dpTwo.setBounds(10, 120, 870, 485);
		contentPane.add(dpTwo);
		
		
		
				
	}
	

}
