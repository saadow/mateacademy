package lesson03;

import java.util.ArrayList;
import java.util.List;

import lesson03_builder.BuilderExample;

public class MainMethodClass {

	public static void main(String[] args) {
		ClassInter.StaticTest st = new ClassInter.StaticTest();
		ClassInter.NonStaticTest nst = new ClassInter().new NonStaticTest();
		
		TestInterface ti = new TestInterface() {
			@Override
			public void printWord() {
				System.out.println("Anonymous printword");
			}
			
			@Override
			public void print() {
				System.out.println("Anonymous print");
			}
		};
		List <TestInterface> tilist = new ArrayList<TestInterface>();
		tilist.add(st);
		tilist.add(nst);
		tilist.add(ti);
		//tilist.stream().map(tin->tin.getClass().getName()).forEach(System.out::println);;
		
		String name = "name";
		String surname = "surname";
		int age = 18;
		
		BuilderExample be = BuilderExample.builder().withSurname(surname).build();
		System.out.println(be);
	}

}
