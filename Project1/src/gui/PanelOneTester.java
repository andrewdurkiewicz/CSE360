package gui;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import gui.DrawPanelOne;

public class PanelOneTester{
   public static void main(String[] args){
      JFrame myFrame = new JFrame();
      myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      myFrame.setVisible(true);
      myFrame.setBounds(0,0,800,600);
      myFrame.setTitle("Hope it Works");
      
      JPanel myPanel = new DrawPanelOne(800, 100);
      JPanel panel2 = new JPanel();
      panel2.setVisible(true);
      panel2.setBackground(Color.RED);
      myFrame.add(myPanel);
      myFrame.add(panel2);
      myPanel.setBounds(0,0,800,100);
   }
}