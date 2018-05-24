package gui;
import java.awt.EventQueue;

/**
 * 
 * @author cody
 * <h2>Driver for GUI</h2>
 * <p>This class is stand-alone. It's used for running and testing the GUI. It should not
 * be used in a production environment or called by another class</p>
 * <p>Calls DrawFrame</p>
 */

public class Driver {

	public static void main(String[] args)
	{
		EventQueue.invokeLater(new Runnable()
		{
			public void run() 
			{
				try 
				{
					new DrawFrame();
				} 
				catch (Exception e) 
				{
					e.printStackTrace();
				}
			}
		});

	}
}