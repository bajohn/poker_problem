package poker;

import java.util.ArrayList;

/**
 * Created by bjohn454 on 6/28/2016.
 */
public class Hand {

    public ArrayList<Card> cards;

    public String toString()
    {
        String outString = "";
        for(int i = 0; i<5; i++)
        {
            outString+= cards.get(i).value.toString() + " of " + cards.get(i).suit.toString() + ", ";
        }
        return outString;
    }
    public Hand(Card cardOne, Card cardTwo, Card cardThree, Card cardFour, Card cardFive)
    {
        this.cards =  new ArrayList<>();
        this.cards.add(cardOne);
        this.cards.add(cardTwo);
        this.cards.add(cardThree);
        this.cards.add(cardFour);
        this.cards.add(cardFive);
     }

}
