package de.gwzberlin.zas.survey.shared;

import java.util.List;

import com.google.gwt.user.client.rpc.AsyncCallback;


public interface SurveyServiceAsync {

	void sendSelection(Selection selection, AsyncCallback<Alternatives> asyncCallback);

	void saveSelectedAlternatives(List<Integer> result, AsyncCallback<Void> asyncCallback);

}
