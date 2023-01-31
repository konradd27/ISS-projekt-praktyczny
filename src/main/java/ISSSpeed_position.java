public class ISSSpeed_position {
    Double latitude;
    Double longitude;

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    @Override
    public String toString() {
        return "ISSSpeed_position{" +
                "latitude=" + latitude +
                ", longitude=" + longitude +
                '}';
    }
}
