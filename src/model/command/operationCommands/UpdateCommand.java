/***********************************************************************
 * Module:  UpdateCommand.java
 * Author:  Notebook
 * Purpose: Defines the Class UpdateCommand
 ***********************************************************************/

package model.command.operationCommands;

import model.ApplicationModel;
import model.DbResultSet;
import model.command.OperationCommand;

public class UpdateCommand {

	String[] columns;
	Object[] values;
	DbResultSet resultSet;
	public UpdateCommand(String[] columns, Object[] values, DbResultSet resultSet) {
		this.columns = columns;
		this.values = values;
		this.resultSet = resultSet;
	}

	public void execute() {
		resultSet.update(columns,values);


	}
}