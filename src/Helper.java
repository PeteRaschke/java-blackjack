import java.util.ArrayList;

public class Helper {
    public static int handValue(ArrayList<Card> hand) {
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

    //Prints out cards line by line
    public static void buildCard(int numCards, ArrayList<Card> hand) {
        top(numCards);
        center(numCards, hand);
        bottom(numCards);
        System.out.print("\n");
    }

    public static void top(int numCards) {
        for (int i = 0; i < numCards; i++) {
            System.out.print(" _____  ");
        }
        System.out.print("\n");
    }

    public static void center(int numCards, ArrayList<Card> hand) {
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

    public static void bottom(int numCards) {
        for (int i = 0; i < numCards; i++) {
            System.out.print(" ‾‾‾‾‾  ");
        }
        System.out.print("\n");
    }
}
