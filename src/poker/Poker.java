package poker;

import java.util.ArrayList;
import java.util.List;



/**
 * Created by bjohn454 on 6/28/2016.
 */


public class Poker {

    public static int TEN_K = 10000;
    public static int ONE_M = 1000000;

    public static String arrayToString( ArrayList<Card> cardsIn)
    {
        String outString = "";
        for(int i = 0; i<cardsIn.size(); i++)
        {
            outString+= cardsIn.get(i).value.toString() + " of " + cardsIn.get(i).suit.toString() + ", ";
        }
        return outString;
    }

    public static ArrayList<Card> sortCards(ArrayList<Card> cardsIn)
    {
        ArrayList<Card> cardsLocal = ( ArrayList<Card> )cardsIn.clone();
        ArrayList<Card> cardsSorted = new ArrayList<>();

        //sort

        for(int j = 0; j<5;j++)
        {
            int minVal = 99;
            int idx = 0;
            for(int i = 0; i<cardsLocal.size();i++)
            {

                int localVal = cardsLocal.get(i).value.getVal();
                if(localVal < minVal)
                {
                    minVal =  localVal;
                    idx =  i;
                }
            }
            cardsSorted.add(cardsLocal.get(idx));
            cardsLocal.remove(idx);
        }
        return cardsSorted;
    }

    public static double isStraight(ArrayList<Card> cardsIn)
    {
        ArrayList<Card> cardsSorted = sortCards(cardsIn);

        //sort

        //System.out.print(arrayToString(cardsSorted));
       // System.out.print(cardsSorted);


        //check for wheel first
        if(cardsSorted.get(0).value.getVal()==2
                &&cardsSorted.get(1).value.getVal()==3
                &&cardsSorted.get(2).value.getVal()==4
                &&cardsSorted.get(3).value.getVal()==5
                &&cardsSorted.get(4).value.getVal()==14)
        {
            return 4*ONE_M + TEN_K * 5;
        }



        for(int i = 0; i < 4; i++)
        {
            if(cardsSorted.get(i).value.getVal()!=cardsSorted.get(i+1).value.getVal()-1)
            {
                return -1;
            }
        }

        return 4*ONE_M + TEN_K*cardsSorted.get(4).value.getVal();
    }

    public static double isFlush( ArrayList<Card> cardsIn)
    {
        for(int i = 0; i<5;i++)
        {
            if(!cardsIn.get(i).suit.equals(cardsIn.get(0).suit))
            {
                return -1;
            }
        }

        return 5*ONE_M + TEN_K*getHighCard(cardsIn);
    }


    //deprecated...
//    public static boolean hasPair( ArrayList<Card> cardsIn)
//    {
//        for(int i = 0; i<5;i++)
//        {
//            for(int j = 0; j<5; j++)
//            {
//                if(j!=i)
//                {
//                    if(cardsIn.get(i).value.equals(cardsIn.get(j).value))
//                    {
//                        return true;
//                    }
//                }
//            }
//        }
//        return false;
//    }



    public static ArrayList<ArrayList<Integer>> getMatches(ArrayList<Card> cardsIn)
    {
        ArrayList<Card> cardsLocal = (ArrayList<Card> )cardsIn.clone();

        ArrayList<ArrayList<Integer>> matches = new ArrayList<>();

        for(int j = 0; j<5; j++)
        {
            if(cardsLocal.size()==0)
            {
                break;
            }
            Integer matchVal = cardsLocal.get(0).value.getVal();
            ArrayList<Integer> localMatch = new ArrayList<>();
            for (int i = 0; i < cardsLocal.size(); i++) {

                if (matchVal.equals(cardsLocal.get(i).value.getVal())) {
                    localMatch.add(matchVal);
                }
            }
            if(localMatch.size()>1)
            {
                matches.add(localMatch);
            }

            for(int i = 0; i<localMatch.size();i++)
            {
                for(int k=0;k<cardsLocal.size();k++)
                {
                    if(cardsLocal.get(k).value.getVal()==localMatch.get(0))
                    {
                        cardsLocal.remove(k);
                    }
                }
            }

        }

        //what comes out?
        for(int j = 0; j<matches.size(); j++)
        {
        //    System.out.print("\nSize: " + matches.get(j).size());
        }

        return matches;
    }


