package Model;

import java.time.LocalDate;
import java.util.List;

import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.ReadOnlyIntegerProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.ReadOnlyIntegerWrapper;

public class Person {
    private final StringProperty firstName= new SimpleStringProperty("firtName");
    private final StringProperty lastName= new SimpleStringProperty("lastName");
    private final StringProperty team=new SimpleStringProperty("team");
    private final ObjectProperty<LocalDate> birthDate=new SimpleObjectProperty<>();
    private final IntegerProperty lapsThisTime = new SimpleIntegerProperty();
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
    public final String getTeam() {
        return team.get();
    }

    public final StringProperty teamProperty() {
        return team;
    }

    public final void setTeam(String team) {
        teamProperty().set(team);
    }

    /*BirthDate Properties */

    public final LocalDate getBirthDate() {
        return birthDate.get();
    }

    public final ObjectProperty<LocalDate> birthDateProperty() {
        return birthDate;
    }

    public final void setBirthDate(LocalDate birthDate) {
        birthDateProperty().set(birthDate);
    }
    /* LapsThisTime Properties */

    public final int getLapsThisTime() {
        return lapsThisTime.get();
    }

    public final IntegerProperty lapsThisTimeProperty(){
        return lapsThisTime;
    }
    
    public final void setLapsThisTime(int lapsThisTime) {
        lapsThisTimeProperty().set(lapsThisTime);
    }
    /* TotalLapsProperties */

    public final int getTotalLaps() {
        return totalLaps.get();
    }
    public final ReadOnlyIntegerProperty totalLapsProperty () {
        return totalLaps.getReadOnlyProperty();
    }
    /* Check validity of properties*/
    public boolean isValidBirthDate(LocalDate bDate,List<String> errorList){
       
        if(bDate==null){
            return true;
        }
        if(bDate.isAfter(LocalDate.now())){
            errorList.add("Date must not be in the future!");
            return false;
        }
        
        return true;
    }
    public boolean isValidLapsThisTime(int lapsThisTime,List<String> errorList){
        if(lapsThisTime<=0) {
            errorList.add("Laps must be >0");
            return false;
        }
            
        return true;
    }
    @Override
    public String toString(){
        return  "Name:" + firstName.get()+
                "-Last Name: "+ lastName.get()+
                "-Team: "+team.get()+
                "-Birth Date: "+birthDate.get()+
                "-Laps this time: "+lapsThisTime.get()+
                "-Total Laps: "+totalLaps.get();
    }
    public boolean isValidPerson(List<String> errorList){
        return isValidPerson(this,errorList);

    }
    public boolean isValidPerson(Person p, List<String> erroList) {
        boolean isValid=true;
       
        String fn=p.getFirstName();
        if(fn==null || fn.trim().length()==0){
            isValid=false;
            erroList.add("First must contain one charachter!");
        }
        

        String ln = p.getLastName();
        if(ln==null || ln.trim().length()==0) {
            isValid=false;
            erroList.add("Last name must contain one charachter");
        }

     
        String team= p.getTeam();
        if(team==null || team.trim().length()==0) {
            isValid=false;

        }
        //check bDate
        if(!isValidBirthDate(this.getBirthDate(), erroList)){
            isValid=false;
        }
        if(!isValidLapsThisTime(this.getLapsThisTime(), erroList)) {
            isValid=false;
        }

        return isValid;
    }
    public void save() {
    
        System.out.println("Saved"+this.toString());
    }

}
