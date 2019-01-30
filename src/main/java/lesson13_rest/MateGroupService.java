package lesson13_rest;

import javax.ws.rs.core.Response;

import lesson12.Person;
import lesson12.Teacher;

public interface MateGroupService {

	public Response getMateGroup();

	public Response addStudents(int groupId, Person person);
	
	public Response putTeacher(int groupId, Teacher teacher);
}