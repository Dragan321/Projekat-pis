package view.viewComponents.applicationBrowser;

import javax.swing.table.TableModel;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreeNode;

import model.XMLModel;
import model.databaseModel.PackageModel;
import model.databaseModel.TreeElement;


import java.awt.Dimension;


import javax.swing.table.TableModel;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreeNode;

import model.XMLModel;
import model.databaseModel.PackageModel;
import model.databaseModel.TreeElement;

public class ApplicationBrowserTreeModel extends DefaultTreeModel {
	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	private XMLModel xmlModel = null;

	public XMLModel getXmlModel() {
		return xmlModel;
	}

	@Override
	public Object getChild(Object parent, int index) {
		if (parent instanceof PackageModel) {
			return ((PackageModel) parent).getElementAt(index);
		} else if (parent instanceof TableModel) {
			return null;
		}
		return null;
	}

	@Override
	public int getChildCount(Object parent) {
		if (parent instanceof PackageModel) {
			return ((PackageModel) parent).getAllElemente().size();
		} else if (parent instanceof TableModel) {
			return 0;
		}
		return 0;
	}

	@Override
	public int getIndexOfChild(Object parent, Object child) {
		if (parent instanceof PackageModel) {
			return ((PackageModel) parent).getIndeksOfElement((TreeElement) child);
		} else if (parent instanceof TableModel) {
			return -1;
		}
		return -1;
	}

	@Override
	public Object getRoot() {
		return this.xmlModel.getRootPaket();
	}

	@Override
	public boolean isLeaf(Object node) {
		if (node instanceof TableModel) {
			return true;
		}
		return false;
	}

	public ApplicationBrowserTreeModel(TreeNode root, XMLModel xmlModel) {
		super(root);
		this.xmlModel = xmlModel;
	}


}
