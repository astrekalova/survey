package de.gwzberlin.zas.survey.server;

import de.gwzberlin.zas.survey.shared.Alternatives;
import de.gwzberlin.zas.survey.shared.Selection;

public interface AlternativesService {

	public Alternatives makeAlternatives(Selection selection);
}
