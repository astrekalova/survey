package de.gwzberlin.zas.survey.client;

import java.util.Arrays;
import java.util.List;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.Widget;

public class SurveyViewImpl extends Composite implements SurveyView {

	interface SurveyUiBinder extends UiBinder<Widget, SurveyViewImpl> {
	}

	private static final SurveyUiBinder uiBinder = GWT.create(SurveyUiBinder.class);

	private Presenter presenter;
	
	private List<String> allColors = Arrays.asList("", "rot", "orange", "gelb", "grün", "blau", "lila", "schwarz", "weiss", "grau");
	private List<String> allMaterials = Arrays.asList("", "Rattan", "Plastik", "Leder", "Wildleder", "Samt","Baumwolle", "Seide", "Leinen");

	@UiField
	ListBox colors;
	
	@UiField
	ListBox materials;
	
	public SurveyViewImpl() {
		
		initWidget(uiBinder.createAndBindUi(this));		
		
		for (String color : allColors) {
			colors.addItem(color);
		}		
		for (String material : allMaterials) {
			materials.addItem(material);
		}		
	}

	public void setPresenter(Presenter presenter) {
		this.presenter = presenter;
	}

	public void clear() {
		
	}
}
