package blackjackTester;

import blackjack.Card;
import blackjack.Player;

public final class PlayerTester {
    private final Player _player;

    public PlayerTester(Player player) {
        _player = player;
    }

    public void testAddUpdatesScore(Card card, int expectedIncrease) {
        int startingScore = _player.getScore();
        _player.addToHand(card);
        int finalScore = _player.getScore();

        if (finalScore == startingScore + expectedIncrease) {
            System.out.println("Pass: Add updates player's score");
        } else {
            System.out.println("FAIL: Add does not update player's score");
        }
    }
}
