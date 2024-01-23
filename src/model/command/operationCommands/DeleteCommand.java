/***********************************************************************
 * Module:  DeleteCommand.java
 * Author:  Notebook
 * Purpose: Defines the Class DeleteCommand
 ***********************************************************************/

package model.command.operationCommands;

import model.ApplicationModel;
import model.DbResultSet;
import model.command.OperationCommand;

public class DeleteCommand extends OperationCommand {

	String pk;
	DbResultSet resultSet;
	public DeleteCommand(ApplicationModel applicationModel, String pkValue, DbResultSet resultSet) {
		super(applicationModel);
		this.pk = pkValue;
		this.resultSet = resultSet;
	}

	@Override
	public void execute() {
		System.out.println(resultSet.getTableName());
		resultSet.delete(pk);

	}
}