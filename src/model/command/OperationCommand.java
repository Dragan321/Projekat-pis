package model.command;

import model.ApplicationModel;

public abstract class OperationCommand extends Command {
	private ApplicationModel applicationModel;

	public ApplicationModel getApplication() {
		return applicationModel;
	}

	public void setApplication(ApplicationModel newApplication) {
		applicationModel = newApplication;
	}

	public OperationCommand(ApplicationModel applicationModel) {
		this.applicationModel = applicationModel;
	}
	
	public abstract void execute();
}
