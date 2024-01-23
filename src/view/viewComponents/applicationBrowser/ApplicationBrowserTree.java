package view.viewComponents.applicationBrowser;

import javax.swing.JTree;
import javax.swing.BorderFactory;

import observer.Subject;
import view.MainPage;
import view.viewComponents.Utils.UIUtils;
import view.viewComponents.ViewComponent;

public class ApplicationBrowserTree extends JTree implements ViewComponent {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ApplicationBrowserTree(ApplicationBrowserTreeModel xmlTreeModel, MainPage mainPage) {
		super(xmlTreeModel);
		setBorder(BorderFactory.createEmptyBorder(5, 0, 10, 20));
		setRootVisible(false);
		setBackground(UIUtils.COLOR_BACKGROUND);
		setShowsRootHandles(true);
		this.setCellRenderer(new ApplicationBrowserCellRender());
		new ApplicationBrowserListener(xmlTreeModel, this, mainPage);
	}

	@Override
	public void update(Subject subject) {
		// TODO Auto-generated method stub

	}

}
