public class CommunityCard {
    private static String[] cards = {"Advance to Go", "Bank error in your favor. Collect $200", "Doctor's fees. {fee} Pay $50", "From sale of stock you get $50", "Get out of jail free", "Go directly to jail", "Collect $50 from every player for opening night seats. ", "Holiday {Xmas} Fund matures. Receive {Collect} $100", "Income tax refund. Collect $20.", "It's your birthday. Collect $10 from every player.",
            "You have been elected Chairman of the Board. Pay each player $50",
            "You inherit $100", "School fees. Pay $50"};

    private String cardPhrase;

    public static int total = cards.length;

    public CommunityCard () {
        cardPhrase = cards[(int)(Math.random()*total)];
    }

    public String getCardPhrase () {
        return cardPhrase;
    }

}
