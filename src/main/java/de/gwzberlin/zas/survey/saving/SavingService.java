package de.gwzberlin.zas.survey.saving;

import java.util.List;

import de.gwzberlin.zas.survey.shared.AlternativesXml;
import de.gwzberlin.zas.survey.shared.Selection;

public interface SavingService {

	void initialSave(Selection selection, AlternativesXml alternatives);

	void saveSelectedAlternatives(List<Long> selected);	
}
