package blackjackTester;

import blackjack.Card;
import blackjack.Deck;

public final class DeckTester {
    private final Deck _deck;

    public DeckTester(Deck deck) {
        _deck = deck;
    }

//    public DeckTester(String configuration) {
//        cards = new ArrayList<>();
//        switch (configuration) {
//            case "empty":
//                break;
//            case "singleSuit":
//                for (Card.Rank rank : Card.Rank.values()) {
//                    cards.add(new Card(Card.Suit.SPADES, rank));
//                }
//                break;
//            case "aces":
//                for (Card.Suit suit : Card.Suit.values()) {
//                    cards.add(new Card(suit, Card.Rank.ACE));
//                }
//                break;
//        }
//    }

    public void testDealReturnsNextCard(Card nextCard) {
        Card dealtCard = _deck.deal();
        if (dealtCard.equals(nextCard)) {
            System.out.println("Pass: Deal returns the next card in deck");
        } else {
            System.out.println("FAIL: Deal doesn't return the next card in deck");
        }
    }

    public void testDealRejectsExhaustedDeck(int deckSize) {
        for (int i= 1; i < deckSize; i++) {
            _deck.deal();
        }
        try {
            _deck.deal();
            System.out.println("FAIL: Deal can take an exhausted deck");
        } catch (Exception e) {
            System.out.println("Pass: Deal rejects an exhausted deck");
        }
    }
}
