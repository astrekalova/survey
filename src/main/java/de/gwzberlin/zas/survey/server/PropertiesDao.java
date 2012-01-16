package de.gwzberlin.zas.survey.server;

import de.gwzberlin.zas.survey.types.Colors;
import de.gwzberlin.zas.survey.types.Materials;

public interface PropertiesDao {

	Colors getColors();
	
	Materials getMaterials();
}