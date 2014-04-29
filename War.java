import java.util.Scanner;
import java.util.ArrayList;

// Isaiah Simon
// CS 110
// War

/**
   The War class holds the information about a war game object
*/

public class War
{
   private Deck deck;
   private Pile player1;
   private Pile player2;
   
   /**
   This constructor initializes the deck, and both player piles
   It also shuffles the deck and splits the deck into two piles
   */
   
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
   
   /**
   getPlayer1Pile
   @return A pile object from player 1
   */
   
   public Pile getPlayer1Pile()
   {
      return player1;
   }
   
   /**
   getPlayer1Pile
   @return A pile object from player 2
   */
   
   public Pile getPlayer2Pile()
   {
      return player2;
   }
   
   /**
   getPlayer1Size
   @return An int that is the size of the player 1 pile
   */
   
   public int getPlayer1Size()
   {
      return player1.size();
   }
   
   /**
   getPlayer2Size
   @return An int that is the size of the player 2 pile
   */
   
   public int getPlayer2Size()
   {
      return player2.size();
   }
   
   /**
   getPlayer1TopCard
   @return A card that is the top card of the pile from pile 1
   */
   
   public Card getPlayer1TopCard()
   {
      if(player1.isEmpty())
         return null;
      else
         return player1.getCard(player1.size()-1);
   }
   
   /**
   getPlayer2TopCard
   @return A card that is the top card of the pile from pile 2
   */
   
   public Card getPlayer2TopCard()
   {
      if(player2.isEmpty())
         return null;
      else
         return player2.getCard(player2.size()-1);
   }
   
   /**
   compareTopCards
   @return An int that is the eqauality of the top two cards
   */
   
   public int compareTopCards()
   {
      return player1.getCard(player1.size()-1).compareTo(player2.getCard(player2.size()-1));
   }
   
   /**
   addToPlayer1
   Adds cards player 1 pile
   */
   
   public void addToPlayer1()
   {
       player1.addCard(0,player1.draw(player1.size()-1));
       player1.addCard(0,player2.draw(player2.size()-1));
   }
   
   /**
   addToPlayer2
   Adds cards player 2 pile
   */
   
   public void addToPlayer2()
   {
       player2.addCard(0,player2.draw(player2.size()-1));
       player2.addCard(0,player1.draw(player1.size()-1));
   }
   
   /**
   warAddtoPlayer1
   @param s an int that is the number of times to loops through
   @param p1 Array list of pile 1
   @param p2 Array list of pile 2
   */
   
   public void warAddtoPlayer1(int s, ArrayList p1, ArrayList p2)
   {
      //Adds card to the player 1 pile
      for(int i=0; i<s; i++)
      {
         if(i<p1.size())
         {
            Object obj1 = p1.get(0);
            Card c1 = (Card)obj1;
            player1.addCard(0,c1);
         }
         
         if(i<p2.size())
         {
            Object obj2 = p2.get(0);
            Card c2 = (Card)obj2;
            player1.addCard(0,c2);
         }
      }
   }
   
   /**
   warAddtoPlayer2
   @param s an int that is the number of times to loops through
   @param p1 Array list of pile 1
   @param p2 Array list of pile 2
   */
   
   public void warAddtoPlayer2(int s, ArrayList p1, ArrayList p2)
   {
      //Adds card to the player 2 pile
      for(int i=0; i<s; i++)
      {
         if(i<p1.size())
         {
            Object obj1 = p1.get(0);
            Card c1 = (Card)obj1;
            player2.addCard(0,c1);
         }
         
         if(i<p2.size())
         {
            Object obj2 = p2.get(0);
            Card c2 = (Card)obj2;
            player2.addCard(0,c2);
         }
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
     
     ArrayList<Card> totalCards = new ArrayList<Card>();
  
     try
     {
       while((!((w.getPlayer1Pile().isEmpty() && w.getPlayer2Pile().isEmpty())))&& decision.equals("y"))
       {
         
         //Comparision of the two cards
         int compare = w.compareTopCards();
         System.out.println("\nPlayer 1's Card: " + w.getPlayer1TopCard());
         System.out.println("Player 2's Card: " + w.getPlayer2TopCard());
         
         System.out.println("Player 1's pile size: " + w.getPlayer1Size());
         System.out.println("Player 2's pile size: " + w.getPlayer2Size());
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
            
            System.out.println("\nWAR!!");
            System.out.println("Deal for war? y/n");
            decision = in.nextLine();
            
            int warCompare = 0;
            
            while(warCompare == 0 && decision.equals("y"))
            {
               //Creates Array Lists for cards for war
               ArrayList<Card> player1War = w.getPlayer1Pile().warDraw(w.getPlayer1Pile());
               player1War.add(0,w.getPlayer1TopCard());
               
               ArrayList<Card> player2War = w.getPlayer2Pile().warDraw(w.getPlayer2Pile());
               player2War.add(0,w.getPlayer2TopCard());
               
               //Checks card after 3 pulled face down
               warCompare = player1War.get(3).compareTo(player2War.get(3));
               System.out.println("One drawn faced down");
              
               //Prints out the fourth card that was drawn
               System.out.println("Player1's second card: " + player1War.get(3));
               System.out.println("Player2's second card: " + player2War.get(3));
                  
                  if(warCompare == 1)
                  {
                     //Checks if there are cards left over from last war
                     try
                     {
                        int tcSize = totalCards.size();
                        while(totalCards.get(0) != null)
                        {
                          player1War.add(totalCards.get(0));
                          totalCards.remove(0);
                        }
                     }
                     catch(IndexOutOfBoundsException exception)
                     {
                     
                     }
                  
                     //Takes cards from piles and adds to player1 pile
                     w.warAddtoPlayer1(player1War.size(),player1War,player2War);

                     System.out.println("\nPlayer 1 wins the war");
                  }
                  
                  if(warCompare == -1)
                  {
                     //Checks if there are cards left over from last war
                     try
                     {
                        int tcSize = totalCards.size();
                        while(totalCards.get(0) != null)
                        {
                          player2War.add(totalCards.get(0));
                          totalCards.remove(0);
                        }
                     }
                     catch(IndexOutOfBoundsException exception)
                     {
                     
                     }

                  
                     //Takes cards from piles and adds to player2 pile
                     w.warAddtoPlayer2(player1War.size(),player1War,player2War);
                     
                     System.out.println("\nPlayer 2 wins the war");
                  }
                  
                  //Continues war if needed
                  if(warCompare == 0)
                  {
                     int p1Size = player1War.size();
                     int p2Size = player2War.size();
                     
                     //Adds into an array so the cards don't disappear between different wars
                     for(int i = 0; i<p1Size; i++)
                     {
                        totalCards.add(player1War.get(i));
                     }
                     
                     for(int i = 0; i<p2Size; i++)
                     {
                        totalCards.add(player1War.get(i));
                     }

                  
                     System.out.println("\nThe War continues");
                     System.out.println("Deal for war? y/n");                
                     decision = in.nextLine();
                  }
                  
              }
              
              compare = 1;
                           
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