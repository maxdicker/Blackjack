package blackjackTester;

import blackjack.Card;

public final class CardTester {

    private void assertTrue(Boolean condition, String expectation) {
        if (condition) {
            System.out.println("Pass: " + expectation);
        } else {
            System.out.println("FAIL: " + expectation);
        }
    }

    public void testCardIsEqual () {
        Card card = new Card(Card.Suit.SPADES, Card.Rank.TWO);
        Card sameCard = new Card(Card.Suit.SPADES, Card.Rank.TWO);
        System.out.println("--testCardIsEqual--");

        assertTrue(card.equals(sameCard), "card is the same");
    }

    public void testCardIsNotEqual() {
        Card card = new Card(Card.Suit.SPADES, Card.Rank.TWO);
        Card differentCard = new Card(Card.Suit.CLUBS, Card.Rank.THREE);
        System.out.println("--testCardIsNotEqual--");

        assertTrue(!card.equals(differentCard), "card is not the same");
    }
}
