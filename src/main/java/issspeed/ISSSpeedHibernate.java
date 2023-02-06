package issspeed;

import javax.persistence.*;

@Entity
@Table(name = "issspeed")

public class ISSSpeedHibernate {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long ID;
    @Column(name = "speed")
    private double speed;

    @Column(name = "timestamp")
    private int timeStamp;

    public ISSSpeedHibernate() {
    }

    public ISSSpeedHibernate(double speed, int timeStamp) {

        this.speed = speed;
        this.timeStamp = timeStamp;
    }

    public long getID() {
        return ID;
    }

    public void setID(long ID) {
        this.ID = ID;
    }

    public double getSpeed() {
        return speed;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }

    public int getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(int timeStamp) {
        this.timeStamp = timeStamp;
    }
}
