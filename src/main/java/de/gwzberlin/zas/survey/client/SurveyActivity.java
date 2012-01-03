package de.gwzberlin.zas.survey.client;

import java.util.List;

import com.google.gwt.activity.shared.AbstractActivity;
import com.google.gwt.activity.shared.Activity;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.AcceptsOneWidget;

import de.gwzberlin.zas.survey.shared.Alternatives;
import de.gwzberlin.zas.survey.shared.Selection;
import de.gwzberlin.zas.survey.shared.SurveyResponse;
import de.gwzberlin.zas.survey.shared.SurveyServiceAsync;


public class SurveyActivity extends AbstractActivity implements SurveyView.Presenter {

	private final ClientFactory clientFactory;
	private final SurveyPlace place;
	private SurveyView view;	
	
	public SurveyActivity(ClientFactory clientFactory, SurveyPlace place) {
		this.clientFactory = clientFactory;
		this.place = place;
	}

	public void start(AcceptsOneWidget panel, EventBus eventBus) {
		view = clientFactory.getSurveyView();
		view.setPresenter(this);
		panel.setWidget(view.asWidget());	
		
		if (place.getType() == SurveyPlaceType.Question1) {
			view.setInfoBoxVisibility(false);
		}		
		if (place.getType() == SurveyPlaceType.Alternatives) {
			view.setInfoBoxVisibility(true);
		}		
	}
	
	public void onProcessingSelection(Selection selection) {
		
		SurveyServiceAsync surveyServiceAsync = clientFactory.getSurveyServiceAsync();
		surveyServiceAsync.sendSelection(selection, new AsyncCallback<Alternatives>() {

			public void onSuccess(Alternatives result) {
				place.setType(SurveyPlaceType.Alternatives);
				view.setInfoBoxVisibility(true);
				view.setAlternatives(result);
			}

			public void onFailure(Throwable caught) {
			}
		});
	}

	public void onSavingAlternatives(List<Integer> result) {
		
		SurveyServiceAsync surveyServiceAsync = clientFactory.getSurveyServiceAsync();
		surveyServiceAsync.saveSelectedAlternatives(result, new AsyncCallback<Void>() {
			
			public void onSuccess(Void result) {
			}

			public void onFailure(Throwable caught) {
			}			
		});		
	}
}
