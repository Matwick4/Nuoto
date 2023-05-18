
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;


public class Main extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primarystage) throws Exception{

        Label l = new Label("hello", null);
        Group root = new Group(l);

        primarystage.setTitle("Test");
        primarystage.setScene(new Scene(root, 400, 300, false, null));
        primarystage.show();
    }
}
