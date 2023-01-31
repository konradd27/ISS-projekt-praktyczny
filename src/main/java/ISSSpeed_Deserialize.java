import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ISSSpeed_Deserialize {
    public static void main(String[] args) throws Exception {
        String JSON = ISSSpeed_API.getJSON();
        System.out.println(JSON);
        ObjectMapper objectMapper = new ObjectMapper()
                .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        ISSSpeedDto issSpeedDto = objectMapper.readValue(JSON, ISSSpeedDto.class);
        System.out.println(issSpeedDto);
    }
}
