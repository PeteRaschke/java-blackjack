import java.util.Scanner;

public class Main {
    private static Scanner scnr = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.print("Enter Starting Balance: $");
        int balance = Integer.parseInt(scnr.next());

        newShoe(balance);
    }

    public static void newShoe(int balance) {
        boolean playing = true;
        while (playing) {
            System.out.print("New Shoe? (y/n)\n");
            String answer = scnr.next();
            if(answer.equals("y")) {
                Play game = new Play(balance);
                game.start();
            } else {
                playing = false;
            }
        }
    }
}