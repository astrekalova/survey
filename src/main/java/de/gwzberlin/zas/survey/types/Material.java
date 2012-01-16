package de.gwzberlin.zas.survey.types;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;

public class Material {

	private String name;
	private List<EquivalenceClass> eqclasses = new ArrayList<EquivalenceClass>();
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	@XmlElementWrapper(name = "eqclasses")
	@XmlElement(name = "eqclass")
	public List<EquivalenceClass> getEqclasses() {
		return eqclasses;
	}
	public void setEqclasses(List<EquivalenceClass> eqclasses) {
		this.eqclasses = eqclasses;
	}
	@Override
	public String toString() {
		return "Material [name=" + name + ", eqclasses=" + eqclasses + "]";
	}	
}
