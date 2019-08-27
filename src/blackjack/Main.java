package blackjack;

import blackjackTester.DeckTester;
import blackjackTester.PlayerTester;

public class Main {

    public static void main(String[] args) {
//      blackjack.GameManager.play();

        runDeckTests();
        runPlayerTests();
    }

    private static void runDeckTests() {
        var card1 = new Card(Card.Suit.SPADES, Card.Rank.TWO);
        var card2 = new Card(Card.Suit.SPADES, Card.Rank.THREE);
        var card3 = new Card(Card.Suit.SPADES, Card.Rank.FOUR);

        Card[] testCards = {card1, card2, card3};
        var testDeck = new Deck(testCards);
        var tester = new DeckTester(testDeck);

        tester.testDealReturnsNextCard(card1);
        tester.testDealRejectsExhaustedDeck(3);
    }

    private static void runPlayerTests() {
        var testPlayer = new Player();
        testPlayer.addToHand(new Card(Card.Suit.SPADES, Card.Rank.THREE));
        testPlayer.addToHand(new Card(Card.Suit.SPADES, Card.Rank.SIX));

        var tester = new PlayerTester(testPlayer);

        tester.testAddUpdatesScore(new Card(Card.Suit.SPADES, Card.Rank.KING), 10);
    }
}

//Do my tests indicate I wrote them after implementation? Do they look for the right behaviour?
//are they structured correctly? i.e. Ive requested they be passed some arguments to assist the test. Is that good?
//Can a test call some methods in its implementation? Or best not to rely on those methods - as they too should be tested.
