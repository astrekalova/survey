package de.gwzberlin.zas.survey.client;

import com.google.gwt.place.shared.PlaceHistoryMapper;
import com.google.gwt.place.shared.WithTokenizers;

import de.gwzberlin.zas.survey.client.SurveyPlace;

@WithTokenizers({ SurveyPlace.Tokenizer.class })
public interface SurveyPlaceHistoryMapper extends PlaceHistoryMapper  {

}
