// Author: Zach
package gui;
import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;



public class DrawFrame extends JFrame 
{
	/**
	 * 
	 * GUI class.
	 * This is the top level class of the gui. 
	 * <br>
	 * -Is called by JUML
	 */
	private static final long serialVersionUID = 1L;
	private JFrame mainWindow;
	private JPanel	contentPane;
	/**
	 * Default Constructor.
	 * Used to create a new instance of the GUI and makes it visible
	 */
	public DrawFrame() 
	{
		initialize();
		mainWindow.setVisible(true);
	}
	
	/**
	 * Creates GUI objects and populates the gui with UI Components
	 */
	private void initialize()
	{
		//Create Basic structure and assign the properties of the JFrame and Main Content Pane
		mainWindow = new JFrame();
		mainWindow.setSize(new Dimension(1400, 900)); //Needs to be a bit over the sum of all componen
		mainWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainWindow.setTitle("JavaDraw GUI");
		mainWindow.getContentPane().setLayout(new FlowLayout(FlowLayout.CENTER,0,0));
		contentPane = new JPanel();
		contentPane.setLayout(new FlowLayout(FlowLayout.CENTER,0,0)); 
		contentPane.setBackground(Color.GRAY);
		//contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		JPanel bp = new JPanel();
		bp.setLayout(new GridLayout(1, 2));
		bp.setPreferredSize(new Dimension(600, 800));
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
		mainWindow.getContentPane().add(contentPane, BorderLayout.CENTER);
		
		mainWindow.getContentPane().add(bp,BorderLayout.CENTER);
		
		JMenuBar menuBar = new JMenuBar();
		mainWindow.setJMenuBar(menuBar);
		
		JMenu mnFile = new JMenu("File");
		menuBar.add(mnFile);
		
		JMenuItem mntmSave = new JMenuItem("Save");
		mntmSave.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e) 
			{
				DataHandler.save(mainWindow);
			}
		});
		mnFile.add(mntmSave);
		
		JMenuItem mntmLoad = new JMenuItem("Load");
		mntmLoad.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e) 
			{
				DataHandler.load(mainWindow);
				//After records are set, draw everything
				dpTwo.updatePanel();
				//Add listeners back to objects
				dpTwo.addLoadedListeners();
			}
		});
		mnFile.add(mntmLoad);
		
		JMenuItem mntmAbout = new JMenuItem("About");
		mntmAbout.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e) 
			{
				JOptionPane.showMessageDialog(mainWindow, "J-UML\nProject 2\n"
						+ "************Authors************\n"
						+ "Zach Carnago\nCody Roberson\nTyler Cole\nAndrew Durkiewicz", "About", JOptionPane.PLAIN_MESSAGE);
			}
		});
		mnFile.add(mntmAbout);
		
		JMenuItem mntmQuit = new JMenuItem("Quit");
		mntmQuit.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				int res = JOptionPane.showConfirmDialog(null, "If you have unsaved changes, they will be lost.\n"
						+ "Close?", "Warning", JOptionPane.YES_NO_OPTION);
				if(res==0) 
				{
					System.exit(0);
				}
			}
		});
		mnFile.add(mntmQuit);
		pack();
	}
}
