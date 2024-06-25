import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scnr = new Scanner(System.in);
        Deck deck = new Deck();

        boolean play = true;
        while (play) {
            System.out.print("Hit?\n");
            String answer = scnr.next();
            if(answer.equals("y")) {
                Card card = deck.drawCard();
                System.out.print(card.getStringOfValue() + card.getStringOfSuit() + "\n");
            } else {
                play = false;
            }
        }
    }
}