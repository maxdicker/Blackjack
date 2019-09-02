package blackjack;

public class Dealer extends Player {
    private final int minimumStayScore = 18;

    public Dealer() {
        setShowHits(false);
    }

    @Override
    public void printScore() {
        System.out.println("Dealer is at " + getScore());
        printHand();
    }

    @Override
    public String drawPrefix() {
        return "Dealer draws ";
    }

    @Override
    public boolean checkHit() {
        return (getScore() < minimumStayScore);
    }

    @Override
    public void printWinMessage() {
        System.out.println("Dealer wins!");
    }

    @Override
    public void printLoseMessage() {
        System.out.println("You beat the dealer!");
    }
}
