package issnumberofppl;

import javax.persistence.*;
import javax.print.attribute.standard.DateTimeAtCreation;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Table(name = "people")
public class ISSPeople {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "name")
    private String name;
    @Column(name = "craft")
    private String craft;
    @Column(name = "time")
    private LocalDateTime datetime = java.time.LocalDateTime.now();

    public LocalDateTime getDatetime() {
        return datetime;
    }

    public void setDatetime(LocalDateTime datetime) {
        this.datetime = datetime;
    }

    public ISSPeople(String name, String craft, LocalDateTime datetime) {
        this.name = name;
        this.craft = craft;
        this.datetime = datetime;
    }

    public ISSPeople(String name, String craft) {
        this.name = name;
        this.craft = craft;

    }

    public ISSPeople() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCraft() {
        return craft;
    }

    public void setCraft(String craft) {
        this.craft = craft;
    }

    @Override
    public String toString() {
        return "ISSPeople{" +
                "name='" + name + '\'' +
                ", craft='" + craft + '\'' +
                ", datetime=" + datetime +
                '}';
    }
}
