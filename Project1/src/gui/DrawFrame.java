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
import java.awt.ComponentOrientation;
import java.awt.Dimension;
import java.awt.FlowLayout;
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
		mainWindow.setSize(new Dimension(1050, 850)); //Needs to be a bit over the sum of all componen
		mainWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainWindow.setTitle("JavaDraw GUI");
		mainWindow.setLayout(new FlowLayout(FlowLayout.CENTER,0,0));
		contentPane = new JPanel();
		contentPane.setLayout(new FlowLayout(FlowLayout.CENTER,0,0)); 
		contentPane.setBackground(Color.GRAY);
		//contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		JPanel bp = new JPanel();
		bp.setLayout(new GridLayout(1, 1));
		bp.setPreferredSize(new Dimension(300, 800));
		ButtonPanel ourButtons = new ButtonPanel();
		ourButtons.setPreferredSize(new Dimension(300,800));
		bp.add(ourButtons);
		
		DrawPanelOne dpOne = new DrawPanelOne(); //panel1
		DrawPanelTwo dpTwo = new DrawPanelTwo(); //panel2
		dpTwo.lineReference = ourButtons;
		contentPane.setPreferredSize(new Dimension(700, 800));
		dpOne.setPreferredSize(new Dimension(700,150));
		dpTwo.setPreferredSize(new Dimension(700,650));

		dpOne.setBorder(BorderFactory.createLineBorder(Color.black));
		dpTwo.setBorder(BorderFactory.createLineBorder(Color.black));
		contentPane.add(dpOne);
		contentPane.add(dpTwo);	
		mainWindow.add(contentPane, BorderLayout.CENTER);
		
		mainWindow.add(bp,BorderLayout.CENTER);
		pack();
	}
}
