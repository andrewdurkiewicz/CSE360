package gui;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

public class OvalLabel extends JLabel{
   public OvalLabel(){
      super();
      super.setVisible(true);
      super.setOpaque(false);
      super.setPreferredSize(new Dimension(70, 70));
   }
   
   public void paintComponent(Graphics g){
      super.paintComponent(g);
      g.setColor(Color.BLACK);
      g.fillOval(10, 10, 50, 50);
   }
}