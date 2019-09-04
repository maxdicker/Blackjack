package blackjackTester;

import blackjack.Card;
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

    public void testHitIncreasesPlayersHandSize() {
        Player player = new Player();
        Deck deck = new Deck(new Card[] {new Card(Card.Suit.SPADES, Card.Rank.ACE), new Card(Card.Suit.SPADES, Card.Rank.TWO)});
        System.out.println("--testHitIncreasesPlayersHandSize--");
        _gameManager.hit(deck, player);
        _gameManager.hit(deck, player);

        if (player.numCardsInHand() == 2) {
            System.out.println("Pass: hit increases players hand size");
        } else {
            System.out.println("FAIL: hit does not increase players hand size properly");
        }

    }

    public void testHitReducesDeckSize() {
        // arrange
        Player player = new Player();
        Deck deck = new Deck(new Card[] {new Card(Card.Suit.SPADES, Card.Rank.ACE), new Card(Card.Suit.SPADES, Card.Rank.TWO)});
        System.out.println("--testHitReducesDeckSize--");
        int startDeckSize = deck.numberOfCards();

        // act
        _gameManager.hit(deck, player);

        // assert
        int endDeckSize = deck.numberOfCards();

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
