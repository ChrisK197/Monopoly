import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class MainFile extends Application {
    private int spaceCount=0;
    public void start(Stage ps){
        Pane mainPane= new Pane();
        Button diceRoll= new Button();
        diceRoll.setText("Roll");
        diceRoll.setOnAction(e->{
            diceRoll();
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
}
