package blackjackTester;

import blackjack.Card;
import blackjack.Player;

public final class PlayerTester {

    private void assertTrue(Boolean condition, String expectation) {
        if (condition) {
            System.out.println("Pass: " + expectation);
        } else {
            System.out.println("FAIL: " + expectation);
        }
    }

    public void testAddUpdatesScore() {
        Player player = new Player();
        player.addToHand(new Card(Card.Suit.SPADES, Card.Rank.KING));
        int startingScore = player.getScore();
        System.out.println("--testAddUpdatesScore--");

        player.addToHand(new Card(Card.Suit.SPADES, Card.Rank.NINE));
        int finalScore = player.getScore();

        assertTrue(finalScore == startingScore + 9, "add to hand updates player's score");
    }
}
