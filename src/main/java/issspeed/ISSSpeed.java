package issspeed;

public class ISSSpeed {

    public double getSpeed() throws Exception {

        ISSSpeed_Deserialize issSpeed_deserialize = new ISSSpeed_Deserialize();

        ISSSpeedDto issSpeedDto = issSpeed_deserialize.getIssJson();
        Thread.sleep(5000);
        ISSSpeedDto issSpeedDto2 = issSpeed_deserialize.getIssJson();


        double lat1 = issSpeedDto.getIss_position().getLatitude();
        double lat2 = issSpeedDto2.getIss_position().getLatitude();

        double lon1 = issSpeedDto.getIss_position().getLongitude();
        double lon2 = issSpeedDto2.getIss_position().getLongitude();
        double distance = distance(lat1, lat2, lon1, lon2);

        double speed = distance / (issSpeedDto2.getTimestamp() - issSpeedDto.getTimestamp());

        return speed;

    }

    public static double distance(double lat1, double lat2, double lon1,
                                  double lon2) {

        final int R = 6371 + 408; // Radius of the earth + average height of ISS

        double latDistance = Math.toRadians(lat2 - lat1);
        double lonDistance = Math.toRadians(lon2 - lon1);
        double a = Math.sin(latDistance / 2) * Math.sin(latDistance / 2)
                + Math.cos(Math.toRadians(lat1)) * Math.cos(Math.toRadians(lat2))
                * Math.sin(lonDistance / 2) * Math.sin(lonDistance / 2);
        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));

        return R * c * 1000;
    }

}
