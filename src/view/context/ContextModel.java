/***********************************************************************
 * Module:  ContextModel.java
 * Author:  Notebook
 * Purpose: Defines the Class ContextModel
 ***********************************************************************/

package view.context;

import java.util.Iterator;
import java.util.Vector;

import model.DataModel;
import model.UserModel;
import view.context.contextState.ContextState;

public class ContextModel {
	private ContextState contextState;

	private Vector<DataModel> dataModel;
	private UserModel userModel;


	public UserModel getUserModel() {
		return userModel;
	}
	public void setUserModel(UserModel userModel) {
		this.userModel = userModel;
	}


	public Vector<DataModel> getDataModel() {
		if (dataModel == null)
			dataModel = new Vector<DataModel>();
		return dataModel;
	}
	public void setDataModel(java.util.Collection<DataModel> newDataModel) {
		removeAllDataModel();
		for (Iterator<DataModel> iter = newDataModel.iterator(); iter.hasNext();)
			addDataModel((DataModel) iter.next());
	}

	public void addDataModel(DataModel newDataModel) {
		if (newDataModel == null)
			return;
		if (this.dataModel == null)
			this.dataModel = new Vector<DataModel>();
		if (!this.dataModel.contains(newDataModel))
			this.dataModel.add(newDataModel);
	}

	public void removeDataModel(DataModel oldDataModel) {
		if (oldDataModel == null)
			return;
		if (this.dataModel != null)
			if (this.dataModel.contains(oldDataModel))
				this.dataModel.remove(oldDataModel);
	}

	public void removeAllDataModel() {
		if (dataModel != null)
			dataModel.clear();
	}

	public ContextState getContextState() {
		return contextState;
	}

	public void setContextState(ContextState newContextState) {
		contextState = newContextState;
	}

	public ContextModel(DataModel dataModel, UserModel userModel) {
		this.dataModel = new Vector<DataModel>();
		this.dataModel.add(dataModel);
		this.userModel = userModel;
	}
}