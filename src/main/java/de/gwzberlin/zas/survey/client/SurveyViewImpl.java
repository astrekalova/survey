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

import de.gwzberlin.zas.survey.shared.AlternativeXml;
import de.gwzberlin.zas.survey.shared.AlternativesXml;
import de.gwzberlin.zas.survey.shared.Selection;

public class SurveyViewImpl extends Composite implements SurveyView {

	interface SurveyUiBinder extends UiBinder<Widget, SurveyViewImpl> {
	}

	private static final SurveyUiBinder uiBinder = GWT.create(SurveyUiBinder.class);

	private Presenter presenter;

	private List<String> allColors = Arrays.asList("", "red", "orange", "yellow", "green", "blue", "violet", "black", "white", "gray");
	private List<String> allMaterials = Arrays.asList("", "rattan", "plastic", "leather", "suede", "velvet","cotton", "silk", "linen");
	
	private ListDataProvider<AlternativeXml> alternativesDataProvider = new ListDataProvider<AlternativeXml>();
	private MultiSelectionModel<AlternativeXml> answerOptionSelectionModel;
	
	@UiField
	ListBox colors;
	
	@UiField
	ListBox materials;
	
	@UiField(provided = true)
	CellTable<AlternativeXml> alternativesTable;
	
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
		
		alternativesTable = new CellTable<AlternativeXml>(100, alternativesDataProvider);
		alternativesTable.setWidth("100%");
		answerOptionSelectionModel = new MultiSelectionModel<AlternativeXml>(alternativesDataProvider);
		alternativesTable.setSelectionModel(answerOptionSelectionModel, DefaultSelectionEventManager.<AlternativeXml> createCheckboxManager());
		
		// Create checkbox column
		Column<AlternativeXml, Boolean> checkboxColumn = new Column<AlternativeXml, Boolean>(new CheckboxCell(true, false)) {
			@Override
			public Boolean getValue(AlternativeXml object) {
				return answerOptionSelectionModel.isSelected(object);
			}
		};
		alternativesTable.addColumn(checkboxColumn);
		
		// Create alternatives column
		TextColumn<AlternativeXml> alternativesColumn = new TextColumn<AlternativeXml>() {
			@Override
			public String getValue(AlternativeXml alternative) {	
				StringBuilder builder = new StringBuilder();
				String colorName = alternative.getColor().getName();
				String materialName = alternative.getMaterial().getName();
				builder.append(colorName + " " + materialName);
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
		final List<Long> result = new ArrayList<Long>();
		Set<AlternativeXml> selectedSet = answerOptionSelectionModel.getSelectedSet();
		for (AlternativeXml option : selectedSet) {
			result.add(option.getId());
		}
		
		presenter.onSavingAlternatives(result);
		saveButton.setEnabled(false);
	}
	
	public void setPresenter(Presenter presenter) {
		this.presenter = presenter;
	}

	public void clear() {
		answerOptionSelectionModel.clear();
		alternativesDataProvider.getList().clear();
	}

	public void setAlternatives(AlternativesXml result) {				
		alternativesDataProvider.getList().addAll(result.getAlternatives());
	}
	
	public void setInfoBoxVisibility(boolean visible) {
		infoBox.setVisible(visible);
	}
}
