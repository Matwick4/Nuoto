package View;
import Model.Person;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import java.util.List;
import java.util.ArrayList;

public class PersonView extends GridPane {
    Person model;
    public PersonView(Person model){
        this.model=model;
        setLayout();
        bind();
        attach();
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

    Button saveBtn= new Button("Save");
    
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

        this.add(saveBtn, 2, 0);
    }
    private void attach(){
        saveBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event){
                List<String> l=new ArrayList<>();
                if(model.isValidPerson(model, l))
                    model.save();
                else
                    System.out.println(l);
            }
        });
    }
    private void bind() {
        firstNameFld.textProperty().bindBidirectional(model.firstNamProperty());
        lastNameFld.textProperty().bindBidirectional(model.lastNameProperty());
        teamFld.textProperty().bindBidirectional(model.teamProperty());
    }
    
}
