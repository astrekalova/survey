package de.gwzberlin.zas.survey.client;

import com.google.gwt.user.client.ui.IsWidget;

public interface SurveyView extends IsWidget {

	void setPresenter(Presenter presenter);
	
	void clear();
	
	public interface Presenter
	{
		
	}

	void addAlternative(String chatEntry);
}
