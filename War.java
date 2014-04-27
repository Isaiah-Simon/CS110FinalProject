import java.util.Scanner;
import java.util.ArrayList;

// Isaiah Simon
// CS 110
// War

public class War
{
   public static void main(String [] args)
   {
     // declare variables
     Deck deck = new Deck();
     Pile player1 = new Pile();
     Pile player2 = new Pile();
     
     String decision;
     
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
     
     System.out.println("Let the game begin!");
     
     //Asks if the user wants to deal
     System.out.println("Deal? y/n");
     Scanner in = new Scanner(System.in);
     decision = in.nextLine();
     
     try
     {
       while((!((player1.isEmpty() && player2.isEmpty())))&& decision.equals("y"))
       {
         
         System.out.println("\nPlayer 1 deck size: " +
         player1.size()+"\nPlayer 2 deck size " +player2.size());
         
         int compare = player1.getCard(player1.size()-1).compareTo(player2.getCard(player2.size()-1));
         compare = 0;
         System.out.println("\nPlayer 1's Card: " + player1.getCard(player1.size()-1));
         System.out.println("Player 2's Card: " + player2.getCard(player2.size()-1));
         
         if(compare == 1)
         {
            
            System.out.println("\nPlayer 1 wins!!!!!");
            
            player1.addCard(0,player1.draw(player1.size()-1));
            player1.addCard(0,player2.draw(player2.size()-1));
            
         }
         
         
         if(compare == -1)
         {
            System.out.println("\nPlayer 2 wins!!!!!");
            
            player2.addCard(0,player2.draw(player2.size()-1));
            player2.addCard(0,player1.draw(player1.size()-1));
            
         }
         
         while(compare == 0)
         {
            
            System.out.println("\nWAR!!");
            System.out.println("Deal? y/n");
            decision = in.nextLine();
            
            int warCompare = 0;
            
            while(warCompare == 0 && decision.equals("y"));
            {
               ArrayList<Card> player1War = player1.warDraw(player1);
               ArrayList<Card> player2War = player2.warDraw(player2);
               
               warCompare = player1War.get(3).compareTo(player2War.get(3));
               warCompare = 0;
                  if(warCompare == 1)
                  {
                     System.out.println("\nPlayer 1 wins the war");
                  }
                  
                  if(warCompare == -1)
                  {
                     System.out.println("\nPlayer 1 wins the war");
                  }
                  
                  if(warCompare == 0)
                  {
                     System.out.println("\nThe War continues");
                  }
                  
              }
                           
         }
         
         System.out.println("Deal? y/n");
         decision = in.nextLine();
      
       }    
     } 
     catch (IndexOutOfBoundsException theException)  //tries to catch this type...
     {
         
         if(player1.size() == 0)
            System.out.println("Winner is Player 2" );

       

         if(player2.size() == 0)
            System.out.println("Winner is Player 1" );
    
     }       
     
   }
   
}