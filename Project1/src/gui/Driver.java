package gui;

<<<<<<< HEAD
import java.awt.EventQueue;

/**
 * 
 * @author cody
 * <h2>Driver for GUI</h2>
 * <p>This class is used to make the GUI runnable but also modular.
 * That way, the gui made in this project can be called on in the future
 * by a larger project.</p>
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
=======
public class Driver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

>>>>>>> d7997d6d3719de0865f795e5e9cb46133280cd25
	}

}
