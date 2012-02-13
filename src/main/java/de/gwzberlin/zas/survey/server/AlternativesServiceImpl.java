package de.gwzberlin.zas.survey.server;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import de.gwzberlin.zas.survey.db.Alternative;
import de.gwzberlin.zas.survey.shared.AlternativeXml;
import de.gwzberlin.zas.survey.shared.AlternativesXml;
import de.gwzberlin.zas.survey.shared.NameValuePair;
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

	public AlternativesXml makeAlternatives(Selection selection) {

		AlternativesXml alternatives = new AlternativesXml();
		List<AlternativeXml> alternativesList = new ArrayList<AlternativeXml>();		
		
		Color selectedColor = getSelectedColor(selection);
		Material selectedMaterial = getSelectedMaterial(selection);

		// make lists with equivalent classes of all values
		List<EquivalenceClass> colorEqClass1 = new ArrayList<EquivalenceClass>();
		List<EquivalenceClass> colorEqClass2 = new ArrayList<EquivalenceClass>();
		List<EquivalenceClass> colorEqClass3 = new ArrayList<EquivalenceClass>();		
		
		List<EquivalenceClass> materialEqClass1 = new ArrayList<EquivalenceClass>();
		List<EquivalenceClass> materialEqClass2 = new ArrayList<EquivalenceClass>();
		List<EquivalenceClass> materialEqClass3 = new ArrayList<EquivalenceClass>();		

		for (EquivalenceClass colorEqClass : selectedColor.getEquivalenceClasses()) {
			int colorNumber = colorEqClass.getNumber();			
			if (colorNumber == 1) {
				colorEqClass1.add(colorEqClass);
			} else if (colorNumber == 2) {
				colorEqClass2.add(colorEqClass);
			} else if (colorNumber == 3) {
				colorEqClass3.add(colorEqClass);
			}
		}		
		
		for (EquivalenceClass materialEqClass : selectedMaterial.getEqclasses()) {
			int materialNumber = materialEqClass.getNumber();						
			if (materialNumber == 1) {
				materialEqClass1.add(materialEqClass);
			} else if (materialNumber == 2) {
				materialEqClass2.add(materialEqClass);
			} else if (materialNumber == 3) {
				materialEqClass3.add(materialEqClass);
			}
		}		
		
		// combine equivalent classes to create alternatives
		
		for (EquivalenceClass color : colorEqClass1) {
			for (EquivalenceClass material : materialEqClass2) {
				AlternativeXml alt = new AlternativeXml();
				alt.setColor(new NameValuePair(color.getName(), color.getNumber()));
				alt.setMaterial(new NameValuePair(material.getName(), material.getNumber()));
				alternativesList.add(alt);
			}
		}
		
		for (EquivalenceClass color : colorEqClass2) {
			for (EquivalenceClass material : materialEqClass1) {
				AlternativeXml alt = new AlternativeXml();
				alt.setColor(new NameValuePair(color.getName(), color.getNumber()));
				alt.setMaterial(new NameValuePair(material.getName(), material.getNumber()));
				alternativesList.add(alt);
			}
		}
		
		for (EquivalenceClass color : colorEqClass3) {
			AlternativeXml alt = new AlternativeXml();
			alt.setColor(new NameValuePair(color.getName(), color.getNumber()));
			alt.setMaterial(new NameValuePair(selection.getMaterial(), 0));
			alternativesList.add(alt);
		}
		
		for (EquivalenceClass material : materialEqClass3) {
			AlternativeXml alt = new AlternativeXml();
			alt.setColor(new NameValuePair(selection.getColor(), 0));
			alt.setMaterial(new NameValuePair(material.getName(), material.getNumber()));
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
