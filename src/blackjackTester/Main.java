package blackjackTester;

public class Main {

    public static void main(String[] args) {
        runCardTests();
        runDeckTests();
        runPlayerTests();
        runGameManagerTests();
    }

    private static void runCardTests() {
        var tester = new CardTester();

        tester.testCardIsEqual();
        tester.testCardIsNotEqual();
    }

    private static void runDeckTests() {
        var tester = new DeckTester();

        tester.testDealRejectsExhaustedDeck();
        tester.testDealReturnsNextCard();
    }

    private static void runPlayerTests() {
        var tester = new PlayerTester();

        tester.testAddUpdatesScore();
    }

    private static void runGameManagerTests() {
        var tester = new GameManagerTester();

        tester.testHitIncreasesPlayersHandSize();
        tester.testHitReducesDeckSize();
        tester.testThatBustedPlayerLoses();
    }
}

//Do my tests indicate I wrote them after implementation? Do they look for the right behaviour?
//are they structured correctly? i.e. Ive requested they be passed some arguments to assist the test. Is that good?
//Can a test call some methods in its implementation? Or best not to rely on those methods - as they too should be tested.