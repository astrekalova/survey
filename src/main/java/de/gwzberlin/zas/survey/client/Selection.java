package de.gwzberlin.zas.survey.client;

import com.google.gwt.user.client.rpc.IsSerializable;

public class Selection implements IsSerializable {

	private String color;
	private String material;
	
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public String getMaterial() {
		return material;
	}
	public void setMaterial(String material) {
		this.material = material;
	}
}
