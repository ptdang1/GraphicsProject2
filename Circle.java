package cs304.graphics2;

import java.awt.Color;
import java.awt.Graphics2D;


public class Circle extends Shape2D 
{
   Color color;
   double radius;
     
   public Circle(){
      super(0,0);
      this.radius = 32 + (int)(Math.random()*32);
      double speed = 16;
      color = colors[(int)(Math.random() * colors.length)];
      this.setVelX(Math.random()*speed - speed/2);
      this.setVelY(Math.random()*speed - speed/2);
   }

   public void draw( DrawScreen ds )
   {
      Graphics2D g2D = (Graphics2D) ds.g;
      g2D.setColor(this.color);
      int sx = (int)(this.getX() - radius + ds.getWidth()/2);
      int sy = (int)(this.getY() - radius + ds.getHeight()/2);
      g2D.fillOval(sx, sy, (int)(radius*2), (int)(radius*2));
   }
   public void updateGravity(DrawScreen ds)
   {
      this.setVelX(this.getVelX() + ds.getGravityX());
      this.setVelY(this.getVelY() + ds.getGravityY());
   }
   
   public void move( DrawScreen ds )
   {
      double sx = this.getX();
      double sy = this.getY();
      
      if( sx - radius + getVelX() < -ds.getWidth() / 2.0 ||
            sx + radius + getVelX() > ds.getWidth() / 2.0 )
      {
         this.setVelX(0-this.getVelX());
      }
      if( sy - radius + getVelY() < -ds.getHeight() / 2.0 ||
            sy + radius + getVelY() > ds.getHeight() / 2.0 )
      {
         this.setVelY(0-this.getVelY());
      }
      
      sx = sx + this.getVelX();
      sy = sy + this.getVelY();
      this.setX(sx);
      this.setY(sy);
   }
}