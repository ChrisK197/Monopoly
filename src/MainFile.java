import javafx.application.Application;
import javafx.beans.property.StringProperty;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class MainFile extends Application {
    public Property purple1;
    public Property purple2;
    public Property railroad1;
    public Property railroad2;
    public Property railroad3;
    public Property railroad4;
    public Property lblue1;
    public Property lblue2;
    public Property lblue3;
    public Property pink1;
    public Property pink2;
    public Property pink3;
    public Property orange1;
    public Property orange2;
    public Property orange3;
    public Property red1;
    public Property red2;
    public Property red3;
    public Property yellow1;
    public Property yellow2;
    public Property yellow3;
    public Property green1;
    public Property green2;
    public Property green3;
    public Property dblue1;
    public Property dblue2;
    public Property[] properties = {
            purple1 = new Property(60, 2, "purple", "Mediterranean Ave", 1),
            purple2 = new Property(60, 4, "purple", "Baltic Ave", 3),
            railroad1 = new Property(200, 25, "railroad", "Reading railroad", 5),
            railroad2 = new Property(200, 25, "railroad", "Pennsylvania railroad", 15),
            railroad3 = new Property(200, 25, "railroad", "B. and O. railroad", 25),
            railroad4 = new Property(200, 25, "railroad", "Short Line railroad", 35),
            lblue1 = new Property(100, 6, "light blue", "Oriental ave", 6),
            lblue2 = new Property(100, 6, "light blue", "Vermont ave", 8),
            lblue3 = new Property(120, 8, "light blue", "Connecticut ave", 9),
            pink1 = new Property(140, 10, "pink", "St. Charles Place", 11),
            pink2 = new Property(140, 10, "pink", "States ave", 13),
            pink3 = new Property(140, 12, "pink", "Virginia ave", 14),
            orange1 = new Property(180, 14, "orange", "St. James Place", 16),
            orange2 = new Property(180, 14, "orange", "Tennessee ave", 18),
            orange3 = new Property(200, 16, "orange", "New York ave", 19),
            red1 = new Property(220, 18, "red", "Kentucky ave", 21),
            red2 = new Property(220, 18, "red", "Indiana ave", 23),
            red3 = new Property(240, 20, "red", "Illinois ave", 24),
            yellow1 = new Property(260, 22, "yellow", "Atlantic ave", 26),
            yellow2 = new Property(260, 22, "yellow", "Ventnor ave", 27),
            yellow3 = new Property(280, 24, "yellow", "Marvin Gardens", 29),
            green1 = new Property(300, 26, "green", "Pacific ave", 31),
            green2 = new Property(300, 26, "green", "North Carolina ave", 32),
            green3 = new Property(320, 28, "green", "Pennsylvania ave", 34),
            dblue1 = new Property(350, 35, "dark blue", "Park Place", 37),
            dblue2 = new Property(400, 50, "dark blue", "Boardwalk", 39)
    };

    private int spaceCount=0;
    //player1 is 1, 2 is 2 etc.
    private int turnCounter=1;
    public void start(Stage ps){
        Pane mainPane= new Pane();

        Image player1image = new Image("respass.png");
        Player player1 = new Player(player1image, 610, 610, 1);
        ImageView player1ImageView = player1.getImageView();
        player1ImageView.setImage(player1image);
        player1ImageView.setFitWidth(40);
        player1ImageView.setFitHeight(40);
        player1ImageView.setX(610);
        player1ImageView.setY(610);
        mainPane.getChildren().add(player1ImageView);

        Image player2image = new Image("isecke.png");
        Player player2 = new Player(player2image, 610, 570, 2);
        ImageView player2ImageView = player2.getImageView();
        player2ImageView.setImage(player2image);
        player2ImageView.setFitWidth(40);
        player2ImageView.setFitHeight(40);
        player2ImageView.setX(610);
        player2ImageView.setY(570);
        mainPane.getChildren().add(player2ImageView);

        Image player3image = new Image("bcayy.png");
        Player player3 = new Player(player3image, 550, 570, 3);
        ImageView player3ImageView = player3.getImageView();
        player3ImageView.setImage(player3image);
        player3ImageView.setFitWidth(40);
        player3ImageView.setFitHeight(40);
        player3ImageView.setX(565);
        player3ImageView.setY(570);
        mainPane.getChildren().add(player3ImageView);


        Button diceRoll= new Button();
        diceRoll.setText("Roll");
        diceRoll.setPrefSize(50, 50);
        diceRoll.setOnAction(e->{
            if(turnCounter==1){
                player1.move();
                for(int i=0; i<properties.length; i++){
                    if(properties[i].getSpacenum()==player1.getSpace()  ){
                        player1.action(properties[i]);
                        break;
                        //if not property do something else
                    }
                }
            }
            else if(turnCounter==2){
                player2.move();
                for(int i=0; i<properties.length; i++){
                    if(properties[i].getSpacenum()==player2.getSpace()  ){
                        player2.action(properties[i]);
                        break;
                        //if not property do something else
                    }
                }
            }
            else if(turnCounter==3){
                player3.move();
                for(int i=0; i<properties.length; i++){
                    if(properties[i].getSpacenum()==player3.getSpace()  ){
                        player3.action(properties[i]);
                        break;
                        //if not property do something else
                    }
                }
            }

            if(turnCounter==3){
                turnCounter=1;
            }
            else{
                turnCounter++;
            }
        });
        mainPane.getChildren().add(diceRoll);
        diceRoll.setLayoutX(300);
        diceRoll.setLayoutY(300);



        Image board = new Image("monopoly_original.jpg");
        ImageView boardImageView = new ImageView();
        boardImageView.setImage(board);
        boardImageView.setFitWidth(650);
        boardImageView.setFitHeight(650);
        mainPane.getChildren().add(boardImageView);

        player1ImageView.toFront();
        player2ImageView.toFront();
        player3ImageView.toFront();
        diceRoll.toFront();

        Text p1 = new Text("Player 1: ");
        p1.setScaleX(2);
        p1.setScaleY(2);
        p1.setX(680);
        p1.setY(30);
        mainPane.getChildren().add(p1);
        Text p1Money = new Text();
        p1Money.setText(String.format("Money: $%d",player1.getMoney()));
        p1Money.setScaleX(2);
        p1Money.setScaleY(2);
        p1Money.setX(690);
        p1Money.setY(70);
        mainPane.getChildren().add(p1Money);

        Text p2 = new Text("Player 2: ");
        p2.setScaleX(2);
        p2.setScaleY(2);
        p2.setX(680);
        p2.setY(650/3 + 30);
        mainPane.getChildren().add(p2);

        Text p2Money = new Text();
        p2Money.setText(String.format("Money: $%d",player2.getMoney()));
        p2Money.setScaleX(2);
        p2Money.setScaleY(2);
        p2Money.setX(690);
        p2Money.setY(650/3 + 70);
        mainPane.getChildren().add(p2Money);

        Text p3 = new Text("Player 3: ");
        p3.setScaleX(2);
        p3.setScaleY(2);
        p3.setX(680);
        p3.setY(650/3 * 2 + 30);
        mainPane.getChildren().add(p3);
//ahhhhhhhhhhhhh
        Text p3Money = new Text();
        p3Money.setText(String.format("Money: $%d",player3.getMoney()));
        p3Money.setScaleX(2);
        p3Money.setScaleY(2);
        p3Money.setX(690);
        p3Money.setY(650/3 * 2 + 70);
        mainPane.getChildren().add(p3Money);


        Scene scene = new Scene(mainPane, 850,650);
        ps.setTitle("Monopoly");
        mainPane.requestFocus();
        ps.setScene(scene);
        ps.show();
    }

}
