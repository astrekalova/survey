package de.gwzberlin.zas.survey.server;

import de.gwzberlin.zas.survey.shared.AlternativesXml;
import de.gwzberlin.zas.survey.shared.Selection;

public interface AlternativesService {

	public AlternativesXml makeAlternatives(Selection selection);
}
