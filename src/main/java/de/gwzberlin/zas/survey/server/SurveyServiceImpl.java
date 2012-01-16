package de.gwzberlin.zas.survey.server;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;

import de.gwzberlin.zas.survey.shared.Alternatives;
import de.gwzberlin.zas.survey.shared.Selection;
import de.gwzberlin.zas.survey.shared.SurveyService;

@Service("surveyService")
public class SurveyServiceImpl extends RemoteServiceServlet implements SurveyService {
	
	@Autowired
	AlternativesService alternativesService;
	
	private static final long serialVersionUID = -9064724242475917405L;

	public Alternatives sendSelection(Selection selection) {
		
		Alternatives alternatives = alternativesService.makeAlternatives(selection);		
		return alternatives;
	}

	public void saveSelectedAlternatives(List<Integer> result) {
		// TODO Auto-generated method stub
		
	}
}
