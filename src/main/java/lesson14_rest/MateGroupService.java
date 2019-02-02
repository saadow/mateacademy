package lesson14_rest;

import javax.ws.rs.core.Response;

import lesson12.HumanResource;

public interface MateGroupService {

	public Response getMateGroup(int groupId);

	public Response addStudents(int groupId, Person person);

	public Response deleteStudent(int groupId, String surname);
	
	public Response updateStudent(int groupId, String surname, String newname);
	
	public Response addHR(int groupId, HumanResource hr);
	
	public Response deleteHR(int groupId, String surname);
	
	public Response updateStartWorkYearHR(int groupId, String surname, int newStartWorkYear);
	
	public Response showAllHRs(int groupId);
	
	public Response showSingleHR(int groupId, String surname);

}