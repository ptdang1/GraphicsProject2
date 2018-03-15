package cs304.graphics2;

import javax.swing.JFrame;
import java.awt.BorderLayout;

public class ViewFrame extends JFrame
{
   private DrawScreen drawScreen;
   private ButtonPanel buttonPanel;

   public ViewFrame()
   {
      this.setSize(800, 840);
      this.setTitle( "Data Structures" );
      this.setLayout(new BorderLayout());
      this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      drawScreen = new DrawScreen();

      buttonPanel = new ButtonPanel(drawScreen);
      this.add(buttonPanel, BorderLayout.EAST);         
      this.add(drawScreen, BorderLayout.CENTER);
   }
}