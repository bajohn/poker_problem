package poker;

import java.util.ArrayList;

import static poker.Poker.arrayToString;
import static poker.Poker.evaluateHand;
import static poker.Poker.getPermSizeSix;

/**
 * Created by 587177 on 9/7/2016.
 */
public class Final {

    //methods and things unique to original question are here

    public static ArrayList<Card> createRemainingDeck() {
        //Let's just do the deck manually:
        ArrayList<Card> deck = new ArrayList<>();
        //deck.add(new Card(Card.CardVals.TWO, Card.Suits.CLUBS));
        deck.add(new Card(Card.CardVals.TWO, Card.Suits.DIAMONDS));
        deck.add(new Card(Card.CardVals.TWO, Card.Suits.HEARTS));
        deck.add(new Card(Card.CardVals.TWO, Card.Suits.SPADES));

        deck.add(new Card(Card.CardVals.THREE, Card.Suits.CLUBS));
        deck.add(new Card(Card.CardVals.THREE, Card.Suits.DIAMONDS));
        deck.add(new Card(Card.CardVals.THREE, Card.Suits.HEARTS));
        deck.add(new Card(Card.CardVals.THREE, Card.Suits.SPADES));

        deck.add(new Card(Card.CardVals.FOUR, Card.Suits.CLUBS));
        deck.add(new Card(Card.CardVals.FOUR, Card.Suits.DIAMONDS));
        deck.add(new Card(Card.CardVals.FOUR, Card.Suits.HEARTS));
        deck.add(new Card(Card.CardVals.FOUR, Card.Suits.SPADES));

        deck.add(new Card(Card.CardVals.FIVE, Card.Suits.CLUBS));
        deck.add(new Card(Card.CardVals.FIVE, Card.Suits.DIAMONDS));
        deck.add(new Card(Card.CardVals.FIVE, Card.Suits.HEARTS));
        //deck.add(new Card(Card.CardVals.FIVE, Card.Suits.SPADES));

        //deck.add(new Card(Card.CardVals.SIX, Card.Suits.CLUBS));
        deck.add(new Card(Card.CardVals.SIX, Card.Suits.DIAMONDS));
        deck.add(new Card(Card.CardVals.SIX, Card.Suits.HEARTS));
        deck.add(new Card(Card.CardVals.SIX, Card.Suits.SPADES));

        deck.add(new Card(Card.CardVals.SEVEN, Card.Suits.CLUBS));
        deck.add(new Card(Card.CardVals.SEVEN, Card.Suits.DIAMONDS));
        //deck.add(new Card(Card.CardVals.SEVEN, Card.Suits.HEARTS));
        deck.add(new Card(Card.CardVals.SEVEN, Card.Suits.SPADES));

        deck.add(new Card(Card.CardVals.EIGHT, Card.Suits.CLUBS));
        deck.add(new Card(Card.CardVals.EIGHT, Card.Suits.DIAMONDS));
        //deck.add(new Card(Card.CardVals.EIGHT, Card.Suits.HEARTS));
        deck.add(new Card(Card.CardVals.EIGHT, Card.Suits.SPADES));

        deck.add(new Card(Card.CardVals.NINE, Card.Suits.CLUBS));
        deck.add(new Card(Card.CardVals.NINE, Card.Suits.DIAMONDS));
        deck.add(new Card(Card.CardVals.NINE, Card.Suits.HEARTS));
        deck.add(new Card(Card.CardVals.NINE, Card.Suits.SPADES));

        deck.add(new Card(Card.CardVals.TEN, Card.Suits.CLUBS));
        deck.add(new Card(Card.CardVals.TEN, Card.Suits.DIAMONDS));
        deck.add(new Card(Card.CardVals.TEN, Card.Suits.HEARTS));
        deck.add(new Card(Card.CardVals.TEN, Card.Suits.SPADES));

        deck.add(new Card(Card.CardVals.JACK, Card.Suits.CLUBS));
        deck.add(new Card(Card.CardVals.JACK, Card.Suits.DIAMONDS));
        deck.add(new Card(Card.CardVals.JACK, Card.Suits.HEARTS));
        deck.add(new Card(Card.CardVals.JACK, Card.Suits.SPADES));

        deck.add(new Card(Card.CardVals.QUEEN, Card.Suits.CLUBS));
        deck.add(new Card(Card.CardVals.QUEEN, Card.Suits.DIAMONDS));
        deck.add(new Card(Card.CardVals.QUEEN, Card.Suits.HEARTS));
        deck.add(new Card(Card.CardVals.QUEEN, Card.Suits.SPADES));

        deck.add(new Card(Card.CardVals.KING, Card.Suits.CLUBS));
        deck.add(new Card(Card.CardVals.KING, Card.Suits.DIAMONDS));
        deck.add(new Card(Card.CardVals.KING, Card.Suits.HEARTS));
        deck.add(new Card(Card.CardVals.KING, Card.Suits.SPADES));

        //deck.add(new Card(Card.CardVals.ACE, Card.Suits.CLUBS));
        deck.add(new Card(Card.CardVals.ACE, Card.Suits.DIAMONDS));
        deck.add(new Card(Card.CardVals.ACE, Card.Suits.HEARTS));
        //deck.add(new Card(Card.CardVals.ACE, Card.Suits.SPADES));


        return deck;
    }
    public static ArrayList<String> crackArray;
    public static void checkHands(
            ArrayList<Card> pocketCardsA,   ArrayList<Card> pocketCardsB,   ArrayList<Card> pocketCardsC,   Hand boardCards, double valToBeat)
    {
        if(evaluateHand(pocketCardsA, boardCards.cards) > valToBeat &&
                evaluateHand(pocketCardsB, boardCards.cards) > valToBeat &&
                evaluateHand(pocketCardsC, boardCards.cards) > valToBeat)
        {
            //System.out.print("\n\nThese crack the aces:\n");
            String handString = "Hand 1: " + arrayToString(pocketCardsA) + ", Hand 2: " + arrayToString(pocketCardsB) + ", Hand 3: " + arrayToString(pocketCardsC);
            //System.out.print("Hand 1: " + arrayToString(pocketCardsA) + ", Hand 2: " + arrayToString(pocketCardsB) + ", Hand 3: " + arrayToString(pocketCardsC));
            if(!crackArray.contains(handString))
            {
                crackArray.add(handString);
            }
            else
            {
                System.out.print("\nError: repeated case!\n");
                System.out.print(handString);
            }


        }
    }

