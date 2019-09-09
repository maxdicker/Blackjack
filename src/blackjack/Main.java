package blackjack;

public class Main {

    public static void main(String[] args) {
        Player[] players = {new Player()};
        Dealer dealer = new Dealer();
        Deck deck = new Deck();
        deck.shuffle();

        GameManager game = new GameManager(deck, players, dealer);
        game.play();

    }
}