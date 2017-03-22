import java.util.Random;

/**
 * Created by estensen on 21/03/2017.
 */
public class Card {
    private final Rank rank;
    private final Suit suit;

    public enum Color {
        RED, BLACK
    }

    public enum Rank {
        ACE(1, "Ace"), TWO(2, "2"), THREE(3, "3"), FOUR(4, "4"), FIVE(5, "5"), SIX(6, "6"), SEVEN(7, "7"),
        EIGHT(8, "8"), NINE(9, "9"), TEN(10, "10"), JACK(11, "Jack"), QUEEN(12, "Queen"), KING(13, "King");
        private final int value;
        private final String displayName;

        Rank(int value, String displayName) {
            this.value = value;
            this.displayName = displayName;
        }

        public int getValue() {
            return value;
        }

        public String getDisplayName() {
            return displayName;
        }

        public static Rank of(int value) {
            return java.util.Arrays.stream(Rank.values())
                    .filter(rank -> rank.getValue() == value)
                    .findFirst()
                    .orElseThrow(() -> new IllegalArgumentException("No card with value " + value + "exists."));
        }
    }

    public enum Suit {
        HEARTS(Color.RED, "hearts"), DIAMONDS(Color.RED, "diamonds"), SPADES(Color.BLACK, "spades"), CLUBS(Color.BLACK, "clubs");
        private Color color;
        private String displayName;

        Suit(Color color, String displayName) {
            this.color = color;
            this.displayName = displayName;
        }

        public Color getColor() {
            return color;
        }

        public String getDisplayName() {
            return displayName;
        }
    }

    public Card(Rank rank, Suit suit) {
        this.rank = rank;
        this.suit = suit;
    }

    public static Card random() {
        Random generator = new Random();
        Rank rank = Rank.values()[generator.nextInt(Rank.values().length)];
        Suit suit = Suit.values()[generator.nextInt(Suit.values().length)];
        return new Card(rank, suit);
    }

    @Override
    public String toString() {
        return rank.getDisplayName() + " of " + suit.getDisplayName();
    }

    public static void main(String[] args) {
        System.out.println(Card.random());
    }
}
