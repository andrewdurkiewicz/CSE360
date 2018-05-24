package gui;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

public class DiamondLabel extends JLabel{
   public DiamondLabel(){
      super();
      super.setVisible(true);
      super.setOpaque(true);
      super.setPreferredSize(new Dimension(70, 70));
   }
   
   public void paintComponent(Graphics g){
      super.paintComponent(g);
      g.setColor(Color.BLACK);
      int[] x = new int[4];
      int[] y = new int[4];
      x[0]=10; x[1]=35; x[2]=60; x[3]=35;
      y[0]=35; y[1]=10; y[2]=35; y[3]=60;
      int n = 4;
      g.drawPolygon(x, y, n);
   }
}