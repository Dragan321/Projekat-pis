package model.command.operationCommands;

import model.ApplicationModel;
import model.command.OperationCommand;
import view.viewComponents.Utils.UIUtils;

import javax.swing.*;

/**
 * 
 * Klasa koja realizuje zatvaranje aplikacije
 *
 */
public class CloseApplicationCommand extends OperationCommand {

	public CloseApplicationCommand(ApplicationModel applicationModel) {
		super(applicationModel);
	}

	public void execute() {

		String answers[] = { "Da", "Odustani" };

		UIManager UI=new UIManager();
		UI.put("OptionPane.background", UIUtils.COLOR_BACKGROUND);
		UI.put("Panel.background",UIUtils.COLOR_BACKGROUND);
		UI.put("OptionPane.messageForeground", UIUtils.OFFWHITE);
		int exit = JOptionPane.showOptionDialog(null, "Da li želite izlazak iz Net Marketa?", "Net Market", JOptionPane.YES_NO_OPTION,
				JOptionPane.WARNING_MESSAGE, null, answers, null);
		
		if (exit == JOptionPane.YES_OPTION) {
			System.exit(0);
		}
	}

}