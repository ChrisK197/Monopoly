public class CommunityCard {
    private static String[] cards = {"Advance to Go", "Bank error in your favor. Collect $200", "Doctor's fees. Pay $50",
            "From sale of stock you get $50", "Get out of jail free", "Go directly to jail", "Collect $50 from every player for opening night seats.",
            "Holiday Fund matures. Receive $100", "Income tax refund. Collect $20.", "It's your birthday. Collect $10 from every player.",
            "You have been elected Chairman of the Board. Pay each player $50", "You inherit $100", "School fees. Pay $50"};

    private String cardPhrase;

    public static int total = cards.length;

    public CommunityCard () {
        cardPhrase = cards[(int)(Math.random()*total)];
    }

    //arr[0] --> 0 = move; 1 = money
    public int[] cardType() {
        int[] arr = new int[2];
        if (cardPhrase.equals(cards[0]) || cardPhrase.equals(cards[5])) {
            arr[0] = 0;
            if (cardPhrase.equals(cards[0])) {
                arr[1] = 0;
            }
            else {
                arr[1] = -1;
            }
        }
        else {
            arr[0] = 1;
            if (cardPhrase.equals(cards[1])) {
                arr[1] = 200;
            }
            else if (cardPhrase.equals(cards[2])) {
                arr[1] = -50;
            }
            else if (cardPhrase.equals(cards[3])) {
                arr[1] = 50;
            }
            else if (cardPhrase.equals(cards[4])) {
                arr[1] = 0;
            }
            else if (cardPhrase.equals(cards[6])) {
                //Special case - collect from all
                arr[1] = 50;
            }
            else if (cardPhrase.equals(cards[7])) {
                arr[1] = 100;
            }
            else if (cardPhrase.equals(cards[8])) {
                arr[1] = 20;
            }
            else if (cardPhrase.equals(cards[9])) {
                //Special case - collect from all
                arr[1] = 10;
            }
            else if (cardPhrase.equals(cards[10])) {
                //Special case - collect from all
                arr[1] = -50;
            }

            else if (cardPhrase.equals(cards[11])) {
                arr[1] = 100;
            }

            else if (cardPhrase.equals(cards[12])) {
                arr[1] = -50;
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
