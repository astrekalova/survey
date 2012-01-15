package de.gwzberlin.zas.survey.server;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;

import de.gwzberlin.zas.survey.shared.Alternative;
import de.gwzberlin.zas.survey.shared.Alternatives;
import de.gwzberlin.zas.survey.shared.Selection;
import de.gwzberlin.zas.survey.shared.SurveyService;
import de.gwzberlin.zas.survey.types.Color;
import de.gwzberlin.zas.survey.types.Colors;

@Service("surveyService")
public class SurveyServiceImpl extends RemoteServiceServlet implements SurveyService {

	@Autowired
	PropertiesDao propertiesDao;
	
	private static final long serialVersionUID = -9064724242475917405L;

	public Alternatives sendSelection(Selection selection) {
		
		Colors colors = propertiesDao.getColors();
		
		Alternatives alternatives = new Alternatives();

		Alternative alternative = new Alternative();
		Color firstColor = colors.getColors().get(0);
		alternative.setValues(Arrays.asList(firstColor.getEquivalenceClasses().get(0).getName(), selection.getMaterial()));
		
		alternatives.setAlternatives(Arrays.asList(alternative));
		
		return alternatives;
	}

	public void saveSelectedAlternatives(List<Integer> result) {
		// TODO Auto-generated method stub
		
	}
}
