package de.gwzberlin.zas.survey.shared;

import java.util.ArrayList;
import java.util.List;

import com.google.gwt.user.client.rpc.IsSerializable;

public class AlternativesXml implements IsSerializable {

	private List<AlternativeXml> alternatives = new ArrayList<AlternativeXml>();

	public List<AlternativeXml> getAlternatives() {
		return alternatives;
	}

	public void setAlternatives(List<AlternativeXml> alternatives) {
		this.alternatives = alternatives;
	}

	@Override
	public String toString() {
		return "Alternatives [alternatives=" + alternatives + "]";
	} 
}