    public static double isPair(ArrayList<Card> cardsIn)
    {
        ArrayList<Card> cardsSorted = sortCards(cardsIn);
        ArrayList<ArrayList<Integer>> matchesIn = getMatches(cardsSorted);
        if(matchesIn.size()==1)
        {
            int pairVal = matchesIn.get(0).get(0);
            if(matchesIn.get(0).size()==2)
            {

                int kickerOne = 0;
                int kickerTwo = 0;
                int kickerThree = 0;

                for(int i =0; i<5; i++)
                {
                    int localVal = cardsSorted.get(i).value.getVal();
                    if(localVal!=pairVal)
                    {
                        if(kickerOne==0)
                        {
                            if(kickerTwo==0)
                            {
                                if(kickerThree==0)
                                {
                                    kickerThree = localVal;
                                }
                                else
                                {
                                    kickerTwo = localVal;
                                }
                            }
                            else
                            {
                                kickerOne = localVal;
                            }

                        }
                    }
                }
                return ONE_M + TEN_K *  pairVal + 100*kickerOne + kickerTwo + .01*kickerThree;
            }
        }
        return -1;

    }
    public static double isTwoPair(ArrayList<Card> cardsIn)
    {
        ArrayList<ArrayList<Integer>> matchesIn = getMatches(cardsIn);

        if(matchesIn.size()==2)
        {
            if(matchesIn.get(0).size()==2 && matchesIn.get(1).size()==2)
            {
                if(matchesIn.get(0).get(0)>matchesIn.get(1).get(0))
                {
                    return 2*ONE_M + TEN_K*matchesIn.get(0).get(0) + 100*matchesIn.get(1).get(0);
                }
                else
                {
                    return 2*ONE_M + TEN_K*matchesIn.get(1).get(0) + 100*matchesIn.get(0).get(0);
                }
            }
        }
        return -1;
    }
    public static double isThreeOfKind(ArrayList<Card> cardsIn)
    {
        ArrayList<ArrayList<Integer>> matchesIn = getMatches(cardsIn);

        if(matchesIn.size()==1)
        {
            if(matchesIn.get(0).size()==3)
            {
                int maxVal = 0;
                for(int i =0; i<5; i++)
                {
                    int localVal = cardsIn.get(i).value.getVal();
                    if(localVal>maxVal)
                    {
                        if(localVal!=matchesIn.get(0).get(0))
                        {
                            maxVal = localVal;
                        }
                    }
                }
                return 3*ONE_M + TEN_K*maxVal;
            }
        }
        return -1;
    }
    public static double isFullHouse(ArrayList<Card> cardsIn)
    {
        ArrayList<ArrayList<Integer>> matchesIn = getMatches(cardsIn);

        if(matchesIn.size()==2)
        {
            if(matchesIn.get(0).size()==3 && matchesIn.get(1).size()==2)
            {
                return 6*ONE_M+TEN_K*matchesIn.get(0).get(0) + 100*matchesIn.get(1).get(0);
            }
            if(matchesIn.get(0).size()==2 && matchesIn.get(1).size()==3)
            {
                return 6*ONE_M+TEN_K*matchesIn.get(1).get(0) + 100*matchesIn.get(0).get(0);
            }
        }
        return -1;
    }

    public static double isFourOfKind(ArrayList<Card> cardsIn)
    {
        ArrayList<ArrayList<Integer>> matchesIn = getMatches(cardsIn);
        if(matchesIn.size()==1)
        {
            if(matchesIn.get(0).size()==4)
            {
                for(int i = 0; i<5;i++)
                {
                    int localVal = cardsIn.get(i).value.getVal();
                    if(matchesIn.get(0).get(0)!=localVal)
                    {

                        return 7*ONE_M + TEN_K *matchesIn.get(0).get(0) + localVal;
                    }
                }
            }

        }
        return -1;
    }

