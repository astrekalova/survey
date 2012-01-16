package de.gwzberlin.zas.survey.types;

import javax.xml.bind.annotation.XmlType;

@XmlType
public class EquivalenceClass {

	private int number;
	private String name;
	
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "EquivalenceClass [number=" + number + ", name=" + name + "]";
	}
}
