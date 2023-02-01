public class ISSNumberOfPeopleDto {
    private String message;

    private String name;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }


    public String getName() {
        return name;
    }

    public void setName(String message) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "ISSNumberOfPeopleDto{" +
                "message='" + message + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
