package view.viewComponents.applicationBrowser;

import model.DbResultSet;
import model.databaseModel.TableModel;
import model.databaseModel.TreeElement;
import view.MainPage;

import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class ApplicationBrowserListener implements MouseListener, TreeSelectionListener {

	private ApplicationBrowserTreeModel browserModel;
	private ApplicationBrowserTree applicationBrowserTree;
	private MainPage mainPage;
	
	public ApplicationBrowserListener(ApplicationBrowserTreeModel browserModel,
                                      ApplicationBrowserTree applicationBrowserTree, MainPage mainPage) {
		this.browserModel = browserModel;
		this.applicationBrowserTree = applicationBrowserTree;
		
		this.mainPage = mainPage;

		applicationBrowserTree.addTreeSelectionListener(this);
		applicationBrowserTree.addMouseListener(this);
	}

	@Override
	public void valueChanged(TreeSelectionEvent e) {
		TreeElement x = (TreeElement) applicationBrowserTree.getLastSelectedPathComponent();

		if (x instanceof TableModel) {
			TableModel tableModel = (TableModel) x;
			mainPage.getContextModel().getDataModel().get(0).setResultSet(new DbResultSet(browserModel.getXmlModel().getDbConfiguration(), tableModel.getCrudOperation(), tableModel.getNaziv()));
			mainPage.refreshPage();
			
		}
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}

}
