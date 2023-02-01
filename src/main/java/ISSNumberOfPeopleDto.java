import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ISSNumberOfPeopleDto {
    private String message;

     List<ISSPeople> people;

    private Integer number;

    public void setPeople(List<ISSPeople> people) {
        this.people = people;
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
        return "ISSNumberOfPeopleDto{" +
                "message='" + message + '\'' +
                ", people=" + people +
                ", number=" + number +
                '}';
    }
}

