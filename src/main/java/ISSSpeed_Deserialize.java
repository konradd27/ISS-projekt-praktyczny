import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ISSSpeed_Deserialize {
    public static void main(String[] args) throws Exception {
        String JSON = ISSSpeed_API.getJSON();
        Thread.sleep(5000);
        String JSON2 = ISSSpeed_API.getJSON();
        System.out.println(JSON);
        ObjectMapper objectMapper = new ObjectMapper()
                .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        ISSSpeedDto issSpeedDto = objectMapper.readValue(JSON, ISSSpeedDto.class);
        System.out.println(issSpeedDto);

        ISSSpeedDto issSpeedDto2 = objectMapper.readValue(JSON2, ISSSpeedDto.class);
        System.out.println(issSpeedDto2);
    }

    public ISSSpeedDto getIssJson()throws Exception{
        String JSON = ISSSpeed_API.getJSON();

        ObjectMapper objectMapper = new ObjectMapper()
                .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        ISSSpeedDto issSpeedDto1 = objectMapper.readValue(JSON, ISSSpeedDto.class);

        return issSpeedDto1;
    }
}
