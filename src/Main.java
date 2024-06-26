import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scnr = new Scanner(System.in);
        Deck deck = new Deck();

        boolean playing = true;
        while (playing) {
            System.out.print("Play?\n");
            String answer = scnr.next();
            if(answer.equals("y")) {
                Play game = new Play();
                game.start(1);
            } else {
                playing = false;
            }
        }
    }
}