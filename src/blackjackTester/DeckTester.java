package blackjackTester;

import blackjack.Card;
import blackjack.Deck;

public final class DeckTester {

    private void assertTrue(Boolean condition, String expectation) {
        if (condition) {
            System.out.println("Pass: " + expectation);
        } else {
            System.out.println("FAIL: " + expectation);
        }
    }

    public void testDealReturnsNextCard() {
        Card aceOfSpades = new Card(Card.Suit.SPADES, Card.Rank.ACE);
        Deck deck = new Deck(new Card[] {
                new Card(Card.Suit.SPADES, Card.Rank.ACE),
                new Card(Card.Suit.SPADES, Card.Rank.TWO)
        });
        System.out.println("--testDealReturnsNextCard--");

        Card dealtCard = deck.deal();

        assertTrue(dealtCard.equals(aceOfSpades), "deal returns next card in deck");
    }

    public void testDealThrowsExceptionWhenDeckIsEmpty() {
        Deck deck = new Deck(new Card[] {
                new Card(Card.Suit.SPADES, Card.Rank.ACE),
                new Card(Card.Suit.SPADES, Card.Rank.TWO),
                new Card(Card.Suit.SPADES, Card.Rank.THREE)
        });
        int deckSize = 3;
        System.out.println("--testDealThrowsExceptionWhenDeckIsEmpty--");

        for (int i= 1; i <= deckSize; i++) {
            deck.deal();
        }

        boolean thrown = false;
        try {
            deck.deal();
        } catch (IllegalStateException e) {
            thrown = true;
        }

        assertTrue(thrown, "deal throws exception if deck is empty");
    }
}
