package blackjackTester;

import blackjack.Deck;
import blackjack.GameManager;
import blackjack.Player;

public final class GameManagerTester {
    private final GameManager _gameManager;

    public GameManagerTester(GameManager gameManager) {
        _gameManager = gameManager;
    }

    public void testCantKeepHitting(Player player) {
        //GameManager.play();

        // loop 21 times
        // prompt player for hit or stay
        // make player 1 hit
        //
        // assert that player 1 has busted
    }

    public void testHit(Deck deck, Player player) {
        System.out.println("--testHit--");
        _gameManager.hit(deck, player);
        _gameManager.hit(deck, player);
        int startDeckSize = _gameManager.getDeck().numberOfCards();
        _gameManager.hit(deck, player);
        int endDeckSize = _gameManager.getDeck().numberOfCards();

        if (player.numCardsInHand() == 3) {
            System.out.println("Pass: hit increases players hand size");
        } else {
            System.out.println("FAIL: hit does not increase players hand size properly");
        }

        if (endDeckSize == startDeckSize - 1) {
            System.out.println("Pass: hit reduces deck size");
        } else {
            System.out.println("FAIL: hit does not reduce deck size");
        }

    }

    public void testThatBustedPlayerCannotPlay() {
        // create game where player 1's score is 22 and dealer is 10
        // do next game step
        // assert player has lost
        // assert dealer has won
    }

}
