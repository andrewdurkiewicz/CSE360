// Author: Zach
package gui;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.sun.org.apache.bcel.internal.generic.NEW;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.WindowListener;
import java.awt.event.MouseAdapter;

/**
 * 
 * @author Cody
 * GUI class.
 * This is the top level class of the gui. 
 * <br>
 * -Is called by JUML
 */

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
		
		//Create Basic structure and assign the properties of the JFrame and Main Content Pane
		mainWindow = new JFrame();
		mainWindow.setExtendedState(JFrame.MAXIMIZED_BOTH); 
		mainWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainWindow.setTitle("JavaDraw GUI");
		mainWindow.setLayout(new GridLayout(1, 2));

		contentPane = new JPanel();
		JPanel ButtonPanel = new JPanel();
		contentPane.setLayout(new GridLayout(2, 1));
		contentPane.setBackground(Color.GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		//mainWindow.setContentPane(contentPane);
		
		ButtonPanel ourButtons = new ButtonPanel();
		ourButtons.setBounds(10, 10, 870, 100);
		
		ButtonPanel.add(ourButtons,BorderLayout.CENTER);
		
		//Add Panel One
		DrawPanelOne dpOne = new DrawPanelOne(); 
		
		contentPane.add(dpOne);
		
		//Add Panel Two
		DrawPanelTwo dpTwo = new DrawPanelTwo();
		dpTwo.setBounds(10, 120, 870, 485);
		dpTwo.setBorder(BorderFactory.createLineBorder(Color.black));
		contentPane.add(dpTwo);	


		mainWindow.add(contentPane);
		mainWindow.add(ButtonPanel);

	}
}
