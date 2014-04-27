import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

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
   private JButton warButton;
   
   private War w;
   
   private ImageIcon cardBackImage;
   
   public WarGUI() throws FileNotFoundException
   {
      setLayout(new GridLayout(2,1));
      topPanel = new JPanel();
      topPanel.setLayout(new GridLayout(1,4));
      w = new War();
      
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
      player1Hand = new JLabel();
      player2Hand = new JLabel();
   
      topPanel.add(player1Pile); 
      topPanel.add(player1Hand);  
      topPanel.add(player2Hand);    
      topPanel.add(player2Pile);     

      
      bottomPanel = new JPanel(new GridLayout(2,1));
      message = new JLabel("The war has begun");
      next = new JButton("Begin Game"); 
      next.addActionListener(new ButtonListener());   
      
      bottomPanel.add(message);
      bottomPanel.add(next);   
      
      this.add(topPanel);
      this.add(bottomPanel); 
         
   }
   
   private void updatePlayer1Image()
   {
      if(w.getPlayer1Size() != 0)
      {
         player1Hand.setIcon(new ImageIcon(w.getPlayer1TopCard().getCardImage()));
      }
      else
      {
         message.setText("Player 2 Wins");
         next.setEnabled(false);
         warButton.setEnabled(false);
      }
   }
   
   private void updatePlayer1Image(Card c)
   {
      if(w.getPlayer1Size() != 0)
      {
         player1Hand.setIcon(new ImageIcon(c.getCardImage()));
      }
      else
      {
         message.setText("Player 2 Wins");
         next.setEnabled(false);
         warButton.setEnabled(false);
      }
   }
   
   private void updatePlayer2Image()
   {
      if(w.getPlayer2Size() != 0)
      {
         player2Hand.setIcon(new ImageIcon(w.getPlayer2TopCard().getCardImage()));
      }
      else
      {
         message.setText("Player 1 Wins");
         next.setEnabled(false);
         warButton.setEnabled(false);
      }
   }
   
   private void updatePlayer2Image(Card c)
   {
      if(w.getPlayer2Size() != 0)
      {
         player2Hand.setIcon(new ImageIcon(c.getCardImage()));
      }
      else
      {
         message.setText("Player 1 Wins");
         next.setEnabled(false);
         warButton.setEnabled(false);
      }
   }
   
   public void updateMessage()
   {
      String newMessage =
    			  "<html><br>Player 1's hand size: " + w.getPlayer1Size()
    			+ "<br>Player 2's hand size: " + w.getPlayer2Size()
    			+ "</html>";
      
      message.setText(newMessage);	
   }
   
   
   
   private class ButtonListener implements ActionListener
   {
      public void actionPerformed(ActionEvent e) throws ArrayIndexOutOfBoundsException
      {
         try
         {
            next.setText("Draw");
            updatePlayer1Image();
            updatePlayer2Image();
            
            int compare = w.compareTopCards();
            //If the player1 card is higher
            
            if(compare == 1)
            {
               message.setText("Player 1 wins this round!");
            
               String newMessage =
          			  "<html><br>" + message.getText() + "<br>Player 1's hand size: " + w.getPlayer1Size()
          			+ "<br>Player 2's hand size: " + w.getPlayer2Size()
          			+ "</html>";
               
               message.setText(newMessage);
               w.addToPlayer1();
               
   
               
            }
            
            //If the player1 card is lower
            if(compare == -1)
            {
               message.setText("Player 2 wins this round!");

            
               String newMessage =
          			  "<html><br>" + message.getText() + "<br>Player 1's hand size: " + w.getPlayer1Size()
          			+ "<br>Player 2's hand size: " + w.getPlayer2Size()
          			+ "</html>";
               
               message.setText(newMessage);
               w.addToPlayer2();
            }
            
            
            if(compare == 0)
            {
               message.setText("WAR!");
               bottomPanel.remove(next);
               warButton = new JButton("A war has occured");
               warButton.addActionListener(new WarButtonListener());
               bottomPanel.add(warButton);
             }  
             
         }
         catch (ArrayIndexOutOfBoundsException ex)
         {
            if(w.getPlayer1Size() == 0)
            {
               message.setText("Player 2 wins the game!");
               next.setEnabled(false);
            }
            
            if(w.getPlayer2Size() == 0)
            {
               message.setText("Player 1 wins the game!");
               next.setEnabled(false);
            }
         }

       }
         
   }
   
   private class WarButtonListener implements ActionListener
   {
     ArrayList<Card> totalCards = new ArrayList<Card>();
   
     public void actionPerformed(ActionEvent e) throws ArrayIndexOutOfBoundsException
     {
      try
      {
         ArrayList<Card> player1War = w.getPlayer1Pile().warDraw(w.getPlayer1Pile());
         player1War.add(0,w.getPlayer1TopCard());
         
         ArrayList<Card> player2War = w.getPlayer2Pile().warDraw(w.getPlayer2Pile());
         player2War.add(0,w.getPlayer2TopCard());
         
         int test = w.getPlayer1Size();
         int test2 = w.getPlayer2Size();
         
         message.setText(player1War.get(2).getCardImage());
         updatePlayer1Image(player1War.get(2));
         updatePlayer2Image(player2War.get(2));
            
            
         //Checks card after 1 pulled face down
         int warCompare = player1War.get(2).compareTo(player2War.get(2));
         
         if(warCompare == 1)
            {  
               try
               {
                  for(int i = 0; i<totalCards.size(); i++)
                  {
                    player1War.add(totalCards.get(i));
                    totalCards.remove(i);
                  }
               }
               catch(IndexOutOfBoundsException IOOBE)
               {
               
               }
            
               //Takes cards from piles and adds to player1 pile
               w.warAddtoPlayer1(player1War.size(),player1War,player2War);
               message.setText("Player 1 wins the war");
               
               String newMessage =
          			  "<html><br>" + message.getText() + "<br>Player 1's hand size: " + w.getPlayer1Size()
          			+ "<br>Player 2's hand size: " + w.getPlayer2Size()
          			+ "</html>";
         
               message.setText(newMessage);
               
               bottomPanel.remove(warButton);
               bottomPanel.add(next);

               

            }
            
            if(warCompare == -1)
            {
               try
               {
                  for(int i = 0; i<totalCards.size(); i++)
                  {
                    player2War.add(totalCards.get(i));
                    totalCards.remove(i);
                  }
               }
               catch(IndexOutOfBoundsException IOOBE)
               {
               
               }
            
               //Takes cards from piles and adds to player2 pile
               w.warAddtoPlayer2(player1War.size(),player1War,player2War);
                  
               message.setText("Player 2 wins the war");
               String newMessage =
          			  "<html><br>" + message.getText() + "<br>Player 1's hand size: " + w.getPlayer1Size()
          			+ "<br>Player 2's hand size: " + w.getPlayer2Size()
          			+ "</html>";
         
               message.setText(newMessage);
               
               bottomPanel.remove(warButton);
               bottomPanel.add(next);

            }
            
            //Continues war if needed
            if(warCompare == 0)
            {
               message.setText("The war continues");
               
               String newMessage =
          			  "<html><br>" + message.getText() + "<br>Player 1's hand size: " + w.getPlayer1Size()
          			+ "<br>Player 2's hand size: " + w.getPlayer2Size()
          			+ "</html>";
         
               message.setText(newMessage);
               
               //Adds into an array so the cards don't disappear between different wars
               for(int i = 0; i<player1War.size(); i++)
               {
                  totalCards.add(player1War.get(i));
                  totalCards.add(player2War.get(i));
               }
               
               
            } 
      }
      catch (ArrayIndexOutOfBoundsException warEx)
      {
         if(w.getPlayer1Size() == 0)
         {
            message.setText("Player 2 wins the game!");
            warButton.setEnabled(false);
         }
         
         if(w.getPlayer2Size() == 0)
         {
            message.setText("Player 1 wins the game!");
            warButton.setEnabled(false);  
         }
      }
     }         
   }
   
   public static void main(String[] args) throws FileNotFoundException
   {
        WarGUI gui;
        try
        {
          gui = new WarGUI();  
        }
        catch (FileNotFoundException ex)
        {
            throw new FileNotFoundException("Card image: back.jpg not found.");
        }
        gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        gui.setSize(700,500);
        gui.setVisible(true);
    }
}