    public static void main(String arg[]) {
        crackArray = new ArrayList<>();
        //board is constant for this.
        //
        Card cardOne = new Card(Card.CardVals.TWO, Card.Suits.CLUBS);
        Card cardTwo = new Card(Card.CardVals.SEVEN, Card.Suits.HEARTS);
        Card cardThree = new Card(Card.CardVals.EIGHT, Card.Suits.HEARTS);
        Card cardFour = new Card(Card.CardVals.SIX, Card.Suits.CLUBS);
        Card cardFive = new Card(Card.CardVals.FIVE, Card.Suits.SPADES);


        Hand boardCards = new Hand(cardOne, cardTwo, cardThree, cardFour, cardFive);

        //Trying to beat this hand:
        Card pocketBeat_One = new Card(Card.CardVals.ACE, Card.Suits.CLUBS);
        Card pocketBeat_Two = new Card(Card.CardVals.ACE, Card.Suits.SPADES);


        ArrayList<Card> pocketCardsBeat = new ArrayList<>();
        pocketCardsBeat.add(pocketBeat_One);
        pocketCardsBeat.add(pocketBeat_Two);

        double valToBeat = evaluateHand(pocketCardsBeat, boardCards.cards);

        System.out.print("Val:" + valToBeat);


        ArrayList<Card> deck = createRemainingDeck();
        System.out.print("deck:" + deck.size());

        ArrayList<ArrayList<Integer>> perm = getPermSizeSix();

        double permSize = perm.size();
        System.out.print("\npermsize: " + permSize);
        for(int i = 0; i< permSize; i++)
        {
            //double iDouble = i;
            System.out.print("\nPROGRESS: " + i);
            ArrayList<Card> localSix = new ArrayList<>();
            ArrayList<Integer> permLocal = perm.get(i);
            for(Integer j : permLocal)
            {
                localSix.add(deck.get(j));
            }

            int numWinners = 0;
            for(Card cardLocal : localSix)
            {
                if(cardLocal.value.getVal()==2 || cardLocal.value.getVal()==5 || cardLocal.value.getVal()==6
                        || cardLocal.value.getVal()==7 || cardLocal.value.getVal()==8)
                {
                    numWinners+=1;
                }
                else if(cardLocal.value.getVal()==4 || cardLocal.value.getVal()==9)
                {
                    numWinners+=2;
                }
            }
            if(numWinners>5) {


                //System.out.print("\n" + arrayToString(localSix));

                ArrayList<Card> pocketCardsA = new ArrayList<>();
                pocketCardsA.add(localSix.get(0));
                pocketCardsA.add(localSix.get(1));

                ArrayList<Card> pocketCardsB = new ArrayList<>();
                pocketCardsB.add(localSix.get(2));
                pocketCardsB.add(localSix.get(3));

                ArrayList<Card> pocketCardsC = new ArrayList<>();
                pocketCardsC.add(localSix.get(4));
                pocketCardsC.add(localSix.get(5));

                checkHands(pocketCardsA, pocketCardsB, pocketCardsC, boardCards, valToBeat);


                pocketCardsA = new ArrayList<>();
                pocketCardsA.add(localSix.get(0));
                pocketCardsA.add(localSix.get(1));

                pocketCardsB = new ArrayList<>();
                pocketCardsB.add(localSix.get(2));
                pocketCardsB.add(localSix.get(4));

                pocketCardsC = new ArrayList<>();
                pocketCardsC.add(localSix.get(3));
                pocketCardsC.add(localSix.get(5));

                checkHands(pocketCardsA, pocketCardsB, pocketCardsC, boardCards, valToBeat);

                pocketCardsA = new ArrayList<>();
                pocketCardsA.add(localSix.get(0));
                pocketCardsA.add(localSix.get(1));

                pocketCardsB = new ArrayList<>();
                pocketCardsB.add(localSix.get(2));
                pocketCardsB.add(localSix.get(5));

                pocketCardsC = new ArrayList<>();
                pocketCardsC.add(localSix.get(3));
                pocketCardsC.add(localSix.get(4));

                checkHands(pocketCardsA, pocketCardsB, pocketCardsC, boardCards, valToBeat);

                pocketCardsA = new ArrayList<>();
                pocketCardsA.add(localSix.get(0));
                pocketCardsA.add(localSix.get(2));

                pocketCardsB = new ArrayList<>();
                pocketCardsB.add(localSix.get(1));
                pocketCardsB.add(localSix.get(3));

                pocketCardsC = new ArrayList<>();
                pocketCardsC.add(localSix.get(4));
                pocketCardsC.add(localSix.get(5));

                checkHands(pocketCardsA, pocketCardsB, pocketCardsC, boardCards, valToBeat);

                pocketCardsA = new ArrayList<>();
                pocketCardsA.add(localSix.get(0));
                pocketCardsA.add(localSix.get(2));

                pocketCardsB = new ArrayList<>();
                pocketCardsB.add(localSix.get(1));
                pocketCardsB.add(localSix.get(4));

                pocketCardsC = new ArrayList<>();
                pocketCardsC.add(localSix.get(3));
                pocketCardsC.add(localSix.get(5));

                checkHands(pocketCardsA, pocketCardsB, pocketCardsC, boardCards, valToBeat);

                pocketCardsA = new ArrayList<>();
                pocketCardsA.add(localSix.get(0));
                pocketCardsA.add(localSix.get(2));

                pocketCardsB = new ArrayList<>();
                pocketCardsB.add(localSix.get(1));
                pocketCardsB.add(localSix.get(5));

                pocketCardsC = new ArrayList<>();
                pocketCardsC.add(localSix.get(3));
                pocketCardsC.add(localSix.get(4));

                checkHands(pocketCardsA, pocketCardsB, pocketCardsC, boardCards, valToBeat);

                pocketCardsA = new ArrayList<>();
                pocketCardsA.add(localSix.get(0));
                pocketCardsA.add(localSix.get(3));

                pocketCardsB = new ArrayList<>();
                pocketCardsB.add(localSix.get(1));
                pocketCardsB.add(localSix.get(2));

                pocketCardsC = new ArrayList<>();
                pocketCardsC.add(localSix.get(4));
                pocketCardsC.add(localSix.get(5));

                checkHands(pocketCardsA, pocketCardsB, pocketCardsC, boardCards, valToBeat);

                pocketCardsA = new ArrayList<>();
                pocketCardsA.add(localSix.get(0));
                pocketCardsA.add(localSix.get(3));

                pocketCardsB = new ArrayList<>();
                pocketCardsB.add(localSix.get(1));
                pocketCardsB.add(localSix.get(4));

                pocketCardsC = new ArrayList<>();
                pocketCardsC.add(localSix.get(2));
                pocketCardsC.add(localSix.get(5));

                checkHands(pocketCardsA, pocketCardsB, pocketCardsC, boardCards, valToBeat);

                pocketCardsA = new ArrayList<>();
                pocketCardsA.add(localSix.get(0));
                pocketCardsA.add(localSix.get(3));

                pocketCardsB = new ArrayList<>();
                pocketCardsB.add(localSix.get(1));
                pocketCardsB.add(localSix.get(5));

                pocketCardsC = new ArrayList<>();
                pocketCardsC.add(localSix.get(2));
                pocketCardsC.add(localSix.get(4));

                checkHands(pocketCardsA, pocketCardsB, pocketCardsC, boardCards, valToBeat);

                pocketCardsA = new ArrayList<>();
                pocketCardsA.add(localSix.get(0));
                pocketCardsA.add(localSix.get(4));

                pocketCardsB = new ArrayList<>();
                pocketCardsB.add(localSix.get(1));
                pocketCardsB.add(localSix.get(2));

                pocketCardsC = new ArrayList<>();
                pocketCardsC.add(localSix.get(3));
                pocketCardsC.add(localSix.get(5));

                checkHands(pocketCardsA, pocketCardsB, pocketCardsC, boardCards, valToBeat);

                pocketCardsA = new ArrayList<>();
                pocketCardsA.add(localSix.get(0));
                pocketCardsA.add(localSix.get(4));

                pocketCardsB = new ArrayList<>();
                pocketCardsB.add(localSix.get(1));
                pocketCardsB.add(localSix.get(3));

                pocketCardsC = new ArrayList<>();
                pocketCardsC.add(localSix.get(2));
                pocketCardsC.add(localSix.get(5));

                checkHands(pocketCardsA, pocketCardsB, pocketCardsC, boardCards, valToBeat);

                pocketCardsA = new ArrayList<>();
                pocketCardsA.add(localSix.get(0));
                pocketCardsA.add(localSix.get(4));

                pocketCardsB = new ArrayList<>();
                pocketCardsB.add(localSix.get(1));
                pocketCardsB.add(localSix.get(5));

                pocketCardsC = new ArrayList<>();
                pocketCardsC.add(localSix.get(2));
                pocketCardsC.add(localSix.get(3));

                checkHands(pocketCardsA, pocketCardsB, pocketCardsC, boardCards, valToBeat);

                pocketCardsA = new ArrayList<>();
                pocketCardsA.add(localSix.get(0));
                pocketCardsA.add(localSix.get(5));

                pocketCardsB = new ArrayList<>();
                pocketCardsB.add(localSix.get(1));
                pocketCardsB.add(localSix.get(2));

                pocketCardsC = new ArrayList<>();
                pocketCardsC.add(localSix.get(3));
                pocketCardsC.add(localSix.get(4));

                checkHands(pocketCardsA, pocketCardsB, pocketCardsC, boardCards, valToBeat);

                pocketCardsA = new ArrayList<>();
                pocketCardsA.add(localSix.get(0));
                pocketCardsA.add(localSix.get(5));

                pocketCardsB = new ArrayList<>();
                pocketCardsB.add(localSix.get(1));
                pocketCardsB.add(localSix.get(3));

                pocketCardsC = new ArrayList<>();
                pocketCardsC.add(localSix.get(2));
                pocketCardsC.add(localSix.get(4));

                checkHands(pocketCardsA, pocketCardsB, pocketCardsC, boardCards, valToBeat);

                pocketCardsA = new ArrayList<>();
                pocketCardsA.add(localSix.get(0));
                pocketCardsA.add(localSix.get(5));

                pocketCardsB = new ArrayList<>();
                pocketCardsB.add(localSix.get(1));
                pocketCardsB.add(localSix.get(4));

                pocketCardsC = new ArrayList<>();
                pocketCardsC.add(localSix.get(2));
                pocketCardsC.add(localSix.get(3));

                checkHands(pocketCardsA, pocketCardsB, pocketCardsC, boardCards, valToBeat);


            }

        }
        System.out.print("\nThere are " + crackArray.size() + " unique arrangements of hands that all crack the aces\n");
        for(String localHand : crackArray)
        {
            System.out.print(localHand + "\n");
        }
        System.out.print("\nThere are " + crackArray.size() + " unique arrangements of hands that all crack the aces\n");
    }
}












//           for (int a = 0; a < 6; a++) {
//        for (int b = 0; b < 6; b++) {
//        if (b != a && b>a) {
//        for (int c = 0; c < 6; c++) {
//        if (c != b && c != a) {
//        for (int d = 0; d < 6; d++) {
//        if (d != c && d != b && d != a && d>c) {
//        // System.out.print("\n" + a + " " + b + " " + c + " " +d );
//        for (int e = 0; e < 6; e++) {
//        if (e != d && e != c && e != b && e != a) {
//        for (int f = 0; f < 6; f++) {
//        if (f != a && f != b && f != c && f != d && f != e && f>e) {
//        System.out.print("\n" + a + " " + b + " " + c + " " +d + " " +e + " "+f);
//        }
//        }
//        }
//        }
//        }
//        }
//        }
//
//        }
//        }
//
//
//        }
//
//        }