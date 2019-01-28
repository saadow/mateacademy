package lesson12;

import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonRootName;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@XmlRootElement(name = "teacher")
@JsonRootName("teacher")
@JsonIgnoreProperties({"salary"})
@JsonInclude(Include.NON_NULL)
public class Teacher extends Person {
	private int salary;
	private String specialization;
	
	public Teacher(String name, String surname, int yearOfBorn, String specialization, int salary) {
		super(name, surname, yearOfBorn);
		this.specialization = specialization;
		this.salary = salary;
	}

	public Teacher() {
		super();
	}

	@Override
	public String getName() {
		return super.getName();
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}
	
	public String getSpecialization() {
		return specialization;
	}
	
	public void setSpecialization(String specialization) {
		this.specialization = specialization;
	}

	@Override
	public String toString() {
		return "Teacher [specialization=" + specialization + ", salary=" + salary + " " + super.toString() + "]";
	}

}
