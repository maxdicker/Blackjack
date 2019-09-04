package blackjack;

import blackjackTester.CardTester;
import blackjackTester.DeckTester;
import blackjackTester.GameManagerTester;
import blackjackTester.PlayerTester;

public class Main {

    public static void main(String[] args) {
        Player[] players = {new Player(), new Dealer()};
        Deck deck = new Deck();
        deck.shuffle();

//        GameManager g = new GameManager(deck, players);
//        g.play();

        runGameTests();
        runDeckTests();
        runPlayerTests();
        runCardTests();
    }

    private static Card firstCard = new Card(Card.Suit.SPADES, Card.Rank.TWO);

    private static Card[] initCards() {
        var card1 = new Card(Card.Suit.SPADES, Card.Rank.TWO);
        var card2 = new Card(Card.Suit.SPADES, Card.Rank.THREE);
        var card3 = new Card(Card.Suit.SPADES, Card.Rank.FOUR);

        Card[] testCards = {card1, card2, card3};
        return testCards;
    }

    private static Deck initDeck() {
        Deck testDeck = new Deck(initCards());
        return testDeck;
    }

    private static void runDeckTests() {
        var tester = new DeckTester(initDeck());

        tester.testDealRejectsExhaustedDeck(3);

        tester = new DeckTester(initDeck());

        tester.testDealReturnsNextCard(firstCard);
    }

    private static void runPlayerTests() {
        var testPlayer = new Player();
        testPlayer.addToHand(new Card(Card.Suit.SPADES, Card.Rank.THREE));
        testPlayer.addToHand(new Card(Card.Suit.SPADES, Card.Rank.SIX));

        var tester = new PlayerTester(testPlayer);

        tester.testAddUpdatesScore(new Card(Card.Suit.SPADES, Card.Rank.KING), 10);
    }

    private static void runCardTests() {
        var tester = new CardTester();
        final Card twoOfSpades = new Card(Card.Suit.SPADES, Card.Rank.TWO);
        final Card threeOfClubs = new Card(Card.Suit.CLUBS, Card.Rank.THREE);

        tester.testCardIsEqual(twoOfSpades, new Card(Card.Suit.SPADES, Card.Rank.TWO));
        tester.testCardIsEqual(twoOfSpades, twoOfSpades);
        tester.testCardIsNotEqual(twoOfSpades, threeOfClubs);
    }

    private static void runGameTests() {
        var testDeck = initDeck();
        var manager = new GameManager(testDeck, new Player[] {new Player()});
        var tester = new GameManagerTester(manager);
        var testPlayer = new Player();

        tester.testHitIncreasesPlayersHandSize();
        tester.testHitReducesDeckSize();

        testPlayer = new Player();
    }
}

//Do my tests indicate I wrote them after implementation? Do they look for the right behaviour?
//are they structured correctly? i.e. Ive requested they be passed some arguments to assist the test. Is that good?
//Can a test call some methods in its implementation? Or best not to rely on those methods - as they too should be tested.
