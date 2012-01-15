package de.gwzberlin.zas.survey.types;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlType;

@XmlType
public class Color {

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
	public List<EquivalenceClass> getEquivalenceClasses() {
		return eqclasses;
	}
	public void setEquivalenceClasses(List<EquivalenceClass> equivalenceClasses) {
		this.eqclasses = equivalenceClasses;
	}	
}
