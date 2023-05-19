package View;
import Model.Person;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;


public class PersonView extends GridPane {
    Person model;
    public PersonView(){
        setLayout();
        bind();
    }
    //Label declaration
    Label firstNameLbl= new Label("First Name: ");
    Label lastNameLbl=new Label("Last Name: ");
    Label teamLbl= new Label("Team: ");
    Label birthDateLbl= new Label("Birth Date: ");
    Label lapsThisTimeLbl=new Label("Laps: ");

    //Text declaration

    TextField firstNameFld=new TextField();
    TextField lastNameFld=new TextField();
    TextField teamFld= new TextField();
    TextField birthDateFld= new TextField();
    TextField lapsThisTimeFld=new TextField();
    
    private void setLayout() {
        this.add(firstNameLbl,0,0);
        this.add(lastNameLbl,0,1);
        this.add(teamLbl,0,2);
        this.add(birthDateLbl,0,3);
        this.add(lapsThisTimeLbl,0,4);

        this.add(firstNameFld,1,0);
        this.add(lastNameFld,1,1);
        this.add(teamFld,1,2);
        this.add(birthDateFld,1,3);
        this.add(lapsThisTimeFld,1,4);
    }

    private void bind() {
        firstNameFld.textProperty().bind(model.firstName);
    }
    
}
