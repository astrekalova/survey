package de.gwzberlin.zas.survey.client;

import java.util.Arrays;
import java.util.List;

import com.google.gwt.cell.client.CheckboxCell;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.cellview.client.CellTable;
import com.google.gwt.user.cellview.client.Column;
import com.google.gwt.user.cellview.client.TextColumn;
import com.google.gwt.user.client.Timer;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.ScrollPanel;
import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.view.client.ListDataProvider;

import de.gwzberlin.zas.survey.shared.Alternative;
import de.gwzberlin.zas.survey.shared.Alternatives;

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
	CellTable<String> alternativesTable;
	
	@UiField
	ScrollPanel alternativesScroller;

	private Selection selection;
	
	public SurveyViewImpl() {
		
		initWidget(uiBinder.createAndBindUi(this));		

		for (String color : allColors) {
			colors.addItem(color);
		}		
		for (String material : allMaterials) {
			materials.addItem(material);
		}	

//		//if color + material are selected, show list
//		alternativesTable = new CellTable<String>(300);
//		alternativesTable.setWidth("100%");
//		alternativesTable.addColumn(new TextColumn<String>() {
//			public String getValue(String object) {
//				return object;
//			}
//		});
		
		alternativesDataProvider.addDataDisplay(alternativesTable);
	}
	
	public void addAlternatives(Alternatives alternatives) {
//		alternativesDataProvider.getList().add(alternatives);

		//if color + material are selected, show list
//		alternativesTable = new CellTable<Alternative>(300);
//		alternativesTable.setWidth("100%");
//		
//		Column<Alternative, Boolean> checkboxColumn = new Column<Alternative, Boolean>(new CheckboxCell(true, false)) {
//			@Override
//			public Boolean getValue(Alternative object) {
//				return answerOptionSelectionModel.isSelected(object);
//			}
//		};
//		alternativesTable.addColumn(checkboxColumn, "Select");
		
		
		
		new Timer() {
			public void run() {
				alternativesScroller.scrollToBottom();
			};
		}.schedule(1);
	}

	@UiHandler("colors")
	public void onChangeColors(ClickEvent event) {
		selection.setColor(colors.getItemText(colors.getSelectedIndex()));
	}
	
	@UiHandler("materials")
	public void onChangeMaterials(ClickEvent event) {
		selection.setMaterial(materials.getItemText(materials.getSelectedIndex()));
		presenter.onSelection(selection);
	}
	
	public void setPresenter(Presenter presenter) {
		this.presenter = presenter;
	}

	public void clear() {
		alternativesDataProvider.getList().clear();
	}
}
