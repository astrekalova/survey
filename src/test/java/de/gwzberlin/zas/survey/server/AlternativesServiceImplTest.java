package de.gwzberlin.zas.survey.server;

import static org.junit.Assert.*;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import de.gwzberlin.zas.survey.shared.AlternativesXml;
import de.gwzberlin.zas.survey.shared.Selection;
import de.gwzberlin.zas.survey.test.ContextAwareTest;

public class AlternativesServiceImplTest extends ContextAwareTest {

	@Autowired
	AlternativesService alternativesService;
	
	@Test
	public void testMakeAlternatives() {
		
		Selection selection = new Selection();
		selection.setColor("red");
		selection.setMaterial("leather");
		
		AlternativesXml alternatives = alternativesService.makeAlternatives(selection);
		
		assertTrue(alternatives != null);
		assertTrue(alternatives.getAlternatives().size() == 15);
		
		assertNotNull(alternatives.getAlternatives().get(0).getMaterial());
	}

}
