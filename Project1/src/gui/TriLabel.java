package gui;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

public class TriLabel extends JLabel{
   public TriLabel(){
      super();
      super.setVisible(true);
      super.setOpaque(true);
      super.setPreferredSize(new Dimension(70, 70));
   }
   
   public void paintComponent(Graphics g){
      super.paintComponent(g);
      g.setColor(Color.BLACK);
      int[] x = new int[3];
      int[] y = new int[3];
      x[0]=10; x[1]=35; x[2]=60;
      y[0]=60; y[1]=10; y[2]=60;
      int n = 3;
      g.drawPolygon(x, y, n);
   }
}