import java.util.HashMap;

public class Property {
    private int price;
    private int tax;
    private String color;
    private boolean isPurchased = false;
    private String name;
    private int spacenum;
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


}
