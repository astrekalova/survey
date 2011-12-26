package de.gwzberlin.zas.survey.client;

import java.util.Arrays;
import java.util.List;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.cellview.client.CellTable;
import com.google.gwt.user.client.ui.CheckBox;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.Widget;

import de.gwzberlin.zas.survey.shared.Alternative;

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
	
	@UiField
	CellTable<Alternative> list;
	
	public SurveyViewImpl() {
		
		initWidget(uiBinder.createAndBindUi(this));		
		
		for (String color : allColors) {
			colors.addItem(color);
		}		
		for (String material : allMaterials) {
			materials.addItem(material);
		}	
		
		//if color + material are selected, show list
	}

	public void setPresenter(Presenter presenter) {
		this.presenter = presenter;
	}

	public void clear() {
		
	}
}
