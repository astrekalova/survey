package de.gwzberlin.zas.survey.client;

import com.google.gwt.user.client.ui.IsWidget;

import de.gwzberlin.zas.survey.shared.Alternatives;

public interface SurveyView extends IsWidget {

	void setPresenter(Presenter presenter);
	
	void clear();
	
	public interface Presenter
	{
		void onSelection(Selection selection);
	}

	void addAlternatives(Alternatives alternatives);
}
