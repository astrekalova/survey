package de.gwzberlin.zas.survey.saving;

import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import de.gwzberlin.zas.survey.dao.AlternativeDao;
import de.gwzberlin.zas.survey.dao.UserChoiceDao;
import de.gwzberlin.zas.survey.db.Alternative;
import de.gwzberlin.zas.survey.db.UserChoice;
import de.gwzberlin.zas.survey.shared.AlternativeXml;
import de.gwzberlin.zas.survey.shared.AlternativesXml;
import de.gwzberlin.zas.survey.shared.Selection;

@Service("savingService")
public class SavingServiceImpl implements SavingService {

	private static final Logger log = LoggerFactory.getLogger(SavingServiceImpl.class);

	@Autowired
	private UserChoiceDao userChoiceDao;
	@Autowired
	private AlternativeDao selectedAlternativeDao;

	public void initialSave(Selection selection, AlternativesXml alternatives) {

		final UserChoice userChoice = new UserChoice();
		userChoice.setDate(new Date());
		userChoice.setColor(selection.getColor());
		userChoice.setMaterial(selection.getMaterial());

		userChoiceDao.saveOrUpdate(userChoice);
		
		log.debug("First user choice with id={}", userChoice.getId());

		for (AlternativeXml alternativeXml : alternatives.getAlternatives()) {

			Alternative alternative = new Alternative();
			alternative.setColor(alternativeXml.getColor().getName());
			alternative.setColorValue(alternativeXml.getColor().getNumber());
			alternative.setMaterial(alternativeXml.getMaterial().getName());
			alternative.setMaterialValue(alternativeXml.getMaterial()
					.getNumber());

			userChoice.getAlternatives().add(alternative);
			selectedAlternativeDao.saveOrUpdate(alternative);

			alternativeXml.setId(alternative.getId());
		}
		
		log.debug("Updated {} alternatives", alternatives.getAlternatives().size());

		userChoiceDao.saveOrUpdate(userChoice);

		log.debug("Second user choice with id={}", userChoice.getId());
	}

	public void saveSelectedAlternatives(List<Long> selected) {
		for (Long id : selected) {
			Alternative alternative = selectedAlternativeDao.findById(id);
			alternative.setSelected(true);
			selectedAlternativeDao.saveOrUpdate(alternative);
		}
		log.debug("Updated {} selected", selected.size());
	}
}