import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Player {
    private int space = 0;
    private Image ic;
    private ImageView icon;
    private int money = 0;

    public Player(Image image){
        icon = new ImageView(image);
    }

    protected void move(int val){

    }

    public int addMoney(int amount){
        money += amount;
        return money;
    }




    public int getSpace() {
        return space;
    }

    public void setSpace(int space) {
        this.space = space;
    }

    public Image getIc() {
        return ic;
    }

    public void setIc(Image ic) {
        this.ic = ic;
    }

    public ImageView getIcon() {
        return icon;
    }

    public void setIcon(ImageView icon) {
        this.icon = icon;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }
}
