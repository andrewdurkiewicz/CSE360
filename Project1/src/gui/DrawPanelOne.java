package gui;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Dimension;

public class DrawPanelOne extends JPanel{

private int height, width;
public JLabel oval;
public JLabel rectangle;
public JLabel triangle;
public JLabel diamond;

   public DrawPanelOne(){
      super();
      super.setVisible(true);
      super.setBackground(Color.YELLOW);
   
      oval = new OvalLabel();
      rectangle = new RectLabel();
      triangle = new TriLabel();
      diamond = new DiamondLabel();
      super.add(oval);
      super.add(rectangle);
      super.add(triangle);
      super.add(diamond);
      
   }
   
}
