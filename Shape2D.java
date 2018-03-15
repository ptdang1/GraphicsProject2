package cs304.graphics2;
import java.awt.Color;

public abstract class Shape2D implements Drawable, Moveable
{
   Color[] colors = {Color.RED, Color.ORANGE, Color.YELLOW, Color.GREEN, 
      new Color(180, 180, 255), Color.BLACK, Color.WHITE, Color.CYAN, Color.LIGHT_GRAY,
      Color.PINK, Color.MAGENTA, Color.DARK_GRAY};

   private double x, y;
   private double velX, velY; 
   
   public Shape2D(double x, double y)
   {
      this.x = x;
      this.y = y;
   }
   
   public double getX()
   {
      return x;
   }
   public double getY()
   {
      return y;
   }
   public double getVelX()
   {
      return velX;
   }
   public double getVelY()
   {
      return velY;
   }
   public void setX(double x)
   {
      this.x = x;
   }
   public void setY(double y)
   {
      this.y = y;
   }
   public void setVelX(double x)
   {
      this.velX = x;
   }
   public void setVelY(double y)
   {
      this.velY = y;
   }
}