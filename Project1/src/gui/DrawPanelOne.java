package gui;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Dimension;

public class DrawPanelOne extends JPanel{

private int height, width;
public OvalLabel oval;
public TriLabel triangle;
public RectLabel rectangle;
public StarLabel star;
public DiamondLabel diamond;

   public DrawPanelOne(){
      super();
      super.setVisible(true);
      super.setBackground(Color.WHITE);
   
      oval = new OvalLabel();
      triangle = new TriLabel();
      rectangle = new RectLabel();
      star = new StarLabel();
      diamond = new DiamondLabel();
      super.add(oval);
      super.add(triangle);
      super.add(rectangle);
      super.add(star);
      super.add(diamond);
      
   }
   
}
