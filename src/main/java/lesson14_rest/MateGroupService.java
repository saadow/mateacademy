package lesson14_rest;

import javax.ws.rs.core.Response;

import lesson12.Person;

public interface MateGroupService {

	public Response getMateGroup(int groupId);

	public Response addStudents(int groupId, Person person);

	public Response deleteStudent(int groupId, String surname);

	public Response updateStudent(int groupId, String surname, String newname);
}