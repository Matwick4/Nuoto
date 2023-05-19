
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import View.PersonView;

public class Main extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primarystage) throws Exception{

    
        PersonView view= new PersonView();

        primarystage.setTitle("Test");
        primarystage.setScene(new Scene(view, 400, 300, false, null));
        primarystage.show();
    }
}
