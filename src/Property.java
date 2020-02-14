import java.util.HashMap;

public class Property {
    private int price;
    private int tax;
    private String color;
    private boolean isPurchased = false;
    private String name;
    private int spacenum;
    protected static HashMap<String, Integer> propToNum = new HashMap<>();
    static {
        propToNum.put("purple", 2);
        propToNum.put("lblue", 3);
        propToNum.put("pink", 3);
        propToNum.put("orange", 3);
        propToNum.put("red", 3);
        propToNum.put("yellow", 3);
        propToNum.put("green", 3);
        propToNum.put("dblue", 2);
        propToNum.put("railroad", 4);
        propToNum.put("utility", 2);

    }


    public Property(int price, int tax, String color, String name, int space){
        this.price = price;
        this.tax = tax;
        this.color = color;
        this.name = name;
        spacenum = space;
    }


}
