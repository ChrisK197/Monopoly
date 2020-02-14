import javafx.beans.property.StringProperty;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.File;
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
    private Text moneyText = new Text();
    private Text propText = new Text();
    private boolean dead = false;

    private int rollStreak = 0;
    private int jail = 0;

    private String musicFile = "diceRoll.mp3";
    private Media sound = new Media(new File(musicFile).toURI().toString());
    private MediaPlayer mediaPlayer = new MediaPlayer(sound);

    private String musicFile2 = "chaChing.mp3";
    private Media sound2 = new Media(new File(musicFile2).toURI().toString());
    private MediaPlayer mediaPlayer2 = new MediaPlayer(sound2);

    private String musicFile3 = "sadTrombone.mp3";
    private Media sound3 = new Media(new File(musicFile3).toURI().toString());
    private MediaPlayer mediaPlayer3 = new MediaPlayer(sound3);

    public Player(Image image, int x, int y, int pnum){
        icon = new ImageView(image);
        startX = x;
        startY = y;
        playerNum = pnum;
        moneyText.setText(String.format("Money: $%d", money));
        moneyText.setScaleX(2); moneyText.setScaleY(2);
        propText.setText("Properties: None");
    }
    //total of 40 squares. Go is 0. Last is 39
    protected void move(){
        //change to math.random() later.
        int roll = (int)(Math.random()*6)+1;
        int roll2 = (int)(Math.random()*6)+1;
        if (roll == roll2) {
            if (++rollStreak >= 3) {
                jail = 1;
            }
        }
        else {
            rollStreak = 0;
        }
        Stage stage = new Stage();
        stage.setTitle("Roll");
        Pane p = new Pane();
        Text t = new Text(150, 250, "Player " + playerNum + " rolled a " + roll + " and a " + roll2);
        t.setFont(new Font(26));
        p.getChildren().add(t);
        Scene ss = new Scene(p, 500, 500);
        stage.setScene(ss);
        stage.show();

        if (!(jail > 1)) {
            roll += roll2;
        }

        mediaPlayer.setVolume(100);
        mediaPlayer.play();
        for(int i=1; i<=roll; i++){
            if (jail == 1) {
                icon.setX(startX-525);
                icon.setY(startY-35);
                jail++;
                space = 10;
                return;
            }
            if (jail > 1 && jail < 5) {
                if (roll == roll2) {
                    jail = 0;
                    roll += roll2;
                    icon.setX(96);
                    icon.setY(startY);
                }
                else {
                    Stage stageask = new Stage();
                    stageask.setTitle("Want to bail?");
                    Text text = new Text(150, 250, "Want to bail out of jail for $50?" );
                    Pane pane = new Pane();
                    Button yes = new Button();
                    yes.setText("Yes!");
                    yes.setOnAction(e->{
                        addMoney(-50);
                        jail = 0;
                        icon.setX(85);
                        icon.setY(575);
                        space = 10;
                        stage.close();
                        return;
                    });
                    Button no = new Button();
                    no.setText("NO");
                    no.setOnAction(e->{
                        stage.close();
                        jail++;
                        return;
                    });
                    yes.setLayoutX(50);
                    yes.setLayoutY(100);
                    no.setLayoutX(100);
                    no.setLayoutY(100);
                    text.setX(10);
                    text.setY(25);
                    pane.getChildren().add(yes);
                    pane.getChildren().add(no);
                    pane.getChildren().add(text);
                    Scene sse = new Scene(pane, 250, 200);
                    stage.setScene(sse);
                    stage.show();
                }
            }
            if (jail >= 5) {
                Stage stageask = new Stage();
                stageask.setTitle("Automatic bail");
                Text text = new Text(150, 250, "You are being automatically bailed out of jail. You will lose $50");
                Pane pane = new Pane();
                pane.getChildren().add(text);
                Scene sse = new Scene(pane, 250, 200);
                stage.setScene(sse);
                stage.show();
            }
            if(space+1==40){
                space=0;
                addMoney(200);
                Stage stage2 = new Stage();
                stage2.setTitle("Go");
                Text t2 = new Text(10, 50, "Player " + playerNum + " gained $200 from passing go");
                Pane pane2 = new Pane();
                pane2.getChildren().add(t2);
                Scene ss2 = new Scene(pane2, 250, 150);
                stage2.setScene(ss2);
                stage2.show();
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
                if (space == 30) {
                    icon.setX(startX-525);
                    icon.setY(startY-35);
                    jail = 2;
                    space = 10;
                    return;
                }
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
        if(money <= 0){
            dead = true;
            emptyProps();
            mediaPlayer3.setVolume(100);
            mediaPlayer3.play();
            propText.setText("Properties: Bankrupt!!");
            moneyText.setText("Bankrupt!!");
            return 0;
        }
        else {
            moneyText.setText(String.format("Money: $%d", money));
            return money;
        }
    }

    public void action(Property property){
        if(!(property.isPurchased())){
            Stage stage = new Stage();
            stage.setTitle("Want to buy " + property.getName() + "?");
            Text t = new Text(150, 250, "Want to buy " + property.getName() + " for $" + property.getPrice()+"?" );
            Pane p = new Pane();
            Button yes = new Button();
            yes.setText("Yes!");
            yes.setOnAction(e->{
                this.addMoney(property.getPrice()*-1);

                mediaPlayer2.setVolume(100);
                mediaPlayer2.play();
                if(!dead) {
                    property.setPurchased(true);
                    property.setOwner(this);
                    propertiesOwned.add(property);
                    String str = "Properties: ";
                    for (int i = 0; i < propertiesOwned.size(); i++) {
                        str += propertiesOwned.get(i).getName() + ", ";
                    }
                    propText.setText(str);
                }
                propText.setWrappingWidth(860-670-10);
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
        else if(property.getSpacenum()==12 || property.getSpacenum()==28){
            Player owner = property.getOwner();
            Stage stage = new Stage();
            Button roll= new Button();
            roll.setText("Roll");
            roll.setLayoutX(50);
            roll.setLayoutY(50);
            roll.setOnAction(e->{
                int num = (int)(Math.random()*12)+1;
                this.addMoney(num*4*-1);
                owner.addMoney(property.getTax());
                stage.setTitle("Gain/Lose money");
                Text t3 = new Text(10, 50, "Player " + playerNum + " rolled a " + num);
                Text t = new Text(10, 100, "Player " + playerNum + " lost $" + num*4);
                Text t2 = new Text(10, 150, "Player " + owner.playerNum + " gained $" + num*4);
                Pane p = new Pane();
                p.getChildren().add(t);
                p.getChildren().add(t2);
                p.getChildren().add(t3);
                Scene ss = new Scene(p, 100, 250);
                stage.setScene(ss);
                stage.show();
            });
            Pane p = new Pane();
            p.getChildren().add(roll);
            Scene ss = new Scene(p, 100, 100);
            stage.setScene(ss);
            stage.show();
        }
        else{
            Player owner = property.getOwner();
            Stage stage = new Stage();
            this.addMoney(property.getTax()*-1);
            owner.addMoney(property.getTax());
            stage.setTitle("Gain/Lose money");
            Text t = new Text(10, 50, "Player " + playerNum + " lost $" + property.getTax());
            Text t2 = new Text(10, 100, "Player " + owner.playerNum + " gained $" + property.getTax());
            Pane p = new Pane();
            p.getChildren().add(t);
            p.getChildren().add(t2);
            Scene ss = new Scene(p, 250, 150);
            stage.setScene(ss);
            stage.show();
        }
    }

    public void incomeTax(int val){
        Stage stage = new Stage();
        stage.setTitle("Income Tax");
        Text t = new Text(10, 50, "Player " + playerNum + " lost $" + val);
        Pane p = new Pane();
        p.getChildren().add(t);
        Scene ss = new Scene(p, 250, 150);
        stage.setScene(ss);
        stage.show();
    }

    public void emptyProps(){
        for(int i = 0; i < propertiesOwned.size(); i++){
            propertiesOwned.get(i).setPurchased(false);
            propertiesOwned.get(i).setOwner(null);
        }
        propertiesOwned.clear();
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

    public Text getMoneyText() {
        return moneyText;
    }

    public void setMoneyText(Text moneyText) {
        this.moneyText = moneyText;
    }

    public Text getPropText() {
        return propText;
    }

    public void setPropText(Text propText) {
        this.propText = propText;
    }

    public boolean isDead() {
        return dead;
    }

    public void setDead(boolean dead) {
        this.dead = dead;
    }
}
