import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.util.ArrayList;

public class Player {
    private int space = 0;
    private Image ic;
    private ImageView icon;
    private int money = 1500;
    private int startX;
    private int startY;
    private int playerNum;
    private ArrayList<Property> propertiesOwned = new ArrayList<>();
    private boolean allPurpleProps = false;
    private boolean allLBlueProps = false;
    private boolean allPinkProps = false;
    private boolean allOrangeProps = false;
    private boolean allRedProps = false;
    private boolean allYellowProps = false;
    private boolean allGreenProps = false;
    private boolean allDBlueProps = false;

    public Player(Image image, int x, int y, int pnum){
        icon = new ImageView(image);
        startX = x;
        startY = y;
        playerNum = pnum;
    }
    //total of 40 squares. Go is 0. Last is 39
    protected void move(){
        //change to math.random() later.
        int roll = (int)(Math.random()*6)+1;
        Stage stage = new Stage();
        stage.setTitle("Roll");
        Pane p = new Pane();
        Text t = new Text(150, 250, "Player " + playerNum + " rolled a " + roll);
        t.setFont(new Font(26));
        p.getChildren().add(t);
        Scene ss = new Scene(p, 500, 500);
        stage.setScene(ss);
        stage.show();
        for(int i=1; i<=roll; i++){
            if(space+1==40){
                space=0;
                addMoney(200);
            }
            else {
                space++;
            }
            if(space==0){
                //change later to make better
                icon.setX(startX);
                icon.setY(startY);
            }
            else if(space==1){
                icon.setX(520);
            }
            else if(2<=space && space<=10){
                icon.setX(icon.getX()-53);
            }
            else if(space==11){
                icon.setY(520);
            }
            else if(12<=space && space<=20){
                icon.setY(icon.getY()-53);
            }
            else if(21==space){
                icon.setX(icon.getX()+55);
            }
            else if(22<=space && space<=30){
                icon.setX(icon.getX()+53);
            }
            else if(31== space){
                icon.setY(icon.getY()+47);
            }
            else if(32<=space && space<=40){
                icon.setY(icon.getY()+53);
            }
            else{
                System.out.println("Didn't detect where the space is.");
            }
        }
    }

    public int addMoney(int amount){
        money += amount;
        return money;
    }

    public void action(Property property){
        if(!(property.isPurchased())){
            Stage stage = new Stage();
            stage.setTitle("Want to buy " + property.getName() + "?");
            Text t = new Text(150, 250, "Want to buy " + property.getName() + "?");
            Pane p = new Pane();
            Button yes = new Button();
            yes.setText("Yes!");
            yes.setOnAction(e->{
                this.addMoney(property.getPrice()*-1);
                property.setPurchased(true);
                property.setOwner(this);
                propertiesOwned.add(property);
                stage.close();
                return;
            });
            Button no = new Button();
            no.setText("NO");
            no.setOnAction(e->{
                stage.close();
                return;
            });
            yes.setLayoutX(50);
            yes.setLayoutY(100);
            no.setLayoutX(100);
            no.setLayoutY(100);
            t.setX(10);
            t.setY(25);
            p.getChildren().add(yes);
            p.getChildren().add(no);
            p.getChildren().add(t);
            Scene ss = new Scene(p, 250, 200);
            stage.setScene(ss);
            stage.show();
        }
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

    public int getStartX() {
        return startX;
    }

    public void setStartX(int startX) {
        this.startX = startX;
    }

    public int getStartY() {
        return startY;
    }

    public void setStartY(int startY) {
        this.startY = startY;
    }

    public ArrayList<Property> getPropertiesOwned() {
        return propertiesOwned;
    }

    public void setPropertiesOwned(ArrayList<Property> propertiesOwned) {
        this.propertiesOwned = propertiesOwned;
    }
}
