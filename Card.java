// Isaiah Simon
// CS 110
// Card

/**
   The Card class holds the information about a card object.
*/

public class Card
{ 
   
   // Create Card Variables
   private int rank;
   private char suit;
   private String cardImage;
   
   /**
      This constructor initializes the rank
      and suit variable
      @param rank The cards rank
      @param suit The cards suit
   */
   
   public Card (char suit, int rank)
   {
      this.suit = suit;
      this.rank = rank;
      
      setCardImage(suit, rank);
   }
   
   /**
   This constructor initializes the rank
   and suit variable
   @param rank The cards rank
   @param suit The cards suit
   */
   
   public Card (Card c)
   {
      this.suit = c.getSuit();
      this.rank = c.getRank();  
      
      setCardImage(c);
   }
   
   //Mutators are not included as a card cannot be changed after it has been created.
   
   /**
      getSuit method
      @return An int containing the suit of the card.
   */
   
   public char getSuit()
   {
      return suit;
   }
   
   /**
      getRank method
      @return An int containing the rank of the card.
   */
   
   public int getRank()
   {
      return rank;
   }
   
   
   /**
      setCardImage
      @param suit A character that is the suit
      @param rank An int that is the rank
   */
   
   private void setCardImage(char suit, int rank)
   {
      String rankStr;
   
      if(rank == 11)
      {
         rankStr = "jack";
      }
      else if(rank == 12)
      {
         rankStr = "queen";
      }
      else if(rank == 13)
      {
         rankStr = "king";
      }
      else if(rank == 14)
      {
        rankStr = "ace";
      }
      else
      {
         rankStr = rank + "";
      }
      
      cardImage = "images/" + rankStr + suit + ".jpg";
   }
   
   /**
      setCardImage
      @param c A card that contains rank and suit
   */
   
   private void setCardImage(Card c)
   {
      String rankStr;
   
      if(c.getRank() == 11)
      {
         rankStr = "jack";
      }
      else if(c.getRank() == 12)
      {
         rankStr = "queen";
      }
      else if(c.getRank() == 13)
      {
         rankStr = "king";
      }
      else if(c.getRank() == 14)
      {
        rankStr = "ace";
      }
      else
      {
         rankStr = rank + "";
      }
      
      cardImage = "images/" + rankStr + c.getSuit() + ".jpg";
   }
   
   /**
   getCardImage
   @return An string of the image for the card
   */
   
   public String getCardImage()
   {
      return cardImage;
      
   }
   
   
   /**
      toString method
      @return A string indicating the object's
              suit and rank
              Ex: 4c = Four of clubs
   */
   
   public String toString()
   {
      String rankStr = null;
      
      if(rank == 11)
      {
         rankStr = "jack";
         String str = rankStr+suit;
         return str;
      }
      else if(rank == 12)
      {
         rankStr = "queen";
         String str = rankStr+suit;
         return str;
      }
      else if(rank == 13)
      {
         rankStr = "king";
         String str = rankStr+suit;
         return str;
      }
      else if(rank == 14)
      {
        rankStr = "ace";
        String str = rankStr+suit;
        return str;
      }
      else
      {
        String str = rank + "" + suit;
        return str;
      }  
     
   }
   
   /**
    compareTo method is used to compare two card objects based on their rank.
    @return A number based on the comparisions of the cards. If it is 1, this card object is higher.
    If it is -1, the other card object is higher. If it is 0, they are the same rank.
   */
   
   public int compareTo(Card other)
   {
      if(this.rank > other.getRank())
         return 1;
      
      if(this.rank < other.getRank())
         return -1;
         
         else
         {
            return 0;
         }
    }
}