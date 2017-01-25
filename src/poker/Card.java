package poker;

/**
 * Created by bjohn454 on 6/28/2016.
 */
public class Card {

    public enum Suits
    {
        HEARTS,
        DIAMONDS,
        CLUBS,
        SPADES;
    }

    public enum CardVals
    {
        TWO(2),
        THREE(3),
        FOUR(4),
        FIVE(5),
        SIX(6),
        SEVEN(7),
        EIGHT(8),
        NINE(9),
        TEN(10),
        JACK(11),
        QUEEN(12),
        KING(13),
        ACE(14);

        private int value;
        CardVals(int valIn)
        {
            this.value = valIn;
        }

        public int getVal()
        {
            return this.value;
        }
    }

    public CardVals value;
    public Suits suit;

    Card(CardVals valIn, Suits suitIn)
    {
        this.value = valIn;
        this.suit = suitIn;
    }
}
