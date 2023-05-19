package Model;

import java.time.LocalDate;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.ReadOnlyIntegerWrapper;

public class Person {
    private final StringProperty firstName= new SimpleStringProperty("firtName");
    private final StringProperty lastName= new SimpleStringProperty("lastName");
    private final StringProperty team=new SimpleStringProperty("team");
    private final ObjectProperty<LocalDate> birthDate=new SimpleObjectProperty<>();
    private final IntegerProperty lapsThisTime = new SimpleIntegerProperty(0);
    private final ReadOnlyIntegerWrapper totalLaps = new ReadOnlyIntegerWrapper(0);

    public Person () {
        this(null,null,null,null,0);
    }
    
    public Person(String firstName, String lastName, String team,LocalDate birthDate,int lapsThisTime) {
        this.firstName.set(firstName);
        this.lastName.set(lastName);
        this.team.set(team);
        this.birthDate.set(birthDate);
        this.lapsThisTime.set(lapsThisTime);
    }

    /* First Name Properties */
    public final String getFirstName() {
        return firstName.get();
    }

    public final StringProperty firstNamProperty() {
        return firstName;
    }

    public final void setFirstName(String firstName) {
        firstNamProperty().set(firstName);
    }

    /* Last Name Properties */
    public final String getLastName() {
        return lastName.get();
    }

    public final StringProperty lastNameProperty() {
        return lastName;
    }

    public final void setLastName(String lastName) {
        lastNameProperty().set(lastName);
    }
    /* Team Properties */

    /*BirthDate Properties */

    /* LapsThisTime Properties */

    /* TotalLapsProperties */


    /* Check validity of properties*/

    @Override
    public String toString(){
        return  "Name:" + firstName.get()+
                "Last Name: "+ lastName.get()+
                "Team: "+team.get()+
                "Birth Date: "+birthDate.get()+
                "Total Laps: "+totalLaps.get();
    }

    public void save() {
        System.out.println("Saved"+this.toString());
    }

}
