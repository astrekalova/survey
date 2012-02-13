package de.gwzberlin.zas.survey.dao;

import static org.junit.Assert.*;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import de.gwzberlin.zas.survey.db.Alternative;
import de.gwzberlin.zas.survey.test.TransactionAwareTest;


public class AlternativeDaoTest extends TransactionAwareTest {

	@Autowired
	AlternativeDao selectedAlternativeDao;
	
	@Test
	public void simpleTest() {
		
		Alternative alternative = new Alternative();
		alternative.setSelected(true);
		
		selectedAlternativeDao.saveOrUpdate(alternative);
		
		Long alternativeId = alternative.getId();
		
		Alternative selectedAlternative = selectedAlternativeDao.findById(alternativeId);
		
		assertNotNull(selectedAlternative);
	}
}
