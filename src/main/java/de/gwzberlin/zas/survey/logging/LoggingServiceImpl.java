package de.gwzberlin.zas.survey.logging;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import de.gwzberlin.zas.survey.db.UserChoice;
import de.gwzberlin.zas.survey.shared.Selection;

@Service("loggingService")
@Scope("session")
public class LoggingServiceImpl implements LoggingService {

	private static final Logger log = LoggerFactory.getLogger(LoggingServiceImpl.class);
	
	public void logSelection(Selection selection) {

		final UserChoice conversation = getUserChoice();
		
		
	}	

	private UserChoice getUserChoice() {
		UserChoice choice = new UserChoice();
		return choice;
	}
	
	public void logAlternatives() {
		// TODO Auto-generated method stub

	}

}
