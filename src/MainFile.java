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
        Player player1 = new Player(player1image, 610, 610);
        ImageView player1ImageView = player1.getImageView();
        player1ImageView.setImage(player1image);
        player1ImageView.setFitWidth(40);
        player1ImageView.setFitHeight(40);
        player1ImageView.setX(610);
        player1ImageView.setY(610);
        mainPane.getChildren().add(player1ImageView);

        Image player2image = new Image("isecke.png");
        Player player2 = new Player(player2image, 610, 570);
        ImageView player2ImageView = player2.getImageView();
        player2ImageView.setImage(player2image);
        player2ImageView.setFitWidth(40);
        player2ImageView.setFitHeight(40);
        player2ImageView.setX(610);
        player2ImageView.setY(570);
        mainPane.getChildren().add(player2ImageView);

        Image player3image = new Image("bcayy.png");
        Player player3 = new Player(player3image, 550, 550);
        ImageView player3ImageView = player3.getImageView();
        player3ImageView.setImage(player3image);
        player3ImageView.setFitWidth(40);
        player3ImageView.setFitHeight(40);
        player3ImageView.setX(550);
        player3ImageView.setY(550);
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
}
