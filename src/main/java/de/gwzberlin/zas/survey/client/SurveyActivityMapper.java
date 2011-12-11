package de.gwzberlin.zas.survey.client;

import com.google.gwt.activity.shared.Activity;
import com.google.gwt.activity.shared.ActivityMapper;
import com.google.gwt.place.shared.Place;

public class SurveyActivityMapper implements ActivityMapper {

	private final ClientFactory clientFactory;	
	
	public SurveyActivityMapper(ClientFactory clientFactory) {
		this.clientFactory = clientFactory;
	}

	public Activity getActivity(Place place) {
		if (place instanceof SurveyPlace) {
			return new SurveyActivity(clientFactory, (SurveyPlace)place);
		}
		
		throw new RuntimeException("Unknow place: " + place.toString());
	}
}
