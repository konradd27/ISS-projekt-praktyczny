package issnumberofppl;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

public class ISSNumberOfPeopleDto {

    private int id;

    private String message;


    private ArrayList<ISSPeople> people;

    private Integer number;

    public ISSNumberOfPeopleDto(String message, List<ISSPeople> people, Integer number) {
        this.message = message;
        //this.people = people;
        this.number = number;
    }

    public ISSNumberOfPeopleDto() {
    }

    public void setPeople(ArrayList<ISSPeople> people) {
        this.people = people;
    }

    public ArrayList<ISSPeople> getPeople() {
        return people;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }


    public List getName() {
        return List.of(people);
    }

    public void setName(String message) {
        this.people = people;
    }

    @Override
    public String toString() {
        return "issnumberofppl.ISSNumberOfPeopleDto{" +
                "message='" + message + '\'' +
                //", people=" + people +
                ", number=" + number +
                '}';
    }
}

