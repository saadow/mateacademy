package lesson12;

import java.io.File;

import java.io.IOException;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import org.eclipse.persistence.jaxb.MarshallerProperties;
import org.eclipse.persistence.oxm.MediaType;

public class MainClazzToJson {
	public static void main(String[] args) {

		MateGroup mateGroup = MateGroup.mateGroupExampleCreator();

		try {
			File file = new File("src/resources/mateGroup.json");
			JAXBContext jaxbContext = JAXBContext.newInstance(MateGroup.class);
			Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

			// output pretty printed
			jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

			jaxbMarshaller.setProperty(MarshallerProperties.MEDIA_TYPE, MediaType.APPLICATION_JSON);
			jaxbMarshaller.setProperty(MarshallerProperties.JSON_INCLUDE_ROOT, false);
			jaxbMarshaller.marshal(mateGroup, file);
			jaxbMarshaller.marshal(mateGroup, System.out);

		} catch (JAXBException e) {
			e.printStackTrace();
		}
	}
}