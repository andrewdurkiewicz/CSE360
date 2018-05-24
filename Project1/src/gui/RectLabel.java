package gui;
import javax.swing.JLabel;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;

public class RectLabel extends JLabel{
   public RectLabel(){
      super();
      super.setVisible(true);
      super.setOpaque(false);
      super.setPreferredSize(new Dimension(70, 70));
   }
   
   public void paintComponent(Graphics g){
      super.paintComponent(g);
      Graphics2D g2 = (Graphics2D) g;
      g2.setColor(Color.BLACK);
      g2.setStroke(new BasicStroke(5));
      g2.drawRect(10, 15, 50, 40);
   }
}