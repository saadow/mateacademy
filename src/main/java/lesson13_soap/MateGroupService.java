package lesson13_soap;

import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;

import lesson12.MateGroup;
import lesson12.Person;


@WebService
@SOAPBinding(style = Style.DOCUMENT)
public interface MateGroupService {

	@WebMethod
	public MateGroup getMateGroup();

	@WebMethod
	public MateGroup addStudents(List<Person> persons);
}