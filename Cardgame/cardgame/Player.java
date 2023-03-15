package cardgame;

// Player - Simple card game player with name and hand of cards
// author:
// date:
public class Player {
    // properties
    String name;
    Cards hand;

    // constructors
    public Player(String name) {
        this.name = name;
        hand = new Cards(false);
    }

    // methods
    public String getName() {
        return name;
    }

    public void add(Card c) {
        if (!hand.addTopCard(c)) {
            System.out.println("not possible");
        }
    }

    public Card playCard() {
        return hand.getTopCard();
    }

} // end class Player
