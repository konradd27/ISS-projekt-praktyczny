import java.util.List;

public class ISSNumberOfPeople {
    public Integer getNumberOfPeople ()throws Exception{
        ISSNumberOfPeople_Deserialize issNumberOfPeople_deserialize = new ISSNumberOfPeople_Deserialize();
        ISSNumberOfPeopleDto issNumberOfPeopleDto = issNumberOfPeople_deserialize.getIssNumberOfPeopleDto();
        return issNumberOfPeopleDto.getNumber();
    }

    public List<ISSPeople> getListOfPeople() throws Exception{
        ISSNumberOfPeople_Deserialize issNumberOfPeople_deserialize = new ISSNumberOfPeople_Deserialize();
        ISSNumberOfPeopleDto issNumberOfPeopleDto = issNumberOfPeople_deserialize.getIssNumberOfPeopleDto();
        return issNumberOfPeopleDto.getPeople();
    }
}
