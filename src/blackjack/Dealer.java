package blackjack;

public class Dealer extends Player {
    private final int minimumStayScore = 18;

    @Override
    public void printScore() {
        System.out.println("Dealer is at " + getScore());
    }

    @Override
    public boolean checkHit() {
        return (getScore() < minimumStayScore);
    }

    @Override
    public void printWinMessage() {
        System.out.println("Dealer wins!");
    }
}
