package blackjack;

import java.util.ArrayList;
import java.util.Scanner;

public class Player {
    private ArrayList<Card> hand;
    private int score;
    private boolean showHits = true;

    public Player() {
        hand = new ArrayList<>();
        score = 0;
    }

    public void addToHand(Card card) {
        hand.add(card);
        score += card.getValue();
    }

    public boolean isShowingHits() { return showHits; }

    public void setShowHits(boolean showHits) {
        this.showHits = showHits;
    }

    public int getScore() {
        return score;
    }

    public int numCardsInHand() {
        return hand.size();
    }

    public void printScore() {
        System.out.println("You are currently at " + getScore());
        printHand();
    }

    void printHand() {
        System.out.print("with the hand ");
        hand.forEach(System.out::print);
        System.out.println();
    }

    public String drawPrefix() {
        return "You draw ";
    }

    public void refreshScore() {
        for (Card card : hand) {
            if (card.getRank() == Card.Rank.ACE && card.getValue() > 1) {
                card.setValue(1);
                score -= 10;
            }
        }
    }

    public void printWinMessage() {
        System.out.println("You beat the dealer!");
    }

    public void printLoseMessage() {
        System.out.println("Dealer wins!");
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

    public boolean equals(Player player) {
        return this.hand.equals(player.getHand());
    }

    public ArrayList<Card> getHand() {
        return hand;
    }
}