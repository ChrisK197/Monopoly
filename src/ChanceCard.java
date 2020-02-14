public class ChanceCard {
    private static String[] cards = {"Advance to Go, and collect $200 on the way", "Advance to Illinois Avenue. If you pass Go, collect $200",
            "Advance St. Charles Place. If you pass Go, collect $200", "Get out of jail free", "Go back three spaces",
            "Go to jail. Go directly to jail.", "Pay $25 for each property", "Pay poor tax of $15",
            "Go to the Reading Railroad. If you pass Go, collect $200", "You have been elected Chairman of the Board. Pay each player $50",
            "Your investments are soaring. Collect $150", "You have won a crossword competition. Collect $100"};

    private String cardPhrase;

    public static int total = cards.length;

    public ChanceCard () {
        cardPhrase = cards[(int)(Math.random()*total)];
    }

    //arr[0] --> 0 = move; 1 = money
    public int[] cardType() {
        int[] arr = new int[2];
        if (cardPhrase.equals(cards[0]) || cardPhrase.equals(cards[1]) || cardPhrase.equals(cards[2]) || cardPhrase.equals(cards[4]) || cardPhrase.equals(cards[5]) || cardPhrase.equals(cards[8])) {
            arr[0] = 0;
            if (cardPhrase.equals(cards[0])) {
                arr[1] = 0;
            }
            else if (cardPhrase.equals(cards[1])) {
                arr[1] = 24;
            }
            else if (cardPhrase.equals(cards[2])) {
                arr[1] = 11;
            }
            else if (cardPhrase.equals(cards[4])) {
                arr[1] = -3;
            }
            else if (cardPhrase.equals(cards[5])) {
                arr[1] = -1;
            }
            else {
                arr[1] = 5;
            }
        }
        else {
            arr[0] = 1;
            if (cardPhrase.equals(cards[3])) {
                arr[1] = 0;
            }
            else if (cardPhrase.equals(cards[6])) {
                arr[1] = -25;
            }
            else if (cardPhrase.equals(cards[7])) {
                arr[1] = -15;
            }
            else if (cardPhrase.equals(cards[9])) {
                arr[1] = -50;
            }
            else if (cardPhrase.equals(cards[10])) {
                arr[1] = 150;
            }
            else {
                arr[1] = 100;
            }
        }
        return arr;
    }

    public String getCardPhrase () {
        return cardPhrase;
    }

}
