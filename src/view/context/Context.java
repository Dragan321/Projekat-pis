/***********************************************************************
 * Module:  Context.java
 * Author:  Notebook
 * Purpose: Defines the Class Context
 ***********************************************************************/

package view.context;

import java.util.Vector;

import model.ApplicationModel;

public class Context {
	private ContextModel contextModel;
	private Vector<ContextView> contextViews;
	
	public Vector<ContextView> getContextViews() {
		return contextViews;
	}

	public Context(ApplicationModel applicationModel) {
		this.contextModel = new ContextModel(applicationModel.getDataModel(), applicationModel.getUserModel());
		this.contextViews = new Vector<ContextView>();
		//contextViews.add(new ContextView(this.contextModel));

	}
}