package lesson14_soap;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;

import lesson12.Person;
import lesson12.Student;
import lesson12.Teacher;

public class MateGroupServiceClient {

	public static void main(String[] args) throws Exception {

		URL url = new URL("http://localhost:9999/ws/mate?wsdl");

		// 1st argument service URI, refer to wsdl document above
		// 2nd argument is service name, refer to wsdl document above
		QName qname = new QName("http://lesson14_soap/", "MateGroupServiceImplService");

		Service service = Service.create(url, qname);

		MateGroupService hello = service.getPort(MateGroupService.class);

		System.out.println(hello.getMateGroup(18122018));

		List<Person> persons = new ArrayList<>();
		persons.add(new Student("First", "First", 1995, null));
		persons.add(new Teacher("Second", "Second", 1990, null, 666));
		System.out.println(hello.addStudents(18122018, persons));

	}

}