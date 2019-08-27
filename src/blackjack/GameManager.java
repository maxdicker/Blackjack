package blackjack;

import java.util.Scanner;

public class GameManager {
    private static Deck deck = new Deck();

    public static void play() {
        deck.shuffle();
        Scanner scanner = new Scanner(System.in);

        Player player = new Player();
        Player dealer = new Player();
        dealInitialCards(player);
        dealInitialCards(dealer);

        printScore(dealer);

        while (player.getScore() <= 21) {
            printScore(player);
            System.out.println("Hit or stay? (Hit = 1, Stay = 0)");
            String decision = scanner.nextLine();

            if (decision.equals("1")) {
                hit(player);
            } else if (decision.equals("0")) {
                break;
            } else {
                System.out.println("Invalid input. Try again");
            }
        }

        while (dealer.getScore() < 17) {
            hit(dealer);
        }


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

    private static void printScore(Player player) {
        System.out.println("You are currently at " + player.getScore());
    }

}
