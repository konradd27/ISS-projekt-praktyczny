import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.CollectionType;
import com.fasterxml.jackson.databind.type.TypeFactory;

import java.util.List;

public class ISSNumberOfPeople_Deserialize {
    public static void main(String[] args) throws Exception {
        String JSON = ISSNumberOfPeople_API.getJSON();
        System.out.println(JSON);
        ObjectMapper objectMapper = new ObjectMapper()
                .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
       ISSNumberOfPeopleDto issNumberOfPeopleDto = objectMapper.readValue(JSON, ISSNumberOfPeopleDto.class);

       System.out.println(issNumberOfPeopleDto);

       ObjectMapper objectMapper1 = new ObjectMapper();

       final JsonNode response = objectMapper.readTree(ISSNumberOfPeople_API.getJSON()).path("people");

       final CollectionType collectionType= TypeFactory
               .defaultInstance()
               .constructCollectionType(List.class, ISSPeople.class);

       List<ISSPeople> people = objectMapper1.reader(collectionType).readValue(response);

        System.out.println(people);

        issNumberOfPeopleDto.setPeople(people);

        System.out.println(issNumberOfPeopleDto);

    }
    public ISSNumberOfPeopleDto getIssNumberOfPeopleDto() throws Exception{
        String JSON = ISSNumberOfPeople_API.getJSON();
        System.out.println(JSON);
        ObjectMapper objectMapper = new ObjectMapper()
                .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        ISSNumberOfPeopleDto issNumberOfPeopleDto = objectMapper.readValue(JSON, ISSNumberOfPeopleDto.class);

        System.out.println(issNumberOfPeopleDto);

        ObjectMapper objectMapper1 = new ObjectMapper();

        final JsonNode response = objectMapper.readTree(ISSNumberOfPeople_API.getJSON()).path("people");

        final CollectionType collectionType= TypeFactory
                .defaultInstance()
                .constructCollectionType(List.class, ISSPeople.class);

        List<ISSPeople> people = objectMapper1.reader(collectionType).readValue(response);

        System.out.println(people);

        issNumberOfPeopleDto.setPeople(people);

        System.out.println(issNumberOfPeopleDto);
        return issNumberOfPeopleDto;
    }
}
