package blackjack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Deck {
    private ArrayList<Card> cards;

    public Deck() {
        cards = new ArrayList<>();
        for (Card.Suit suit : Card.Suit.values()) {
            for (Card.Rank rank : Card.Rank.values()) {
                cards.add(new Card(suit, rank));
            }
        }
    }

    public Deck(Card[] cardArr) {
        cards = new ArrayList<>(Arrays.asList(cardArr));
    }

    public void shuffle() {
        Collections.shuffle(cards);
    }

    public Card deal() {
        if (!cards.isEmpty()) {
            Card nextCard = cards.get(0);
            cards.remove(0);
            return nextCard;
        } else {
            throw new IllegalStateException("The deck has no cards left.");
        }
    }

    public int numberOfCards() {
        return cards.size();
    }

}
