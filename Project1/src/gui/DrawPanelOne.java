package gui;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Dimension;

public class DrawPanelOne extends JPanel{

private int height, width;

   public DrawPanelOne(int w, int h){
      super();
      height = h;
      width = w;
      super.setVisible(true);
      super.setPreferredSize(new Dimension(width, height));
      super.setBackground(Color.YELLOW);
   
      JLabel oval = new OvalLabel();
      JLabel rectangle = new RectLabel();
      JLabel triangle = new TriLabel();
      JLabel diamond = new DiamondLabel();
      super.add(oval);
      super.add(rectangle);
      super.add(triangle);
      super.add(diamond);
      
   }
   
}
