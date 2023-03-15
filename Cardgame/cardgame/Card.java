package cardgame;

import javax.lang.model.util.ElementScanner6;

/**
 * Card - a single playing card
 * 
 * @author
 * @version
 */
public class Card {
    // constants - to do in lectures
    final String[] SUITS = { "Hearts", "Diamonds", "Spades", "Clubs" };
    final String[] FACES = { "A", "2", "3", "4", "5",
            "6", "7", "8", "9", "10",
            "J", "Q", "K" };

    final int NOOFCARDSINSUIT = 13;

    // properties - to do in lectures
    int cardNo;

    // constructors - to do in lectures
    public Card(int faceValue, int suit) {
        cardNo = faceValue + suit * NOOFCARDSINSUIT;
    }

    public Card(int cardNumber) {
        cardNo = cardNumber;
    }

    public int getFaceValue() {
        return cardNo % NOOFCARDSINSUIT;
    }

    public int getSuit() {
        return cardNo / NOOFCARDSINSUIT;
    }

    public String toString() {
        return FACES[getFaceValue()] + " of " + SUITS[getSuit()];
    }

    public boolean equals(Card c) {
        return cardNo == c.cardNo;
    }

    public int compareTo(Card c) {

        if (getFaceValue() > c.getFaceValue())
            return 1;

        else if (getFaceValue() < c.getFaceValue())
            return -1;

        else
            return 0;
    }
}