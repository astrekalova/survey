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
	
	@UiField
	ListBox colors;
	
	@UiField
	ListBox materials;
	
	public SurveyViewImpl() {
		
		colors = new ListBox(false);
		List<String> allColors = Arrays.asList("rot","blau", "gelb");
		for (int i = 0; i < allColors.size(); i++) {
			colors.addItem(allColors.get(i));
			
		}
		colors.ensureDebugId("colors-dropBox");
		
		materials = new ListBox(false);
		List<String> allMaterials = Arrays.asList("Leder","Baumwolle", "Seide");
		for (int i = 0; i < allMaterials.size(); i++) {
			materials.addItem(allMaterials.get(i));
		}
		
		initWidget(uiBinder.createAndBindUi(this));
	}

	public void setPresenter(Presenter presenter) {
		this.presenter = presenter;
	}

	public void clear() {
		
	}
}
