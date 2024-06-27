public class Card {
    private int valueOfCard = 0; //1-10 J-K = 11-13
    private int suitOfCard = 0;  //1-4 Spade,Heart,Club,Diamond
    private boolean hidden = false;

    public Card(int newCardValue, int newCardSuit) {
        valueOfCard = newCardValue;
        suitOfCard = newCardSuit;
    }

    public int getValue() {
        return valueOfCard;
    }

    public int getSuitValue() {
        return suitOfCard;
    }

    public String getStringOfValue() {
        return switch (this.valueOfCard) {
            case 1 -> "A";
            case 2 -> "2";
            case 3 -> "3";
            case 4 -> "4";
            case 5 -> "5";
            case 6 -> "6";
            case 7 -> "7";
            case 8 -> "8";
            case 9 -> "9";
            case 10 -> "T";
            case 11 -> "J";
            case 12 -> "Q";
            case 13 -> "K";
            default -> null;
        };
    }

    public String getStringOfSuit() {
        return switch (this.suitOfCard) {
            case 1 -> "S";
            case 2 -> "H";
            case 3 -> "C";
            case 4 -> "D";
            default -> null;
        };

    }

    public boolean getHidden() {
        return this.hidden;
    }

    public void setHidden(boolean hidden) {
        this.hidden = hidden;
    }
}

