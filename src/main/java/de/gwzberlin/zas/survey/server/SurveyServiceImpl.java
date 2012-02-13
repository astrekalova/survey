package de.gwzberlin.zas.survey.server;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;

import de.gwzberlin.zas.survey.saving.SavingService;
import de.gwzberlin.zas.survey.shared.AlternativesXml;
import de.gwzberlin.zas.survey.shared.Selection;
import de.gwzberlin.zas.survey.shared.SurveyService;

@Service("surveyService")
public class SurveyServiceImpl extends RemoteServiceServlet implements SurveyService {
	
	@Autowired
	AlternativesService alternativesService;
	
	@Autowired
	SavingService savingService;
	
	private static final long serialVersionUID = -9064724242475917405L;

	@Transactional
	public AlternativesXml sendSelection(Selection selection) {
		
		AlternativesXml alternatives = alternativesService.makeAlternatives(selection);
		
		savingService.initialSave(selection, alternatives);
		
		return alternatives;
	}

	@Transactional
	public void saveAlternatives(List<Long> selectedIds) {
		savingService.saveSelectedAlternatives(selectedIds);
	}
}
