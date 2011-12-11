package de.gwzberlin.zas.survey.client;

import com.google.gwt.activity.shared.AbstractActivity;
import com.google.gwt.activity.shared.Activity;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.user.client.ui.AcceptsOneWidget;


public class SurveyActivity extends AbstractActivity implements SurveyView.Presenter {

	private final ClientFactory clientFactory;
	private final SurveyPlace place;
	private SurveyView view;	
	
	public SurveyActivity(ClientFactory clientFactory, SurveyPlace place) {
		this.clientFactory = clientFactory;
		this.place = place;
	}

	public String mayStop() {
		// TODO Auto-generated method stub
		return null;
	}

	public void onCancel() {
		// TODO Auto-generated method stub

	}

	public void onStop() {
		// TODO Auto-generated method stub

	}

	public void start(AcceptsOneWidget panel, EventBus eventBus) {
		view = clientFactory.getSurveyView();
		view.setPresenter(this);
		panel.setWidget(view.asWidget());		
		
	}

}
