package de.gwzberlin.zas.survey.client;

import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceTokenizer;
import com.google.gwt.place.shared.Prefix;

public class SurveyPlace extends Place {

	private final SurveyPlaceType type;
	
	public SurveyPlace() {
		this.type = SurveyPlaceType.Question1;
	}
	
	public SurveyPlace(SurveyPlaceType type) {
		this.type = type;
	}

	public SurveyPlaceType getType() {
		return type;
	}
	
	@Prefix("Survey")
	public static class Tokenizer implements PlaceTokenizer<SurveyPlace> {

		public String getToken(SurveyPlace place) {
			return place.getType().name();
		}
		
		public SurveyPlace getPlace(String token) {
			SurveyPlaceType type = Enum.valueOf(SurveyPlaceType.class, token);
			return new SurveyPlace(type);
		}
	}
}
