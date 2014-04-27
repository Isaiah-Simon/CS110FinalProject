import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

// Isaiah Simon
// CS 110
// War GUI

public class WarGUI extends JFrame
{
   private JPanel topPanel;
   private JPanel bottomPanel;
   
   private JLabel player1Hand;
   private JLabel player1Pile;
   private JLabel player2Hand;
   private JLabel player2Pile;
   private JLabel message;
   
   private JButton next;
   
   private ImageIcon cardBackImage;
   
   public WarGUI() throws FileNotFoundException
   {
      setLayout(new GridLayout(2,1));
      topPanel = new JPanel();
      topPanel.setLayout(new GridLayout(1,4));
      
      try
      {
         cardBackImage = new ImageIcon(ImageIO.read(new File("images/back.jpg")));
      }
      catch (IOException ex)
      {
         throw new FileNotFoundException("Card image: back.jpg not found.");
      }
      
      player1Pile = new JLabel(cardBackImage);
      player2Pile = new JLabel(cardBackImage);
   
      topPanel.add(player1Pile); 
      topPanel.add(player1Hand);     
      topPanel.add(player2Pile);     
      topPanel.add(player2Hand); 
      
      bottomPanel = new JPanel(new GridLayout(2,1));
      message = new JLabel("");
      next = new JButton("Begin Game");     
      
      bottomPanel.add(message);
      bottomPanel.add(next);   
      
      this.add(topPanel);
      this.add(bottomPanel); 
         
   }
   


}