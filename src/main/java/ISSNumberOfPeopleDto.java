import java.util.List;

public class ISSNumberOfPeopleDto {
    private String message;

    private List<ISSPeople> people;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }


    public List getName() {
        return people;
    }

    public void setName(String message) {
        this.people = people;
    }

    @Override
    public String toString() {
        return "ISSNumberOfPeopleDto{" +
                "message='" + message + '\'' +
                ", people=" + people +
                '}';
    }
}
