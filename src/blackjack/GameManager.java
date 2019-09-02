package blackjack;

public class GameManager {
    private final static int highestScore = 21;
    private Deck deck;
    private Player[] players;

    public GameManager(Deck deck, Player[] players) {
        this.deck = deck;
        this.players = players;
    }

    public void play() {
        dealInitialCards(deck, players);

        for (Player p : players) {
            takeTurn(deck, p);
        }

        checkWinner(players);
    }

    public void dealInitialCards (Deck deck, Player[] players) {
        for (Player p : players) {
            hit(deck, p);
            hit(deck, p);
        }
    }

    public void hit(Deck deck, Player player) {
        Card draw = deck.deal();
        player.addToHand(draw);
        if (player.isShowingHits()) {
            System.out.println(player.drawPrefix() + draw);
        }
    }

    public void takeTurn(Deck deck, Player player) {

        // check for BlackJack => If satisfied, then print and move on to the next person (or exit)

        // check for bust => If satisifed, then print and move on to the next person (or exit)

        // otherwise, checkhit
        // get the new score
        // check for BlackJack => If satisfied, then print and move on to the next person (or exit)

        // check for bust => If satisifed, then print and move on to the next person (or exit)

        if (player.getScore() == highestScore) {
            System.out.println("Blackjack!");
        } else {
            player.setShowHits(true);
            player.printScore();
            while (player.checkHit()) {
                hit(deck, player);
                if (isBust(player)) {
                    player.printLoseMessage();
                    System.exit(0);
                }
                player.printScore();
            }
        }

    }

    public void checkWinner(Player[] players) {
        int winningPlayer = 0;

        for (int i = 1; i < players.length; i++) {
            if (players[i].getScore() > players[winningPlayer].getScore()) {
                winningPlayer = i;
            } else if (players[i].getScore() == players[winningPlayer].getScore()) {
                System.out.println("It's a tie!");
            }
        }

        players[winningPlayer].printWinMessage();
    }

    public boolean isBust(Player player) {
        if (player.getScore() > highestScore) {
            player.refreshScore();

            if (player.getScore() > highestScore) {
                System.out.println("Bust!");
                return true;
            }
        }
        return false;
    }

    public Deck getDeck() {
        return deck;
    }

}
