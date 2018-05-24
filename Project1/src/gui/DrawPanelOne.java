package gui;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Dimension;

public class DrawPanelOne extends JPanel{

private int height, width;
public JLabel oval;
public JLabel triangle;
public JLabel rectangle;
public JLabel star;

   public DrawPanelOne(){
      super();
      super.setVisible(true);
      super.setBackground(Color.WHITE);
   
      oval = new OvalLabel();
      triangle = new TriLabel();
      rectangle = new RectLabel();
      star = new StarLabel();
      super.add(oval);
      super.add(triangle);
      super.add(rectangle);
      super.add(star);
      
   }
   
}
