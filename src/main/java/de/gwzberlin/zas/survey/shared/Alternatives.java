package de.gwzberlin.zas.survey.shared;

import java.util.ArrayList;
import java.util.List;

import com.google.gwt.user.client.rpc.IsSerializable;

public class Alternatives implements IsSerializable {

	private List<Alternative> alternatives = new ArrayList<Alternative>();

	public List<Alternative> getAlternatives() {
		return alternatives;
	}

	public void setAlternatives(List<Alternative> alternatives) {
		this.alternatives = alternatives;
	}

	@Override
	public String toString() {
		return "Alternatives [alternatives=" + alternatives + "]";
	} 
}
