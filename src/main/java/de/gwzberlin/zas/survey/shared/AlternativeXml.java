package de.gwzberlin.zas.survey.shared;

import com.google.gwt.user.client.rpc.IsSerializable;

public class AlternativeXml implements IsSerializable {
	
	private long id;
	private NameValuePair color;
	private NameValuePair material;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public NameValuePair getColor() {
		return color;
	}

	public void setColor(NameValuePair nameValuePair) {
		this.color = nameValuePair;
	}

	public NameValuePair getMaterial() {
		return material;
	}

	public void setMaterial(NameValuePair material) {
		this.material = material;
	}
}
