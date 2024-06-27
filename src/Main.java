import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scnr = new Scanner(System.in);

        boolean playing = true;
        while (playing) {
            System.out.print("New Shoe?\n");
            String answer = scnr.next();
            if(answer.equals("y")) {
                Play game = new Play();
                game.start();
            } else {
                playing = false;
            }
        }
    }
}