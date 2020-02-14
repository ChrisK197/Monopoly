import java.util.HashMap;

public class Property {
    private int price;
    private int tax;
    private String color;
    private boolean isPurchased = false;
    private String name;
    private int spacenum;
    //protected static HashMap<String, Integer> propToNum= {"Brown": 2};

    public Property(int price, int tax, String color, String name, int space){
        this.price = price;
        this.tax = tax;
        this.color = color;
        this.name = name;
        spacenum = space;
    }


}
