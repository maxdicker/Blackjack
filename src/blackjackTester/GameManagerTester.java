package blackjackTester;

import blackjack.*;

public final class GameManagerTester {

    private void assertTrue(Boolean condition, String expectation) {
        if (condition) {
            System.out.println("Pass: " + expectation);
        } else {
            System.out.println("FAIL: " + expectation);
        }
    }

    public void testHitIncreasesPlayersHandSize() {
        Player player = new Player();
        Deck deck = new Deck(new Card[] {
                new Card(Card.Suit.SPADES, Card.Rank.ACE),
                new Card(Card.Suit.SPADES, Card.Rank.TWO)
                });
        GameManager manager = new GameManager(deck, new Player[] {player}, new Dealer());
        System.out.println("--testHitIncreasesPlayersHandSize--");

        manager.hit(deck, player);
        manager.hit(deck, player);

        assertTrue(player.numCardsInHand() == 2, "hit increases players hand size");
    }

    public void testHitReducesDeckSize() {
        // arrange
        Player player = new Player();
        Deck deck = new Deck(new Card[] {
                new Card(Card.Suit.SPADES, Card.Rank.ACE),
                new Card(Card.Suit.SPADES, Card.Rank.TWO)
                });
        GameManager manager = new GameManager(deck, new Player[] {player}, new Dealer());
        System.out.println("--testHitReducesDeckSize--");
        int startDeckSize = deck.numberOfCards();

        // act
        manager.hit(deck, player);

        // assert
        int endDeckSize = deck.numberOfCards();

        assertTrue(endDeckSize == startDeckSize - 1, "hit reduces deck size");
    }

    public void testThatBustedPlayerLoses() {
        Deck deck = new Deck(new Card[] {});
        Player player = new Player();
        Dealer dealer = new Dealer();
        player.addToHand(new Card(Card.Suit.SPADES, Card.Rank.TEN));
        player.addToHand(new Card(Card.Suit.SPADES, Card.Rank.TEN));
        player.addToHand(new Card(Card.Suit.SPADES, Card.Rank.TWO));
        dealer.addToHand(new Card(Card.Suit.SPADES, Card.Rank.KING));
        System.out.println("--testThatBustedPlayerLoses--");

        GameManager manager = new GameManager(deck, new Player[] {player}, dealer);

        assertTrue(manager.getWinners().equals(dealer), "dealer should win");
    }

    public void testThatBustCheckConsidersDifferentValuesForAces() {
        Deck deck = new Deck(new Card[] {});
        Player player = new Player();
        Dealer dealer = new Dealer();
        player.addToHand(new Card(Card.Suit.SPADES, Card.Rank.ACE));
        player.addToHand(new Card(Card.Suit.CLUBS, Card.Rank.ACE));
        player.addToHand(new Card(Card.Suit.DIAMONDS, Card.Rank.ACE));
        player.addToHand(new Card(Card.Suit.HEARTS, Card.Rank.ACE));
        System.out.println("--testThatBustCheckConsidersDifferentValuesForAces--");

        GameManager manager = new GameManager(deck, new Player[] {player}, dealer);

        assertTrue(!manager.isBust(player), "bust check considers possible values for aces");
    }
}
