package de.gwzberlin.zas.survey.logging;

import de.gwzberlin.zas.survey.shared.Selection;

public interface LoggingService {

	void logSelection(Selection selection);
	
	void logAlternatives();
}
