package de.gwzberlin.zas.survey.client;

import com.google.gwt.event.shared.EventBus;
import com.google.gwt.place.shared.PlaceController;

import de.gwzberlin.zas.survey.shared.SurveyServiceAsync;

public interface ClientFactory {
	
	EventBus getEventBus();
	PlaceController getPlaceController();
	SurveyView getSurveyView();
	SurveyServiceAsync getSurveyServiceAsync();
}
