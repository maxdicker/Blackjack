package blackjackTester;

import blackjack.Card;

public final class CardTester {

    public CardTester() {
    }

    public void testCardIsEqual (Card card, Card anotherCard) {
        System.out.println("--testCardIsEqual--");
        if (card.equals(anotherCard)) {
            System.out.println("Pass: Card is the same");
        } else {
            System.out.println("FAIL: Card is not the same");
        }
    }

    public void testCardIsNotEqual(Card card, Card anotherCard) {
        System.out.println("--testCardIsNotEqual--");
        if (card.equals(anotherCard)) {
            System.out.println("FAIL: Card is the same");
        } else {
            System.out.println("Pass: Card is not the same");
        }
    }
}
