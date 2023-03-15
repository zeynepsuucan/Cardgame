import java.util.Scanner;
import cardgame.*;

// CardGameTest
// author:
// date:
public class CardGameTest
{
    public static void main( String[] args)
    {
        Scanner scan = new Scanner( System.in);
        
        System.out.println( "Start of CardGameTest\n");
        
        
        // VARIABLES
        Card       c;
        Card       card2;
        Cards      cards;
        ScoreCard  scores;
        CardGame   game;
        

        // test Card class
        c = new Card(1);
        card2 = new Card(2);

        System.out.println(c);
        System.out.println(card2);
        
        System.out.println(c.equals(card2));
        System.out.println(c.compareTo(card2));


        // test Cards class
        cards = new Cards(true);
        cards.addTopCard(c);
        cards.shuffle();

        
        // test ScoreCard class
        scores = new ScoreCard(4);
        scores.update(3, 1);
        scores.update(1, 2);
        scores.update(2, 5);
        scores.update(0, 1);
        System.out.println( "\n" + scores );

        
        // test Player class
        Player player1 = new Player("Zeynep"); // naming players to test the card game class
        Player player2 = new Player("Su");
        Player player3 = new Player("Kerem");
        Player player4 = new Player("Burak");


        // adding cards to player 1's deck
        player1.add(c); 
        player1.add(card2);
        

        // test Card Game class 
        game = new CardGame(player1, player2, player3, player4);
        System.out.println(game.playTurn(player2,player2.playCard())); // testing the card game class
        // as a result we get that it's not player 2's turn
        System.out.println(game.playTurn(player1,player1.playCard())); // testing the card game class
        // it prints true which means its the first players turn.

        
        System.out.println( "\nEnd of CardGameTest\n" );
    }
    
} 