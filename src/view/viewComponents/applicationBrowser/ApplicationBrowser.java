/***********************************************************************
 * Module:  ApplicationBrowser.java
 * Author:  Korisnik
 * Purpose: Defines the Class ApplicationBrowser
 ***********************************************************************/

package view.viewComponents.applicationBrowser;

import observer.Subject;
import view.context.ContextModel;
import view.viewComponents.Utils.UIUtils;
import view.viewComponents.ViewComponent;
import view.MainPage;

import javax.swing.*;
import java.awt.*;

/** @pdOid 12462003-bc3b-425e-96db-2312f0b9c789 */
public class ApplicationBrowser extends JScrollPane implements ViewComponent {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	public ApplicationBrowser(ContextModel contextModel, MainPage mainPage) {
		super(new ApplicationBrowserTree(
				new ApplicationBrowserTreeModel(null, contextModel.getDataModel().get(0).getXmlModel()), mainPage));
		setPreferredSize(new Dimension(300,0));
		setBackground(UIUtils.COLOR_BACKGROUND);
		setForeground(UIUtils.COLOR_INTERACTIVE_DARKER);
		super.setBorder(BorderFactory.createLineBorder(UIUtils.COLOR_OUTLINE));
	}


	@Override
	public void update(Subject subject) {
		// TODO Auto-generated method stub

	}

}