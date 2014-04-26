import java.util.ArrayList;
import java.util.Collections;

// Isaiah Simon
// CS 110
// Pile

/**
   The Pile class holds the information about a pile object.
*/

public class Pile extends Deck
{  
   //Declare Constants
   public static int WAR_CARD_AMOUNT = 4;
 
   //Declare Variables
   ArrayList<Card> pile = new ArrayList<Card>(); 

   /**
   This constructor creates a new pile of cards
   */
   Pile()
   {
   }
   
   /**
   size
   @return An int that is the size of the array
   */
  
   public int size()
   {
      return pile.size();
   }
   
   /**
   addCard
   @return An int that is the size of the array
   */
  
   public void addCard(Card c)
   {
      Card c2 = new Card(c);
      pile.add(c2);
   }
   
   
   
   public ArrayList<Card> warDraw(Pile p)
   {
      ArrayList<Card> cards = new ArrayList<Card>(); 
      
      for(int i=0; i < WAR_CARD_AMOUNT; i++)
      {
         Card c = new Card(p.getCard(p.size()-1));
         p.removeCard(i);
         cards.add(c);
      }
      
      return cards;
   }
   
   /**
   toString method
   @return A string containing the information 
           of every card in the array
   */
   
   public String toString()
   {
       return pile.toString();
   }
   


}