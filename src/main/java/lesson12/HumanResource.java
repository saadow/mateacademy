package lesson12;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonRootName;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonRootName("hr")
@JsonInclude(Include.NON_NULL)
public class HumanResource extends Person {

	private int startWorkYear;
	private int salary;

	public HumanResource() {
		super();
	}

	public HumanResource(String name, String surname, int yearOfBorn, int startWorkYear, int salary) {
		super(name, surname, yearOfBorn);
		this.startWorkYear = startWorkYear;
		this.salary = salary;
	}

	public int getStartWorkYear() {
		return startWorkYear;
	}

	public void setStartWorkYear(int startWorkYear) {
		this.startWorkYear = startWorkYear;
	}
	
	public int getSalary() {
		return salary;
	}

	public void setSsalary(int salary) {
		this.salary = salary;
	}
	@Override
	public String toString() {
		return "HumanResource [salary=" + salary + ", startWorkYear=" + startWorkYear + ", " + super.toString() + "]";
	}
}