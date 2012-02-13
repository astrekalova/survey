package de.gwzberlin.zas.survey.dao;

import static org.junit.Assert.assertNotNull;

import java.util.Date;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import de.gwzberlin.zas.survey.db.UserChoice;
import de.gwzberlin.zas.survey.test.TransactionAwareTest;


public class UserChoiceDaoTest extends TransactionAwareTest {
	
	@Autowired
	private UserChoiceDao userChoiceDao;
	
	@Test
	public void simpleTest() {
		
		UserChoice userChoice = new UserChoice();
		userChoice.setDate(new Date());
		
		userChoice.setColor("rot");
		
		userChoiceDao.saveOrUpdate(userChoice);
		final Long userChoiceId = userChoice.getId();
		
		userChoice = userChoiceDao.findById(userChoiceId);
		assertNotNull(userChoice);
		assertNotNull(userChoice.getColor());
	}
	
}
