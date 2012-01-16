package de.gwzberlin.zas.survey.shared;

import java.util.ArrayList;
import java.util.List;

import com.google.gwt.user.client.rpc.IsSerializable;

public class Alternative implements IsSerializable {

	private int id;
	private List<String> values = new ArrayList<String>();

	public List<String> getValues() {
		return values;
	}

	public void setValues(List<String> values) {
		this.values = values;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "Alternative [id=" + id + ", values=" + values + "]";
	}
}
