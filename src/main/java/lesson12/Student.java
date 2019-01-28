package lesson12;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlTransient;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonRootName;

@XmlAccessorType(XmlAccessType.PROPERTY)
@JsonRootName("student")
@JsonIgnoreProperties({"yearOfBorn"})
@JsonInclude(Include.NON_NULL)
public class Student extends Person {
	private String fieldOfStudy;

	@Override
	@XmlTransient
	public String getSurname() {
		return super.getSurname();
	}

	@Override
	public String toString() {
		return "Student [getSurname()=" + getSurname() + ", getName()=" + getName() + ", getYearOfBorn()="
				+ getYearOfBorn() + ", getFieldOfStudy()=" + getFieldOfStudy();
	}

	public Student() {

	}

	public Student(String name, String surname, int yearOfBorn, String fieldOfStudy) {
		super(name, surname, yearOfBorn);
		this.fieldOfStudy = fieldOfStudy;
	}

	public String getFieldOfStudy() {
		return fieldOfStudy;
	}

	public void setFieldOfStudy(String fieldOfStudy) {
		this.fieldOfStudy = fieldOfStudy;
	}
}
