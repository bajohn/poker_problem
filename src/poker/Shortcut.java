package poker;

/**
 * Created by 587177 on 9/8/2016.
 */
public class Shortcut {

    //This is a faster ("Shortcut") way of solving the poker problem.
    //We go around the table to each player trying to crack the aces, and calculate the probability that
    //he does. After removing the two cards for that player from the deck, we calculate the probability for
    //the next player, and so on. This process must be repeated for each possible way to beat the aces,
    //hence the recursion.

    //More details are in main()

    //hand one:
    public static double prob = 0;

    public static void calc(String history, double prob_in, int counts_remaining, double L, double H, double T)
    {
        //LL
        double probLL = prob_in * L/T * (L-1)/(T-1);
        String historyLL = history+" LL ";
        if(counts_remaining>0)
        {
            calc(historyLL, probLL, counts_remaining-1, L-2, H, T-2);
        }
        else
        {
            System.out.print("\nFinal prob at end of this tree: " + historyLL + probLL);
            prob+=probLL;
        }

        //HL
        double probHL = prob_in * H/T * L/(T-1);
        String historyHL = history+" HL ";
        if(counts_remaining>0)
        {
            calc(historyHL, probHL, counts_remaining-1, L-1, H-1, T-2);
        }
        else
        {
            System.out.print("\nFinal prob at end of this tree: " + historyHL+ probHL);
            prob+=probHL;
        }

        //HO
        double probHO = prob_in * H/T * (T-H-L)/(T-1);
        String historyHO = history+" HO ";
        if(counts_remaining>0)
        {
            calc(historyHO, probHO, counts_remaining-1, L, H-1, T-2);
        }
        else
        {
            System.out.print("\nFinal prob at end of this tree: " + historyHO + probHO);
            prob+=probHO;
        }

        //HH
        double probHH = prob_in * H/T * (H-1)/(T-1);
        String historyHH = history+" HH ";
        if(counts_remaining>0)
        {
            calc(historyHH, probHH, counts_remaining-1, L, H-2, T-2);
        }
        else
        {
            System.out.print("\nFinal prob at end of this tree: " + historyHH + probHH);
            prob+=probHH;
        }


    }

    public static void main(String args[])
    {

        // "H" for "High" represents a 4 or 9 of any suit. This completes a straight.Only one "H" is required
        // to crack the aces.
        double H = 8;
        //"L" for "Low" represents one of the community cards. Two L's are required to crack the aces. Since
        //each community card has a different face value, there are 3*5=15 of them in the deck
        double L = 15;
        // Total remaining deck, after board cards and hand to beat are removed
        double T = 45;


        calc("", 1, 2, L, H, T);
        System.out.print("\nANSWER\n\n"+prob);

    }
}
