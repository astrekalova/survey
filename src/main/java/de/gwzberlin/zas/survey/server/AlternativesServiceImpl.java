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
		
		List<String> colorEqClass1 = new ArrayList<String>();
		List<String> colorEqClass2 = new ArrayList<String>();
		List<String> colorEqClass3 = new ArrayList<String>();		
		
		for (EquivalenceClass colorEqClass : selectedColor.getEquivalenceClasses()) {
			int colorNumber = colorEqClass.getNumber();			
			if (colorNumber == 1) {
				colorEqClass1.add(colorEqClass.getName());
			} else if (colorNumber == 2) {
				colorEqClass2.add(colorEqClass.getName());
			} else if (colorNumber == 3) {
				colorEqClass3.add(colorEqClass.getName());
			}
		}
		
		List<String> materialEqClass1 = new ArrayList<String>();
		List<String> materialEqClass2 = new ArrayList<String>();
		List<String> materialEqClass3 = new ArrayList<String>();
		
		for (EquivalenceClass materialEqClass : selectedMaterial.getEqclasses()) {
			int materialNumber = materialEqClass.getNumber();						
			if (materialNumber == 1) {
				materialEqClass1.add(materialEqClass.getName());
			} else if (materialNumber == 2) {
				materialEqClass2.add(materialEqClass.getName());
			} else if (materialNumber == 3) {
				materialEqClass3.add(materialEqClass.getName());
			}
		}
		
		for (String color : colorEqClass1) {
			for (String material : materialEqClass2) {
				Alternative alt = new Alternative();
				alt.setValues(Arrays.asList(color, material));
				alternativesList.add(alt);
			}
		}
		
		for (String color : colorEqClass2) {
			for (String material : materialEqClass1) {
				Alternative alt = new Alternative();
				alt.setValues(Arrays.asList(color, material));
				alternativesList.add(alt);
			}
		}
		
		for (String color : colorEqClass3) {
			Alternative alt = new Alternative();
			alt.setValues(Arrays.asList(color, selection.getMaterial()));
			alternativesList.add(alt);
		}
		
		for (String material : materialEqClass3) {
			Alternative alt = new Alternative();
			alt.setValues(Arrays.asList(selection.getColor(), material));
			alternativesList.add(alt);
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