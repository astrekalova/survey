package de.gwzberlin.zas.survey.server;

import org.springframework.stereotype.Service;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;

import de.gwzberlin.zas.survey.client.Selection;
import de.gwzberlin.zas.survey.shared.Alternatives;
import de.gwzberlin.zas.survey.shared.SurveyService;

@Service("surveyService")
public class SurveyServiceImpl extends RemoteServiceServlet implements
		SurveyService {

	private static final long serialVersionUID = -9064724242475917405L;

	public Alternatives sendSelection(Selection selection) {
		// TODO here get the list with alternatives!
		return null;
	}
}
