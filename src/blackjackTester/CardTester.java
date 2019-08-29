package blackjackTester;

import blackjack.Card;

public final class CardTester {
    private final Card _card;

    public CardTester(Card card) {
        _card = card;
    }

//    public void testCardIsBlack (Card anotherCard) {
//
//        if (anotherCard.isBlack()) {
//            System.out.println("Pass: Card is black");
//        } else {
//            System.out.println("FAIL: Card is not black");
//        }
//    }

    public void testCardIsEqual (Card anotherCard) {
        if (this._card == anotherCard) {
            System.out.println("Pass: Card is the same");
        } else {
            System.out.println("FAIL: Card is not the same");
        }
    }

}
