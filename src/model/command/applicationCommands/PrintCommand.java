package model.command.applicationCommands;

import model.command.Command;

import javax.swing.*;
import java.awt.print.PrinterException;
import java.text.MessageFormat;

public class PrintCommand extends Command {

	private JTable table = null;
	
	public PrintCommand(JTable table) {
		this.table = table;
	}
	
	@Override
	public void execute() {
		MessageFormat header = new MessageFormat("Izvjestaj:");
		MessageFormat footer = new MessageFormat("Stranica{0,number,integer}");
		JTable table = this.table;
		try {
			table.print(JTable.PrintMode.FIT_WIDTH, header, footer);
		} catch (PrinterException e1) {
			JOptionPane.showMessageDialog(table, "Printanje trenutno nije moguce!");
			e1.printStackTrace();
		}
		
	}

}
