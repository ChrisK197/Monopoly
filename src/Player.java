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

    public ImageView getImageView() {
        return icon;
    }

    public void setImageView(ImageView icon) {
        this.icon = icon;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }
}
