package de.gwzberlin.zas.survey.client;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

import com.google.gwt.cell.client.CheckboxCell;
import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.cellview.client.CellList;
import com.google.gwt.user.cellview.client.CellTable;
import com.google.gwt.user.cellview.client.Column;
import com.google.gwt.user.cellview.client.TextColumn;
import com.google.gwt.user.client.Timer;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.DockLayoutPanel;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.ScrollPanel;
import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.view.client.DefaultSelectionEventManager;
import com.google.gwt.view.client.ListDataProvider;
import com.google.gwt.view.client.MultiSelectionModel;

import de.gwzberlin.zas.survey.shared.Alternative;
import de.gwzberlin.zas.survey.shared.Alternatives;
import de.gwzberlin.zas.survey.shared.Selection;

public class SurveyViewImpl extends Composite implements SurveyView {

	interface SurveyUiBinder extends UiBinder<Widget, SurveyViewImpl> {
	}

	private static final SurveyUiBinder uiBinder = GWT.create(SurveyUiBinder.class);

	private Presenter presenter;

	private List<String> allColors = Arrays.asList("", "rot", "orange", "gelb", "grün", "blau", "lila", "schwarz", "weiss", "grau");
	private List<String> allMaterials = Arrays.asList("", "Rattan", "Plastik", "Leder", "Wildleder", "Samt","Baumwolle", "Seide", "Leinen");
	
	private ListDataProvider<Alternative> alternativesDataProvider = new ListDataProvider<Alternative>();
	private MultiSelectionModel<Alternative> answerOptionSelectionModel;
	
	@UiField
	ListBox colors;
	
	@UiField
	ListBox materials;
	
	@UiField(provided = true)
	CellTable<Alternative> alternativesTable;
	
	@UiField
	ScrollPanel alternativesScroller;
	
	@UiField
	DockLayoutPanel infoBox;
	
	@UiField
	Button submitButton;
	
	@UiField
	Button saveButton;

	private Selection selection;
	
	public SurveyViewImpl() {
		
		alternativesTable = new CellTable<Alternative>(100, alternativesDataProvider);
		alternativesTable.setWidth("100%");
		answerOptionSelectionModel = new MultiSelectionModel<Alternative>(alternativesDataProvider);
		alternativesTable.setSelectionModel(answerOptionSelectionModel, DefaultSelectionEventManager.<Alternative> createCheckboxManager());
		
		// Create checkbox column
		Column<Alternative, Boolean> checkboxColumn = new Column<Alternative, Boolean>(new CheckboxCell(true, false)) {
			@Override
			public Boolean getValue(Alternative object) {
				return answerOptionSelectionModel.isSelected(object);
			}
		};
		alternativesTable.addColumn(checkboxColumn);
		
		// Create alternatives column
		TextColumn<Alternative> alternativesColumn = new TextColumn<Alternative>() {
			@Override
			public String getValue(Alternative alternative) {	
				StringBuilder builder = new StringBuilder();
				for (String value : alternative.getValues()) {
					builder.append(value + " ");
				}
				return builder.toString();
			}
		};
		alternativesTable.addColumn(alternativesColumn);
		
		alternativesTable.setColumnWidth(checkboxColumn, 40.0, Unit.PX);
		
		alternativesDataProvider.addDataDisplay(alternativesTable);


		initWidget(uiBinder.createAndBindUi(this));
		

		for (String color : allColors) {
			colors.addItem(color);
		}		
		for (String material : allMaterials) {
			materials.addItem(material);
		}	
	}
	
	@UiHandler("submitButton")
	public void onSubmit(ClickEvent event) {
		selection = new Selection();
		selection.setColor(colors.getItemText(colors.getSelectedIndex()));
		selection.setMaterial(materials.getItemText(materials.getSelectedIndex()));
		presenter.onProcessingSelection(selection);
		submitButton.setEnabled(false);
	}
	
	@UiHandler("saveButton")
	public void onSave(ClickEvent event) {
		final List<Integer> result = new ArrayList<Integer>();
		Set<Alternative> selectedSet = answerOptionSelectionModel.getSelectedSet();
		for (Alternative option : selectedSet) {
			result.add(option.getId());
		}
		
		presenter.onSavingAlternatives(result);
		saveButton.setEnabled(false);
	}
	
	public void setPresenter(Presenter presenter) {
		this.presenter = presenter;
	}

	public void clear() {
		alternativesDataProvider.getList().clear();
	}

	public void setAlternatives(Alternatives result) {				
		alternativesDataProvider.getList().addAll(result.getAlternatives());
	}
	
	public void setInfoBoxVisibility(boolean visible) {
		infoBox.setVisible(visible);
	}
}
