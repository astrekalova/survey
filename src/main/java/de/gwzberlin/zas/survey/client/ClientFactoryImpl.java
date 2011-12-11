package de.gwzberlin.zas.survey.client;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.event.shared.SimpleEventBus;
import com.google.gwt.place.shared.PlaceController;

import de.gwzberlin.zas.survey.shared.SurveyService;
import de.gwzberlin.zas.survey.shared.SurveyServiceAsync;

public class ClientFactoryImpl implements ClientFactory {

	private static final EventBus eventBus = new SimpleEventBus();
	private static final PlaceController placeController = new PlaceController(eventBus);
	private static final SurveyView surveyView = new SurveyViewImpl();
	private static final SurveyServiceAsync surveyServiceAsync = GWT.create(SurveyService.class);
	
	public EventBus getEventBus() {
		return eventBus;
	}

	public PlaceController getPlaceController() {
		return placeController;
	}

	public SurveyView getSurveyView() {
		return surveyView;
	}

	public SurveyServiceAsync getSurveyServiceAsync() {
		return surveyServiceAsync;
	}

}
