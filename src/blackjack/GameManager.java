package blackjack;

import java.util.ArrayList;
import java.util.Arrays;

public class GameManager {
    private final static int highestScore = 21;
    private Deck deck;
    private ArrayList<Player> startingPlayers;
    private ArrayList<Player> remainingPlayers;

    public GameManager(Deck deck, Player[] players, Dealer dealer) {
        this.deck = deck;
        this.startingPlayers = new ArrayList<>();
        this.startingPlayers.addAll(Arrays.asList(players));
        this.startingPlayers.add(dealer);
        this.remainingPlayers = this.startingPlayers;
    }

    public void play() {
        dealInitialCards(deck, startingPlayers);

        for (Player p : startingPlayers) {
            takeTurn(deck, p);
        }

        getWinners().printWinMessage();
    }

    public void dealInitialCards (Deck deck, ArrayList<Player> players) {
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
                    remainingPlayers.remove(player);
                    player.printLoseMessage();
                    System.exit(0);
                }
                player.printScore();
            }
        }

    }

    public Player getWinners() {

        for (Player p : startingPlayers) {
            if (remainingPlayers.contains(p) && isBust(p)) {
                remainingPlayers.remove(p);
            }
        }

        int leadingPlayer = 0;

        for (int i = 1; i < remainingPlayers.size(); i++) {
            if (!isBust(remainingPlayers.get(i))) {
                if (remainingPlayers.get(i).getScore() > remainingPlayers.get(leadingPlayer).getScore()) {
                    leadingPlayer = i;
                } else if (remainingPlayers.get(i).getScore() == remainingPlayers.get(leadingPlayer).getScore()) {
                    System.out.println("It's a tie!");
                }
            }
        }

        return remainingPlayers.get(leadingPlayer);
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
