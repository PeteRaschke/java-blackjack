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

        playerHand.add(deck.drawCard());
        playerHand.add(deck.drawCard());
        pHandSize += 2;
        dealerHand.add(deck.drawCard());
        Card hiddenCard = deck.drawCard();
        hiddenCard.setHidden(true);
        dealerHand.add(hiddenCard);
        dHandSize += 2;

        while (playing) {
            buildCard(dHandSize, dealerHand);
            buildCard(pHandSize, playerHand);
            dHandValue = handValue(dealerHand);
            pHandValue = handValue(playerHand);
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
                dHandValue = handValue(dealerHand);
            }
        }
    }

    public int handValue(ArrayList<Card> hand) {
        int handVal = 0;
        int numAces = 0;

        for (Card card : hand) {
            if (card.getValue() == 1) {
                numAces += 1;
            }
            else if (card.getValue() < 10) {
                handVal += card.getValue();
            }
            else{
                handVal += 10;
            }
        }
        for (int i = 0; i < numAces; i++) {
            if(handVal < 11) {
                handVal += 11;
            }
            else {
                handVal += 1;
            }
        }

        return handVal;
    }

    public void buildCard(int numCards, ArrayList<Card> hand) {
        top(numCards);
        center(numCards, hand);
        bottom(numCards);
        System.out.print("\n");
    }

    public void top(int numCards) {
        for (int i = 0; i < numCards; i++) {
            System.out.print(" _____  ");
        }
        System.out.print("\n");
    }

    public void center(int numCards, ArrayList<Card> hand) {
        for (int i = 0; i < numCards; i++) {
            if (!hand.get(i).getHidden()) {
                System.out.print("|" + hand.get(i).getStringOfValue() + "    | ");
            }
            else {
                System.out.print("|     | ");
            }
        }
        System.out.print("\n");
        for (int i = 0; i < numCards; i++) {
            if (!hand.get(i).getHidden()) {
                System.out.print("|  " + hand.get(i).getStringOfSuit() + "  | ");
            }
            else {
                System.out.print("|     | ");
            }
        }
        System.out.print("\n");
        for (int i = 0; i < numCards; i++) {
            if (!hand.get(i).getHidden()) {
                System.out.print("|    " + hand.get(i).getStringOfValue() + "| ");
            }
            else {
                System.out.print("|     | ");
            }
        }
        System.out.print("\n");
    }

    public void bottom(int numCards) {
        for (int i = 0; i < numCards; i++) {
            System.out.print(" ‾‾‾‾‾  ");
        }
        System.out.print("\n");
    }
}