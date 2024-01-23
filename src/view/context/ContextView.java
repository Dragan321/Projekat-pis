/***********************************************************************
 * Module:  ContextView.java
 * Author:  Notebook
 * Purpose: Defines the Class ContextView
 ***********************************************************************/

package view.context;

import view.Frame;
import view.LoginPage;
import view.View;
import view.Window;

import java.awt.*;

public class ContextView {
	private ContextModel contextModel;
	private Window window;

	public ContextModel getContextModel() {
		return contextModel;
	}

	public Window getWindow() {
		return window;
	}

	public ContextView(ContextModel contextModel, View view) {
		this.contextModel = contextModel;

		if (contextModel.getUserModel() != null) {
			this.window = new Frame(contextModel, view);
		} else {
			this.window = new LoginPage(contextModel, view);
		}
	}

}