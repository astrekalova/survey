package de.gwzberlin.zas.survey.types;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "materials")
public class Materials {

	private List<Material> materials = new ArrayList<Material>();

	@XmlElement(name = "material")
	public List<Material> getMaterials() {
		return materials;
	}

	public void setMaterials(List<Material> materials) {
		this.materials = materials;
	}
}
