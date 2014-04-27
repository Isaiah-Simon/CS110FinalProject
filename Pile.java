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
   public static int WAR_CARD_AMOUNT = 3;
 
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
   @param A card that goes to the top of the pile
   */
  
   public void addCard(Card c)
   {
      Card c2 = new Card(c);
      pile.add(c2);
   }
   
   /**
   addCardTo
   @param A card that you want to add to the specifc place in the pile
   @param An int that is where you want the card to be added
   */
  
   public void addCard(int i, Card c)
   {
      Card c2 = new Card(c);
      pile.add(i,c2);
   }
   
   /**
   getCard
   @param i The card number that you want
   @return A Card object
   */
   
   public Card getCard(int i)
   {
      return pile.get(i);    
   }
   
   /**
   draw
   @param i The card number that you want
   @return A Card object
   */
   
   public Card draw(int i)
   {
      Card card = new Card(pile.get(i));  
      pile.remove(i);
      return card; 
   }
   
   /**
   isEmpty
   @return A boolean if the pile is empty
   */
   
   public boolean isEmpty()
   {
       return pile.isEmpty();
   }
   
   /**
   warDraw
   @param p The pile they are being removed from
   @return An array of the cards that were removed
   */
   
   public ArrayList<Card> warDraw(Pile p)
   {
      ArrayList<Card> cards = new ArrayList<Card>(); 
      
      for(int i=0; i < WAR_CARD_AMOUNT; i++)
      {
         Card c = new Card(p.getCard(p.size()-1));
         p.draw(p.size()-1);
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