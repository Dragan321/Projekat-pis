package view;

import observer.Subject;
import view.context.ContextModel;
import view.viewComponents.Utils.UIUtils;
import view.viewComponents.ViewComponent;
import view.viewComponents.table.Table;

import javax.swing.*;
import javax.swing.text.Utilities;
import java.awt.*;

public class MainPage extends JPanel implements ViewComponent {


	private static final long serialVersionUID = 1L;
	private ContextModel contextModel;

	public Table getTable() {
		return table;
	}

	private Table table;

	public ContextModel getContextModel() {
		return this.contextModel;
	}

	public MainPage(ContextModel contextModel) {
		Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
		setLayout(new BorderLayout());
		this.setBackground(UIUtils.COLOR_BACKGROUND);

		JLabel message = new JLabel("Dobrodošli " + contextModel.getUserModel().getForename() + " "
				+ contextModel.getUserModel().getSurname() + "!");
		message.setFont(new Font("Serif", Font.BOLD, 15));
		message.setForeground(UIUtils.OFFWHITE);
		add(message, BorderLayout.NORTH);

		table = new Table(contextModel);
		table.setOpaque(false);
		add(table, BorderLayout.CENTER);
		setBackground(UIUtils.COLOR_BACKGROUND);
		this.contextModel = contextModel;

	}

	//trebace
	public void refreshPage() {
		remove(table);
		contextModel.getDataModel().get(0).getResultSet().retrieveAll();
		table = new Table(contextModel);
		add(table, BorderLayout.CENTER);
		updateUI();
	}

	@Override
	public void update(Subject subject) {
		// TODO Auto-generated method stub

	}
}
