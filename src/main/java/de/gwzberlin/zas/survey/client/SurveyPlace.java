package de.gwzberlin.zas.survey.client;

import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceTokenizer;
import com.google.gwt.place.shared.Prefix;

public class SurveyPlace extends Place {

	@Prefix("Survey")
	public static class Tokenizer implements PlaceTokenizer<SurveyPlace> {

		public SurveyPlace getPlace(String token) {
			// TODO Auto-generated method stub
			return null;
		}

		public String getToken(SurveyPlace place) {
			// TODO Auto-generated method stub
			return null;
		}
	}
}
