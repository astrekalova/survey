package de.gwzberlin.zas.survey.server;

import static org.junit.Assert.*;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import de.gwzberlin.zas.survey.test.ContextAwareTest;

public class PropertiesDaoImplTest extends ContextAwareTest {

	
	@Autowired
	PropertiesDao propertiesDao;
	
	@Test
	public void testGetColors() {		
		
		assertTrue(propertiesDao.getColors().getColors().size() > 0);
	}

}
