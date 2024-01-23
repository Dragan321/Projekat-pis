package main;

import model.ApplicationModel;
import view.View;
import view.context.ContextView;
import view.viewComponents.ViewComponent;

import javax.swing.*;
import java.awt.*;


public class MainClass {

	public static void main(String[] args) {

		ApplicationModel applicationModel = new ApplicationModel();
		View applicationView = new View(applicationModel);

		for (ContextView contextView : applicationView.getContextViews()) {
			for (ViewComponent viewComponent : contextView.getWindow().getViewComponents()) {
				applicationModel.attachObserver(viewComponent);
			}
		}

		applicationModel.notifyObservers();


	}

}
