package de.gwzberlin.zas.survey.types;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "colors")
public class Colors {

	private List<Color> colors = new ArrayList<Color>();

	@XmlElement(name = "color")
	public List<Color> getColors() {
		return colors;
	}

	public void setColors(List<Color> colors) {
		this.colors = colors;
	}
}
