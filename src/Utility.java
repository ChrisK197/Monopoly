public class Utility {
    private int price;
    private boolean isPurchased = false;
    private String name;
    private int spacenum;
    private Player owner;
    public Utility(int price, String name, int spacenum){
        this.price = price;
        this.name = name;
        this.spacenum=spacenum;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public boolean isPurchased() {
        return isPurchased;
    }

    public void setPurchased(boolean purchased) {
        isPurchased = purchased;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSpacenum() {
        return spacenum;
    }

    public void setSpacenum(int spacenum) {
        this.spacenum = spacenum;
    }

    public Player getOwner() {
        return owner;
    }

    public void setOwner(Player owner) {
        this.owner = owner;
    }
}
