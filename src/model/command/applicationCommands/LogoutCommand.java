package model.command.applicationCommands;

import model.ApplicationModel;
import model.command.OperationCommand;

public class LogoutCommand extends OperationCommand {

	public LogoutCommand(ApplicationModel applicationModel) {
		super(applicationModel);
	}

	@Override
	public void execute() {
		super.getApplication().setUserModel(null);
	}

}
