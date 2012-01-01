package de.gwzberlin.zas.survey.shared;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

import de.gwzberlin.zas.survey.client.Selection;

@RemoteServiceRelativePath("survey")
public interface SurveyService extends RemoteService {

	Alternatives sendSelection(Selection selection);
}
