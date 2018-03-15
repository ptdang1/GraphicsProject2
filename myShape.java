package cs304.graphics2;

import java.awt.Color;
import java.awt.Graphics2D;


public class myShape extends Shape2D
{
   Color color;
   int size;
     
   public myShape(){
      super(0,0);
      this.size = 40 + (int)(Math.random()*40);
      double speed = 16;
      color = colors[(int)(Math.random() * colors.length)];
      this.setVelX(Math.random()*speed - speed/2);
      this.setVelY(Math.random()*speed - speed/2);
   }
      public void draw( DrawScreen ds )
   {
      Graphics2D g2D = (Graphics2D) ds.g;
      g2D.setColor(this.color);
      int sx = (int)(this.getX() - size + ds.getWidth()/2);
      int sy = (int)(this.getY() - size + ds.getHeight()/2);
      g2D.fillRect(sx, sy, (int)(size*2), (int)(size*2));
   }
   public void move( DrawScreen ds )
   {
      double sx = this.getX();
      double sy = this.getY();
      
      if( sx - size + getVelX() < -ds.getWidth() / 2.0 ||
            sx + size + getVelX() > ds.getWidth() / 2.0 )
      {
         this.setVelX(0-this.getVelX());
      }
      if( sy - size + getVelY() < -ds.getHeight() / 2.0 ||
            sy + size + getVelY() > ds.getHeight() / 2.0 )
      {
         this.setVelY(0-this.getVelY());
      }
      
      sx = sx + this.getVelX();
      sy = sy + this.getVelY();
      this.setX(sx);
      this.setY(sy);
   }
   public void updateGravity(DrawScreen ds)
   {
      this.setVelX(this.getVelX() + ds.getGravityX());
      this.setVelY(this.getVelY() + ds.getGravityY());
   }
   
}