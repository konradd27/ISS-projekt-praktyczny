package issnumberofppl;

import java.util.List;

public class ISSNumberOfPeople {
    public Integer getNumberOfPeople() throws Exception {
        ISSNumberOfPeople_Deserialize issNumberOfPeople_deserialize = new ISSNumberOfPeople_Deserialize();
        ISSNumberOfPeopleDto issNumberOfPeopleDto = issNumberOfPeople_deserialize.getIssNumberOfPeopleDto();
        return issNumberOfPeopleDto.getNumber();
    }

    public void getListOfPeople() throws Exception {
        ISSNumberOfPeople_Deserialize issNumberOfPeople_deserialize = new ISSNumberOfPeople_Deserialize();
        ISSNumberOfPeopleDto issNumberOfPeopleDto = issNumberOfPeople_deserialize.getIssNumberOfPeopleDto();
        for(ISSPeople people : issNumberOfPeopleDto.getPeople()){
            System.out.println(people.getName());
        }
    }

}
