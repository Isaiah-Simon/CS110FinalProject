import java.util.Scanner;
import java.util.ArrayList;

// Isaiah Simon
// CS 110
// War

public class War
{
   private Deck deck;
   private Pile player1;
   private Pile player2;
   
   public War()
   {
     deck = new Deck();
     player1 = new Pile();
     player2 = new Pile();
     
     //Shuffles the deck
     deck.shuffle();
     
     //Splits deck into two piles
     for(int i=0; i<52; i+=2)
     {
        Card tempCard1 = new Card(deck.getCard(i));
        Card tempCard2 = new Card(deck.getCard(i+1));
        
        player1.addCard(tempCard1);
        player2.addCard(tempCard2);
     }

   }
   
   public Pile getPlayer1Pile()
   {
      return player1;
   }
   
   public Pile getPlayer2Pile()
   {
      return player2;
   }
   
   public int getPlayer1Size()
   {
      return player1.size();
   }
   
   public int getPlayer2Size()
   {
      return player2.size();
   }
   
   public Card getPlayer1TopCard()
   {
      if(player1.isEmpty())
         return null;
      else
         return player1.getCard(player1.size()-1);
   }
   
   public Card getPlayer2TopCard()
   {
      if(player2.isEmpty())
         return null;
      else
         return player2.getCard(player2.size()-1);
   }
   
   public int compareTopCards()
   {
      return player1.getCard(player1.size()-1).compareTo(player2.getCard(player2.size()-1));
   }
   
   public void addToPlayer1()
   {
       player1.addCard(0,player1.draw(player1.size()-1));
       player1.addCard(0,player2.draw(player2.size()-1));
   }
   
   public void addToPlayer2()
   {
       player2.addCard(0,player2.draw(player2.size()-1));
       player2.addCard(0,player1.draw(player1.size()-1));
   }
   
   public void warAddtoPlayer1(int s, ArrayList p1, ArrayList p2)
   {
      for(int i=0; i<s; i++)
      {
         Object obj1 = p1.get(i);
         Card c1 = (Card)obj1;
         
         Object obj2 = p2.get(i);
         Card c2 = (Card)obj2;
         
         player1.addCard(0,c1);
         player1.addCard(0,c2);
      }
   }
   
   public void warAddtoPlayer2(int s, ArrayList p1, ArrayList p2)
   {
      for(int i=0; i<s; i++)
      {
         Object obj1 = p1.get(i);
         Card c1 = (Card)obj1;
         
         Object obj2 = p2.get(i);
         Card c2 = (Card)obj2;
         
         player2.addCard(0,c1);
         player2.addCard(0,c2);
      }
   }
   

   
   public static void main(String [] args)
   {
     // declare variables
     War w = new War();
     String decision;
          
     System.out.println("Let the game begin!");
     
     //Asks if the user wants to deal
     System.out.println("Deal? y/n");
     Scanner in = new Scanner(System.in);
     decision = in.nextLine();
     
     try
     {
       while((!((w.getPlayer1Pile().isEmpty() && w.getPlayer2Pile().isEmpty())))&& decision.equals("y"))
       {
         
         //Comparision of the two cards
         int compare = w.compareTopCards();
         System.out.println("\nPlayer 1's Card: " + w.getPlayer1TopCard());
         System.out.println("Player 2's Card: " + w.getPlayer2TopCard());
         //If the player1 card is higher
         if(compare == 1)
         {
            
            System.out.println("\nPlayer 1 wins!");
            w.addToPlayer1();

            
         }
         
         //If the player1 card is lower
         if(compare == -1)
         {
            System.out.println("\nPlayer 2 wins!");
            w.addToPlayer2();
            

            
         }
         
         //If player1 card and player2 card are the same
         while(compare == 0)
         {
            
            System.out.println("\nWA!!");
            System.out.println("Deal for war? y/n");
            decision = in.nextLine();
            
            int warCompare = 0;
            
            while(warCompare == 0 && decision.equals("y"))
            {
               ArrayList<Card> player1War = w.getPlayer1Pile().warDraw(w.getPlayer1Pile());
               player1War.add(0,w.getPlayer1TopCard());
               
               ArrayList<Card> player2War = w.getPlayer2Pile().warDraw(w.getPlayer2Pile());
               player2War.add(0,w.getPlayer2TopCard());
               
               //Checks card after 3 pulled face down
               warCompare = player1War.get(1).compareTo(player2War.get(1));
               System.out.println("One drawn faced down");
              
               //Prints out the fourth card that was drawn
               System.out.println("Player1's second card: " + player1War.get(1));
               System.out.println("Player2's second card: " + player2War.get(1));
                  
                  if(warCompare == 1)
                  {
                     //Takes cards from piles and adds to player1 pile
                     w.warAddtoPlayer1(player1War.size(),player1War,player2War);
                     System.out.println("\nPlayer 1 wins the war");
                  }
                  
                  if(warCompare == -1)
                  {
                     //Takes cards from piles and adds to player2 pile
                     w.warAddtoPlayer2(player1War.size(),player1War,player2War);
                     
                     System.out.println("\nPlayer 2 wins the war");
                  }
                  
                  //Continues war if needed
                  if(warCompare == 0)
                  {
                     System.out.println("\nThe War continues");
                     System.out.println("Deal for war? y/n");                
                     decision = in.nextLine();
                  }
                  
              }
              
//               compare = 1;
                           
         }
         
         System.out.println("Deal? y/n");
         decision = in.nextLine();
      
       }
       if(!decision.equals("y"));
       {
         System.out.println("Thanks for playing");
       }
           
     } 
     catch (IndexOutOfBoundsException theException)  //tries to catch this type...
     {
         
         if(w.getPlayer1Size() == 0)
            System.out.println("Winner is Player 2" );

       

         if(w.getPlayer2Size() == 0)
            System.out.println("Winner is Player 1" );
    
     }       
     
   }
   
}