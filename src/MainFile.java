import com.sun.prism.paint.Color;
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


        Button diceRoll= new Button();
        diceRoll.setText("Roll");
        diceRoll.setPrefSize(50, 50);
        diceRoll.setOnAction(e->{
            diceRoll();
            move();
        });
        mainPane.getChildren().add(diceRoll);
        diceRoll.setLayoutX(300);
        diceRoll.setLayoutY(300);

        Image player1 = new Image("mr.respass.jpg");
        ImageView player1ImageView = new ImageView();
        player1ImageView.setImage(player1);
        player1ImageView.setFitWidth(40);
        player1ImageView.setFitHeight(40);
        player1ImageView.setX(600);
        player1ImageView.setY(600);
        mainPane.getChildren().add(player1ImageView);

        Image board = new Image("monopoly_original.jpg");
        ImageView boardImageView = new ImageView();
        boardImageView.setImage(board);
        boardImageView.setFitWidth(650);
        boardImageView.setFitHeight(650);
        mainPane.getChildren().add(boardImageView);

        player1ImageView.toFront();
        diceRoll.toFront();
        Scene scene = new Scene(mainPane, 650,650);
        ps.setTitle("Monopoly");
        mainPane.requestFocus();
        ps.setScene(scene);
        ps.show();
    }
    //total of 40 squares. Go is 0. Last is 39
    private void diceRoll(){
        int roll = (int)(Math.random()*6)+1;
        for(int i=1; i<=roll; i++){
            if(spaceCount+i==40){
                spaceCount=0;
            }
            else{
                spaceCount++;
            }
        }
    }
    private void move(){

    }
}
