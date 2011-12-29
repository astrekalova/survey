package de.gwzberlin.zas.survey.shared;

import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;
import com.google.gwt.user.client.rpc.RemoteService;

import de.gwzberlin.zas.survey.client.Selection;

@RemoteServiceRelativePath("survey")
public interface SurveyService extends RemoteService {

	void sendSelection(Selection selection);
}
