package de.gwzberlin.zas.survey.shared;

import java.util.List;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;


@RemoteServiceRelativePath("survey")
public interface SurveyService extends RemoteService {

	AlternativesXml sendSelection(Selection selection);
	
	void saveAlternatives(List<Long> result);
}