    public static double isStraightFlush(ArrayList<Card> cardsIn)
    {
        if(isStraight(cardsIn) > 0 && isFlush(cardsIn) > 0)
        {
            return 4*ONE_M + isStraight(cardsIn); //4M + 4M = 8M
        }
        return -1;
    }

    public static double getHighCard(ArrayList<Card> cardsIn)
    {
        int maxVal = 0;
        for(int i =0; i<5; i++)
        {
            int localVal = cardsIn.get(i).value.getVal();
            if(localVal>maxVal)
            {
                maxVal = localVal;
            }

        }
        return maxVal;
    }
    public static ArrayList<ArrayList<Integer>> getPermSizeSix()
    {
        //get all groups of six cards, from which we can see who beats the given hand
        ArrayList<ArrayList<Integer>> output = new ArrayList<>();

        for(int a = 0; a<45; a++)
        {

            for(int b = a; b<45; b++)
            {
                if(a!=b)
                    for(int c = b; c<45; c++)
                    {
                        if(a!=c && b!=c)
                            for(int d = c; d<45; d++)
                            {
                                if(a!=d && b!=d && c!=d)
                                    for(int e = d; e<45; e++)
                                    {
                                        if(a!=e && b!=e && c!=e && d!=e)

                                            for(int f = e; f<45; f++)
                                            {
                                                if (a != f && b != f && c != f && d != f && e != f)
                                                {
                                                    ArrayList<Integer> idxArray = new ArrayList<>();
                                                    idxArray.add(a);
                                                    idxArray.add(b);
                                                    idxArray.add(c);
                                                    idxArray.add(d);
                                                    idxArray.add(e);
                                                    idxArray.add(f);
                                                    output.add(idxArray);
                                                    //System.out.print("\n" + idxArray);
                                                }
                                            }

                                    }
                            }
                    }
            }
        }
        return output;
    }

    public static ArrayList<ArrayList<Integer>> getPermSizeFive()
    {
        //permute all possible hands (size 5) from 7 cards (5 board cards + 2 pocket cards)
        ArrayList<ArrayList<Integer>> output = new ArrayList<>();

        for(int a = 0; a<7; a++)
        {

            for(int b = 0; b<7; b++)
            {
                if(a!=b)
                for(int c = 0; c<7; c++)
                {
                    if(a!=c && b!=c)
                    for(int d = 0; d<7; d++)
                    {
                        if(a!=d && b!=d && c!=d)
                        for(int e = 0; e<7; e++)
                        {
                            if(a!=e && b!=e && c!=e && d!=e)
                            {
                                ArrayList<Integer> idxArray = new ArrayList<>();
                                idxArray.add(a);
                                idxArray.add(b);
                                idxArray.add(c);
                                idxArray.add(d);
                                idxArray.add(e);

                                output.add(idxArray);
                            }
                        }
                    }
                }
            }
        }
        return output;
    }

