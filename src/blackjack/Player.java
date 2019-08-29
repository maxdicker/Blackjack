package blackjack;

import java.util.ArrayList;
import java.util.Scanner;

public class Player {
    private ArrayList<Card> hand;
    private int score;

    public Player() {
        hand = new ArrayList<>();
        score = 0;
    }

    public void addToHand(Card card) {
        hand.add(card);
        score += card.getValue();
    }

    public int getScore() {
        return score;
    }

    public void printScore() {
        System.out.println("You are currently at " + getScore());
    }

    public void printHand() {
        System.out.print("with the hand ");
        hand.forEach(System.out::print);
        System.out.println();
    }

    public void refreshScore() {
        for (Card card : hand) {
            if (card.getRank() == Card.Rank.ACE && card.getValue() > 1) {
                card.changeValue(1);
                score -= 10;
            }
        }
    }

    public void printWinMessage() {
        System.out.println("You beat the dealer!");
    }

    public boolean checkHit() {
        Scanner scanner = new Scanner(System.in);
        String decision;

        do {
            System.out.println("Hit or stay? (Hit = 1, Stay = 0)");
            decision = scanner.nextLine();

            if (decision.equals("1")) {
                return true;
            } else if (decision.equals("0")) {
                return false;
            }

            System.out.println("Invalid input. Try again");
        } while (true);
    }

}