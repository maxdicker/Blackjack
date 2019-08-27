package blackjack;

public class Card {

    enum Suit {SPADES ("Black"), CLUBS ("Black"), DIAMONDS ("Red"), HEARTS ("Red");
        private String colour;
        Suit(String colour) {
            this.colour = colour;
        }
    }

    enum Rank {TWO, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT,
        NINE, TEN, JACK, QUEEN, KING, ACE;
        Rank() {
        }
    }

    private Suit suit;
    private Rank rank;
    private int value;

    public Card(Suit suit, Rank rank) {
        this.suit = suit;
        this.rank = rank;
        switch (rank) {
            case TWO:   this.value = 2; break;
            case THREE: this.value = 3; break;
            case FOUR:  this.value = 4; break;
            case FIVE:  this.value = 5; break;
            case SIX:   this.value = 6; break;
            case SEVEN: this.value = 7; break;
            case EIGHT: this.value = 8; break;
            case NINE:  this.value = 9; break;
            case TEN:
            case JACK:
            case QUEEN:
            case KING:
                this.value = 10; break;
            case ACE:   this.value = 11;
        }
    }

    @Override
    public String toString() {
        return "[" + rank + " of " + suit + "]";
    }

    public boolean equals(Card card) {
        return this.rank == card.rank && this.suit == card.suit;
    }

    public int getValue() {
        return value;
    }

}
