/***********************************************************************
 * Module:  CreateCommnad.java
 * Author:  Notebook
 * Purpose: Defines the Class CreateCommnad
 ***********************************************************************/

package model.command.operationCommands;

import model.ApplicationModel;
import model.DbResultSet;
import model.command.OperationCommand;

public class CreateCommand extends OperationCommand {

	String[] columns;
	Object[] values;
	DbResultSet resultSet;
	public CreateCommand(ApplicationModel applicationModel, String[] columns, Object[] values, DbResultSet resultSet) {
		super(applicationModel);
		this.columns = columns;
		this.values = values;
		this.resultSet = resultSet;
	}

	@Override
	public void execute() {
		// TODO Auto-generated method stub
		resultSet.insert(columns, values);


	}
}