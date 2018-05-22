package gui;

import javax.swing.JFrame;

public class DrawFrame {
	private JFrame mainWindow;
	
	public DrawFrame(){
		initialize();
		mainWindow.setVisible(true);
	}
	
	private void initialize() {
		mainWindow = new JFrame();
		mainWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainWindow.setBounds(0, 0, 800, 600);
		mainWindow.setTitle("JavaDraw Project 1");
	}
}
