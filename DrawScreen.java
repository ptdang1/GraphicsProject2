package cs304.graphics2;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Graphics;
import javax.swing.Timer;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import cs304.datastructures.generics.LinkedList;

public class DrawScreen extends JPanel implements ActionListener
{
   ViewFrame vf;
   Graphics g;
   Timer timer;
   LinkedList<Shape2D> shapeList;
   private  boolean gravityOn;
   private  boolean paused;
   private double gravityX;
   private double gravityY;   
   
   public DrawScreen()
   {
      this.setSize(700, 800);
      this.setBackground(Color.BLUE); 
      this.setVisible(true);
      shapeList = new LinkedList<>();
      
      g = this.getGraphics();
      timer = new Timer(20, this);   
      timer.start();   
      gravityOn = false;
      paused = true;
      gravityX = 0.0;
      gravityY = 0.4;
      
   }
   public int count;
   public void actionPerformed( ActionEvent ae )
   {
      count++;
      //System.out.println( "Count = " + count );
      repaint();
   }
   public void paint(Graphics g)
   {
      /* paint the background */
      super.paint(g);
      this.g = g;
      g.setColor(Color.RED);
      g.drawLine(0,this.getHeight()/2,this.getWidth(), this.getHeight()/2);
      g.drawLine(this.getWidth()/2,0, this.getWidth()/2, this.getHeight()); 
      
      /* move and draw the shape objects */           
      for( int i=0; i<shapeList.size(); i++ )
      {
         Shape2D shp = shapeList.get(i);
         if( !paused )
         {
            shp.updateGravity(this);
            shp.move(this);
         }
         shp.draw(this);
      }
   }
   public void setGravity(boolean on)
   {
      gravityOn = on;
   }
   public void setPause(boolean on)
   {
      paused = on;
   }
   public double getGravityX()
   {
      if( !gravityOn ) return 0.0;
      return gravityX;
   }
   public double getGravityY()
   {
      if( !gravityOn ) return 0.0;
      return gravityY;
   }
   public void addShape()
   {
      if( Math.random() > .5 )
         shapeList.add(new myShape());
          
      else
         shapeList.add(new Circle());
      
   }
   public void removeShape()
   {
      shapeList.remove(0);
   }
   
}