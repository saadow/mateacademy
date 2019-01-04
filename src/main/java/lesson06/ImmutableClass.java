package lesson06;

import java.util.HashMap;
import java.util.List;

public final class ImmutableClass {
	private String name;
	private String surname;
	private int age;
	private String city;
	private List<String> list;

	public ImmutableClass(String name, String surname, int age, String city) {
		this.name = name;
		this.surname = surname;
		this.age = age;
		this.city = city;
	}

	public List<String> getList() {
		return list;
	}

	public void setList(List<String> list) {
		this.list = list;
	}

	public String getName() {
		return name;
	}

	public String getSurname() {
		return surname;
	}

	public int getAge() {
		return age;
	}

	public String getCity() {
		return city;
	}
	
	public static void main (String[] args) {
		ImmutableClass ic = new ImmutableClass("Name", "Surname", 17, "Kiev");
		ic.getList().add("String");
	}

}