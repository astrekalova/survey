package de.gwzberlin.zas.survey.server;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;

import de.gwzberlin.zas.survey.shared.Alternative;
import de.gwzberlin.zas.survey.shared.Alternatives;
import de.gwzberlin.zas.survey.shared.Selection;
import de.gwzberlin.zas.survey.shared.SurveyService;

@Service("surveyService")
public class SurveyServiceImpl extends RemoteServiceServlet implements SurveyService {

	private static final long serialVersionUID = -9064724242475917405L;

	public Alternatives sendSelection(Selection selection) {
		// TODO here get the list with alternatives!
		Alternatives alternatives = new Alternatives();
		
		Alternative alternative1 = new Alternative();
		alternative1.setValues(Arrays.asList("orange", "Leder"));
		Alternative alternative2 = new Alternative();
		alternative2.setValues(Arrays.asList("blau", "Leinen"));
		alternatives.setAlternatives(Arrays.asList(alternative1, alternative2));
		
		return alternatives;
	}

	public void saveSelectedAlternatives(List<Integer> result) {
		// TODO Auto-generated method stub
		
	}
}
