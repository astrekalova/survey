package de.gwzberlin.zas.survey.client;

import java.util.List;

import com.google.gwt.user.client.ui.IsWidget;

import de.gwzberlin.zas.survey.shared.Alternatives;
import de.gwzberlin.zas.survey.shared.Selection;

public interface SurveyView extends IsWidget {

	void setPresenter(Presenter presenter);
	
	void clear();
	
	public interface Presenter
	{
		void onProcessingSelection(Selection selection);

		void onSavingAlternatives(List<Integer> result);
	}

	void setAlternatives(Alternatives result);
	
	void setInfoBoxVisibility(boolean visible);
}
