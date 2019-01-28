package lesson12;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonRootName;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonTypeInfo.As;

@XmlRootElement(name = "group")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(propOrder = {"id", "room", "students", "teacher", "humanResources"})
@JsonPropertyOrder({ "id", "room", "students", "teacher", "humanResources" })
@JsonRootName("group")
@JsonIgnoreProperties({"id"})
public class MateGroup implements Serializable {

	@XmlElement(type = Teacher.class)
	private Person teacher;
	@XmlElementWrapper(name = "students")
	@XmlElement(name = "student")
	@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = As.PROPERTY, property = "type")
	@JsonSubTypes({ @JsonSubTypes.Type(value = Teacher.class, name = "teacher"),
			@JsonSubTypes.Type(value = Student.class, name = "student") })
	private List<Person> students;
	@XmlElement(required = true, nillable = false)
	private Room room;
	@XmlElementWrapper(name = "hrs")
	@XmlElement(name = "humanResource")
	private Set<HumanResource> humanResources;
	private int id;

	public MateGroup(Teacher teacher, List<Person> students, Room room, Set<HumanResource> humanResources) {
		this.teacher = teacher;
		this.students = students;
		this.room = room;
		this.humanResources = humanResources;
	}

	public MateGroup() {
	}

	public Person getTeacher() {
		return teacher;
	}

	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}

	public List<Person> getStudents() {
		return students;
	}

	public void setStudents(List<Person> students) {
		this.students = students;
	}

	public Room getRoom() {
		return room;
	}

	public void setRoom(Room room) {
		this.room = room;
	}

	public Set<HumanResource> getHumanResources() {
		return humanResources;
	}

	public void setHumanResources(Set<HumanResource> humanResources) {
		this.humanResources = humanResources;
	}

	@Override
	public String toString() {
		return "MateGroup [teacher=" + teacher + ", students=" + students + ", room=" + room + ", humanResources="
				+ humanResources + "]";
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public static MateGroup mateGroupExampleCreator() {
		MateGroup mateGroup = new MateGroup();
		mateGroup.setId(18122018);

		Teacher teacher = new Teacher("Serhii", "Pasko", 1988, "Java", 666);
		mateGroup.setTeacher(teacher);

		Room room = new Room("Kiyv", "Tarasivska", 16, 28);
		mateGroup.setRoom(room);

		Set<HumanResource> humanResources = new HashSet<>();
		humanResources.add(new HumanResource("Karmen", "Sanya", 1990, 500, 2018));
		humanResources.add(new HumanResource("Efiria", "Vanya", 1989, 700, 2019));
		mateGroup.setHumanResources(humanResources);

		List<Person> students = new ArrayList<>();
		students.add(new Student("Iza", "Rabinovish", 1997, "Java"));
		students.add(new Student("Abram", "Kolom", 1998, "Java"));
		students.add(new Teacher("Moisha", "Stefan", 1990, "FrontEnd", 666));
		mateGroup.setStudents(students);

		return mateGroup;
	}

}
