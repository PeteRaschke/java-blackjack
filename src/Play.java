import java.util.Scanner;
import java.util.ArrayList;

public class Play {
    private Deck deck;
    private Scanner scnr;
    private int pHandValue = 0;
    private int dHandValue = 0;
    private int pHandSize = 0;
    private int dHandSize = 0;
    ArrayList<Card> playerHand = new ArrayList<Card>();
    ArrayList<Card> dealerHand = new ArrayList<Card>();

    public Play() {
        this.deck = new Deck();
        this.scnr = new Scanner(System.in);
    }

    public void start() {
        boolean playing = true;
        resetHands();

        playerHand.add(deck.drawCard());
        playerHand.add(deck.drawCard());
        pHandSize += 2;
        dealerHand.add(deck.drawCard());
        Card hiddenCard = deck.drawCard();
        hiddenCard.setHidden(true);
        dealerHand.add(hiddenCard);
        dHandSize += 2;

        while (playing) {
            Helper.buildCard(dHandSize, dealerHand);
            Helper.buildCard(pHandSize, playerHand);
            dHandValue = Helper.handValue(dealerHand);
            pHandValue = Helper.handValue(playerHand);
            if (pHandValue > 21) {
                System.out.print("Player bust!\n");
                System.out.print("Continue with this shoe? (y/n):\n");
                String answer = scnr.next();
                if (answer.equals("y")) {
                    start();
                }
                else {
                    break;
                }
            }
            System.out.print("Current hand value: " + pHandValue + "\n");
            System.out.print("Hit(h), Stay(s)?");
            String answer = scnr.next();
            if (answer.equals("h")) {
                playerHand.add(deck.drawCard());
                pHandSize += 1;
            }
            else if (answer.equals("s")) {
                dealersTurn();
            }
            else if (answer.equals("q")) {
                playing = false;
            }
        }
    }

    public void dealersTurn() {
        boolean drawing = true;
        dealerHand.get(1).setHidden(false);
        while (drawing) {
            if (dHandValue > 16) {
                drawing = false;
            }
            else {
                dealerHand.add(deck.drawCard());
                dHandSize += 1;
                dHandValue = Helper.handValue(dealerHand);
            }
        }
    }

    public void resetHands() {
        playerHand.clear();
        dealerHand.clear();
        pHandValue = 0;
        dHandValue = 0;
        pHandSize = 0;
        dHandSize = 0;
    }
}