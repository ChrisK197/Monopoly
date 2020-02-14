import java.util.HashMap;

public class Property {
    private int price;
    private int tax;
    private String color;
    private boolean isPurchased = false;
    private String name;
    private int spacenum;
    private Player owner;
    public static HashMap<String, Integer> propToNumOfColor = new HashMap<>();
    static {
        propToNumOfColor.put("purple", 2);
        propToNumOfColor.put("lblue", 3);
        propToNumOfColor.put("pink", 3);
        propToNumOfColor.put("orange", 3);
        propToNumOfColor.put("red", 3);
        propToNumOfColor.put("yellow", 3);
        propToNumOfColor.put("green", 3);
        propToNumOfColor.put("dblue", 2);
        propToNumOfColor.put("railroad", 4);
        propToNumOfColor.put("utility", 2);

    }

    public Property(int price, int tax, String color, String name, int space){
        this.price = price;
        this.tax = tax;
        this.color = color;
        this.name = name;
        spacenum = space;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getTax() {
        return tax;
    }

    public void setTax(int tax) {
        this.tax = tax;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
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

    public static HashMap<String, Integer> getPropToNumOfColor() {
        return propToNumOfColor;
    }

    public static void setPropToNumOfColor(HashMap<String, Integer> propToNumOfColor) {
        Property.propToNumOfColor = propToNumOfColor;
    }

    public Player getOwner() {
        return owner;
    }

    public void setOwner(Player owner) {
        this.owner = owner;
    }
}
