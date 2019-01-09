package homework07;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;

public class MainAnimalReflection {

	public static void main(String[] args) throws NoSuchMethodException, SecurityException {

		@SuppressWarnings("rawtypes")
		Constructor[] constructors = Animal.class.getDeclaredConstructors();
		System.out.println("Animal constructors: " + Arrays.toString(constructors));

		Constructor<Animal> constructor = Animal.class.getDeclaredConstructor();
		constructor.setAccessible(true);

		try {
			Animal animal = constructor.newInstance();
			animal.setName("Animal with private constructor");
			System.out.println(animal);
		} catch (InstantiationException | IllegalAccessException | IllegalArgumentException
				| InvocationTargetException e) {
			e.printStackTrace();
		}
	}
}
