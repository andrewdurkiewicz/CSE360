// Author: Andrew

package gui;
import java.awt.EventQueue;
/**
 * @author cody
 * <h2>JUML</h2>
 * <p>This Class is used to run the program. It creates a new Thread and Runs the GUI in it.</p>
 * <p>Calls DrawFrame</p>
 */

public class JUML {

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