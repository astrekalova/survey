package de.gwzberlin.zas.survey.client;

import java.util.Arrays;
import java.util.List;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.cellview.client.CellTable;
import com.google.gwt.user.cellview.client.TextColumn;
import com.google.gwt.user.client.Timer;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.ScrollPanel;
import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.view.client.ListDataProvider;

public class SurveyViewImpl extends Composite implements SurveyView {

	interface SurveyUiBinder extends UiBinder<Widget, SurveyViewImpl> {
	}

	private static final SurveyUiBinder uiBinder = GWT.create(SurveyUiBinder.class);

	private Presenter presenter;

	private List<String> allColors = Arrays.asList("", "rot", "orange", "gelb", "grün", "blau", "lila", "schwarz", "weiss", "grau");
	private List<String> allMaterials = Arrays.asList("", "Rattan", "Plastik", "Leder", "Wildleder", "Samt","Baumwolle", "Seide", "Leinen");
	
	private ListDataProvider<String> alternativesDataProvider = new ListDataProvider<String>();
	
	@UiField
	ListBox colors;
	
	@UiField
	ListBox materials;
	
	@UiField(provided = true)
	CellTable<String> alternatives;
	
	@UiField
	ScrollPanel alternativesScroller;
	
	public SurveyViewImpl() {
		
		initWidget(uiBinder.createAndBindUi(this));		

		for (String color : allColors) {
			colors.addItem(color);
		}		
		for (String material : allMaterials) {
			materials.addItem(material);
		}	

		//if color + material are selected, show list
		alternatives = new CellTable<String>(300);
		alternatives.setWidth("100%");
		alternatives.addColumn(new TextColumn<String>() {
			public String getValue(String object) {
				return object;
			}
		});
		
		alternativesDataProvider.addDataDisplay(alternatives);
	}
	
	public void addAlternative(String alternative) {
		alternativesDataProvider.getList().add(alternative);

		new Timer() {
			public void run() {
				alternativesScroller.scrollToBottom();
			};
		}.schedule(1);
	}

	public void setPresenter(Presenter presenter) {
		this.presenter = presenter;
	}

	public void clear() {
		
	}
}
