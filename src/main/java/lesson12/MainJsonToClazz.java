package lesson12;

import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import org.eclipse.persistence.jaxb.MarshallerProperties;
import org.eclipse.persistence.oxm.MediaType;


public class MainJsonToClazz {
	public static void main(String[] args) {

		try {
			File file = new File("src/resources/mateGroup.json");
			JAXBContext jaxbContext = JAXBContext.newInstance(MateGroup.class);

			Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
			jaxbUnmarshaller.setProperty(MarshallerProperties.MEDIA_TYPE, MediaType.APPLICATION_JSON);
			jaxbUnmarshaller.setProperty(MarshallerProperties.JSON_INCLUDE_ROOT, false);
			MateGroup mateGroup = (MateGroup) jaxbUnmarshaller.unmarshal(file);
			System.out.println(mateGroup);

		} catch (JAXBException e) {
			e.printStackTrace();
		}
	}
}