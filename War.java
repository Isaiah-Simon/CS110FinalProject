import java.util.Scanner;

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
     
     
     
   }
   
}