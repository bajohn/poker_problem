package poker;

import java.util.ArrayList;

import static poker.Poker.evaluateHand;

/**
 * Created by 587177 on 9/7/2016.
 */
public class testScript {

    public static void main(String arg[])
    {
        {
            //both have pair of 9's, first kicker decides
            Card cardOne = new Card(Card.CardVals.NINE, Card.Suits.HEARTS);
            Card cardTwo = new Card(Card.CardVals.TWO, Card.Suits.CLUBS);
            Card cardThree = new Card(Card.CardVals.SEVEN, Card.Suits.HEARTS);
            Card cardFour = new Card(Card.CardVals.FIVE, Card.Suits.HEARTS);
            Card cardFive = new Card(Card.CardVals.THREE, Card.Suits.DIAMONDS);

            Card pocketA = new Card(Card.CardVals.NINE, Card.Suits.DIAMONDS);
            Card pocketB = new Card(Card.CardVals.KING, Card.Suits.SPADES);

            ArrayList<Card> pocketCards = new ArrayList<>();
            pocketCards.add(pocketA);
            pocketCards.add(pocketB);


            Hand boardCards = new Hand(cardOne, cardTwo, cardThree, cardFour, cardFive);


            Card pocketTwoA = new Card(Card.CardVals.NINE, Card.Suits.CLUBS);
            Card pocketTwoB = new Card(Card.CardVals.QUEEN, Card.Suits.CLUBS);

            ArrayList<Card> pocketCardsTwo = new ArrayList<>();
            pocketCardsTwo.add(pocketTwoA);
            pocketCardsTwo.add(pocketTwoB);

            double valOne = evaluateHand(pocketCards, boardCards.cards);
            double valTwo = evaluateHand(pocketCardsTwo, boardCards.cards);

            System.out.print("\ntest one:");
            System.out.print("\n" + valOne);
            System.out.print("\n" + valTwo);
            assert(valOne > valTwo);
        }
        {
            //both have pair of 9's, third kicker decides
            Card cardOne = new Card(Card.CardVals.ACE, Card.Suits.HEARTS);
            Card cardTwo = new Card(Card.CardVals.QUEEN, Card.Suits.CLUBS);
            Card cardThree = new Card(Card.CardVals.THREE, Card.Suits.HEARTS);
            Card cardFour = new Card(Card.CardVals.NINE, Card.Suits.HEARTS);
            Card cardFive = new Card(Card.CardVals.SIX, Card.Suits.DIAMONDS);

            Card pocketA = new Card(Card.CardVals.NINE, Card.Suits.DIAMONDS);
            Card pocketB = new Card(Card.CardVals.SEVEN, Card.Suits.SPADES);

            Card pocketTwoA = new Card(Card.CardVals.NINE, Card.Suits.CLUBS);
            Card pocketTwoB = new Card(Card.CardVals.TWO, Card.Suits.CLUBS);
            ArrayList<Card> pocketCards = new ArrayList<>();
            pocketCards.add(pocketA);
            pocketCards.add(pocketB);


            Hand boardCards = new Hand(cardOne, cardTwo, cardThree, cardFour, cardFive);




            ArrayList<Card> pocketCardsTwo = new ArrayList<>();
            pocketCardsTwo.add(pocketTwoA);
            pocketCardsTwo.add(pocketTwoB);

            double valOne = evaluateHand(pocketCards, boardCards.cards);
            double valTwo = evaluateHand(pocketCardsTwo, boardCards.cards);
            System.out.print("\ntest two:");
            System.out.print("\n" + valOne);
            System.out.print("\n" + valTwo);
            assert(valOne > valTwo);
        }










//        if(valOne > valTwo)
//        {
//            System.out.print("\n\nFirst hand better than second");
//            System.out.print("\n" + valOne);
//            System.out.print("\n" + valTwo);
//        }
//        else if(valOne < valTwo)
//        {
//            System.out.print("Second hand better than first");
//            System.out.print("\n" + valOne);
//            System.out.print("\n" + valTwo);
//        }
//        else
//        {
//            System.out.print("Hands are equal");
//            System.out.print("\n" + valOne);
//            System.out.print("\n" + valTwo);
//        }



    }
}
