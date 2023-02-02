package issnumberofppl;

import java.util.List;

public class ISSNumberOfPeopleDto {
    private String message;

    List<ISSPeople> people;

    private Integer number;

    public void setPeople(List<ISSPeople> people) {
        this.people = people;
    }

    public List<ISSPeople> getPeople() {
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
                ", people=" + people +
                ", number=" + number +
                '}';
    }
}

