package de.gwzberlin.zas.survey.shared;

import com.google.gwt.user.client.rpc.AsyncCallback;

import de.gwzberlin.zas.survey.client.Selection;

public interface SurveyServiceAsync {

	void sendSelection(Selection selection, AsyncCallback<Alternatives> asyncCallback);

}
