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

    public void testDealRejectsExhaustedDeck() {
        Deck deck = new Deck(new Card[] {
                new Card(Card.Suit.SPADES, Card.Rank.ACE),
                new Card(Card.Suit.SPADES, Card.Rank.TWO),
                new Card(Card.Suit.SPADES, Card.Rank.THREE)
        });
        int deckSize = 3;
        System.out.println("--testDealRejectsExhaustedDeck--");

        for (int i= 1; i <= deckSize; i++) {
            deck.deal();
        }

        try {
            deck.deal();
            System.out.println("FAIL: Deal does not throw exception on exhausted deck");
        } catch (IllegalStateException e) {
            System.out.println("Pass: Deal throws exception on exhausted deck");
        }
    }
}
