package blackjack;

public class GameManager {
    private final static int highestScore = 21;
    private static Deck deck = new Deck();

    public static void play() {
        deck.shuffle();

        Player player = new Player();
        Dealer dealer = new Dealer();
        dealInitialCards(player);
        dealInitialCards(dealer);

        takeTurn(player);

        dealer.printScore();
        takeTurn(dealer);

        checkWinner(dealer, player);
    }

    private static void dealInitialCards (Player player) {
        hit(player);
        hit(player);
    }

    private static void hit(Player player) {
        Card draw = deck.deal();
        player.addToHand(draw);
        System.out.println("You draw " + draw);
    }

    private static void takeTurn(Player player) {
        if (player.getScore() == highestScore) {
            System.out.println("Blackjack!");
        } else {
            player.printScore();
            player.printHand();
            while (player.checkHit()) {
                hit(player);
                checkBust(player);
            }
        }

    }

    private static void checkWinner(Player player1, Player player2) {
        if (player1.getScore() > player2.getScore()) {
            player1.printWinMessage();
        } else if (player1.getScore() < player2.getScore()) {
            player2.printWinMessage();
        } else {
            System.out.println("It's a tie!");
        }
    }

    private static void checkBust(Player player) {
        if (player.getScore() > highestScore) {
            player.refreshScore();

            if (player.getScore() > highestScore) {
                System.out.println("Bust!");
            }
        }
    }
}
