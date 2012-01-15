package de.gwzberlin.zas.survey.server;

import java.io.InputStream;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import de.gwzberlin.zas.survey.types.Colors;

@Service("propertiesDao")
public class PropertiesDaoImpl implements PropertiesDao {

	private static final Logger log = LoggerFactory.getLogger(PropertiesDaoImpl.class);
	
	public Colors getColors() {		
		
		InputStream is = null;
		Colors colors = null;
		
		is = getClass().getResourceAsStream("/de/gwzberlin/zas/properties/color.xml");	
		
			try {
				JAXBContext context = JAXBContext.newInstance(Colors.class);
				colors = (Colors) context.createUnmarshaller().unmarshal(is);
			} catch(JAXBException e) {
				System.out.println("error parsing xml: ");
				e.printStackTrace();
				System.exit(1);
			}
			
		log.info("data reading was compelted");
		
		return colors;
	}
}