    public static double evaluateHand(ArrayList<Card> pocketCards, ArrayList<Card> boardCards) //2 pocket cards, 5 from board
    {
        ArrayList<ArrayList<Integer>> perm = getPermSizeFive();
        double maxHand = 0;
        ArrayList<Card> handFinal = new ArrayList<>();
        for(int i = 0; i< perm.size(); i++)
        {
            ArrayList<Card> handLocal = new ArrayList<>();
            ArrayList<Integer> permLocal = perm.get(i);
            for(Integer j : permLocal)
            {
                if(j.equals(5))
                {
                    handLocal.add(pocketCards.get(0));

                }
                else if(j.equals(6))
                {
                    handLocal.add(pocketCards.get(1));
                }
                else
                {
                    handLocal.add(boardCards.get(j));
                }
            }
//            double valLocal = isStraightFlush(handLocal);
//
//            if(valLocal>0)
//            {
//                if(valLocal> maxHand)
//                {
//                    maxHand = valLocal;
//                    handFinal = handLocal;
//                }
//            }
//            else
//            {
//                valLocal = isFourOfKind(handLocal);
//                if(valLocal > 0)
//                {
//                    if(valLocal > maxHand)
//                    {
//                        maxHand = valLocal;
//                        handFinal = handLocal;
//                    }
//                }
//                else
//                {
//                    valLocal = isFullHouse(handLocal);
//                    if(valLocal > 0)
//                    {
//                        if(valLocal > maxHand)
//                        {
//                            maxHand = valLocal;
//                            handFinal = handLocal;
//                        }
//                    }
//                    else
//                    {
//                        valLocal = isFlush(handLocal);
//                        if(valLocal > 0)
//                        {
//                            if(valLocal > maxHand)
//                            {
//                                maxHand = valLocal;
//                                handFinal = handLocal;
//                            }
//                        }
//                        else
//                        {
                            double valLocal = isStraight(handLocal);
                            if(valLocal > 0)
                            {
                                if(valLocal > maxHand)
                                {
                                    maxHand = valLocal;
                                    handFinal = handLocal;
                                }
                            }
                            else
                            {
                                valLocal = isThreeOfKind(handLocal);
                                if(valLocal > 0)
                                {
                                    if(valLocal > maxHand)
                                    {
                                        maxHand = valLocal;
                                        handFinal = handLocal;
                                    }
                                }
                                else
                                {
                                    valLocal = isTwoPair(handLocal);
                                    if(valLocal > 0)
                                    {
                                        if(valLocal > maxHand)
                                        {
                                            maxHand = valLocal;
                                            handFinal = handLocal;
                                        }
                                    }
                                    else
                                    {
                                        valLocal = isPair(handLocal);
                                        if(valLocal > 0)
                                        {
                                            if(valLocal > maxHand)
                                            {
                                                maxHand = valLocal;
                                                handFinal = handLocal;
                                            }
                                        }
                                        else
                                        {
                                            valLocal = getHighCard(handLocal);
                                             if(valLocal > maxHand)
                                            {
                                                maxHand = valLocal;
                                                handFinal = handLocal;
                                            }

                                        }
                                    }
                                }
                            }
                        }
//                    }
//                }
//            }
//
//        }

        //System.out.print("\nBest hand: "+ maxHand + "\n");
        //System.out.print("\n" + arrayToString(sortCards(handFinal)));

        return maxHand;

    }
    public static void main(String arg[])
    {
        Card cardOne = new Card(Card.CardVals.NINE, Card.Suits.HEARTS);
        Card cardTwo = new Card(Card.CardVals.TWO, Card.Suits.CLUBS);
        Card cardThree = new Card(Card.CardVals.FOUR, Card.Suits.HEARTS);
        Card cardFour = new Card(Card.CardVals.FIVE, Card.Suits.HEARTS);
        Card cardFive = new Card(Card.CardVals.THREE, Card.Suits.DIAMONDS);

        Card pocketA = new Card(Card.CardVals.ACE, Card.Suits.HEARTS);
        Card pocketB = new Card(Card.CardVals.ACE, Card.Suits.CLUBS);

        ArrayList<Card> pocketCards = new ArrayList<>();
        pocketCards.add(pocketA);
        pocketCards.add(pocketB);


        Hand boardCards = new Hand(cardOne, cardTwo, cardThree, cardFour, cardFive);




        Card pocketTwoA = new Card(Card.CardVals.KING, Card.Suits.HEARTS);
        Card pocketTwoB = new Card(Card.CardVals.KING, Card.Suits.CLUBS);

        ArrayList<Card> pocketCardsTwo = new ArrayList<>();
        pocketCardsTwo.add(pocketTwoA);
        pocketCardsTwo.add(pocketTwoB);

        double valOne = evaluateHand(pocketCards, boardCards.cards);
        double valTwo = evaluateHand(pocketCardsTwo, boardCards.cards);
        if(valOne > valTwo)
        {
            System.out.print("First hand better than second");
            System.out.print("\n" + valOne);
            System.out.print("\n" + valTwo);
        }





//        for(int i =0;i<perm.size();i++)
//        {
//            System.out.print(perm.get(i) + "\n");
//        }

    }
}
