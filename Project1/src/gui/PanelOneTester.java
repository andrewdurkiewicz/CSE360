package gui;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Dimension;

import gui.DrawPanelOne;

public class PanelOneTester{
   public static void main(String[] args){
	   //make the frame
      JFrame myFrame = new JFrame();
      JPanel panel1 = new DrawPanelOne();//NOTE: REMOVED INT HEIGHT AND WIDTH FROM DRAWPANELONE
      JPanel panel2 = new JPanel();
      
      myFrame.setTitle("Project1");
      myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      myFrame.setVisible(true);
      myFrame.setSize(new Dimension(800,600));
      
      panel2.setBackground(Color.RED);
      panel1.setBackground(Color.YELLOW);
      myFrame.add(panel1);
      myFrame.add(panel2);
      
      
      
      panel2.setVisible(true);

      panel2.setBounds(0,0,800,600);
      panel1.setBounds(0,0,800,100);

      panel1.setVisible(true);
     
   }
}