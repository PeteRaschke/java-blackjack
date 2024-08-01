import java.util.Scanner;
import java.util.ArrayList;

public class Play {
    private Deck deck;
    private Scanner scnr;
    private int bet = 0;
    private int balance = 0;
    private int pHandValue = 0;
    private int dHandValue = 0;
    private int pHandSize = 0;
    private int dHandSize = 0;
    ArrayList<Card> playerHand = new ArrayList<Card>();
    ArrayList<Card> dealerHand = new ArrayList<Card>();

    public Play(int initBalance) {
        this.deck = new Deck();
        this.scnr = new Scanner(System.in);
        balance = initBalance;
    }

    //This is the main game loop
    public void start() {
        boolean playing = true;
        resetHands();

        System.out.print("Current balance: $" + balance + "\n");
        System.out.print("Place Bet: $");
        bet = Integer.parseInt(scnr.next());
        balance -= bet;
        playerHand.add(deck.drawCard());
        playerHand.add(deck.drawCard());
        pHandSize += 2;
        dealerHand.add(deck.drawCard());
        Card hiddenCard = deck.drawCard();
        hiddenCard.setHidden(true);
        dealerHand.add(hiddenCard);
        dHandSize += 2;

        //NOTE: this should be seperated, the function is doing too much
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
                    Main.newShoe(balance);
                }
            }
            System.out.print("Current hand value: " + pHandValue + "\n");
            System.out.print("Current balance: $" + balance + "\n");
            System.out.print("Cards left in shoe: " + deck.cardsLeft() + "\n"); //For Testing
            System.out.print("Hit(h), Stay(s)?");
            String answer = scnr.next();
            if (answer.equals("h")) {
                playerHand.add(deck.drawCard());
                pHandSize += 1;
            }
            else if (answer.equals("s")) {
                dealersTurn();
                Helper.buildCard(dHandSize, dealerHand);
                Helper.buildCard(pHandSize, playerHand);
                System.out.print("Current hand value: " + pHandValue + "\n");
                compareHands();
                System.out.print("Continue with this shoe? (y/n):\n");
                String cont = scnr.next();
                if (cont.equals("y")) {
                    start();
                }
                else {
                    Main.newShoe(balance);
                }
            }
            else if (answer.equals("q")) {
                playing = false;
            }
        }
    }

    //Reveals dealer's hidden card and plays out dealer turn
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

    public void compareHands() {
        if (dHandValue < pHandValue) {
            System.out.print("Player wins!\n");
            balance += bet * 2;
        }
        else if (dHandValue == pHandValue) {
            System.out.print("Draw!\n");
            balance += bet;
        }
        else if (dHandValue > 21) {
            System.out.print("Dealer bust, player wins!\n");
            balance += bet * 2;
        }
        else {
            System.out.print("Dealer wins!\n");
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