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
        int roll = 1;
        for(int i=1; i<=roll; i++){
            if(space+1==40){
                space=0;
            }
            else{
                if(0<=space && space<=9){
                    icon.setX(icon.getX()-65);
                }
                else if(10<=space && space<=19){
                    icon.setY(icon.getY()-65);
                }
                else if(20<=space && space<=29){
                    icon.setX(icon.getX()+65);
                }
                else if(30<=space && space<=39){
                    icon.setY(icon.getY()+65);
                }
                else{
                    System.out.println("Didn't deatect where the space is.");
                }
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
