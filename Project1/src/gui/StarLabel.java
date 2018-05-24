package gui;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.BasicStroke;

public class StarLabel extends JLabel{
   public StarLabel(){
      super();
      super.setVisible(true);
      super.setOpaque(false);
      super.setPreferredSize(new Dimension(70, 70));
   }
   
   public void paintComponent(Graphics g){
      super.paintComponent(g);
      Graphics2D g2 = (Graphics2D) g;
      g2.setColor(Color.BLACK);
      g2.setStroke(new BasicStroke(3));
      int[] x = new int[10];
      int[] y = new int[10];
      x[0]=10; x[1]=25; x[2]=17; x[3]=35; x[4]=53; x[5]=45; x[6]=60; x[7]=43; x[8]=35; x[9]=27;
      y[0]=60-45+10; y[1]=60-30+7; y[2]=60-10+5; y[3]=60-25+10; y[4]=60-10+5; y[5]=60-30+7; y[6]=60-45+10; y[7]=60-45+10; y[8]=60-50; y[9]=60-45+10;
      int n = 10;
      g2.fillPolygon(x, y, n);
   }
}