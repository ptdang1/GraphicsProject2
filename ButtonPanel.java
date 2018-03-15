package cs304.graphics2;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.GridLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JOptionPane;



public class ButtonPanel extends JPanel implements ActionListener
{
   public DrawScreen drawScreen;
   
   public ButtonPanel( DrawScreen ds ) 
   {
      this.drawScreen = ds;
      
      this.setSize(100, 800);
      this.setBackground(Color.YELLOW);
      this.setVisible(true);
      this.setLayout(new GridLayout(12,1,20,20));
      
      JButton addButton = new JButton("ADD");
      addButton.addActionListener(this);
      this.add(addButton);
      JButton removeButton = new JButton("REMOVE");
      removeButton.addActionListener(this);
      this.add(removeButton);
      JButton stopButton = new JButton("STOP");
      stopButton.addActionListener(this);
      this.add(stopButton);
      JButton startButton = new JButton("START");
      startButton.addActionListener(this);
      this.add(startButton);
      JButton aboutButton = new JButton("ABOUT");
      aboutButton.addActionListener(this);
      this.add(aboutButton);
      JButton gravityOnButton = new JButton("GRAVITY ON");
      gravityOnButton.addActionListener(this);
      this.add(gravityOnButton);
      JButton gravityOffButton = new JButton("GRAVITY OFF");
      gravityOffButton.addActionListener(this);
      this.add(gravityOffButton);
   }
   public void actionPerformed(ActionEvent ae)
   {
      //JOptionPane.showMessageDialog(null, "Button Pressed!" );
      System.out.println("Button Pressed!" );
      if( ae.getActionCommand().equalsIgnoreCase("Add") )
      {
         drawScreen.addShape();
      }
      else if( ae.getActionCommand().equalsIgnoreCase("Remove") )
      {
         drawScreen.removeShape();
      }
      else if( ae.getActionCommand().equalsIgnoreCase("GRAVITY ON") )
      {
         drawScreen.setGravity(true);
      }
      else if( ae.getActionCommand().equalsIgnoreCase("GRAVITY Off") )
      {
         drawScreen.setGravity(false);
      }
      else if( ae.getActionCommand().equalsIgnoreCase("Start") )
      {
         drawScreen.setPause(false);
      }
      else if( ae.getActionCommand().equalsIgnoreCase("Stop") )
      {
         drawScreen.setPause(true);
      }
   }
}