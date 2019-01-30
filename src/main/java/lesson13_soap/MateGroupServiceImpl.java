package lesson13_soap;

import java.util.List;
import javax.jws.WebService;

import lesson12.MateGroup;
import lesson12.Person;

@WebService(endpointInterface = "lesson13.MateGroupService")
public class MateGroupServiceImpl implements MateGroupService {
	private MateGroup mateGroup = MateGroup.mateGroupExampleCreator();

	@Override
	public MateGroup getMateGroup() {
		return mateGroup;
	}

	@Override
	public MateGroup addStudents(List<Person> persons) {
		mateGroup.getStudents().addAll(persons);
		return mateGroup;
	}

}