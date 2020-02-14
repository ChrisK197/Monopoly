import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class MainFile extends Application {
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
            }
            else if(turnCounter==2){
                player2.move();
            }
            else if(turnCounter==3){
                player3.move();
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
        Scene scene = new Scene(mainPane, 850,650);
        ps.setTitle("Monopoly");
        mainPane.requestFocus();
        ps.setScene(scene);
        ps.show();
    }

    private void creatingProperties(){
        Property purple1 = new Property(60, 2, "purple", "Mediterranean Ave", 1);
        Property purple2 = new Property(60, 4, "purple", "Baltic Ave", 3);
        Property railroad1 = new Property(200, 25, "railroad", "Reading railroad", 5);
        Property railroad2 = new Property(200, 25, "railroad", "Pennsylvania railroad", 15);
        Property railroad3 = new Property(200, 25, "railroad", "B. and O. railroad", 25);
        Property railroad4 = new Property(200, 25, "railroad", "Short Line railroad", 35);
        Property lblue1 = new Property(100, 6, "light blue", "Oriental ave", 6);
        Property lblue2 = new Property(100, 6, "light blue", "Vermont ave", 8);
        Property lblue3 = new Property(120, 8, "light blue", "Connecticut ave", 9);
        Property pink1 = new Property(140, 10, "pink", "St. Charles Place", 11);
        Property pink2 = new Property(140, 10, "pink", "States ave", 13);
        Property pink3 = new Property(140, 12, "pink", "Virginia ave", 14);
        Property orange1 = new Property(180, 14, "orange", "St. James Place", 16);
        Property orange2 = new Property(180, 14, "orange", "Tennessee ave", 18);
        Property orange3 = new Property(200, 16, "orange", "New York ave", 19);
        Property red1 = new Property(220, 18, "red", "Kentucky ave", 21);
        Property red2 = new Property(220, 18, "red", "Indiana ave", 23);
        Property red3 = new Property(240, 20, "red", "Illinois ave", 24);
        Property yellow1 = new Property(260, 22, "yellow", "Atlantic ave", 26);
        Property yellow2 = new Property(260, 22, "yellow", "Ventnor ave", 27);
        Property yellow3 = new Property(280, 24, "yellow", "Marvin Gardens", 29);
        Property green1 = new Property(300, 26, "green", "Pacific ave", 31);
        Property green2 = new Property(300, 26, "green", "North Carolina ave", 32);
        Property green3 = new Property(320, 28, "green", "Pennsylvania ave", 34);
        Property dblue1 = new Property(350, 35, "dark blue", "Park Place", 37);
        Property dblue2 = new Property(400, 50, "dark blue", "Boardwalk", 39);
    }
}
