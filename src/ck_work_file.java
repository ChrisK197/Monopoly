/*import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class ck_work_file {
    else if (player1.getSpace() == 2 || player1.getSpace() == 17 || player1.getSpace() == 33) {
        CommunityCard com = new CommunityCard();
        Stage stage = new Stage();
        stage.setTitle("New Community Chest Card");
        Text t = new Text(50, 50, "New Community Chest Card Card! \n\n" + com.getCardPhrase());
        Pane p = new Pane();
        p.getChildren().add(t);
        Scene ss = new Scene(p, 400, 200);
        stage.setScene(ss);
        stage.show();
        int[] c = com.cardType();
        if (c[0] == 0) {
            if (c[1] == 0) {
                player1.setSpace(0);
                player1ImageView.setX(player1.getStartX());
                player1ImageView.setY(player1.getStartY());
                player1.addMoney(200);
            }
            else if (c[1] == -3) {
                int space = player1.getSpace();
                ImageView icon = player1.getImageView();
                space-=3;
                if(space==0){
                    //change later to make better
                    icon.setX(player1.getStartX());
                    icon.setY(player1.getStartY());
                }
                else if(space==1){
                    icon.setX(520);
                }
                else if(2<=space && space<=10){
                    if(space==10){
                        icon.setY(625);
                    }
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
            else if (c[1] == -1) {
                player1.getImageView().setX(40);
                player1.getImageView().setY(585);
                daysInJail1 = 0;
                player1.setSpace(10);
            }
            else {
                if (player1.getSpace() > c[1]) {
                    player1.addMoney(200);
                }
                player1.setSpace(c[1]);
                int space = c[1];
                ImageView icon = player1.getImageView();
                if(space==5){
                    icon.setX(340);
                    icon.setY(590);
                }
                else if(space==11){
                    icon.setY(520);
                    icon.setX(50);
                }
                else if (space==24){
                    icon.setY(40);
                    icon.setX(255);
                }
            }
        }
        else {
            if (c[1] == 0) {
                player1.jailBreakCard++;
            }
            else if (c[1] == -25) {
                player1.addMoney(player1.getPropertiesOwned().size() & -25);
            }
            else if (c[1] == -50) {
                player1.addMoney(-100);
                player2.addMoney(50);
                player3.addMoney(50);
            }
            else {
                player1.addMoney(c[1]);
            }
        }
    }
}
*/