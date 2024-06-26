import java.util.Scanner;

public class Play {
    private Deck deck;
    private Scanner scnr;
    private Card[] playerHand;
    private Card[] dealerHand;

    public Play() {
        this.deck = new Deck();
        this.scnr = new Scanner(System.in);
    }

    public void start(int players) {
        boolean playing = true;

        deal(players);
        while (playing) {
            System.out.print("Hit?");
            String answer = scnr.next();
            if(answer.equals("y")) {
                hit();
            } else {
                playing = false;
            }
        }
    }

    public void deal(int player){
        for (int i = 0; i <= player; i++) {
            if (i > 0) {
                buildCard(2);
            }
            else {
                buildCard(1);
            }
        }
    }

    public void hit() {

    }

    public void buildCard(int numCards) {
        Card[] hand = new Card[numCards];

        for (int i = 0; i < numCards; i++) {
           Card currCard = deck.drawCard();
           hand[i] = currCard;
        }

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

    public void center(int numCards, Card[] hand) {
        for (int i = 0; i < numCards; i++) {
            System.out.print("|" + hand[i].getStringOfValue() + "    | ");
        }
        System.out.print("\n");
        for (int i = 0; i < numCards; i++) {
            System.out.print("|  " + hand[i].getStringOfSuit() + "  | ");
        }
        System.out.print("\n");
        for (int i = 0; i < numCards; i++) {
            System.out.print("|    " + hand[i].getStringOfValue() + "| ");
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

