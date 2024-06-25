import java.util.Random;

public class Deck {
    private Card[] deck = new Card[52];
    private int size = 0;

    public Deck() {
        fillDeck();
        shuffle();
    }

    public void fillDeck() {
        int indexCount = 0;
        for (int suit = 1; suit <= 4; suit++) {
            for (int value = 1; value <= 13; value++) {
                deck[indexCount] = new Card(value, suit);
                indexCount++;
                size++;
            }
        }
    }

    public void shuffle() {
        //Shuffles deck using Fisher-Yates Shuffle
        Random random = new Random();
        for (int i = size - 1; i > 0; i--) {
            int j = random.nextInt(i + 1);
            Card tempCard = deck[i];
            deck[i] = deck[j];
            deck[j] = tempCard;
        }
    }

    public Card drawCard() {
        Card cardDrawn = deck[size - 1];
        size--;
        return cardDrawn;
    }

    public int cardsLeft() {
        return size;
    }
}
