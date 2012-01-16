package de.gwzberlin.zas.survey.server;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import de.gwzberlin.zas.survey.shared.Alternative;
import de.gwzberlin.zas.survey.shared.Alternatives;
import de.gwzberlin.zas.survey.shared.Selection;
import de.gwzberlin.zas.survey.types.Color;
import de.gwzberlin.zas.survey.types.Colors;
import de.gwzberlin.zas.survey.types.EquivalenceClass;
import de.gwzberlin.zas.survey.types.Material;
import de.gwzberlin.zas.survey.types.Materials;

@Service("alternativesService")
public class AlternativesServiceImpl implements AlternativesService {

	@Autowired
	PropertiesDao propertiesDao;


	public Alternatives makeAlternatives(Selection selection) {

		Alternatives alternatives = new Alternatives();

		Color selectedColor = getSelectedColor(selection);
		Material selectedMaterial = getSelectedMaterial(selection);
		
		List<Alternative> alternativesList = new ArrayList<Alternative>();
		
		//alternative
		for (EquivalenceClass colorEqClass : selectedColor.getEquivalenceClasses()) {
			int colorNumber = colorEqClass.getNumber();
			
			if (colorNumber == 1) {
				Alternative alternative = new Alternative();
				alternative.setValues(Arrays.asList(colorEqClass.getName(), selection.getMaterial()));
				alternativesList.add(alternative);
				break;
			}

			for (EquivalenceClass materialEqClass : selectedMaterial.getEqclasses()) {
				int materialNumber = materialEqClass.getNumber();				
				
				if (materialNumber == 1) {
					Alternative alternative = new Alternative();
					alternative.setValues(Arrays.asList(selection.getColor(), materialEqClass.getName()));
					alternativesList.add(alternative);
					break;
				}
			}
		}
		
		alternatives.setAlternatives(alternativesList);
		
		return alternatives;
	}

	private Color getSelectedColor(Selection selection) {
		
		Color selectedColor = null;		
		Colors colors = propertiesDao.getColors();
		
		for (Color color : colors.getColors()) {
			if (color.getName().equals(selection.getColor())) {
				selectedColor = color;
			}
		}
		
		return selectedColor;
	}

	private Material getSelectedMaterial(Selection selection) {
		
		Materials materials = propertiesDao.getMaterials();
		
		Material selectedMaterial = null;
		
		for (Material material : materials.getMaterials()) {
			if (material.getName().equals(selection.getMaterial())) {
				selectedMaterial = material;
			}
		}
		
		return selectedMaterial;
	}
}
