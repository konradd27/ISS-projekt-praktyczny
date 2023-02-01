package issspeed;

public class ISSSpeedDto {
    private Integer timestamp;

    private String message;

    private ISSSpeed_position iss_position;



    public Integer getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Integer timestamp) {
        this.timestamp = timestamp;
    }



    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public ISSSpeed_position getIss_position() {
        return iss_position;
    }

    public void setIss_position(ISSSpeed_position iss_position) {
        this.iss_position = iss_position;
    }

    @Override
    public String toString() {
        return "issspeed.ISSSpeedDto{" +
                "timestamp=" + timestamp +
                ", message='" + message + '\'' +
                ", iss_position=" + iss_position +
                '}';
    }
}
