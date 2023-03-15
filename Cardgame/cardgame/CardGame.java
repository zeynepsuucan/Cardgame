package cardgame;

import java.util.ArrayList;

// Cardgame
// author:
// date:
public class CardGame {
  // properties
  Cards fullPack;
  ArrayList<Player> players;
  ScoreCard scoreCard;
  Cards[] cardsOnTable;
  int roundNo;
  int turnOfPlayer;

  // constructors
  public CardGame(Player p1, Player p2, Player p3, Player p4) {

    fullPack = new Cards(true);
    fullPack.shuffle();

    scoreCard = new ScoreCard(4);
    cardsOnTable = new Cards[4];
    players = new ArrayList<>();

    roundNo = 0;
    turnOfPlayer = 0;

    players.add(p1);
    players.add(p2);
    players.add(p3);
    players.add(p4);

    for (Player player : players) { // we can use this method to find the player that we're looking for
      for (int i = 0; i < 13; i++) // as there are 4 players and 52 cards, they will play 13 rounds
        player.add(fullPack.getTopCard());
    }

    for (int i = 0; i < 4; i++) {
      cardsOnTable[i] = new Cards(false); // creating new cards
    }

  }

  // methods
  public boolean playTurn(Player p, Card c) {

    boolean accepted = false;

    if (isTurnOf(p)) {
      accepted = cardsOnTable[turnOfPlayer].addTopCard(c);
    }

    if (accepted) {
      if (isTurnOf(players.get(players.size() - 1))) {

        Card zsu = cardsOnTable[0].getTopCard();
        Card[] newCards = new Card[4];
        newCards[0] = zsu;

        for (int i = 1; i < cardsOnTable.length; i++) {
          Card card = cardsOnTable[i].getTopCard();
          newCards[i] = card;

          if (card.compareTo(zsu) == 1) { // compareto method written in card class, helps find the winner
            zsu = card;
          }

        }

        for (int i = 0; i < players.size(); i++) {
          if (newCards[i].compareTo(zsu) == 0)
            scoreCard.update(i, 1); // adding 1 to each winner, of each round!!!!
        }

        roundNo++; // adding 1 after each round(after 4th player plays their turn)
        turnOfPlayer = 0;

      } else {
        turnOfPlayer++;
      }
    }
    return accepted;
  }

  public boolean isTurnOf(Player p) {
    if (isGameOver())
      return false;
    return players.indexOf(p) == turnOfPlayer;
  }

  public boolean isGameOver() {
    if (roundNo >= 13)
      return true;
    return false;
  }

  public int getScore(int playerNumber) {
    return scoreCard.getScore(playerNumber);
  }

  public String getName(int playerNumber) {
    return players.get(playerNumber).getName();
  }

  public int getRoundNo() {
    return roundNo;
  }

  public int getTurnOfPlayerNo() {
    return turnOfPlayer;
  }

  public Player[] getWinners() {
    int[] winnernum = scoreCard.getWinners();
    Player[] winners = new Player[scoreCard.getWinners().length]; // there could be more than one winner
    for (int i = 0; i < winners.length; i++) { // after finding the number of winners we print each of them
      winners[i] = players.get(winnernum[i]);
    }

    return winners;
  }

  public String showScoreCard() {
    return scoreCard.toString();
  }

}
