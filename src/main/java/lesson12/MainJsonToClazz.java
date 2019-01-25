package lesson12;

import java.io.File;
import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;

public class MainJsonToClazz {
	public static void main(String[] args) {

		ObjectMapper mapper = new ObjectMapper();

		try {
			MateGroup mateGroup = mapper.readValue(new File("src/resources/mateGroup.json"),
					MateGroup.class);
			System.out.println(mateGroup);

		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}