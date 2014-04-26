import java.util.ArrayList;
import java.util.Random;
import java.util.Collections;

// Isaiah Simon
// CS 110
// Deck

/**
   The Deck class holds the information about a deck object.
*/

public class Deck
{ 
   //Declare Constants
   final static int SUIT_CARD_AMOUNT = 14; //The amount of cards in each suit
   ArrayList<Card> deck = new ArrayList<Card>(); 

   /**
   This constructor creates a deck of cards
   */

   public Deck()
   {
      newDeck();
   }
   
   public void newDeck ()
   {
      for(int i=2; i <= SUIT_CARD_AMOUNT; i++)
      {
         //Adding heart cards
         Card c1 = new Card('h',i);
         deck.add(c1);
         
         //Adding spade cards
         Card c2 = new Card('s',i);
         deck.add(c2);
         
         //Adding club cards
         Card c3 = new Card('c',i);
         deck.add(c3);
         
         //Adding diamond cards
         Card c4 = new Card('d',i);
         deck.add(c4);
      }
   }
   
   public Card getCard(int i)
   {
      return deck.get(i);    
   }
   
   public ArrayList<Card> shuffle()
   {
       Collections.shuffle(deck);
       
       return deck;
   }
   
}  