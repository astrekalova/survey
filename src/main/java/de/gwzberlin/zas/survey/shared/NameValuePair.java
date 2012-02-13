package de.gwzberlin.zas.survey.shared;

import com.google.gwt.user.client.rpc.IsSerializable;

public class NameValuePair implements IsSerializable {

	private int number;
	private String name;	
	
	public NameValuePair() {
		
	}
	
	public NameValuePair(String name, int number) {
		super();
		this.name = name;
		this.number = number;
	}
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
		return "NameValuePair [number=" + number + ", name=" + name + "]";
	}
}
