package de.gwzberlin.zas.survey.client;

import java.util.List;

import com.google.gwt.user.client.ui.IsWidget;

import de.gwzberlin.zas.survey.shared.AlternativesXml;
import de.gwzberlin.zas.survey.shared.Selection;

public interface SurveyView extends IsWidget {

	void setPresenter(Presenter presenter);
	
	void clear();
	
	public interface Presenter
	{
		void onProcessingSelection(Selection selection);

		void onSavingAlternatives(List<Long> result);
	}

	void setAlternatives(AlternativesXml result);
	
	void setInfoBoxVisibility(boolean visible);
}
