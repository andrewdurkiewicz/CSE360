package gui;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

public class RectLabel extends JLabel{
   public RectLabel(){
      super();
      super.setVisible(true);
      super.setOpaque(true);
      super.setPreferredSize(new Dimension(70, 70));
   }
   
   public void paintComponent(Graphics g){
      super.paintComponent(g);
      g.setColor(Color.BLACK);
      g.drawRect(10, 15, 50, 40);
   }
}