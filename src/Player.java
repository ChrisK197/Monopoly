import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Player {
    private int space = 0;
    private Image ic;
    private ImageView icon;
    private int money = 1500;

    public Player(Image image){
        icon = new ImageView(image);
    }
    //total of 40 squares. Go is 0. Last is 39
    protected void move(){
        int roll = (int)(Math.random()*6)+1;
        for(int i=1; i<=roll; i++){
            if(space+i==40){
                space=0;
            }
            else{
                space++;
            }
        }
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
